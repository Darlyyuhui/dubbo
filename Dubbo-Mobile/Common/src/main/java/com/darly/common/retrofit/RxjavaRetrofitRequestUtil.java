package com.darly.common.retrofit;


import android.text.TextUtils;

import com.darly.common.DLog;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:Created by zhangyh2 on 2016/12/8 at 10:33.
 * Copyright (c) 2016 Organization Rich-Healthcare(D.L.) zhangyh2 All rights reserved.
 * TODO:
 */

public class RxjavaRetrofitRequestUtil {
    private volatile static RxjavaRetrofitRequestUtil instance;

    private static final int REQUEST_TIME = 5;
    private int interSize = 0;

    private OkHttpClient.Builder builder;

    private static boolean isDebug;
    private static String baseUrl;

    private RxjavaRetrofitRequestUtil() {
        initClient();
    }

    private void initClient() {
        builder = new OkHttpClient.Builder();
        //设置请求超时时间
        builder.readTimeout(REQUEST_TIME, TimeUnit.SECONDS);//设置读取超时时间
        builder.writeTimeout(REQUEST_TIME, TimeUnit.SECONDS);//设置写的超时时间
        builder.connectTimeout(REQUEST_TIME, TimeUnit.SECONDS);//设置连接超时时间
        //设置请求日志
        if (isDebug) {
            HttpLoggingInterceptor log = new HttpLoggingInterceptor();
            log.setLevel(HttpLoggingInterceptor.Level.HEADERS);
            builder.addInterceptor(log);
        }
        interSize = builder.interceptors().size();
        builder.addInterceptor(RxInterceptor.getInstance());

    }


    /**
     * @return 启动单例模式，加载进JVM时不进行初始化，调用getInstance（）初始化请求类。
     */
    public static RxjavaRetrofitRequestUtil getInstance() {
        if (instance == null) {
            synchronized (RxjavaRetrofitRequestUtil.class) {
                if (instance == null) {
                    instance = new RxjavaRetrofitRequestUtil();
                }
            }
        }
        return instance;
    }

    public <T> T  get(Class<T> t) {
        //清理多余的头文件。
        while (builder.interceptors().size() > 0 && builder.interceptors().size() != interSize) {
            builder.interceptors().remove(builder.interceptors().size() - 1);
        }
        //清理多余的头文件。
        builder.addInterceptor(RxInterceptor.getInstance());
        DLog.i(builder.interceptors().size());
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        return retrofit.create(t);
    }


    public <T> T post(Class<T> t) {
        //清理多余的头文件。
        while (builder.interceptors().size() > 0 && builder.interceptors().size() != interSize) {
            builder.interceptors().remove(builder.interceptors().size() - 1);
        }
        //清理多余的头文件。
        builder.addInterceptor(RxInterceptor.getInstance());
        DLog.i(builder.interceptors().size());
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        return retrofit.create(t);
    }

    /**
     * @param m
     * @param paramsEncoding
     * @param <T>
     * @return 将对象参数集合转换为String参数
     */
    public static <T> String getParamers(T m, String paramsEncoding) {
        Map<String, String> params = changeTtoMap(m);
        if (TextUtils.isEmpty(paramsEncoding)) {
            paramsEncoding = "UTF-8";
        }
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                encodedParams.append('=');
                if (!TextUtils.isEmpty(entry.getValue())) {
                    encodedParams.append(URLEncoder.encode(entry.getValue(), paramsEncoding));
                }
                encodedParams.append('&');
            }
            encodedParams.deleteCharAt(encodedParams.length() - 1);
            DLog.json(encodedParams.toString());
            return encodedParams.toString();
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }

    }

    public static String getParamers(Map<String, String> params, String paramsEncoding) {
        if (TextUtils.isEmpty(paramsEncoding)) {
            paramsEncoding = "UTF-8";
        }
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                encodedParams.append('=');
                if (!TextUtils.isEmpty(entry.getValue())) {
                    encodedParams.append(URLEncoder.encode(entry.getValue(), paramsEncoding));
                }
                encodedParams.append('&');
            }
            encodedParams.deleteCharAt(encodedParams.length() - 1);
            DLog.json(encodedParams.toString());
            return encodedParams.toString();
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }

    }


    private static <T> Map<String, String> changeTtoMap(T m) {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            // 获取实体类的所有属性
            Field[] fields = m.getClass().getDeclaredFields();
            for (Field field : fields) {
                String name = field.getName();
                field.setAccessible(true); //设置些属性是可以访问的
                    Object val = field.get(m);//得到此属性的值
                    if (val != null) {
                        map.put(name, String.valueOf(val));
                    }
            }
            return map;
        } catch (Exception e) {
            return map;
        }
    }

    public static void setIsDebug(boolean isDebug) {
        RxjavaRetrofitRequestUtil.isDebug = isDebug;
    }

    public static void setBaseUrl(String baseUrl) {
        RxjavaRetrofitRequestUtil.baseUrl = baseUrl;
    }
}
