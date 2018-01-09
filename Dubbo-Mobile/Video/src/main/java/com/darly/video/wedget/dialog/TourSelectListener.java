package com.darly.video.wedget.dialog;

/**
 * Created by Zhangyuhui/Darly on 2017/6/9.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO:巡检选项总类
 */
public class TourSelectListener {
    public int width;
    public int height;

    public int time;

    public boolean isAuto;

    public TourSelectListener() {
    }

    public TourSelectListener(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public TourSelectListener(int time) {
        this.time = time;
    }

    public TourSelectListener(boolean isAuto) {
        this.isAuto = isAuto;
    }
}
