package com.darly.dubbo.root;

import com.darly.dubbo.framework.listener.SystemInitListener;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
public class ApplicationListener extends SystemInitListener {

    private String name = "Dubbo集成系统";

    public ApplicationListener() {
        super();
        logger.info(getClass().getSimpleName() + "[系统<" + name + ">启动完成]");
        //设置系统参数
        showinfo.notifyApplicationName(name);

        showinfo.iniStaticSource("http://192.168.255.130/resourse/");
    }
}
