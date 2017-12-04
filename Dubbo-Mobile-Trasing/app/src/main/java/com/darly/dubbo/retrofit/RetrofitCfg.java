package com.darly.dubbo.retrofit;

import com.darly.common.retrofit.reobs.RxobsListener;

import okhttp3.Request;

/**
 * @author Darly/张宇辉/2017/12/4 13:39
 * @version 1.0/com.darly.dubbo.retrofit
 */
public class RetrofitCfg implements RxobsListener {
    @Override
    public Request.Builder initHeader(Request.Builder builder) {
        builder.addHeader("account", "admin")
                .addHeader("imei", "123")
                .addHeader("crc", "crc")
                .addHeader("pwd", "admin");
        return builder;
    }
}
