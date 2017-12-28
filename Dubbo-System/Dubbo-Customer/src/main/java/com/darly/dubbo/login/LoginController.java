package com.darly.dubbo.login;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.systemlog.resource.MessageResources;
import com.darly.dubbo.mobile.cfg.ResponseUtil;
import com.darly.dubbo.security.BaseSecurityController;
import com.darly.dubbo.security.securitycfg.UserDetials;
import com.darly.dubbo.security.user.api.LoginApi;
import com.darly.dubbo.store.api.StoreOptionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static java.lang.Math.sin;

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

    @Autowired
    StoreOptionApi storeOptionApi;
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(String error,ModelMap model,HttpServletRequest request){
        hasUser(model);
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
        hasUser(model);
        model.putAll(loginApi.timeout());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    /***
     * 跳转到登陆页面
     */
    @RequestMapping(value="/forwardLogin/",method = RequestMethod.GET)
    public String forwardLogin(ModelMap model){
        hasUser(model);
        model.putAll(loginApi.forwardLogin());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(ModelMap model, HttpServletRequest request) {

        UserDetials user = getCurrentUser();
        if (user == null) {
            model.addAttribute("hasUser", false);
            logger.info("--->没有登录用户--->[方法 home 运行中...]");
            model.putAll(loginApi.index());
            return (String) model.get(ApplicationConst.getForwordUrl());
        } else {
            logger.info("--->用户" + user.getAccount() + "--->[方法 home 运行中...]");
            return "redirect:/home/admin/";
        }
    }

    @RequestMapping(value = {"/map"}, method = RequestMethod.GET)
    public String map(ModelMap model, HttpServletRequest request) {
        hasUser(model);
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
//            model.putAll(loginApi.home());
            model.putAll(storeOptionApi.optionIndex());
            return (String) model.get(ApplicationConst.getForwordUrl());
        }
    }


    /**
     * 此方法主要提供给Ajax传递数据
     * @param request 请求
     * @param response 回调
     */
    @RequestMapping(value = {"/computerinfo"}, method = RequestMethod.GET)
    public void computerinfo( ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        long ajaxnow = Long.valueOf(request.getParameter("ajaxnow"));
        double ajaxvalue = Double.valueOf(request.getParameter("ajaxvalue"));
        double degree = Double.valueOf(request.getParameter("degree"));
        ajaxnow += 1000;
        SimpleDateFormat s = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String time = s.format(new Date(ajaxnow));
        degree += 6;
        if (degree >= 360){
            degree -= 360;
        }
        double a = Math.toRadians(degree);//把数字90 转换成 90度
        Map<String,Object > map= new HashMap<String,Object >();
        map.put("times",time);
        map.put("ajaxnow",ajaxnow);
        map.put("ajaxvalue",ajaxvalue);
        map.put("degree",degree);
        Map<String ,Object> md= new HashMap<String,Object >();
        md.put("name",time);
        md.put("value",new String[]{time,String.valueOf(ajaxvalue*Math.sin(a))});
        map.put("data",md);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), map, response);
    }
}
