package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.store.api.StoreOptionApi;
import com.darly.dubbo.store.bean.*;
import com.darly.dubbo.store.service.*;
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
    @Autowired
    StoreImageService storeImageService;


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
        StoreProductSearch storeProductSearch = new StoreProductSearch();
        storeProductSearch.setOrderByClause("ID DESC");
        List<StoreProduct> types = storeProductService.selectByExample(storeProductSearch);
        if (types!=null){
            for (StoreProduct product: types) {
                StoreImageExample example = new StoreImageExample();
                example.createCriteria().andProductTypeIdEqualTo(product.getId());
                List<StoreImage> list = storeImageService.selectByExample(example);
                if (list!=null&&list.size()>0) {
                    product.setProductImage(list.get(0).getImageUrl());
                }
            }
            model.addAttribute("STOREPRODUCT",types);
        }
        return model;
    }

    @Override
    public ModelMap activityentry() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);

        model.addAttribute(ApplicationConst.getPageTitle(), "活动录入");
        model.addAttribute(ApplicationConst.getForwordUrl(),"storeoperation/activity_entry");

        StoreActiviyTypeSearch storeActiviyTypeSearch = new StoreActiviyTypeSearch();
        storeActiviyTypeSearch.setOrderByClause("ID DESC");
        List<StoreActiviyType> types = storeActiviyTypeService.selectByExample(storeActiviyTypeSearch);
        model.addAttribute("STORETYPE",types);
        return model;
    }

    @Override
    public boolean insertProduct(StoreProduct product) {
        if (product == null) {
            return false;
        }
        return storeProductService.insertProduct(product);
    }
}
