package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.store.api.StoreOptionApi;
import com.darly.dubbo.store.bean.*;
import com.darly.dubbo.store.service.*;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
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
        model.addAttribute(ApplicationConst.getForwordUrl(), "storeoperation/index");
        return model;
    }

    @Override
    public ModelMap productentry(String value) {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);

        model.addAttribute(ApplicationConst.getPageTitle(), "商品录入");
        model.addAttribute(ApplicationConst.getForwordUrl(), "storeoperation/product_entry");
        StoreProductSearch storeProductSearch = new StoreProductSearch();
        if (StringDiyUtils.isEmpty(value)) {
            storeProductSearch.setOrderByClause("ID DESC");
        } else {
            String[] keys = value.split("&");
            for (String key : keys) {
                if (key.split("=").length > 1) {
                    String vale = key.split("=")[1];
                    if (!StringDiyUtils.isEmpty(vale)) {
                        if (key.contains("id")) {
                            //這裡添加productName條件
                            storeProductSearch.setOrderByClause("id " + vale);
                        }
                        if (key.contains("productName")) {
                            //這裡添加productName條件
                            storeProductSearch.createCriteria().andProductNameLike("%" + vale + "%");
                        }
                        if (key.contains("productDesc")) {
                            //這裡添加productName條件
                            storeProductSearch.createCriteria().andProductDescLike("%" + vale + "%");
                        }
                        if (key.contains("productImage")) {
                            //這裡添加productName條件
                            storeProductSearch.createCriteria().andProductImageLike("%" + vale + "%");
                        }
                    }
                }
            }
        }
        List<StoreProduct> types = storeProductService.selectByExample(storeProductSearch);
        if (types != null) {
            for (StoreProduct product : types) {
                StoreImageExample example = new StoreImageExample();
                example.createCriteria().andProductTypeIdEqualTo(product.getId());
                List<StoreImage> list = storeImageService.selectByExample(example);
                if (list != null && list.size() > 0) {
                    product.setProductImage(list.get(0).getImageUrl());
                }
            }
            model.addAttribute("STOREPRODUCT", types);
        }
        return model;
    }

    @Override
    public ModelMap activityentry(String value) {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);

        model.addAttribute(ApplicationConst.getPageTitle(), "活动录入");
        model.addAttribute(ApplicationConst.getForwordUrl(), "storeoperation/activity_entry");
        StoreActiviyTypeSearch storeActiviyTypeSearch = new StoreActiviyTypeSearch();
        if (StringDiyUtils.isEmpty(value)) {
            storeActiviyTypeSearch.setOrderByClause("ID DESC");
        } else {
            String[] keys = value.split("&");
            for (String key : keys) {
                if (key.split("=").length > 1) {
                    String vale = key.split("=")[1];
                    if (!StringDiyUtils.isEmpty(vale)) {
                        if (key.contains("id")) {
                            //這裡添加productName條件
                            storeActiviyTypeSearch.setOrderByClause("id " + vale);
                        }
                        if (key.contains("storeType")) {
                            //這裡添加productName條件
                            storeActiviyTypeSearch.createCriteria().andStoreTypeLike("%" + vale + "%");
                        }
                        if (key.contains("storeDesc")) {
                            //這裡添加productName條件
                            storeActiviyTypeSearch.createCriteria().andStoreDescLike("%" + vale + "%");
                        }
                        if (key.contains("storeTypeOp")) {
                            //這裡添加productName條件
                            storeActiviyTypeSearch.createCriteria().andStoreTypeOpLike("%" + vale + "%");
                        }
                    }
                }
            }
        }
        List<StoreActiviyType> types = storeActiviyTypeService.selectByExample(storeActiviyTypeSearch);
        if (types != null) {
            for (StoreActiviyType product : types) {
                StoreImageExample example = new StoreImageExample();
                example.createCriteria().andProductTypeIdEqualTo(product.getId());
                List<StoreImage> list = storeImageService.selectByExample(example);
                if (list != null && list.size() > 0) {
                    product.setStoreTypeIcon(list.get(0).getImageUrl());
                }
            }
            model.addAttribute("STORETYPE", types);
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
        if (product == null) {
            return false;
        }
        int t = storeProductService.updateById(product);
        if (t > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteImage(String id) {
        if (StringDiyUtils.isEmpty(id)) {
            return;
        }
        StoreImageExample example = new StoreImageExample();
        example.createCriteria().andProductTypeIdEqualTo(id);
        storeImageService.deleteByExample(example);
    }

    @Override
    public StoreProduct productedit(String id) {
        if (StringDiyUtils.isEmpty(id)) {
            return null;
        }
        StoreProduct product = storeProductService.getById(id);
        StoreImageExample example = new StoreImageExample();
        example.createCriteria().andProductTypeIdEqualTo(id);
        List<StoreImage> images = storeImageService.selectByExample(example);
        if (images != null && images.size() > 0) {
            product.setProductImage(images.get(0).getImageUrl());
        }
        return product;
    }

    @Override
    public boolean productdelete(String id) {
        if (StringDiyUtils.isEmpty(id)) {
            return false;
        }
        if (storeProductService.deleteById(id) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public StoreActiviyType activityedit(String id) {
        if (StringDiyUtils.isEmpty(id)) {
            return null;
        }
        StoreActiviyType type = storeActiviyTypeService.getById(id);
        StoreImageExample example = new StoreImageExample();
        example.createCriteria().andProductTypeIdEqualTo(id);
        List<StoreImage> images = storeImageService.selectByExample(example);
        if (images != null && images.size() > 0) {
            type.setStoreTypeIcon(images.get(0).getImageUrl());
        }
        return type;
    }

    @Override
    public boolean activitydelete(String id) {
        if (StringDiyUtils.isEmpty(id)) {
            return false;
        }
        if (storeActiviyTypeService.deleteById(id) > 0) {
            return true;
        } else {
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
        if (type == null) {
            return false;
        }
        int t = storeActiviyTypeService.updateById(type);
        if (t > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<StoreProduct> actproduct(String value) {
        StoreSaleSearch storeSaleSearch = new StoreSaleSearch();
        if (StringDiyUtils.isEmpty(value)) {
            storeSaleSearch.setOrderByClause("ID DESC");
        } else {
            String[] keys = value.split("&");
            for (String key : keys) {
                if (key.split("=").length > 1) {
                    String vale = key.split("=")[1];
                    if (!StringDiyUtils.isEmpty(vale)) {
                        if (key.contains("id")) {
                            //這裡添加productName條件
                            storeSaleSearch.createCriteria().andStoreTypeEqualTo(vale);
                        }
                    }
                }
            }
        }
        List<StoreSale> sales = storeSaleService.selectByExample(storeSaleSearch);
        List<StoreProduct> products = new ArrayList<StoreProduct>();
        for (StoreSale sale : sales) {
            StoreProduct product = storeProductService.getById(sale.getProductId());
            if (product != null) {
                StoreImageExample example = new StoreImageExample();
                example.createCriteria().andProductTypeIdEqualTo(sale.getProductId());
                List<StoreImage> list = storeImageService.selectByExample(example);
                if (list != null && list.size() > 0) {
                    product.setProductImage(list.get(0).getImageUrl());
                }
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public boolean activityproductremove(String id) {
        if (StringDiyUtils.isEmpty(id)) {
            return false;
        }
        StoreSaleSearch storeSaleSearch = new StoreSaleSearch();
        storeSaleSearch.createCriteria().andProductIdEqualTo(id);
        int t = storeSaleService.deleteByExample(storeSaleSearch);
        if (t > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**获取没有参加任何本活动的商品
     * @param s
     * @return
     */
    @Override
    public List<StoreProduct> activityproductinsert(String value) {
        StoreSaleSearch storeSaleSearch = new StoreSaleSearch();
        if (StringDiyUtils.isEmpty(value)) {
            storeSaleSearch.setOrderByClause("ID DESC");
        } else {
            String[] keys = value.split("&");
            for (String key : keys) {
                if (key.split("=").length > 1) {
                    String vale = key.split("=")[1];
                    if (!StringDiyUtils.isEmpty(vale)) {
                        if (key.contains("storeType")) {
                            //這裡添加productName條件
                            storeSaleSearch.createCriteria().andStoreTypeEqualTo(vale);
                        }
                    }
                }
            }
        }
        List<StoreSale> sales = storeSaleService.selectByExample(storeSaleSearch);
        List<String > ids = new ArrayList<String>();
        for (StoreSale sale : sales) {
            ids.add(sale.getProductId());
        }

        StoreProductSearch search = new StoreProductSearch();
        if (ids.size()>0) {
            search.createCriteria().andIdNotIn(ids);
        }
        List<StoreProduct>  products = storeProductService.selectByExample(search);
        for (StoreProduct product:products) {
            if (product != null) {
                StoreImageExample example = new StoreImageExample();
                example.createCriteria().andProductTypeIdEqualTo(product.getId());
                List<StoreImage> list = storeImageService.selectByExample(example);
                if (list != null && list.size() > 0) {
                    product.setProductImage(list.get(0).getImageUrl());
                }
            }
        }
        return products;
    }

    @Override
    public boolean activitysaleinsert(StoreSale sale) {
        if (sale == null){
            return false;
        }
        return  storeSaleService.insertSale(sale);
    }
}
