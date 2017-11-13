package com.darly.dubbo.framework.cache;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 14:12
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：缓存接口
 */
public interface Cache {
    Object get(String var1);

    void put(String var1, Object var2);

    void removeCacheByKey(String var1);

    void setCacheKey(String var1);

    void removeAll();

    void flush();
}
