package com.darly.dubbo.framework.base;



import com.darly.dubbo.framework.common.ResponseUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/20
 * TODO :
 */
public class MobileBaseController extends BaseController {

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

}
