package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.system.service.SystemLogService;
import com.darly.dubbo.security.user.api.LoginApi;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
@Service
public class LoginBiz extends BaseController implements LoginApi {


    @Resource
    SystemLogService systemLogService;

    @Override
    public ModelMap login(String error) {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        logger.info("--->[方法 login 运行中...]");
        if ("true".equals(error)) {
            this.logger.info("用户登陆失败！");
        }
        model.addAttribute(ApplicationConst.getForwordUrl(), "login");
        return model;
    }

    @Override
    public ModelMap sameuser() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "异地登录");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        logger.info("--->[方法 sameuser 运行中...]");
        model.addAttribute(ApplicationConst.getForwordUrl(), "/error/sameuser");
        return model;
    }

    @Override
    public ModelMap timeout() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "登录超时");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        logger.info("--->[方法 timeout 运行中...]");
        model.addAttribute(ApplicationConst.getForwordUrl(), "/error/timeout");
        return model;
    }

    @Override
    public ModelMap forwardLogin() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        logger.info("--->[方法 forwardLogin 运行中...]");
        model.addAttribute(ApplicationConst.getForwordUrl(), "login/relogin");
        return model;
    }

    @Override
    public ModelMap index() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute("storename", "达理全球连锁商城");
        //在这里添加用户登录统计表操作

        model.addAttribute("xAxisData", objectToJson(systemLogService.getAllUserLoginCount()));

        List<SystemLog> user = systemLogService.getUserAccout();
        Map<String ,List<SystemLog>> map= new HashMap<String ,List<SystemLog>>();
        for (SystemLog us:user) {
            map.put(us.getOperatorId(),systemLogService.getSystemLogsByUser(us.getOperatorId()));
        }
        model.addAttribute("users", objectToJson(user));
        model.addAttribute("alluser", objectToJson(map));

        model.addAttribute(ApplicationConst.getForwordUrl(), "login/index");
        return model;
    }

    @Override
    public ModelMap map() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "地图模块");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(), "map/map");
        return model;
    }

    @Override
    public ModelMap home() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);

        //在这里添加用户登录统计表操作

        model.addAttribute("xAxisData", objectToJson(systemLogService.getAllUserLoginCount()));

        List<SystemLog> user = systemLogService.getUserAccout();
        Map<String ,List<SystemLog>> map= new HashMap<String ,List<SystemLog>>();
        for (SystemLog us:user) {
            map.put(us.getOperatorId(),systemLogService.getSystemLogsByUser(us.getOperatorId()));
        }
        model.addAttribute("users", objectToJson(user));
        model.addAttribute("alluser", objectToJson(map));

        model.addAttribute(ApplicationConst.getForwordUrl(), "home/admin");
        return model;
    }
}