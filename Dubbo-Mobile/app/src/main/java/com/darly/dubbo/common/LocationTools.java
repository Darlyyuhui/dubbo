package com.darly.dubbo.common;

import android.content.Context;
import android.text.TextUtils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.darly.common.DLog;
import com.darly.common.ToastApp;
import com.darly.dubbo.base.AppConst;

/**
 * Created by Zhangyuhui/Darly on 2017/8/16.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO:这里将定位代码进行归类整理。单利模式下，建立一个
 */
public class LocationTools implements AMapLocationListener {

    public interface LocationToolsListener {

        void locationSuccess(AMapLocation amapLocation);

        void locationFail();
    }

    private static LocationTools instance = null;


    //声明mLocationOption对象
    private AMapLocationClientOption mLocationOption = null;
    private AMapLocationClient mlocationClient = null;

    private LocationToolsListener listener;

    private LocationTools(Context context) {
        startLocate(context);
    }

    public static void init(Context context) {
        if (instance == null) {
            instance = new LocationTools(context);
        }
    }

    public static LocationTools getInstance() {
        return instance;
    }

    public void setLocationToolsListener(LocationToolsListener listener) {
        this.listener = listener;
    }

    public void startLocate(Context context) {
        mlocationClient = new AMapLocationClient(context);
        //初始化定位参数
        mLocationOption = new AMapLocationClientOption();
        //设置定位监听
        mlocationClient.setLocationListener(this);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(false);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为1000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
    }


    public void start() {
        //启动定位
        if (mlocationClient != null) {
            DLog.i("开始定位，获取位置信息");
            mlocationClient.startLocation();
        } else {
            DLog.i("定位初始化失败");
        }
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                //定位成功回调信息，设置相关消息
                    //请求列表
                    if (listener != null) {
                        DLog.i("定位成功" + amapLocation.getAddress());
                        listener.locationSuccess(amapLocation);
                    }
                    mlocationClient.stopLocation();
            } else {
                ToastApp.showToast("请链接网络或者打开GPS进行定位");
                if (listener != null) {
                    listener.locationFail();
                }
            }
        } else {
            if (listener != null) {
                DLog.i("定位失败了，返回成空了");
                listener.locationFail();
            }
        }
    }

    public void reStart() {
        if (!AppConst.isDebug() && mlocationClient != null && !mlocationClient.isStarted()) {
            mlocationClient.startLocation();
        } else {
            DLog.i("定位重新开始失败");
        }
    }

    public void stop() {
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
        } else {
            DLog.i("定位结束失败");
        }
    }

}
