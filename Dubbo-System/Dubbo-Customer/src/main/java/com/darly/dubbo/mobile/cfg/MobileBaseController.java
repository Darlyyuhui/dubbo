package com.darly.dubbo.mobile.cfg;

import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.mobile.session.SessionData;
import com.darly.dubbo.mobile.session.SessionUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/14
 * TODO :
 */
public class MobileBaseController {
    public Logger logger = new Logger(getClass());
    //--------------------------实现前端接口返回格式-----------------------------------------
    Map<String, Object> resultMap;
    /**
     * 默认页码
     */
    int pageNo = 1;

    /**
     * 默认页数
     */
    int pageSize = 20;

    /**
     * 初始化返回结果集
     */
    protected void initResultMap() {
        resultMap = new HashMap<>();
    }

    /**
     *  正确接口数据返回
     */
    protected void dataResult(String code, String desc, Object data, HttpServletRequest request, HttpServletResponse response) {
        this.initResultMap();
        resultMap.put(ResponseUtil.RES_KEY_CODE, code);
        resultMap.put(ResponseUtil.RES_KEY_DESC, desc);
        resultMap.put(ResponseUtil.RES_KEY_RESULT, data);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /**
     * 简单格式返回
     */
    protected void simpleResult(String code, String desc, HttpServletRequest request, HttpServletResponse response) {
        this.initResultMap();
        resultMap.put(ResponseUtil.RES_KEY_CODE, code);
        resultMap.put(ResponseUtil.RES_KEY_DESC, desc);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }


    /**
     * 获取当前登录人信息
     * @param request
     * @return
     */
    public SessionData getLoginData(HttpServletRequest request) {
        Object user = SessionUtil.SESSION_MAP.get(SessionUtil.makeSessionKey(request));

        return (SessionData)user;
    }
    /**
     * 获取登录人信息
     * @param account
     * @param imei
     * @return
     */
    protected SessionData getLoginUser(String account,String imei){
        Object user = SessionUtil.SESSION_MAP.get(SessionUtil.makeSessionKey(account, imei));

        return (SessionData)user;
    }
    /**
     * 获取当前登录人ID
     * @param request
     * @return
     */
    public String getLoginId(HttpServletRequest request) {
        SessionData sd = this.getLoginData(request);
        return sd.getId();
    }
}
