package com.darly.dubbo.login;

import com.darly.dubbo.security.user.api.UserApi;
import com.darly.dubbo.security.user.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/18
 * TODO :
 */
@Controller
@RequestMapping("user")
public class UserController{
    @Resource
    UserApi userApi;
    /***
     * 跳转到注册页面
     */
    @RequestMapping(value="/regedit",method = RequestMethod.GET)
    public String forwardLogin(ModelMap model){
        model.putAll(userApi.forwardLogin());
        return (String) model.get("url");
    }

    /***
     * 添加用户
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(User user, ModelMap redirectAttributes){
        redirectAttributes.putAll(userApi.addUser(user));
        return (String) redirectAttributes.get("url");
    }
    /***
     * 判断编码是否重复
     */
    @RequestMapping(value = "accountExist")
    @ResponseBody
    public String accountExist(HttpServletRequest req, @RequestParam(value = "account") String account) {
        return userApi.accountExist(req,account);
    }

}
