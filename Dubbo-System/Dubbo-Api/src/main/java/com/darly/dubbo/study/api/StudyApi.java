package com.darly.dubbo.study.api;

import org.springframework.ui.ModelMap;

import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/9
 * TODO :
 */
public interface StudyApi {

     ModelMap studybuild();

     ModelMap checkjson();

    ModelMap landy();

    ModelMap gradle();
}
