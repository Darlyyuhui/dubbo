package com.darly.dubbo.security.securitycfg;

import com.darly.dubbo.framework.base.ApplicationContextHolder;
import com.darly.dubbo.framework.common.DateUtil;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.system.service.SystemLogService;
import com.darly.dubbo.security.user.bean.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/6
 * TODO :
 */
public class LoginoutSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements LogoutSuccessHandler {

    private static Logger loger = new Logger(SessionListener.class);

    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        super.handle(request, response, authentication);
        
        loginoutInfo(request,response,authentication);
        
    }

    private void loginoutInfo(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            UserDetials operatorDetails = (UserDetials) authentication.getPrincipal();
            if (operatorDetails != null) {
                //用戶退出登陆。給在線的用戶發送信息
                //SystemWebSocketHandler.sendMessageToAllUsers(new TextMessage("user:"+operatorDetails.getId()+"user:"+operatorDetails.getRealName()));
                SystemLogService systemLogService = (SystemLogService) ApplicationContextHolder.getBean("systemLogServiceImplementer");
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
                systemLogService.save(log);
                loger.infoLine();
                loger.info("--->登录用户：" + user.getName());
                loger.info("--->"+user.getName()+"退出系统成功");
                loger.infoLine();
            }
        }
    }

}
