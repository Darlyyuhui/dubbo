package com.darly.dubbo.base;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;

import com.darly.common.Common;
import com.darly.dubbo.common.LocationTools;
import com.darly.dubbo.retrofit.RetrofitCfg;
import com.darly.dview.DView;
import com.orm.SugarContext;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AppApplication extends Application {
    private Camera mCamera;
    private static final String lOCALE_CHANGED = Intent.ACTION_LOCALE_CHANGED;

    private String VideoServerIp;
    private int VideoServerPort;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }

    };
    private static AppApplication sApplication;
    private String mDevId;
    private ExecutorService mThreadPool;

    @Override
    public void onCreate() {
        sApplication = this;
        super.onCreate();
        DView.init().notifyInit(AppConst.isDebug(),this);
        Common.init().init(this,"object_share");
        Common.init().initDlog(AppConst.isDebug(), "appName");
        Common.init().initRetrofit(getVersionCode(),"http://10.10.15.110:8082/dubbo/",  new RetrofitCfg());
        LocationTools.init(this);
    }

    public static AppApplication getInstance() {
        return sApplication;
    }



    public Camera getCamera() {
        return mCamera;
    }

    public void setCamera(Camera camera) {
        mCamera = camera;
    }


    public String getDevId() {
        if (mDevId == null) {
            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            mDevId = tm.getDeviceId();
        }
        return mDevId;
    }

    public ExecutorService getThreadPool() {

        if (mThreadPool == null) {
            mThreadPool = Executors.newSingleThreadExecutor();
        }
        return mThreadPool;
    }

    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(lOCALE_CHANGED)) {
                // Permissions.reInitPermissions(getInstance());
            }
        }
    };



    public static void createFiles() {
        File root = new File(AppConst.getRoot());
        if (!root.exists()) {
            root.mkdir();
        }
        //初始化视频录制功能参数。
        File boot = new File(AppConst.getVido());
        if (!boot.exists()) {
            boot.mkdir();
        }
        File sence = new File(AppConst.getSence());
        if (!sence.exists()) {
            sence.mkdir();
        }
    }

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName() {
        String curVersionName = null;
        try {
            PackageManager pm = sApplication.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(sApplication.getPackageName(), 0);
            curVersionName = pi.versionName;
        } catch (Exception e) {
        }
        return curVersionName;
    }

    public int getVersionCode() {
        int version = 0;

        try {
            PackageInfo e = this.getPackageManager().getPackageInfo(this.getPackageName(), 0);
            version = e.versionCode;
        } catch (PackageManager.NameNotFoundException var3) {
            var3.printStackTrace();
        }

        return version;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //数据库Sugar关闭
        SugarContext.terminate();
    }
}
