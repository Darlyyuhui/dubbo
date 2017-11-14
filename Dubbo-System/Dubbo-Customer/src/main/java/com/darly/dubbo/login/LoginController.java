package com.darly.dubbo.login;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.security.user.api.LoginApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 18:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
@Controller
public class LoginController{

    @Autowired
    LoginApi loginApi;

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(String error,ModelMap model,HttpServletRequest request){
        model.putAll(loginApi.login(error));
        return (String) model.get(ApplicationConst.FORWORD_URL);
    }

    @RequestMapping({"/sameuser"})
    public String sameuser(ModelMap model) {
        model.putAll(loginApi.sameuser());
        return (String) model.get(ApplicationConst.FORWORD_URL);
    }

    @RequestMapping({"/timeout"})
    public String timeout(ModelMap model) {
        model.putAll(loginApi.timeout());
        return (String) model.get(ApplicationConst.FORWORD_URL);
    }

    /***
     * 跳转到登陆页面
     */
    @RequestMapping(value="/forwardLogin/",method = RequestMethod.GET)
    public String forwardLogin(ModelMap model){
        model.putAll(loginApi.forwardLogin());
        return (String) model.get(ApplicationConst.FORWORD_URL);
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(ModelMap model, HttpServletRequest request) {
        model.putAll(loginApi.index());
        return (String) model.get(ApplicationConst.FORWORD_URL);
    }

    /***
     * 登錄后跳轉首頁
     */
    @RequestMapping(value = {"/home/admin/"}, method = RequestMethod.GET)
    public String home(ModelMap model, HttpServletRequest request){
        model.putAll(loginApi.home(request));
        return (String) model.get(ApplicationConst.FORWORD_URL);
    }
}
