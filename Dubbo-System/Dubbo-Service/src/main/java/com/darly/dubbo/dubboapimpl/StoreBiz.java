package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.security.user.api.UserApi;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.service.UserService;
import com.darly.dubbo.store.api.StoreApi;
import com.darly.dubbo.store.bean.*;
import com.darly.dubbo.store.service.StoreActiviyTypeService;
import com.darly.dubbo.store.service.StoreBlogService;
import com.darly.dubbo.store.service.StoreProductService;
import com.darly.dubbo.store.service.StoreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO : 在这里添加一些不同功能模块的商品
 */
@Service
public class StoreBiz extends BaseController implements StoreApi {

    @Autowired
    StoreBlogService storeBlogService;
    @Autowired
    StoreSaleService storeSaleService;
    @Autowired
    StoreActiviyTypeService storeActiviyTypeService;
    @Autowired
    StoreProductService storeProductService;

    @Override
    public ModelMap storehome() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute("storename", "达理全球连锁商城");
        model.addAttribute(ApplicationConst.getForwordUrl(),"dlstore/storehome");
        //周活動商品列表
        Map<StoreActiviyType ,List<StoreProduct>> map = new LinkedHashMap<StoreActiviyType ,List<StoreProduct>>();
        List<StoreActiviyType> types = storeActiviyTypeService.findAll();//所有活動
        for (StoreActiviyType type:types) {
            StoreSaleSearch search = new StoreSaleSearch();
            search.createCriteria().andStoreTypeEqualTo(type.getId());
            List<StoreSale> sales = storeSaleService.selectByExample(search);//所有關係
            if (sales!=null&&sales.size()!=0){
                List<StoreProduct> products = new ArrayList<StoreProduct>();
                for (StoreSale sale:sales) {
                    StoreProduct product = storeProductService.getById(sale.getProductId());//所有商品
                    if (product!=null){
                        products.add(product);
                    }
                }
                map.put(type,products);
            }
        }
        model.addAttribute("allSale",map);
        List<StoreBlog> stores =  storeBlogService.findAll();
        if (stores!=null){
            model.addAttribute("storeblog", stores);
        }
        return model;
    }
}
