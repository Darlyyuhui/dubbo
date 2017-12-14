package com.darly.dubbo.store.dao;

import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.store.bean.StoreProduct;
import com.darly.dubbo.store.bean.StoreProductSearch;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface StoreProductMapper extends BaseMapper<StoreProduct,StoreProductSearch> {
    int countByExample(StoreProductSearch example);

    int deleteByExample(StoreProductSearch example);

    int deleteByPrimaryKey(String id);

    int insert(StoreProduct record);

    int insertSelective(StoreProduct record);

    List<StoreProduct> selectByExampleWithRowbounds(StoreProductSearch example, RowBounds rowBounds);

    List<StoreProduct> selectByExample(StoreProductSearch example);

    StoreProduct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StoreProduct record, @Param("example") StoreProductSearch example);

    int updateByExample(@Param("record") StoreProduct record, @Param("example") StoreProductSearch example);

    int updateByPrimaryKeySelective(StoreProduct record);

    int updateByPrimaryKey(StoreProduct record);
}