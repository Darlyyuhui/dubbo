package com.darly.dview.framework;


import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 点击事件注解类
 * @author  Darly/张宇辉/2017/11/23 14:38
 * @version  1.0/com.darly.dview.framework
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//这个注解需要注意,对应的参数在上面注解的 btn_login 点击事件里对应找即可
@BaseEvent(setListener = "setOnClickListener",//setOnClickListener为View.setOnClickListener
        listenerType = View.OnClickListener.class,//监听的类型为点击事件
        listenerCallBack = "onClick")
public @interface ClickBinder {
    int[] value();
}
