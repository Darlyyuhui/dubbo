package com.darly.dubbo.searchengine;

import com.darly.dubbo.mobile.cfg.ResponseUtil;
import com.darly.dubbo.searchengine.api.SearchEngineApi;
import com.darly.dubbo.security.BaseSecurityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2018/1/29
 * TODO :
 */
@Controller
public class SearchEngineController  extends BaseSecurityController {

    @Autowired
    SearchEngineApi searchEngineApi;

    /**
     * 商城管理页面首页
     *
     * @return
     */
    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public void searchEngine( HttpServletRequest request, HttpServletResponse response) {
        String arg = request.getParameter("KeyWord");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
        resultMap.put(ResponseUtil.RES_KEY_RESULT,searchEngineApi.searchEngine(arg).get("values"));
        resultMap.put(ResponseUtil.RES_KEY_DESC, "測試正常");
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

}
