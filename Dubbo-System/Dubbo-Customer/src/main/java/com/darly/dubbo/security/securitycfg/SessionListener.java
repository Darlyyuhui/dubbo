package com.darly.dubbo.security.securitycfg;

import com.darly.dubbo.framework.common.DateUtil;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.user.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/10/20 14:06
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： Session监听器 完成对Seesion会话资源的实时监控
 */
public class SessionListener implements HttpSessionListener {

    private static Logger logger = new Logger(SessionListener.class);

    @Autowired
    SecurityApi api;
    /**
     * 实现HttpSessionListener接口，完成session创建事件控制 说明：此时的Session状态为无效会话，
     * 只有用户成功登录系统后才将此Session写入EAHTTPSESSION表作为有效SESSION来管理
     */
    @Override
    public void sessionCreated(HttpSessionEvent event) {
    }

    public static void addOnlineUser(HttpSession event){
        ServletContext ctx = event.getServletContext();
        Integer numSessions = (Integer) ctx.getAttribute("numSessions");
        if (numSessions == null) {
            numSessions = new Integer(1);
        } else {
            int count = numSessions.intValue();
            numSessions = new Integer(count + 1);
        }
        ctx.setAttribute("numSessions", numSessions);
        logger.info("------>[在線用戶個數：]"+ctx.getAttribute("numSessions"));
    }

    /**
     * 实现HttpSessionListener接口，完成session销毁事件控制
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        HttpSession session = event.getSession();
        Object context = session.getAttribute("SPRING_SECURITY_CONTEXT");
        if (context != null) {

            //踢出掉離線用戶
            ServletContext ctx = event.getSession().getServletContext();
            Integer numSessions = (Integer) ctx.getAttribute("numSessions");
            if (numSessions == null) {
                numSessions = new Integer(0);
            } else {
                int count = numSessions.intValue();
                if (count == 0){
                    numSessions = new Integer(count);
                }else {
                    numSessions = new Integer(count - 1);
                }
            }
            ctx.setAttribute("numSessions", numSessions);

            SecurityContext securityContext = (SecurityContext) context;
            UserDetials operatorDetails = (UserDetials) securityContext.getAuthentication().getPrincipal();
            if (operatorDetails != null) {
                SystemLog log = new SystemLog();
                // 记录在线用户信息
                User user = new User();
                user.setName(operatorDetails.getUsername());
                UserThreadLocal.set(user);
                log.setId(UuidGenerateUtil.getUUIDLong());
                //记录日志
                log.setContent(operatorDetails.getRealName()+"成功退出系统.");
                log.setIpAddress(operatorDetails.getIpAddress());
                log.setOperatorId(operatorDetails.getAccount());
                log.setOperatorName(operatorDetails.getRealName());
                log.setOperationTime(DateUtil.now());
                log.setType(2l);
                log.setLogLevel(1l);
                log.setCreateDate(DateUtil.now());
                log.setCreateBy(operatorDetails.getAccount());
                log.setStatus("0");
                // 存储日志
                api.saveLog(log);
                logger.infoLine();
                logger.info("--->登录用户：" + user.getName());
                logger.info("--->"+user.getName()+"退出系统成功");
                logger.info("--->在线人数统计："+ctx.getAttribute("numSessions"));
                logger.infoLine();
            }

        }
    }

    public static  int getOnlineUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (int) request.getSession().getServletContext().getAttribute("numSessions");
    }
}
