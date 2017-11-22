package com.darly.dview.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:Created by zhangyh2 on 2016/12/8 at 15:39.
 * Copyright (c) 2016 Organization Rich-Healthcare(D.L.) zhangyh2 All rights reserved.
 * TODO:
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
     */
    public void add(String name, Method method) {
        map.put(name, method);
    }
}
