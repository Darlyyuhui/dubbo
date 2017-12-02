package com.darly.dubbo.security.securitycfg;

import com.darly.dubbo.framework.common.DateUtil;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.security.system.bean.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import java.net.UnknownHostException;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/15 9:06
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 用户登录失败事件监听器
 */
public class LoginFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {
    /**
     * 日志
     */
    protected static Logger logger =new Logger(LoginFailureListener.class);
    /**
     * 登录失败后事件处理
     */

    @Autowired
    SecurityApi api;
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent authenticationFailureBadCredentialsEvent) {
      
    	logger.info("--->登陆监听器启动......");
    	
    	Authentication authentication = authenticationFailureBadCredentialsEvent.getAuthentication();
    	AbstractAuthenticationToken authenticationToken = (AbstractAuthenticationToken) authenticationFailureBadCredentialsEvent.getSource();
        WebAuthenticationDetails authenticationDetails = (WebAuthenticationDetails) authenticationToken.getDetails();
        
        String ipAddress = authenticationDetails.getRemoteAddress();
        if (ipAddress.equals("127.0.0.1")) {
            // 根据网卡取本机配置的IP
            java.net.InetAddress inet = null;
            try {
                inet = java.net.InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                logger.error("IP地址获取失败.", e);
            }
            if(inet != null)
            ipAddress = inet.getHostAddress();
        }
        
        //记录日志
        SystemLog log = new SystemLog();
        log.setId(UuidGenerateUtil.getUUIDLong());
        log.setContent("尝试登录系统失败.");
        log.setIpAddress(ipAddress);
        log.setOperatorId(authentication.getName());
        log.setOperatorName(authentication.getName());
        log.setOperationTime(DateUtil.now());
        log.setCreateDate(DateUtil.now());
        log.setCreateBy(authentication.getName());
        log.setStatus("0");
        log.setType(2l);
        log.setLogLevel(2l);
//        SystemLogService systemLogService = (SystemLogService) ApplicationContextHolder.getBean("systemLogServiceImplementer");
//        systemLogService.save(log);
        api.saveLog(log);
        logger.infoLine();
        logger.info("--->登录用户："+ authentication.getName());
        logger.info("--->尝试登录系统失败");
        logger.infoLine();
    }
}
