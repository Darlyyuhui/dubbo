package com.darly.dubbo.store.impl;

import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.store.bean.StoreActiviyType;
import com.darly.dubbo.store.bean.StoreActiviyTypeSearch;
import com.darly.dubbo.store.dao.StoreActiviyTypeMapper;
import com.darly.dubbo.store.service.StoreActiviyTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
@Service
public class StoreActiviyTypeServiceImplementer extends AbstractBaseService<StoreActiviyType, StoreActiviyTypeSearch> implements StoreActiviyTypeService {

    @Resource
    private StoreActiviyTypeMapper storeActiviyTypeMapper;

    public List<StoreActiviyType> findAll() {
        StoreActiviyTypeSearch search = new StoreActiviyTypeSearch();
        search.setOrderByClause("ID desc");
        return this.storeActiviyTypeMapper.selectByExample(search);
    }

    protected BaseMapper<StoreActiviyType, StoreActiviyTypeSearch> getBaseMapper() {
        return this.storeActiviyTypeMapper;
    }
}
