package com.darly.dubbo.framework.cache;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 14:11
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：底层缓存接口
 */
public interface BaseCache {
    String DIC_CACHE = "dicCache";
    String ANALYZE_CACHE = "analyzeCache";
    String MENU_CACHE = "menu_cache";
    String STUDY_CACHE = "studyCache";

    void init() throws Exception;

    String getCacheKey();
}
