package com.darly.dubbo.lucene.impl;

import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.lucene.bean.SystemLucene;
import com.darly.dubbo.lucene.bean.SystemLuceneSearch;
import com.darly.dubbo.lucene.dao.SystemLuceneMapper;
import com.darly.dubbo.lucene.service.SystemLuceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
@Service
public class SystemLuceneImplementer extends AbstractBaseService<SystemLucene, SystemLuceneSearch> implements SystemLuceneService {
    @Autowired
    SystemLuceneMapper mapper;
    @Override
    protected BaseMapper<SystemLucene, SystemLuceneSearch> getBaseMapper() {
        return mapper;
    }

    @Override
    public int save(SystemLucene record) {
        int result = this.mapper.insert(record);
        return result;
    }

    @Override
    public int count(SystemLuceneSearch search) {
        return mapper.countByExample(search);
    }
}
