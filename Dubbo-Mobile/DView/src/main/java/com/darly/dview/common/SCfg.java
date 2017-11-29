package com.darly.dview.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * 系统参数设置类，包括相机参数和设备宽高参数等。
 * @author  Darly/张宇辉/2017/11/23 14:35
 * @version  1.0/com.darly.dview.common
 */

public class SCfg {

    private static SharedPreferences mysp = null;
    private static final String PREFERENCE_NAME = "scfg";

    public static void init(Context context) {
        mysp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        Log.i("SCfg","初始化.."+mysp);
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

    public static void setAccount( String acc) {
       
        mysp.edit().putString("account", acc).commit();
    }

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

    //设置屏幕宽度
    public static void setWidth(int w) {
       
        mysp.edit().putInt("phoneWidth", w).commit();
    }

    //获取屏幕宽度
    public static int getWidth() {
       
        return mysp.getInt("phoneWidth", 0);
    }

    //设置屏幕高度
    public static void setHeight(int h) {
       
        mysp.edit().putInt("phoneHeight", h).commit();
    }

    //获取屏幕高度
    public static int getHeight() {
       
        return mysp.getInt("phoneHeight", 0);
    }


    public static boolean isDebug() {
        return mysp.getBoolean("isDebug", false);
    }

    public static void setIsDebug(boolean isDebug) {
        mysp.edit().putBoolean("isDebug", isDebug).commit();
    }

}
