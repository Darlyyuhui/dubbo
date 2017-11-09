package com.darly.dubbo.framework.base;

import com.darly.dubbo.framework.common.StringDiyUtils;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/14 16:42
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： Service的實現類。
 */
public abstract class AbstractBaseService<T,S> implements BaseService<T, S> {
    //protected Logger logger = new Logger(getClass());
    /**
     * 子类实现
     * @return the baseMapper
     */
    protected abstract BaseMapper<T, S> getBaseMapper();

    @Transactional
    @Override
    public int deleteByExample(S example) {
        return getBaseMapper().deleteByExample(example);
    }

    @Override
    @Transactional
    public int deleteById(String id) {
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public int deleteById(String id,T record){
        return getBaseMapper().deleteByPrimaryKey(id);
    }

    @Override
    public T getById(String id) {
        return getBaseMapper().selectByPrimaryKey(id);
    }

    @Override
    public int getTotalByExample(S example) {
        return getBaseMapper().countByExample(example);
    }

    @Override
    @Transactional
    public int save(T record) {
        return getBaseMapper().insertSelective(record);
    }

    @Override
    public List<T> selectByExample(S example) {
        return getBaseMapper().selectByExample(example);
    }

    @Override
    public Page selectByExample(S example, int pageNo, int pageSize) {
        List<T> dics = getBaseMapper().selectByExample(example, Page.getRowBounds(pageNo, pageSize));
        int totalCount = getBaseMapper().countByExample(example);
        return Page.getPage(totalCount, dics, pageNo, pageSize);
    }


    @Override
    @Transactional
    public int updateByExample(T record, S example) {
        return getBaseMapper().updateByExample(record, example);
    }

    @Override
    @Transactional
    public int updateByExampleSelective(T record, S example) {
        return getBaseMapper().updateByExampleSelective(record, example);
    }

    @Override
    @Transactional
    public int updateById(T record) {
        return getBaseMapper().updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    public int updateByIdSelective(T record) {
        return getBaseMapper().updateByPrimaryKeySelective(record);
    }



    @Override
    public Page getListByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType) {
        if(StringDiyUtils.notEmpty(sortType)){
            map.put("sortColumn", sortType);
        }
        List<T> dics = getBaseMapper().getListByCondition(map,Page.getRowBounds(pageNo, pageSize));
        int totalCount = getBaseMapper().countList(map);
        return Page.getPage(totalCount, dics, pageNo, pageSize);
    }

    /* (non-Javadoc)
     */
    @Override
    public Page getListByCondition(Map<String, Object> map, int pageNo, int pageSize,String sortType,String menuid) {
        return null;
    }

    /* (non-Javadoc)
     */
    @Override
    public int countList(Map<String, Object> map) {
        return  getBaseMapper().countList(map);
    }



}
