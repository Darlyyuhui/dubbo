package com.darly.dubbo.store.dao;

import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.store.bean.StoreImage;
import com.darly.dubbo.store.bean.StoreImageExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface StoreImageMapper extends BaseMapper<StoreImage,StoreImageExample> {
    int countByExample(StoreImageExample example);

    int deleteByExample(StoreImageExample example);

    int deleteByPrimaryKey(String id);

    int insert(StoreImage record);

    int insertSelective(StoreImage record);

    List<StoreImage> selectByExampleWithRowbounds(StoreImageExample example, RowBounds rowBounds);

    List<StoreImage> selectByExample(StoreImageExample example);

    StoreImage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StoreImage record, @Param("example") StoreImageExample example);

    int updateByExample(@Param("record") StoreImage record, @Param("example") StoreImageExample example);

    int updateByPrimaryKeySelective(StoreImage record);

    int updateByPrimaryKey(StoreImage record);
}