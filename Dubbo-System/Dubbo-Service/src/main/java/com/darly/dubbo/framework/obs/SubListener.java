package com.darly.dubbo.framework.obs;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO : 观察者的接口
 */
public interface SubListener {
    void addObserver(ObsListener var1);

    void delObserver(ObsListener var1);

    void notifyApplicationName(String name);
}

