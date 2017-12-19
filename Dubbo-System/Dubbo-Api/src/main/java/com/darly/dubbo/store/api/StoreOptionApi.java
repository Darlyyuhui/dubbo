package com.darly.dubbo.store.api;

import org.springframework.ui.ModelMap;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/9
 * TODO :
 */
public interface StoreOptionApi {
     //商城管理首页
     ModelMap optionIndex();
     //商品录入
     ModelMap productentry();
     //活动录入
     ModelMap activityentry();

}
