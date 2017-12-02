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
    private static  String applicationName= "itmstitle";
    /**
     * 页面内容标题
     */
    private static  String pageTitle= "itmsname";
    /**
     * 跳转页面的URL跳转参数
     */
    private static  String forwordUrl= "url_forword";

    /**
     * 靜態資源文件路徑
     */
    private static  String resourceUrl= "resourceUrl";



    private ApplicationConst(){
        throw new IllegalStateException("Utility class");
    }

    public static String getApplicationName(){
        return applicationName;
    }

    public static String getForwordUrl() {
        return forwordUrl;
    }

    public static String getResourceUrl() {
        return resourceUrl;
    }

    public static String getPageTitle() {
        return pageTitle;
    }
}
