package com.darly.dubbo.store.api;

import com.darly.dubbo.store.bean.StoreActiviyType;
import com.darly.dubbo.store.bean.StoreProduct;
import com.darly.dubbo.store.bean.StoreSale;
import org.springframework.ui.ModelMap;

import java.util.List;

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
    //编辑活动
    StoreActiviyType activityedit(String id);
    //删除活动
    boolean activitydelete(String id);

    //錄入活动
    boolean insertActivity(StoreActiviyType type);
    //活动更新
    boolean updateActivity(StoreActiviyType type);
    //获取活动对应商品集合
    List<StoreProduct> actproduct(String s);
    //移除活动中的商品
    boolean activityproductremove(String id);
    //获取没有参加任何本活动的商品
    List<StoreProduct> activityproductinsert(String s);
    //插入数据
    boolean activitysaleinsert(StoreSale sale);
}
