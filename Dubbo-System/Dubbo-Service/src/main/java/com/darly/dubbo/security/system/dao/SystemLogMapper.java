package com.darly.dubbo.security.system.dao;


import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.system.bean.SystemLogSearch;

import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 10:07
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public interface SystemLogMapper extends BaseMapper<SystemLog,SystemLogSearch> {
    /***
     * 获取上一次登录的信息
     */
    SystemLog selectLastLogUser(String account, String logTime);

    List<SystemLog> selectUserAccount();

    List<SystemLog> selectAllUserLogin();

    List<SystemLog> getSystemLogsByUser(String account);
}
