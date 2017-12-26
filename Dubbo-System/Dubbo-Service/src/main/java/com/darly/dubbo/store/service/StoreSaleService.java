package com.darly.dubbo.store.service;


import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.store.bean.StoreSale;
import com.darly.dubbo.store.bean.StoreSaleSearch;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
public interface StoreSaleService extends BaseService<StoreSale, StoreSaleSearch> {
    List<StoreSale> findAll();

    boolean insertSale(StoreSale sale);
}
