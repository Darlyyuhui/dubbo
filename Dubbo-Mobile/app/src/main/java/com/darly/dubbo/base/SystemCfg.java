package com.darly.dubbo.base;

import android.content.Context;
import android.content.SharedPreferences;



public class SystemCfg {
    private static SharedPreferences mysp = null;
    private static final String PREFERENCE_NAME = "xxsyscfg";

    private static void init(Context context) {
        mysp = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    public static void setVioPicWidth(Context context, int w) {
        init(context);
        mysp.edit().putInt("viopicwidth", w).commit();
    }

    public static int getVioPicWidth(Context context) {
        init(context);
        return mysp.getInt("viopicwidth", 2048);
    }

    public static void setVioPicHight(Context context, int h) {
        init(context);
        mysp.edit().putInt("viopichight", h).commit();
    }

    public static int getVioPicHight(Context context) {
        init(context);
        return mysp.getInt("viopichight", 1536);
    }

    public static int getTextSize(Context context) {
        init(context);
        return mysp.getInt("textsize", 24);
    }

    public static void setTextSize(Context context, int textsize) {
        init(context);
        mysp.edit().putInt("textsize", textsize).commit();
    }

    public static void setServerIP(Context context, String str) {
        init(context);
        mysp.edit().putString("serverip", str).commit();
    }

    public static void setServerPort(Context context, String str) {
        init(context);
        mysp.edit().putString("serverport", str).commit();
    }

    public static String getServerIP(Context context) {
        init(context);
        if (AppConst.isDebug())
            return mysp.getString("serverip", "223.85.191.240");
        else
            return mysp.getString("serverip", "193.169.100.113");
    }

    public static String getServerPort(Context context) {
        init(context);
        if (AppConst.isDebug())
            return mysp.getString("serverport", "7002");
        else
            return mysp.getString("serverport", "8090");
    }

    public static String getGISServerIP(Context context) {
        init(context);
        if (AppConst.isDebug())
            return mysp.getString("gisserverip", "223.85.191.240");
        else
            return mysp.getString("gisserverip", "193.169.100.232");
    }

    public static String getGISServerPort(Context context) {
        init(context);
        if (AppConst.isDebug())
            return mysp.getString("gisserverport", "7005");
        else
            return mysp.getString("gisserverport", "8090");
    }


    public static void setGISServerIP(Context context, String str) {
        init(context);
        mysp.edit().putString("gisserverip", str).commit();
    }

    public static void setGISServerPort(Context context, String str) {
        init(context);
        mysp.edit().putString("gisserverport", str).commit();
    }

    /**
     * 名称
     */
    public static void setUserName(Context context, String name) {
        init(context);
        mysp.edit().putString("Name", name).commit();
    }

    /**
     * 名称
     */
    public static String getUserName(Context context) {
        init(context);
        return mysp.getString("Name", "");
    }

    /**
     * userID
     */
    public static void setUserId(Context context, String id) {
        init(context);
        mysp.edit().putString("userId", id).commit();
    }

    /**
     * userID
     */
    public static String getUserId(Context context) {
        init(context);
        return mysp.getString("userId", "");
    }

    /**
     * 部门名称
     */
    public static void setDepartment(Context context, String dep) {
        init(context);
        mysp.edit().putString("department", dep).commit();
    }

    /**
     * 部门名称
     */
    public static String getDepartment(Context context) {
        init(context);
        return mysp.getString("department", "");
    }

    /**
     * 部门ID
     */
    public static void setDepartmentID(Context context, String id) {
        init(context);
        mysp.edit().putString("departmentId", id).commit();
    }

    /**
     * 部门ID
     */
    public static String getDepartmentID(Context context) {
        init(context);
        return mysp.getString("departmentId", "");
    }

    /**
     * 账户
     */
    public static void setAccount(Context context, String acc) {
        init(context);
        mysp.edit().putString("account", acc).commit();
    }

    /**
     * 账户
     */
    public static String getAccount(Context context) {
        init(context);
        return mysp.getString("account", "");
    }

    /**
     * 账户
     */
    public static void setCRC(Context context, String crc) {
        init(context);
        mysp.edit().putString("crc", crc).commit();
    }

    /**
     * 账户
     */
    public static String getCRC(Context context) {
        init(context);
        return mysp.getString("crc", "");
    }

    /**
     * 密码
     */
    public static void setWhitePwd(Context context, String acc) {
        init(context);
        mysp.edit().putString("pwd", acc).commit();
    }

    /**
     * 密码
     */
    public static String getWhitePwd(Context context) {
        init(context);
        return mysp.getString("pwd", "");
    }

    /**
     * IMEI
     */
    public static void setIMEI(Context context, String acc) {
        init(context);
        mysp.edit().putString("imei", acc).commit();
    }

    /**
     * IMEI
     */
    public static String getIMEI(Context context) {
        init(context);
        return mysp.getString("imei", "");
    }

    public static void loginOut(Context context) {
        init(context);
        mysp.edit().remove("userId").commit();
        mysp.edit().remove("account").commit();
        mysp.edit().remove("pwd").commit();
        mysp.edit().remove("imei").commit();
        mysp.edit().remove("departmentId").commit();
        mysp.edit().remove("department").commit();
        mysp.edit().remove("Name").commit();
    }


    /**
     * 首次登陆
     */
    public static void setIsFirstLogion(Context context, boolean value) {
        init(context);
        mysp.edit().putBoolean("isFirstLogion", value).commit();
    }

    public static boolean getIsFirstLogion(Context context) {
        init(context);
        return mysp.getBoolean("isFirstLogion", true);
    }

    public static String getWhiteBalance(Context context) {
        init(context);
        return mysp.getString("whitebalance", "auto");
    }

    public static void setSceneModes(Context context, String sm) {
        init(context);
        mysp.edit().putString("scenemodes", sm).commit();
    }

    public static String getSceneModes(Context context) {
        init(context);
        return mysp.getString("scenemodes", "auto");
    }

    public static void setExposureCompensation(Context context, int s) {
        init(context);
        mysp.edit().putInt("exposurecompensation", s).commit();
    }

    public static int getExposureCompensation(Context context) {
        init(context);
        return mysp.getInt("exposurecompensation", 0);
    }

    public static void setFlashModes(Context context, String str) {
        init(context);
        mysp.edit().putString("flashmodes", str).commit();
    }

    public static String getFlashModes(Context context) {
        init(context);
        return mysp.getString("flashmodes", "auto");
    }

    //手机宽度保存
    public static void setWidth(Context context, int w) {
        init(context);
        mysp.edit().putInt("phoneWidth", w).commit();
    }

    //手机宽度获取
    public static int getWidth(Context context) {
        init(context);
        return mysp.getInt("phoneWidth", 0);
    }

    //手机高度保存
    public static void setHeight(Context context, int h) {
        init(context);
        mysp.edit().putInt("phoneHeight", h).commit();
    }

    //手机高度获取
    public static int getHeight(Context context) {
        init(context);
        return mysp.getInt("phoneHeight", 0);
    }

    public static void setUserImage(Context context, String str) {
        init(context);
        mysp.edit().putString("usericon", str).commit();
    }

    public static String getUserImage(Context context) {
        init(context);
        return mysp.getString("usericon", null);
    }


    //记忆密码
    public static void setRemark(Context context, boolean w) {
        init(context);
        mysp.edit().putBoolean("LOGINREMARK", w).commit();
    }

    //记忆密码
    public static boolean getRemark(Context context) {
        init(context);
        return mysp.getBoolean("LOGINREMARK", false);
    }
}
