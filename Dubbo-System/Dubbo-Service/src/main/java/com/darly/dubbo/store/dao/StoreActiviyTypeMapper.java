package com.darly.dubbo.store.dao;

import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.store.bean.StoreActiviyType;
import com.darly.dubbo.store.bean.StoreActiviyTypeSearch;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface StoreActiviyTypeMapper extends BaseMapper<StoreActiviyType,StoreActiviyTypeSearch>{
    int countByExample(StoreActiviyTypeSearch example);

    int deleteByExample(StoreActiviyTypeSearch example);

    int deleteByPrimaryKey(String id);

    int insert(StoreActiviyType record);

    int insertSelective(StoreActiviyType record);

    List<StoreActiviyType> selectByExampleWithRowbounds(StoreActiviyTypeSearch example, RowBounds rowBounds);

    List<StoreActiviyType> selectByExample(StoreActiviyTypeSearch example);

    StoreActiviyType selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StoreActiviyType record, @Param("example") StoreActiviyTypeSearch example);

    int updateByExample(@Param("record") StoreActiviyType record, @Param("example") StoreActiviyTypeSearch example);

    int updateByPrimaryKeySelective(StoreActiviyType record);

    int updateByPrimaryKey(StoreActiviyType record);
}