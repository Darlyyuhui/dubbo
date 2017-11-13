package com.darly.dubbo.root;


import com.darly.dubbo.framework.base.ApplicationContextHolder;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO : 通过使用观察者模式，对项目进行赋值
 */
public class ApplicationContext extends ApplicationContextHolder {

    private String name = "Dubbo集成系统";

    public ApplicationContext() {
        super();
        log.info(getClass().getSimpleName() + "[系统<" + name + ">启动完成]");
        //设置系统参数
        showinfo.notifyApplicationName(name);
    }
}
