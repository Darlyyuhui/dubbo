package com.darly.dubbo.framework.common.useragent;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/10/28 16:24
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public enum RenderingEngine {
    TRIDENT("Trident"),
    WORD("Microsoft Office Word"),
    GECKO("Gecko"),
    WEBKIT("WebKit"),
    PRESTO("Presto"),
    MOZILLA("Mozilla"),
    KHTML("KHTML"),
    OTHER("Other");

    String name;

    private RenderingEngine(String name) {
        this.name = name;
    }
}

