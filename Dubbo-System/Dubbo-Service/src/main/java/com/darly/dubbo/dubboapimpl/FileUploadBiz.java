package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.fileupload.FileUploadApi;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.store.bean.StoreProduct;
import com.darly.dubbo.store.service.StoreProductService;
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
public class FileUploadBiz extends BaseController implements FileUploadApi {
    @Autowired
    StoreProductService storeProductService;

    @Override
    public ModelMap fileupload() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getPageTitle(), "商品录入");
        model.addAttribute(ApplicationConst.getForwordUrl(),"storeoperation/product_entry");
        List<StoreProduct> types = storeProductService.findAll();
        model.addAttribute("STOREPRODUCT",types);
        return model;
    }
}
