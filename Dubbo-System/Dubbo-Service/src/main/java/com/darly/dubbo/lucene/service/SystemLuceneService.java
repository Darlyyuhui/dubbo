package com.darly.dubbo.lucene.service;


import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.lucene.bean.SystemLucene;
import com.darly.dubbo.lucene.bean.SystemLuceneSearch;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
public interface SystemLuceneService extends BaseService<SystemLucene, SystemLuceneSearch> {

    int save(SystemLucene lucene);

    int count(SystemLuceneSearch search);
}
