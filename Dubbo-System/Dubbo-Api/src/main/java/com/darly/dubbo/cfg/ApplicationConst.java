package com.darly.dubbo.cfg;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/14
 * TODO: 系統自定义常量类
 */
public class ApplicationConst {
    /**
     * 系统名称提取参数
     */
    private static  String applicationName= "itmsname";
    /**
     * 跳转页面的URL跳转参数
     */
    private static  String forwordUrl= "url_forword";

    private ApplicationConst(){
        throw new IllegalStateException("Utility class");
    }

    public static String getApplicationName(){
        return applicationName;
    }

    public static String getForwordUrl() {
        return forwordUrl;
    }
}
