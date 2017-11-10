package com.darly.dubbo.study.web;


import com.darly.dubbo.study.api.StudyApi;
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

    @Resource
    StudyApi studyApi;

    @RequestMapping(path = "/liststudy", method = RequestMethod.GET)
    public void listStudent() {
        System.out.println("----------------->"+studyApi.listStudys());
    }
}