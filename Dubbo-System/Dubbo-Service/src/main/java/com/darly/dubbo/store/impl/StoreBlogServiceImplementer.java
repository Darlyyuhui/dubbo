package com.darly.dubbo.store.impl;

import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.framework.base.Page;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.store.bean.StoreBlog;
import com.darly.dubbo.store.bean.StoreBlogSearch;
import com.darly.dubbo.store.dao.StoreBlogMapper;
import com.darly.dubbo.store.service.StoreBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
@Service
public class StoreBlogServiceImplementer extends AbstractBaseService<StoreBlog, StoreBlogSearch> implements StoreBlogService {

    @Resource
    private StoreBlogMapper storeBlogMapper;

    public List<StoreBlog> findAll() {
        return this.storeBlogMapper.selectByExample(null);
    }

    protected BaseMapper<StoreBlog, StoreBlogSearch> getBaseMapper() {
        return this.storeBlogMapper;
    }
}
