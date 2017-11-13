package com.darly.dubbo.security.system.service;




import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.framework.base.Page;
import com.darly.dubbo.security.securitycfg.UserDetials;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.system.bean.SystemLogSearch;

import java.util.Map;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 9:13
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 系統日志
 */
public interface SystemLogService extends BaseService<SystemLog,SystemLogSearch> {
    /***
     * 数据保存
     */
    public int save(SystemLog log);

    /***
     * 根据id获取详情信息
     */
    public SystemLog getById(String id);

    /***
     * 获取登陆日志分页数据
     */
    public Page getSystemLogsByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType);

    /***
     * 获取上次登录的相关信息
     */
    public SystemLog getLastLogInfo(UserDetials operator);
}
