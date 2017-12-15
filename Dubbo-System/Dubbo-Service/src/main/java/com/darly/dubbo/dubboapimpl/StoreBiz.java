package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.store.api.StoreApi;
import com.darly.dubbo.store.bean.*;
import com.darly.dubbo.store.service.StoreActiviyTypeService;
import com.darly.dubbo.store.service.StoreBlogService;
import com.darly.dubbo.store.service.StoreProductService;
import com.darly.dubbo.store.service.StoreSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        //独立活动展示
        Map<StoreActiviyType ,List<StoreProduct>> map = new LinkedHashMap<StoreActiviyType ,List<StoreProduct>>();
        List<StoreActiviyType> types = storeActiviyTypeService.findAll();//所有活動
        for (StoreActiviyType type:types) {
            findProduct(map, type);
        }
        model.addAttribute("allSale",map);

        //分组效果展示1
        Map<StoreActiviyType ,List<StoreProduct>> mapping = new LinkedHashMap<StoreActiviyType ,List<StoreProduct>>();
        StoreActiviyTypeSearch search= new StoreActiviyTypeSearch();
        search.createCriteria().andStoreEndTimeGreaterThan(new Date(System.currentTimeMillis()));
        search.setOrderByClause("ID desc");
        List<StoreActiviyType> typeer = storeActiviyTypeService.selectByExample(search);//所有活動
        logger.info(typeer);
        for (StoreActiviyType type:typeer) {
            findProduct(mapping, type);
        }
        model.addAttribute("actionSale",mapping);
        //分组效果展示2
        Map<StoreActiviyType ,List<StoreProduct>> mapping2 = new LinkedHashMap<StoreActiviyType ,List<StoreProduct>>();
        StoreActiviyTypeSearch search2= new StoreActiviyTypeSearch();
        search2.createCriteria().andStoreEndTimeLessThan(new Date(System.currentTimeMillis()));
        search2.setOrderByClause("ID desc");
        List<StoreActiviyType> typeer2 = storeActiviyTypeService.selectByExample(search2);//所有活動
        for (StoreActiviyType type:typeer2) {
            findProduct(mapping2, type);
        }
        model.addAttribute("actionSaleTwo",mapping2);

        List<StoreBlog> stores =  storeBlogService.findAll();
        if (stores!=null){
            model.addAttribute("storeblog", stores);
        }
        return model;
    }

    private void findProduct(Map<StoreActiviyType, List<StoreProduct>> map, StoreActiviyType type) {
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
}
