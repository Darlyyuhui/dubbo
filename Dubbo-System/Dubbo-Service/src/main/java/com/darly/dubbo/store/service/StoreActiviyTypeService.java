package com.darly.dubbo.store.service;


import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.store.bean.StoreActiviyType;
import com.darly.dubbo.store.bean.StoreActiviyTypeSearch;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
public interface StoreActiviyTypeService extends BaseService<StoreActiviyType, StoreActiviyTypeSearch> {
    List<StoreActiviyType> findAll();
}
