package com.darly.dubbo.framework.common.useragent;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/10/28 16:26
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public enum ApplicationType {
    WEBMAIL("Webmail client"),
    UNKNOWN("unknown");

    private String name;

    private ApplicationType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
