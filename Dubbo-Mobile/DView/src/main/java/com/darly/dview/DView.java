package com.darly.dview;

import com.darly.dview.observer.AbstractDesigner;
import com.darly.dview.observer.DesignListener;
import com.darly.dview.observer.InitCfg;
/**
 * DView 自定义控件集合初始化
 * @author  Darly/张宇辉/2017/11/23 14:33
 * @version  1.0/com.darly.dview
 */
public class DView {

    protected static DesignListener design;

    public static DesignListener init(){
        //在這裡對DView中的組件進行初始化變量操作
        design = new AbstractDesigner();
        design.addObserver(InitCfg.getInstance());
        return design;
    }
}
