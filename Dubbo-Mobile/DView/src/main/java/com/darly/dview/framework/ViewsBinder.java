package com.darly.dview.framework;

/**
 * Author:Created by zhangyh2 on 2016/12/8 at 15:07.
 * Copyright (c) 2016 Organization Rich-Healthcare(D.L.) zhangyh2 All rights reserved.
 * TODO:
 */


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author:Created by zhangyh2 on 2016/12/8 at 14:43.
 * Copyright (c) 2016 Organization Rich-Healthcare(D.L.) zhangyh2 All rights reserved.
 * TODO:我们首先要声明一个@interface，也就是注解类：
 */

@Target(ElementType.FIELD)//表示用在字段s上
@Retention(RetentionPolicy.RUNTIME)//表示在生命周期是运行时
public @interface ViewsBinder {
    //@interface是用于自定义注解的，它里面定义的方法的声明不能有参数，也不能抛出异常，
    // 并且方法的返回值被限制为简单类型、String、Class、emnus、@interface，和这些类型的数组。
    int id() default -1;

    int value() default 0;

    String method() default "";

    String type() default "";
}
