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

    public StudyController() {
        System.out.println("----------------->----------------->----------------->----------------->----------------->----------------->----------------->----------------->");
        System.out.println("----------------->----------------->----------------->----------------->----------------->----------------->----------------->----------------->");
        System.out.println("----------------->----------------->----------------->----------------->----------------->----------------->----------------->----------------->");
        System.out.println("----------------->----------------->----------------->----------------->----------------->----------------->----------------->----------------->");
        System.out.println("----------------->----------------->----------------->----------------->----------------->----------------->----------------->----------------->");
        System.out.println("----------------->----------------->----------------->----------------->----------------->----------------->----------------->----------------->");
    }

    @Resource
    StudyApi studyApi;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public void listStudent() {
        System.out.println("----------------->"+studyApi.listStudys());
    }
}