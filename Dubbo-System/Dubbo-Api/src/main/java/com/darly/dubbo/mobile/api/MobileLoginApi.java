package com.darly.dubbo.mobile.api;

import com.darly.dubbo.security.system.bean.SystemLog;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/14
 * TODO :
 */
public interface MobileLoginApi {

    List<SystemLog> loginLog() throws Exception;
}
