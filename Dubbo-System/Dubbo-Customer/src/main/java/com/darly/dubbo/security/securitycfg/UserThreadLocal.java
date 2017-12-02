package com.darly.dubbo.security.securitycfg;


import com.darly.dubbo.security.user.bean.User;

/***
 * 存放用户信息的线程变量，主要用户做数据审计的时候需要当前登录人的信息
 * @author zhouhaij
 * @version 1.0
 * @since 1.0
 */
public class UserThreadLocal {
	
    private static ThreadLocal<User> currentUser = new ThreadLocal<User>();

    public static void set(User userInfo) {
        currentUser.set(userInfo);
    }

    public static User get() {
        return currentUser.get();
    }
}
