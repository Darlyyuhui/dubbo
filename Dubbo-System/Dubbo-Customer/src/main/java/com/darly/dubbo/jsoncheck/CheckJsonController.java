package com.darly.dubbo.jsoncheck;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.security.BaseSecurityController;
import com.darly.dubbo.study.api.StudyApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
@Controller
public class CheckJsonController extends BaseSecurityController {
    @Resource
    StudyApi studyApi;

    /**
     * @param model
     * @return 进入到Json验证页面
     */
    @RequestMapping(value = {"/checkjson"}, method = RequestMethod.GET)
    public String checkjson(ModelMap model) {
        hasUser(model);
        model.putAll(studyApi.checkjson());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    /**
     * @param model
     * @return 进入到Json验证页面
     */
    @RequestMapping(value = {"/landy"}, method = RequestMethod.GET)
    public String landy(ModelMap model) {
        hasUser(model);
        model.putAll(studyApi.landy());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }
    /**
     * @param model
     * @return 进入到Json验证页面
     */
    @RequestMapping(value = {"/gradle"}, method = RequestMethod.GET)
    public String gradle(ModelMap model) {
        hasUser(model);
        model.putAll(studyApi.gradle());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

}
