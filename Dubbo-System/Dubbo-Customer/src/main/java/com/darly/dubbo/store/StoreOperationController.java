package com.darly.dubbo.store;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.security.BaseSecurityController;
import com.darly.dubbo.store.api.StoreOptionApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 18:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
@Controller
@RequestMapping({"/option"})
public class StoreOperationController extends BaseSecurityController {

    @Autowired
    StoreOptionApi storeOptionApi;

    /** 商城管理页面首页
     * @param model
     * @return
     */
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String optionIndex(ModelMap model){
        hasUser(model);
        model.putAll(storeOptionApi.optionIndex());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }
}
