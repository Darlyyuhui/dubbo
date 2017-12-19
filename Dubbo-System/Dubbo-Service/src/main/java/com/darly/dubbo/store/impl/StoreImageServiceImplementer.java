package com.darly.dubbo.store.impl;

import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.store.bean.StoreImage;
import com.darly.dubbo.store.bean.StoreImageExample;
import com.darly.dubbo.store.dao.StoreImageMapper;
import com.darly.dubbo.store.service.StoreImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
@Service
public class StoreImageServiceImplementer extends AbstractBaseService<StoreImage, StoreImageExample> implements StoreImageService {

    @Resource
    private StoreImageMapper storeImageMapper;

    public List<StoreImage> findAll() {
        return this.storeImageMapper.selectByExample(null);
    }

    @Override
    public boolean insertImage(StoreImage image) {
       int t =  storeImageMapper.insertSelective(image);
       if (t>0){
           return true;
       }else {
           return false;
       }
    }

    protected BaseMapper<StoreImage, StoreImageExample> getBaseMapper() {
        return this.storeImageMapper;
    }
}
