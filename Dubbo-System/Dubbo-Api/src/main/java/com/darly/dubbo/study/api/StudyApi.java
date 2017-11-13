package com.darly.dubbo.study.api;

import org.springframework.ui.ModelMap;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/9
 * TODO :
 */
public interface StudyApi {

     String studybuild(ModelMap model);

     String checkjson(ModelMap model);
}
