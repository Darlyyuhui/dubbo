package com.darly.dubbo.retrofit;

import android.text.TextUtils;

import com.darly.common.DLog;
import com.darly.common.Utils;
import com.darly.dubbo.base.AppApplication;
import com.darly.dubbo.base.SystemCfg;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/12/18.
 */

public class RxInterceptor implements Interceptor {

    private volatile static RxInterceptor instance;
    private static int VersionCode = AppApplication.getInstance().getVersionCode();
    private static final String APPSYS_STRING = "Android_";

    /**
     * @return 启动单例模式，加载进JVM时不进行初始化，调用getInstance（）初始化请求类。
     */
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

    private RxInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        String account = SystemCfg.getAccount(AppApplication.getInstance());
        String imei = AppApplication.getInstance().getDevId();
        String crc = SystemCfg.getCRC(AppApplication.getInstance());

        String pwd = Utils.getCipherText(SystemCfg.getWhitePwd(AppApplication.getInstance()));


        DLog.i(account + "-" + crc + "-" + imei);
        if (TextUtils.isEmpty(account) && TextUtils.isEmpty(imei)) {
            builder.addHeader("Content-Type", "application/json;charset=UTF-8")
                    .addHeader("charset", "utf-8")
                    .addHeader("version", APPSYS_STRING + VersionCode)
                    .build();
        } else {
            builder.addHeader("Content-Type", "application/json;charset=UTF-8")
                    .addHeader("charset", "utf-8")
                    .addHeader("account", account)
                    .addHeader("imei", imei)
                    .addHeader("crc", crc)
                    .addHeader("pwd", pwd)
                    .addHeader("version", APPSYS_STRING + VersionCode)
                    .build();
        }
        return chain.proceed(builder.build());
    }
}
