package com.darly.dubbo.base;

import android.os.Environment;

/**
 * Created by Darly on 2017/11/16.
 * retrue : 系统参数
 */
public class AppConst {

    private AppConst(){
        throw new IllegalStateException("AppConst class");
    }

    private static String root = Environment.getExternalStorageDirectory() + "/Sampling/";
    private static String vido = root.concat("video/");
    private static String sence = vido.concat("sence/");


    //是否是虚拟机测试
    private static boolean testphone = false;
    /**
     * true正式环境。地址为绵竹。
     * false开发环境，地址为自己
     */
    private static boolean debug = true;

    private static int liststatefirst = 0x1004;

    private static int liststaterefresh = 0x1005;

    private static int liststateloadmore = 0x1006;

    public static String getUrlHead() {
        if (debug) {
            return "http://" + SystemCfg.getServerIP(AppApplication.getInstance()) + ":" + SystemCfg.getServerPort(AppApplication.getInstance());
        }
        return "http://" + SystemCfg.getServerIP(AppApplication.getInstance()) + ":" + SystemCfg.getServerPort(AppApplication.getInstance());
    }

    //http://10.10.15.201:8090公司外网超图地址
    public static String getMalink() {
        if (debug) {
            return "http://" + SystemCfg.getGISServerIP(AppApplication.getInstance()) + ":" + SystemCfg.getGISServerPort(AppApplication.getInstance()) + "/iserver/services/map-MianZhuShi2/rest/maps/绵竹市";
        }
        return "http://" + SystemCfg.getGISServerIP(AppApplication.getInstance()) + ":" + SystemCfg.getGISServerPort(AppApplication.getInstance()) + "/iserver/services/map-MianZhuShi2/rest/maps/绵竹市";
    }


    /**
     * @return 用戶根目錄
     */
    public static String getRoot() {
        return root;
    }
    /**
     * @return 用戶音视频目录
     */
    public static String getVido() {
        return vido;
    }
    /**
     * @return 用戶主目录
     */
    public static String getSence() {
        return sence;
    }

    public static boolean isTestphone() {
        return testphone;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static int getListstatefirst() {
        return liststatefirst;
    }

    public static int getListstaterefresh() {
        return liststaterefresh;
    }

    public static int getListstateloadmore() {
        return liststateloadmore;
    }
}
