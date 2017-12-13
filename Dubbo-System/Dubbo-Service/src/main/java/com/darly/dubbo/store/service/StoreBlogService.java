package com.darly.dubbo.store.service;


import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.store.bean.StoreBlog;
import com.darly.dubbo.store.bean.StoreBlogSearch;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
public interface StoreBlogService extends BaseService<StoreBlog, StoreBlogSearch> {
    List<StoreBlog> findAll();
}
