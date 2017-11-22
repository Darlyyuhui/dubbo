package com.darly.dview.observer;

import android.content.Context;
import android.view.WindowManager;

import com.darly.dview.common.SCfg;
import com.darly.dview.widget.camera.util.ImageLoaderUtil;

/**
 * Created by Darly on 2017/11/22.
 * @TODO: 對封裝后的工具使用Image進行初始化
 */
public class InitCfg implements ObserverListener{

    private static InitCfg instance = null;

    private InitCfg() {
    }

    public static InitCfg getInstance() {
        if(instance == null) {
            instance = new InitCfg();
        }
        return instance;
    }

    @Override
    public void initConfig(boolean isDebug,Context context) {
        SCfg.init(context);
        calculate(context);
        SCfg.setIsDebug(isDebug);
        ImageLoaderUtil.init(context);
    }

    /**
     * 计算屏幕宽高以及后续辅助参数。都可以在这里进行完善
     */
    private void calculate(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        SCfg.setWidth( wm.getDefaultDisplay().getWidth());
        SCfg.setHeight( wm.getDefaultDisplay().getHeight());
    }
}
