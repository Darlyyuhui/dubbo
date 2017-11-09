package com.darly.dubbo.study.controller;


import com.darly.dubbo.study.api.StudyApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
@Controller
@RequestMapping({"/study"})
public class StudyController {
    private static Logger logger = LoggerFactory.getLogger(StudyController.class);

    @Resource
    StudyApi studyApi;

    @RequestMapping(path = "/listStudent", method = RequestMethod.POST)
    public void listStudent() {
        logger.info("the data are " + studyApi.listStudys());
    }
}
