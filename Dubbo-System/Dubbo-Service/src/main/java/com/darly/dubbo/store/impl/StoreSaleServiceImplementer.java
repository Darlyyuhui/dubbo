package com.darly.dubbo.store.impl;

import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.store.bean.StoreSale;
import com.darly.dubbo.store.bean.StoreSaleSearch;
import com.darly.dubbo.store.dao.StoreSaleMapper;
import com.darly.dubbo.store.service.StoreSaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
@Service
public class StoreSaleServiceImplementer extends AbstractBaseService<StoreSale, StoreSaleSearch> implements StoreSaleService {

    @Resource
    private StoreSaleMapper storeSaleMapper;

    public List<StoreSale> findAll() {
        return this.storeSaleMapper.selectByExample(null);
    }

    protected BaseMapper<StoreSale, StoreSaleSearch> getBaseMapper() {
        return this.storeSaleMapper;
    }
}
