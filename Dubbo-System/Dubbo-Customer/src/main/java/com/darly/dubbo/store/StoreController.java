package com.darly.dubbo.store;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.systemlog.resource.MessageResources;
import com.darly.dubbo.mobile.cfg.ResponseUtil;
import com.darly.dubbo.security.BaseSecurityController;
import com.darly.dubbo.security.securitycfg.UserDetials;
import com.darly.dubbo.security.user.api.LoginApi;
import com.darly.dubbo.store.api.StoreApi;
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

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 18:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
@Controller
public class StoreController extends BaseSecurityController {

    @Autowired
    StoreApi storeApi;

    @RequestMapping(value = {"/storehome"}, method = RequestMethod.GET)
    public String login(ModelMap model){
        hasUser(model);
        model.putAll(storeApi.storehome());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }
}
