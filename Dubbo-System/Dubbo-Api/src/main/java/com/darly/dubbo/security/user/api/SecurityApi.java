package com.darly.dubbo.security.user.api;

import org.springframework.ui.ModelMap;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/30
 * TODO : 点击登录时，需要将数据和模块传递到后台，由后端判断是否登录成功。
 */
public interface SecurityApi {

    /**
     * @return 传递参数到后端进行判断
     */
    ModelMap checkloginuser(String username,String password);
}
