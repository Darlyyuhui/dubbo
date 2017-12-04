package com.darly.dubbo.mobile;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.mobile.api.MobileLoginApi;
import com.darly.dubbo.mobile.api.MobileUserApi;
import com.darly.dubbo.mobile.cfg.MobileBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
