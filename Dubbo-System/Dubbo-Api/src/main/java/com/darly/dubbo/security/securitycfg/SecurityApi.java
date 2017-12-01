package com.darly.dubbo.security.securitycfg;

import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.user.bean.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/1
 * TODO :
 */
public interface SecurityApi {

    /**
     * 保持日志信息
     * @param log 日志类
     */
    void saveLog(SystemLog log);


    /** 根据名字查找用户
     * @param username 名称
     * @return 返回用户
     */
    User findUserByLoginName(String username);


    /**根据id获取用户权限
     * @param id id
     * @return 用户权限集合
     */
    Set<GrantedAuthority> getRoleListByUser(String id);
}
