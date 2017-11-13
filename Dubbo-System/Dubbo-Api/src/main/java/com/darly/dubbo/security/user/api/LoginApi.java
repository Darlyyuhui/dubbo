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
     * @param model
     * @return 传递登录信息，跳转登录页面
     */
    String login(String error, ModelMap model);

    /**
     * @param model
     * @return 相同用户登录后，踢出前一个登录用户弹出页面
     */
    String sameuser(ModelMap model);

    /**
     * @param model
     * @return 用户Session超时页面
     */
    String timeout(ModelMap model);

    /**
     * @param model
     * @return 用户重新登录页面
     */
    String forwardLogin(ModelMap model);

    /**
     * @param model
     * @return 跳转首页
     */
    String index(ModelMap model);

    /**
     * @param model
     * @param request
     * @return 登录后 跳转登录主页
     */
    String home(ModelMap model, HttpServletRequest request);

}
