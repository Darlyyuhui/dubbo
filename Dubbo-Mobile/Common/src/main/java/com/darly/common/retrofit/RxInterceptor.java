package com.darly.common.retrofit;

import com.darly.common.retrofit.reobs.AbstractRx;
import com.darly.common.retrofit.reobs.RxListener;
import com.darly.common.retrofit.reobs.RxobsListener;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
/**
 * 請求頭封裝類
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/4 14:43
 * @version  1.0/com.darly.common.retrofit
 */

public class RxInterceptor  implements Interceptor {

    private volatile static RxInterceptor instance;
    private static int VersionCode;
    private static final String APPSYS_STRING = "Android_";

    public static RxInterceptor getInstance() {
        if (instance == null) {
            synchronized (RxInterceptor.class) {
                if (instance == null) {
                    instance = new RxInterceptor();
                }
            }
        }
        return instance;
    }

    public static void setVersionCode(int versionCode) {
        VersionCode = versionCode;
    }

    private RxInterceptor() {
    }


    private static RxListener listener;
    public static void  init(RxobsListener t){
        //在這裡對DView中的組件進行初始化變量操作
        listener = new AbstractRx();
        listener.addObserver(t);
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        listener.initHeader(builder).addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("charset", "utf-8")
                .addHeader("version", APPSYS_STRING + VersionCode)
                .build();
        return chain.proceed(builder.build());
    }
}
