package com.darly.dubbo.store.impl;

import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.store.bean.StoreProduct;
import com.darly.dubbo.store.bean.StoreProductSearch;
import com.darly.dubbo.store.dao.StoreProductMapper;
import com.darly.dubbo.store.service.StoreProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
@Service
public class StoreProductServiceImplementer extends AbstractBaseService<StoreProduct, StoreProductSearch> implements StoreProductService {

    @Resource
    private StoreProductMapper storeProductMapper;

    public List<StoreProduct> findAll() {
        return this.storeProductMapper.selectByExample(null);
    }

    @Override
    public boolean insertProduct(StoreProduct product) {
        int t =  storeProductMapper.insertSelective(product);
        if (t>0){
            return true;
        }else {
            return false;
        }
    }

    protected BaseMapper<StoreProduct, StoreProductSearch> getBaseMapper() {
        return this.storeProductMapper;
    }
}
