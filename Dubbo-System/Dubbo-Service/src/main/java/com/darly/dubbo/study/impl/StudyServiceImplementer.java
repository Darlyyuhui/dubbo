package com.darly.dubbo.study.impl;

import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.framework.base.Page;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.study.bean.Study;
import com.darly.dubbo.study.bean.StudySearch;
import com.darly.dubbo.study.dao.StudyMapper;
import com.darly.dubbo.study.service.StudyService;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
@Service
public class StudyServiceImplementer extends AbstractBaseService<Study, StudySearch> implements StudyService {

    @Resource
    private StudyMapper studyMapper;

    public Page getByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType) {
        StudySearch search = new StudySearch();
        StudySearch.Criteria criteria = search.createCriteria();
        if (map != null) {
            if (StringDiyUtils.notEmpty(map.get("code") + "")) {
                criteria.andCodeEqualTo(map.get("code").toString());
            }

            if (StringDiyUtils.notEmpty(map.get("name") + "")) {
                criteria.andNameLike("%" + map.get("name").toString() + "%");
            }
        }

        if (StringDiyUtils.notEmpty(sortType)) {
            search.setOrderByClause(sortType);
        }

        Page page = this.selectByExample(search, pageNo, pageSize);
        return page;
    }




    @Transactional
    public int save(Study dic) {
        int result = this.studyMapper.insertSelective(dic);
        this.refreshCache();
        return result;
    }

    @Transactional
    public int deleteByExample(StudySearch example) {
        int result = super.deleteByExample(example);
        this.refreshCache();
        return result;
    }

    @Transactional
    public int deleteById(String id) {
        int result = super.deleteById(id, this.getById(id));
        this.refreshCache();
        return result;
    }

    @Transactional
    public int updateByExample(Study record, StudySearch example) {
        int result = super.updateByExample(record, example);
        this.refreshCache();
        return result;
    }

    @Transactional
    public int updateByExampleSelective(Study record, StudySearch example) {
        int result = super.updateByExampleSelective(record, example);
        this.refreshCache();
        return result;
    }

    @Transactional
    public int updateById(Study record) {
        int result = super.updateById(record);
        this.refreshCache();
        return result;
    }

    @Transactional
    public int updateByIdSelective(Study record) {
        int result = super.updateByIdSelective(record);
        this.refreshCache();
        return result;
    }

    public List<Study> findAll() {
        return this.studyMapper.selectByExample(null);
    }

    protected BaseMapper<Study, StudySearch> getBaseMapper() {
        return this.studyMapper;
    }

    private void refreshCache() {
        Table<String, String, String> table = HashBasedTable.create();
        Iterator var2 = this.findAll().iterator();

        while(var2.hasNext()) {
            Study dic = (Study)var2.next();
            table.put(dic.getCode(), dic.getName(),dic.getRemark());
        }
        //this.cache.put(Study.class.getSimpleName(), table);
    }

    public String getNameByKey(String name, String code, String id) {
        Table table = null/*(Table)this.cache.get(name)*/;
        String str = "";
        if (table != null) {
            if (code == null) {
                str = table.column(name).get(id) == null ? "" : table.column(name).get(id) + "";
                return str;
            } else {
                str = table.column(code).get(id) == null ? "" : table.column(code).get(id) + "";
                return str;
            }
        } else {
            return str;
        }
    }
}
