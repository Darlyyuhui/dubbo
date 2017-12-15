package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.store.api.StoreOptionApi;
import com.darly.dubbo.store.service.StoreActiviyTypeService;
import com.darly.dubbo.store.service.StoreBlogService;
import com.darly.dubbo.store.service.StoreProductService;
import com.darly.dubbo.store.service.StoreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/15
 * TODO :
 */
@Service
public class StoreOptionBiz extends BaseController implements StoreOptionApi {

    @Autowired
    StoreBlogService storeBlogService;
    @Autowired
    StoreSaleService storeSaleService;
    @Autowired
    StoreActiviyTypeService storeActiviyTypeService;
    @Autowired
    StoreProductService storeProductService;


    @Override
    public ModelMap optionIndex() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(),"storeoperation/index");
        return model;
    }
}
