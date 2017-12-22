package com.darly.dubbo.store.api;

import com.darly.dubbo.store.bean.StoreProduct;
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
     ModelMap productentry(String value);
     //活动录入
     ModelMap activityentry(String value);
     //錄入商品
    boolean insertProduct(StoreProduct product);
    //商品更新
    boolean updateProduct(StoreProduct product);
    //刪除商品圖片
    void deleteImage(String id);


    //查詢商品
    StoreProduct productedit(String id);

    //删除制定商品
    boolean productdelete(String id);
}
