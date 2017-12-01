package com.darly.dubbo.login;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.systemlog.resource.MessageResources;
import com.darly.dubbo.security.BaseSecurityController;
import com.darly.dubbo.security.securitycfg.UserDetials;
import com.darly.dubbo.security.user.api.LoginApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 18:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
@Controller
public class LoginController extends BaseSecurityController {

    @Autowired
    LoginApi loginApi;

    public String login(ModelMap model,String j_username,String j_password,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String sessions = (session != null) ? session.getId() : null;
        model.putAll(loginApi.checkloginuser(j_username,j_password,request.getRemoteAddr(),sessions));
        return (String) model.get(ApplicationConst.getForwordUrl());
    }


    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(String error,ModelMap model,HttpServletRequest request){
        model.putAll(loginApi.login(error));
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    @RequestMapping({"/sameuser"})
    public String sameuser(ModelMap model) {
        model.putAll(loginApi.sameuser());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    @RequestMapping({"/timeout"})
    public String timeout(ModelMap model) {
        model.putAll(loginApi.timeout());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    /***
     * 跳转到登陆页面
     */
    @RequestMapping(value="/forwardLogin/",method = RequestMethod.GET)
    public String forwardLogin(ModelMap model){
        model.putAll(loginApi.forwardLogin());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(ModelMap model, HttpServletRequest request) {
        model.putAll(loginApi.index());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    @RequestMapping(value = {"/map"}, method = RequestMethod.GET)
    public String map(ModelMap model, HttpServletRequest request) {
        model.putAll(loginApi.map());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    /***
     * 登錄后跳轉首頁
     */
    @RequestMapping(value = {"/home/admin/"}, method = RequestMethod.GET)
    public String home(ModelMap model, HttpServletRequest request){
        boolean isRealse = this.isRealse(request.getSession().getServletContext());
        String resCode = null;
        if (isRealse) {
            MessageResources resource = MessageResources.getMessageInstance((String)null, (String)null, Locale.CHINA);
            resCode = resource.getMessage("res.code");
        }
        UserDetials user = getCurrentUser();
        if (user == null) {
            model.addAttribute("hasUser", false);
            logger.info("--->没有登录用户--->[方法 home 运行中...]");
            throw new UsernameNotFoundException("用户不存在");
        } else {
            logger.info("--->用户"+user.getAccount()+"--->[方法 home 运行中...]");
            model.addAttribute("hasUser", true);
            model.addAttribute("userName", user.getRealName());
            model.addAttribute("account", user.getId());
            request.getSession().setAttribute("userName", user.getRealName());
            boolean hasIndex = false;
            boolean hasWarring = false;
            HttpSession session = request.getSession();
            session.setAttribute("hasIndex", hasIndex ? "1" : "0");
            session.setAttribute("hasWarring", hasWarring ? "1" : "0");
            String index = request.getParameter("index");
            if (index != null && index.length() > 0) {
                session.setAttribute("index", index);
            }
            model.putAll(loginApi.home());
            return (String) model.get(ApplicationConst.getForwordUrl());
        }
    }
}
