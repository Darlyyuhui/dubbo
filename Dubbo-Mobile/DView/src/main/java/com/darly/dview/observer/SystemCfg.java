package com.darly.dview.observer;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


public class SystemCfg implements ObserverListener {
    private static SystemCfg instance = null;

    private SystemCfg() {
    }

    public static SystemCfg getInstance() {
        if(instance == null) {
            instance = new SystemCfg();
        }
        return instance;
    }
    private static boolean isDebug = false;

    private static SharedPreferences mysp = null;
    private static final String PREFERENCE_NAME = "dubbo_syscfg";

    private static void init(Context context) {
        mysp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        Log.i("SystemCfg","初始化完成.."+mysp);
    }

    public static void setVioPicWidth( int w) {
       
        mysp.edit().putInt("viopicwidth", w).commit();
    }

    public static int getVioPicWidth() {
       
        return mysp.getInt("viopicwidth", 2048);
    }

    public static void setVioPicHight(int h) {
       
        mysp.edit().putInt("viopichight", h).commit();
    }

    public static int getVioPicHight() {
       
        return mysp.getInt("viopichight", 1536);
    }

    public static int getTextSize() {
       
        return mysp.getInt("textsize", 24);
    }

    public static void setTextSize( int textsize) {
       
        mysp.edit().putInt("textsize", textsize).commit();
    }

    /**
     * 账户
     */
    public static void setAccount( String acc) {
       
        mysp.edit().putString("account", acc).commit();
    }

    /**
     * 账户
     */
    public static String getAccount() {
       
        return mysp.getString("account", "");
    }

    public static String getWhiteBalance() {
       
        return mysp.getString("whitebalance", "auto");
    }

    public static void setSceneModes(String sm) {
       
        mysp.edit().putString("scenemodes", sm).commit();
    }

    public static String getSceneModes() {
       
        return mysp.getString("scenemodes", "auto");
    }

    public static void setExposureCompensation(int s) {
       
        mysp.edit().putInt("exposurecompensation", s).commit();
    }

    public static int getExposureCompensation() {
       
        return mysp.getInt("exposurecompensation", 0);
    }

    public static void setFlashModes(String str) {
       
        mysp.edit().putString("flashmodes", str).commit();
    }

    public static String getFlashModes() {
       
        return mysp.getString("flashmodes", "auto");
    }

    //手机宽度保存
    public static void setWidth(int w) {
       
        mysp.edit().putInt("phoneWidth", w).commit();
    }

    //手机宽度获取
    public static int getWidth() {
       
        return mysp.getInt("phoneWidth", 0);
    }

    //手机高度保存
    public static void setHeight(int h) {
       
        mysp.edit().putInt("phoneHeight", h).commit();
    }

    //手机高度获取
    public static int getHeight() {
       
        return mysp.getInt("phoneHeight", 0);
    }


    public static boolean isDebug() {
        return isDebug;
    }

    public static void setIsDebug(boolean isDebug) {
        SystemCfg.isDebug = isDebug;
    }

    @Override
    public void isDebug(boolean isDebug) {
        setIsDebug(isDebug);
    }

    @Override
    public void initConfig(Context context) {
       init(context);
    }
}
