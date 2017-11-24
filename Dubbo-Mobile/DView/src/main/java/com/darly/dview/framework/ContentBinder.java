package com.darly.dview.framework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Activity绑定Layout注解类
 * @author  Darly/张宇辉/2017/11/23 14:40
 * @version  1.0/com.darly.dview.framework
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ContentBinder {
    int value() default 0;
}
