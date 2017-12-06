package com.darly.dubbo.root;

import com.darly.dubbo.framework.base.ApplicationContextHolder;
import com.darly.dubbo.framework.base.BaseController;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
public class ApplicationContext extends ApplicationContextHolder {

    /**
     * #项目名称
     */
    private static String applicationName;
    /**
     * #静态文件路径参数
     */
    private static String resourceUrl;


    public ApplicationContext() {
        super();
        applicationName = ApplicationProperties.getValue("producer-application-name", "系统");
        resourceUrl = ApplicationProperties.getValue("producer-application-url", "http://localhost");
        log.info(getClass().getSimpleName() + "[系统<" + applicationName + ">启动完成]");
        //设置系统参数
        showinfo.notifyApplicationName(applicationName);
        showinfo.initResource(resourceUrl);
        BaseController.refreshPar();
    }

    public static String getApplicationName() {
        return applicationName;
    }

    public static String getResourceUrl() {
        return resourceUrl;
    }
}
