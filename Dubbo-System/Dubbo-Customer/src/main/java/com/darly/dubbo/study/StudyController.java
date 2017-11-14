package com.darly.dubbo.study;


import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.study.api.StudyApi;
import com.darly.dubbo.study.bean.Study;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
@Controller
@RequestMapping({"build"})
public class StudyController {

    @Resource
    StudyApi studyApi;
    /**
     * @param model
     * @return 进入到學習列表页面
     */
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String studyBuild(ModelMap modelMap) {
        modelMap.putAll(studyApi.studybuild());
        return (String) modelMap.get(ApplicationConst.FORWORD_URL);
    }


}