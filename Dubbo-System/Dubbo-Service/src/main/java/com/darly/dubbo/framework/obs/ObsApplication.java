package com.darly.dubbo.framework.obs;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO : 用户信息类
 */
public class ObsApplication implements ObsListener{

    private static ObsApplication instance = null;

    private String applicationName;

    private ObsApplication() {
    }
    public static ObsApplication getInstance() {
        if(instance == null) {
            instance = new ObsApplication();
        }
        return instance;
    }


    @Override
    public void obsApplicationName(String name) {
        setApplicationName(name);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}
