package com.darly.dubbo.security.securitycfg;

import com.darly.dubbo.framework.base.ApplicationContextHolder;
import com.darly.dubbo.framework.common.DateUtil;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.framework.common.useragent.UserAgent;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.system.service.SystemLogService;
import com.darly.dubbo.security.user.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.UnknownHostException;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/15 9:06
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 用户登录成功事件监听器
 */
public class LoginSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    /**
     * 日志
     */
    protected static Logger logger =  new Logger(LoginSuccessListener.class);

    @Autowired
    private SessionRegistry sessionRegistry;//这个类会自动注入 不用我们自己去手动注入
    /**
     * 登录成功后事件处理
     */
    public void onApplicationEvent(AuthenticationSuccessEvent authenticationSuccessEvent) {
        logger.info("--->登陆监听器启动......");
        AbstractAuthenticationToken authenticationToken = (AbstractAuthenticationToken) authenticationSuccessEvent.getSource();
        UserDetials userInfo = (UserDetials) authenticationToken.getPrincipal();
        WebAuthenticationDetails authenticationDetails = (WebAuthenticationDetails) authenticationToken.getDetails();
        String ipAddress = authenticationDetails.getRemoteAddress();
        if (ipAddress.equals("127.0.0.1") || "0:0:0:0:0:0:0:1".equals(ipAddress)) {
            // 根据网卡取本机配置的IP
            java.net.InetAddress inet = null;
            try {
                inet = java.net.InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                logger.error("--->IP地址获取失败.", e);
            }
            if(inet != null)
                ipAddress = inet.getHostAddress();
            userInfo.setIpAddress(ipAddress);
        }

        //用戶登錄成功，統計在線用戶
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //添加在线用户个数
        SessionListener.addOnlineUser(request.getSession());
        SystemLog log = new SystemLog();

        // 记录在线用户信息
        User user = new User();
        user.setName(userInfo.getUsername());
        UserThreadLocal.set(user);
        log.setId(UuidGenerateUtil.getUUIDLong());
        //记录日志
        log.setContent(userInfo.getRealName()+"成功登陆系统");
        log.setIpAddress(ipAddress);
        log.setOperatorId(userInfo.getAccount());
        log.setOperatorName(userInfo.getRealName());
        log.setOperationTime(DateUtil.now());
        log.setType(1l);
        log.setLogLevel(1l);
        log.setCreateDate(DateUtil.now());
        log.setCreateBy(userInfo.getAccount());
        log.setStatus("0");
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        log.setBrowser(userAgent.getBrowser().getName()+userAgent.getOperatingSystem().getName());
        SystemLogService systemLogService = (SystemLogService) ApplicationContextHolder.getBean("systemLogServiceImplementer");
        systemLogService.save(log);
        logger.infoLine();
        logger.info("--->登录用户："+ user.getName());
        logger.info("--->"+user.getName()+"登录系统成功");
        logger.infoLine();
    }
}
