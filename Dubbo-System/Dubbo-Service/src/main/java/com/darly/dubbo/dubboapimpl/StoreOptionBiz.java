package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.framework.common.StringDiyUtils;
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
    public ModelMap productentry(String value) {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);

        model.addAttribute(ApplicationConst.getPageTitle(), "商品录入");
        model.addAttribute(ApplicationConst.getForwordUrl(),"storeoperation/product_entry");
        StoreProductSearch storeProductSearch = new StoreProductSearch();
        if (StringDiyUtils.isEmpty(value)){
            storeProductSearch.setOrderByClause("ID DESC");
        }else {
            String [] keys = value.split("&");
            for (String key:keys) {
                if (key.split("=").length>1) {
                    String vale = key.split("=")[1];
                    if (!StringDiyUtils.isEmpty(vale)) {
                        if (key.contains("id")) {
                            //這裡添加productName條件
                            storeProductSearch.setOrderByClause("id "+vale);
                        }
                        if (key.contains("productName")) {
                            //這裡添加productName條件
                            storeProductSearch.createCriteria().andProductNameLike("%"+vale+"%");
                        }
                        if (key.contains("productDesc")) {
                            //這裡添加productName條件
                            storeProductSearch.createCriteria().andProductDescLike("%"+vale+"%");
                        }
                        if (key.contains("productImage")) {
                            //這裡添加productName條件
                            storeProductSearch.createCriteria().andProductImageLike("%"+vale+"%");
                        }
                    }
                }
            }
        }
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
    public ModelMap activityentry(String value) {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);

        model.addAttribute(ApplicationConst.getPageTitle(), "活动录入");
        model.addAttribute(ApplicationConst.getForwordUrl(),"storeoperation/activity_entry");
        StoreActiviyTypeSearch storeActiviyTypeSearch = new StoreActiviyTypeSearch();
        if (StringDiyUtils.isEmpty(value)){
            storeActiviyTypeSearch.setOrderByClause("ID DESC");
        }else {
            String [] keys = value.split("&");
            for (String key:keys) {
                if (key.split("=").length>1) {
                    String vale = key.split("=")[1];
                    if (!StringDiyUtils.isEmpty(vale)) {
                        if (key.contains("id")) {
                            //這裡添加productName條件
                            storeActiviyTypeSearch.setOrderByClause("id "+vale);
                        }
                        if (key.contains("storeType")) {
                            //這裡添加productName條件
                            storeActiviyTypeSearch.createCriteria().andStoreTypeLike("%"+vale+"%");
                        }
                        if (key.contains("storeDesc")) {
                            //這裡添加productName條件
                            storeActiviyTypeSearch.createCriteria().andStoreDescLike("%"+vale+"%");
                        }
                        if (key.contains("storeTypeOp")) {
                            //這裡添加productName條件
                            storeActiviyTypeSearch.createCriteria().andStoreTypeOpLike("%"+vale+"%");
                        }
                    }
                }
            }
        }
        List<StoreActiviyType> types = storeActiviyTypeService.selectByExample(storeActiviyTypeSearch);
        if (types!=null){
            for (StoreActiviyType product: types) {
                StoreImageExample example = new StoreImageExample();
                example.createCriteria().andProductTypeIdEqualTo(product.getId());
                List<StoreImage> list = storeImageService.selectByExample(example);
                if (list!=null&&list.size()>0) {
                    product.setStoreTypeIcon(list.get(0).getImageUrl());
                }
            }
            model.addAttribute("STORETYPE",types);
        }

        return model;
    }

    @Override
    public boolean insertProduct(StoreProduct product) {
        if (product == null) {
            return false;
        }
        return storeProductService.insertProduct(product);
    }

    @Override
    public boolean updateProduct(StoreProduct product) {
        if (product == null){
            return false;
        }
        int t = storeProductService.updateById(product);
        if (t>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void deleteImage(String id) {
        if (StringDiyUtils.isEmpty(id)){
            return;
        }
        StoreImageExample example = new StoreImageExample();
        example.createCriteria().andProductTypeIdEqualTo(id);
        storeImageService.deleteByExample(example);
    }

    @Override
    public StoreProduct productedit(String id) {
        if (StringDiyUtils.isEmpty(id)){
            return null;
        }
       StoreProduct product=  storeProductService.getById(id);
        StoreImageExample example = new StoreImageExample();
        example.createCriteria().andProductTypeIdEqualTo(id);
        List<StoreImage> images = storeImageService.selectByExample(example);
        if (images!=null&&images.size()>0){
            product.setProductImage(images.get(0).getImageUrl());
        }
        return product;
    }

    @Override
    public boolean productdelete(String id) {
        if (StringDiyUtils.isEmpty(id)){
            return false;
        }
        if (storeProductService.deleteById(id)>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public StoreActiviyType activityedit(String id) {
        if (StringDiyUtils.isEmpty(id)){
            return null;
        }
        StoreActiviyType type=  storeActiviyTypeService.getById(id);
        StoreImageExample example = new StoreImageExample();
        example.createCriteria().andProductTypeIdEqualTo(id);
        List<StoreImage> images = storeImageService.selectByExample(example);
        if (images!=null&&images.size()>0){
            type.setStoreTypeIcon(images.get(0).getImageUrl());
        }
        return type;
    }

    @Override
    public boolean activitydelete(String id) {
        if (StringDiyUtils.isEmpty(id)){
            return false;
        }
        if (storeActiviyTypeService.deleteById(id)>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean insertActivity(StoreActiviyType type) {
        if (type == null) {
            return false;
        }
        return storeActiviyTypeService.insertActivity(type);
    }

    @Override
    public boolean updateActivity(StoreActiviyType type) {
        if (type == null){
            return false;
        }
        int t = storeActiviyTypeService.updateById(type);
        if (t>0){
            return true;
        }else {
            return false;
        }
    }
}
