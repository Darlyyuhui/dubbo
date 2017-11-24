package com.darly.dview.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 映射主体类，@interface 类型，进行注解回调
 * @author  Darly/张宇辉/2017/11/23 14:37
 * @version  1.0/com.darly.dview.framework
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseEvent {

    String setListener();//设置监听方法名称

    Class listenerType();//监听类型

    String listenerCallBack();//监听回调方法名
}
