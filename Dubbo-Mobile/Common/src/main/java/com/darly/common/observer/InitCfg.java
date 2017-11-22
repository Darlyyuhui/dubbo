package com.darly.common.observer;

import android.content.Context;
import android.text.TextUtils;

import com.darly.common.BuildConfig;
import com.darly.common.DLog;
import com.darly.common.ShareObject;
import com.darly.common.ToastApp;

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
    public void initConfig(Context context,String name) {
        //初始化SharePreferHelp和ToastApp
        ToastApp.getInstance().setContext(context);
        ShareObject.getInstance().setContext(context);
        if (!TextUtils.isEmpty(name)) {
            ShareObject.getInstance().setFileName(name);
        }


    }

    @Override
    public void initDlog(boolean isDebug, String name) {
        DLog.init(isDebug, name);
    }

}
