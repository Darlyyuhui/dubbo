package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.store.api.StoreOptionApi;
import com.darly.dubbo.store.bean.StoreActiviyType;
import com.darly.dubbo.store.bean.StoreProduct;
import com.darly.dubbo.store.service.StoreActiviyTypeService;
import com.darly.dubbo.store.service.StoreBlogService;
import com.darly.dubbo.store.service.StoreProductService;
import com.darly.dubbo.store.service.StoreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

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
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getPageTitle(), "商城设置首页");
        model.addAttribute(ApplicationConst.getForwordUrl(),"storeoperation/index");
        return model;
    }

    @Override
    public ModelMap productentry() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);

        model.addAttribute(ApplicationConst.getPageTitle(), "商品录入");
        model.addAttribute(ApplicationConst.getForwordUrl(),"storeoperation/product_entry");
        List<StoreProduct> types = storeProductService.findAll();
        model.addAttribute("STOREPRODUCT",types);

        return model;
    }

    @Override
    public ModelMap activityentry() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);

        model.addAttribute(ApplicationConst.getPageTitle(), "活动录入");
        model.addAttribute(ApplicationConst.getForwordUrl(),"storeoperation/activity_entry");
        List<StoreActiviyType> types = storeActiviyTypeService.findAll();
        model.addAttribute("STORETYPE",types);
        return model;
    }
}
