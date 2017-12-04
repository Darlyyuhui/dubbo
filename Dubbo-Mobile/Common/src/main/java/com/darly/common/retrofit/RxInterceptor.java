package com.darly.common.retrofit;

import android.nfc.tech.NfcA;

import com.darly.common.NameValuePair;
import com.darly.common.observer.AbstractDesigner;
import com.darly.common.observer.DesignListener;
import com.darly.common.observer.InitCfg;
import com.darly.common.retrofit.reobs.AbstractRx;
import com.darly.common.retrofit.reobs.RxListener;
import com.darly.common.retrofit.reobs.RxobsListener;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipal;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/12/18.
 */

public class RxInterceptor  implements Interceptor {

    private volatile static RxInterceptor instance;
    private static int VersionCode;
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

    public static void setVersionCode(int versionCode) {
        VersionCode = versionCode;
    }

    private RxInterceptor() {
    }


    private static RxListener listener;
    public static void  init(Class<? extends RxobsListener> t){
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
