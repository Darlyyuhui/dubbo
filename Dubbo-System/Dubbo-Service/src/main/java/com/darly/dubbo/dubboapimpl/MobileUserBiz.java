package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.mobile.api.MobileUserApi;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/14
 * TODO :
 */
@Service
public class MobileUserBiz extends BaseController implements MobileUserApi {

    @Resource
    UserService userService;

    @Override
    public ModelMap noRight() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.APPLICATION_NAME, applicationName);
        logger.info("--->[方法 noRight 运行中...]");
        model.addAttribute(ApplicationConst.FORWORD_URL,"error/403");
        return model;
    }

    @Override
    public List<User> apiUsers() throws Exception {
        logger.info("--->[方法 apiUsers 前端接口請求用戶...]");
        return userService.findAll(false);
    }
}
