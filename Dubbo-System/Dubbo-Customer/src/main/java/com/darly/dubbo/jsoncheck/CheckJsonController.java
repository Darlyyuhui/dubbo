package com.darly.dubbo.jsoncheck;

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
public class CheckJsonController {
    @Resource
    StudyApi studyApi;

    /**
     * @param model
     * @return 进入到Json验证页面
     */
    @RequestMapping(value = {"/checkjson"}, method = RequestMethod.GET)
    public String checkjson(ModelMap model) {
        return studyApi.checkjson(model);
    }

}
