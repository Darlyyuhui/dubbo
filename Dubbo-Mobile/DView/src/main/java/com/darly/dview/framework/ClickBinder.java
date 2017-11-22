package com.darly.dview.framework;


import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author:Created by zhangyh2 on 2016/12/8 at 15:25.
 * Copyright (c) 2016 Organization Rich-Healthcare(D.L.) zhangyh2 All rights reserved.
 * TODO:
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
