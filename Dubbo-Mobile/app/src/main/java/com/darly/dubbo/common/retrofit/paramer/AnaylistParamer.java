package com.darly.dubbo.common.retrofit.paramer;

/**
 * Created by Zhangyuhui/Darly on 2017/7/25.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO:
 */
public class AnaylistParamer {

    public int pageNo;
    public String regionName;
    public String regionId;

    public String isOver;

    public String type_name;

    public String analy_name;

    public AnaylistParamer(int pageNo, String regionName, String regionId, String isOver, String type_name, String analy_name) {
        this.pageNo = pageNo;
        this.regionName = regionName;
        this.regionId = regionId;
        this.isOver = isOver;
        this.type_name = type_name;
        this.analy_name = analy_name;
    }
}
