package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.security.user.api.LoginApi;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
@Service
public class LoginBiz extends BaseController implements LoginApi {


    @Override
    public ModelMap checkloginuser(String username, String password, String address, String session) {
        try {
            return home();
        } catch (Exception ex) {
            return login("true");
        }
    }
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
        model.addAttribute(ApplicationConst.getForwordUrl(),"login");
        return model;
    }

    @Override
    public ModelMap sameuser() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "异地登录");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        logger.info("--->[方法 sameuser 运行中...]");
        model.addAttribute(ApplicationConst.getForwordUrl(),"/error/sameuser");
        return model;
    }

    @Override
    public ModelMap timeout() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "登录超时");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        logger.info("--->[方法 timeout 运行中...]");
        model.addAttribute(ApplicationConst.getForwordUrl(),"/error/timeout");
        return model;
    }

    @Override
    public ModelMap forwardLogin() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        logger.info("--->[方法 forwardLogin 运行中...]");
        model.addAttribute(ApplicationConst.getForwordUrl(),"login/relogin");
        return model;
    }

    @Override
    public ModelMap index() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(),"login/index");
        return model;
    }

    @Override
    public ModelMap map() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "地图模块");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(),"map/map");
        return model;
    }

    @Override
    public ModelMap home() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(),"home/admin");
        return model;
     }
}