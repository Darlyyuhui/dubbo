package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.security.securitycfg.SecurityApi;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.system.service.SystemLogService;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/1
 * TODO :
 */
@Service
public class SecurityBiz extends BaseController implements SecurityApi {

    @Autowired
    SystemLogService systemLogService;

    @Autowired
    UserService userService;

    @Override
    public void saveLog(SystemLog log) {
        systemLogService.save(log);
    }

    @Override
    public User findUserByLoginName(String username) {
        return userService.findUserByLoginName(username);
    }

    @Override
    public Set<GrantedAuthority> getRoleListByUser(String id) {
        return userService.getRoleListByUser(id);
    }
}
