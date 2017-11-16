package com.darly.dubbo.common.retrofit.paramer;


/**
 * Created by Zhangyuhui/Darly on 2017/7/18.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO:
 */
public class AddPointParamer {

    //点位id
    public String id;
    //方案id
    public String schemeId;
    //编号
    public String code;
    //经度
    public double longitude;
    //纬度
    public double latitude;
    //采样范围X
    public String rangeX;
    //采样范围Y
    public String rangeY;
    //所属区域编号
    public String areaCode;
    //是否采样点
    public Integer isSamplingPoint;
    //核查状态
    public Integer checkStatus;
    //是否发布
    public Integer isRelease;
    //是否采样
    public Integer isSampling;
    //创建人
    public String createId;
    //创建时间
    public String createTime;
    //修改人
    public String updateId;
    //修改时间
    public String updateTime;
    //地块ID
    public String blockId;
    //采样选址
    public String regionId;

    public AddPointParamer() {
    }

    public AddPointParamer(String schemeId, String blockId, String regionId, String longitude, String latitude) {
        this.schemeId = schemeId;
        this.blockId = blockId;
        this.regionId = regionId;
        this.longitude = Double.parseDouble(longitude);
        this.latitude = Double.parseDouble(latitude);
    }
}
