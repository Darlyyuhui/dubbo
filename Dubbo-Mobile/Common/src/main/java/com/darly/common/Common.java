package com.darly.common;


import com.darly.common.observer.AbstractDesigner;
import com.darly.common.observer.DesignListener;
import com.darly.common.observer.InitCfg;

/**
 * Created by Darly on 2017/11/16.
 */
public class Common {

    protected static DesignListener design;

    public static DesignListener init(){
        //在這裡對DView中的組件進行初始化變量操作
        design = new AbstractDesigner();
        design.addObserver(InitCfg.getInstance());
        return design;
    }
}
