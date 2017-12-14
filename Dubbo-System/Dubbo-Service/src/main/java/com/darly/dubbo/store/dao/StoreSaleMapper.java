package com.darly.dubbo.store.dao;

import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.store.bean.StoreSale;
import com.darly.dubbo.store.bean.StoreSaleSearch;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface StoreSaleMapper extends BaseMapper<StoreSale,StoreSaleSearch> {
    int countByExample(StoreSaleSearch example);

    int deleteByExample(StoreSaleSearch example);

    int deleteByPrimaryKey(String id);

    int insert(StoreSale record);

    int insertSelective(StoreSale record);

    List<StoreSale> selectByExampleWithRowbounds(StoreSaleSearch example, RowBounds rowBounds);

    List<StoreSale> selectByExample(StoreSaleSearch example);

    StoreSale selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StoreSale record, @Param("example") StoreSaleSearch example);

    int updateByExample(@Param("record") StoreSale record, @Param("example") StoreSaleSearch example);

    int updateByPrimaryKeySelective(StoreSale record);

    int updateByPrimaryKey(StoreSale record);
}