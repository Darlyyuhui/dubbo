package com.darly.dubbo.framework.base;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/14 9:23
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 所有mapper的父类,各业务中的mapper需要继承此接口，比便在业务mapper中保留自己需要的业务接口
 */
public interface BaseMapper<T,S>  {

    /***
     * 根据实例获取记录条数
     * @param example
     * @return
     */
    int countByExample(S example);
    /***
     * 根据条件删除,可实现批量删除
     * @param example
     * @return
     */
    int deleteByExample(S example);
    /***
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);
    /***
     * 根据条件获取记录
     * @param example
     * @return
     */
    List<T> selectByExample(S example);

    /***
     * 根据条件获取记录
     * @param example
     * @return
     */
    List<T> selectByExampleWithBLOBs(S example);

    /***
     * 根据条件获取分页数据
     * @param example
     * @param rowBounds
     * @return
     */
    List<T> selectByExample(S example, RowBounds rowBounds);


    /***
     * 根据条件获取分页数据
     * @param map
     * @param rowBounds
     * @return
     */
    List<T> getListByCondition(Map<String, Object> map, RowBounds rowBounds);

    /***
     * 分页总数方法与getListByCondition配套使用，以实现分页
     * @param map
     * @return
     */
    int countList(Map<String, Object> map);

    /***
     * 根据主键获取对象
     * @param id
     * @return
     */
    T selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") T record, @Param("example") S example);

    int updateByExample(@Param("record") T record, @Param("example") S example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
