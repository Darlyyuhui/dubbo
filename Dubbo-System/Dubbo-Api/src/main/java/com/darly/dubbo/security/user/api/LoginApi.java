package com.darly.dubbo.security.user.api;

import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
public interface LoginApi {
    /**
     * @param error
     * @return 传递登录信息，跳转登录页面
     */
    ModelMap login(String error );

    /**
     * @return 相同用户登录后，踢出前一个登录用户弹出页面
     */
    ModelMap sameuser();

    /**
     * @return 用户Session超时页面
     */
    ModelMap timeout();

    /**
     * @return 用户重新登录页面
     */
    ModelMap forwardLogin();

    /**
     * @return 跳转首页
     */
    ModelMap index();
    /**
     * @return 跳轉到地圖頁面
     */
    ModelMap map();

    /**
     * @return 登录后 跳转登录主页
     */
    ModelMap home();

}
