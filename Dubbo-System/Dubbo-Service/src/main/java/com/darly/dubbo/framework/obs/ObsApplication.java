package com.darly.dubbo.framework.obs;

import com.darly.dubbo.framework.base.BaseController;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO : 用户信息类
 */
public class ObsApplication implements ObsListener{

    private static ObsApplication instance = null;

    private String applicationName;
    private String resourceUrl;

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

    @Override
    public void obsInitResource(String resouceUrl) {
        setResourceUrl(resouceUrl);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }
}
