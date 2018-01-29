package com.darly.dubbo.searchengine.api;

import org.springframework.ui.ModelMap;


/** 搜索引擎API
 * Author : ZhangYuHui
 * Date : 2017/11/9
 * TODO :
 */
public interface SearchEngineApi {
     ModelMap searchEngine(String key);
}
