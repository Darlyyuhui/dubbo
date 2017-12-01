package com.darly.dubbo.framework.common.useragent;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/10/28 16:23
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public enum BrowserType {
    WEB_BROWSER("Browser"),
    MOBILE_BROWSER("Browser (mobile)"),
    TEXT_BROWSER("Browser (text only)"),
    EMAIL_CLIENT("Email Client"),
    ROBOT("Robot"),
    TOOL("Downloading tool"),
    UNKNOWN("unknown");

    private String name;

    private BrowserType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
