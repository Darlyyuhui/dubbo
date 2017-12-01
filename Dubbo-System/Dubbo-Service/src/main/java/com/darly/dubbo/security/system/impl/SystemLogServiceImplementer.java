package com.darly.dubbo.security.system.impl;

import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.framework.base.Page;
import com.darly.dubbo.framework.common.DateUtil;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.systemlog.constant.FORMAT;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.system.bean.SystemLogSearch;
import com.darly.dubbo.security.system.dao.SystemLogMapper;
import com.darly.dubbo.security.system.service.SystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Map;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 10:12
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
@Service
public class SystemLogServiceImplementer extends AbstractBaseService<SystemLog,SystemLogSearch> implements SystemLogService {
    public SystemLogServiceImplementer() {
    }
    @Resource
    SystemLogMapper systemLogMapper;
    @Override
    protected BaseMapper<SystemLog, SystemLogSearch> getBaseMapper() {
        return systemLogMapper;
    }

    @Override
    public Page getSystemLogsByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType) {
        SystemLogSearch search = new SystemLogSearch();
        SystemLogSearch.Criteria criteria = search.createCriteria();
        if(map!=null){
            if(StringDiyUtils.notEmpty(map.get("startTime")+"")){
                try {
                    criteria.andOperationTimeGreaterThanOrEqualTo(DateUtil.parseDate(map.get("startTime").toString(), FORMAT.DATETIME.DEFAULT));
                } catch (ParseException e) {
                    logger.error(e);
                }
            }

            if(StringDiyUtils.notEmpty(map.get("endtime")+"")){
                try {
                    criteria.andOperationTimeLessThanOrEqualTo(DateUtil.parseDate(map.get("endtime").toString(),FORMAT.DATETIME.DEFAULT));
                } catch (ParseException e) {
                    logger.error(e);
                }
            }

            if(StringDiyUtils.notEmpty(map.get("type")+"")){
                criteria.andTypeEqualTo(Long.parseLong(map.get("type")+""));
            }

            if(StringDiyUtils.notEmpty(map.get("operatorId")+"")){
                criteria.andOperatorIdEqualTo(map.get("operatorId")+"");
            }

            if(StringDiyUtils.notEmpty(map.get("operatorName")+"")){
                criteria.andOperatorNameLike("%"+map.get("operatorName")+"%");
            }
        }
        search.setOrderByClause("OPERATION_TIME desc");
        Page page = selectByExample(search, pageNo, pageSize);
        return page;
    }

    @Override
    public int save(SystemLog record) {
        return systemLogMapper.insertSelective(record);
    }
}
