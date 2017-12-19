package com.darly.dubbo.store.service;


import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.store.bean.StoreImage;
import com.darly.dubbo.store.bean.StoreImageExample;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
public interface StoreImageService extends BaseService<StoreImage, StoreImageExample> {
    List<StoreImage> findAll();

    boolean insertImage(StoreImage image);

}
