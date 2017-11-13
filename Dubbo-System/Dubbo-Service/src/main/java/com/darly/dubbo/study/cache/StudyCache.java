package com.darly.dubbo.study.cache;


import com.darly.dubbo.framework.cache.BaseCache;
import com.darly.dubbo.framework.cache.Cache;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.study.bean.Study;
import com.darly.dubbo.study.service.StudyService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO : 系统数据字典缓存类 数据字典缓存
 */

public class StudyCache implements BaseCache {
    private final Logger logger = new Logger(StudyCache.class);
    @Resource
    Cache cache;

    @Resource
    StudyService studyService;

    @Override
    public String getCacheKey() {
        return STUDY_CACHE;
    }

    @Override
    public void init() throws Exception {
        List<Study> dics = studyService.findAll();
        cache.put(STUDY_CACHE,dics);
        logger.info("[学习页面源码数据] 缓存初始化完成");
    }

}
