package com.darly.dubbo.binder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author:Created by zhangyh2 on 2016/12/8 at 15:28.
 * Copyright (c) 2016 Organization Rich-Healthcare(D.L.) zhangyh2 All rights reserved.
 * TODO:
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseEvent {

    String setListener();//设置监听方法名称

    Class listenerType();//监听类型

    String listenerCallBack();//监听回调方法名
}
