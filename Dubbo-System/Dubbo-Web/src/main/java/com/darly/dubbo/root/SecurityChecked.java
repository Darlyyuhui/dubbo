package com.darly.dubbo.root;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.security.user.api.SecurityApi;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/30
 * TODO :
 */
@Service
public class SecurityChecked extends BaseController implements SecurityApi{

    @Override
    public ModelMap checkloginuser(String username, String password) {
        logger.info(username+"--------------->"+password);
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getForwordUrl(),"");
        return model;
    }
}
