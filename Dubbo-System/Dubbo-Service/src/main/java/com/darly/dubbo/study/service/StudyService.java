package com.darly.dubbo.study.service;


import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.framework.base.Page;
import com.darly.dubbo.study.bean.Study;
import com.darly.dubbo.study.bean.StudySearch;

import java.util.List;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
public interface StudyService extends BaseService<Study, StudySearch> {
    Page getByCondition(Map<String, Object> var1, int var2, int var3, String var4);

    int save(Study var1);

    List<Study> findAll();

    String getNameByKey(String var1, String var2, String var3);
}
