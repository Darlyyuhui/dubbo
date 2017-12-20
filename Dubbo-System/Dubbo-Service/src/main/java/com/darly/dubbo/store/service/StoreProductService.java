package com.darly.dubbo.store.service;


import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.store.bean.StoreImage;
import com.darly.dubbo.store.bean.StoreProduct;
import com.darly.dubbo.store.bean.StoreProductSearch;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
public interface StoreProductService extends BaseService<StoreProduct, StoreProductSearch> {

    List<StoreProduct> findAll();

    boolean insertProduct(StoreProduct product);
}
