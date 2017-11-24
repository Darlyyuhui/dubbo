package com.darly.dview.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 拦截点击事件效果
 * @author  Darly/张宇辉/2017/11/23 14:39
 * @version  1.0/com.darly.dview.framework
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */
public class ClickInvocationHandler implements InvocationHandler {

    //    拦截的方法名列表
    private Map<String, Method> map = new HashMap<String, Method>();
    //    在这里实际上是MainActivity
    private Object target;

    public ClickInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (target != null) {
//            获取方法名
            String name = method.getName();
            Method m = map.get(name);
            if (m != null) {//如果不存在与拦截列表，就执行
                return m.invoke(target, args);
            }
        }
        return null;
    }

    /**
     * 向拦截列表里添加拦截的方法
     * @param name      名称
     * @param method    方法
     */
    public void add(String name, Method method) {
        map.put(name, method);
    }
}
