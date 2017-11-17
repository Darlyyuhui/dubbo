package com.darly.dview;

import com.darly.dview.observer.AbstractDesigner;
import com.darly.dview.observer.DesignListener;
import com.darly.dview.observer.SystemCfg;

/**
 * Created by Darly on 2017/11/16.
 */
public class DView {

    protected static DesignListener design;

    public static DesignListener init(){
        //在這裡對DView中的組件進行初始化變量操作
        design = new AbstractDesigner();
        design.addObserver(SystemCfg.getInstance());
        return design;
    }
}
