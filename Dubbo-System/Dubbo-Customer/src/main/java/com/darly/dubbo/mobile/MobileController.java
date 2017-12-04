package com.darly.dubbo.mobile;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.common.DeEncryptUtil;
import com.darly.dubbo.mobile.api.MobileLoginApi;
import com.darly.dubbo.mobile.api.MobileUserApi;
import com.darly.dubbo.mobile.cfg.MobileBaseController;
import com.darly.dubbo.mobile.session.SessionData;
import com.darly.dubbo.mobile.session.SessionUtil;
import com.darly.dubbo.security.securitycfg.UserDetailServer;
import com.darly.dubbo.security.user.bean.User;
import org.apache.zookeeper.server.SessionTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/18
 * TODO :
 */
@Controller
@RequestMapping("mobile")
public class MobileController extends MobileBaseController {
    @Resource
    MobileLoginApi loginApi;
    @Resource
    MobileUserApi userApi;

    /**
     * @return 用户登录接口
     */
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            simpleResult("201", e.getMessage(),  request, response);
        }
        String account = request.getParameter("account");
        //此时密码为密文
        String pwd = request.getParameter("pwd");
        //设备IMEI
        String imei = request.getParameter("imei");
        if (StringUtils.isEmpty(pwd)) {
            super.simpleResult("201", "缺失登录参数", request, response);
            return;
        }
        if(StringUtils.isEmpty(imei)){
            super.simpleResult("201", "缺失设备编号", request, response);
            return;
        }
        User user = userApi.login(account);
        if (user == null) {
            super.simpleResult("201", "登录失败，账户名错误。", request, response);
            return;
        }
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        String ss=this.decryptPwd(pwd);
        pwd = md5.encodePassword(ss, user.getName());
//        if (!pwd.equals(user.getPwd())) {
//            super.simpleResult("201", "登录失败，账户密码错误。", request, response);
//            return;
//        }
        dataResult("200", "登录成功。", user, request, response);
        SessionData sd = new SessionData();
        sd.setId(user.getId());
        sd.setAccount(user.getAccount());
        sd.setName(user.getName());
        sd.setDeptName(user.getDeptName());
        sd.setMobile(user.getMobile());
        sd.setImei(imei);
        sd.setLoginDate(new Date());
        logger.info(request.getContextPath());
        SessionUtil.SESSION_MAP.put(SessionUtil.makeSessionKey(request), sd);
    }

    /**
     * 密码解密
     * @param pwd 原始密码
     * @return
     */
    public  String decryptPwd(String pwd) {
        try {
            DeEncryptUtil t = new DeEncryptUtil();
            return t.decrypt(pwd);
        } catch (Exception e) {
            logger.error("密码解密失败。"+e.getMessage());
        }
        return null;
    }


    @RequestMapping(value = {"/noright"}, method = RequestMethod.GET)
    public String noRight(ModelMap model) {
        model.putAll(userApi.noRight());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }
    /**
     * @return 前端接口請求用戶
     */
    @RequestMapping(value = {"/api/list"}, method = RequestMethod.GET)
    public void apiUsers(HttpServletRequest request, HttpServletResponse response) {
        try {
            dataResult("200", "查询成功", userApi.apiUsers(), request, response);
        } catch (Exception e) {
            simpleResult("201", "查询失败", request, response);
        }
    }

    /**
     * @return 前端接口請求用戶
     */
    @RequestMapping(value = {"/loginlog"}, method = RequestMethod.GET)
    public void loginLog(HttpServletRequest request, HttpServletResponse response) {
        try {
            dataResult("200", "查询成功", loginApi.loginLog(), request, response);
        } catch (Exception e) {
            simpleResult("201", "查询失败", request, response);
        }
    }

}
