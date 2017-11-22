package com.darly.dview.framework;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author:Created by zhangyh2 on 2016/12/8 at 14:53.
 * Copyright (c) 2016 Organization Rich-Healthcare(D.L.) zhangyh2 All rights reserved.
 * TODO:
 */

public class InitBinder {

    public static void InitAll(Activity activity) {
        InitBinder.InjectContentView(activity, new ViewsFinder(activity));
        InitBinder.InjectViews(activity, null);
    }

    public static void InitAll(Object hander, View view) {
        InitBinder.InjectContentView(hander, new ViewsFinder(view));
        InitBinder.InjectViews(hander, new ViewsFinder(view));
    }


    /**
     * setContentView的注解处理
     */
    public static void InjectContentView(Object hander, ViewsFinder finder) {

        //获取Activity类
        Class clazz = hander.getClass();
        //获取Activity类上的注解，传入的是InjectContentView.class，注意返回的是InjectContentView
        ContentBinder content = (ContentBinder) clazz.getAnnotation(ContentBinder.class);
        if (content != null) {
            //获取注解里的参数，也就是那个int的布局文件（R.layout.XXX)
            try {
                //通过反射获取Activity里的setContentView方法，参数是int型的布局文件id
                Method method = clazz.getMethod("setContentView", int.class);
                //调用反射获取到的方法，value为上面通过注解获取到的layoutID
                method.invoke(hander, content.value());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * findViewById的注解处理
     */
    public static void InjectViews(Object hander, ViewsFinder finder) {
        //获取Activity类
        Class clazz = hander.getClass();
        //获取全部的类中生命的的成员变量
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field declaredField : declaredFields) {
                //获取对应的注解，传入的是ViewsBinder.class，注意返回的是ViewsBinder
                ViewsBinder views = declaredField.getAnnotation(ViewsBinder.class);
                //这里要判断下注解是否为null，因为比如声明一个 public int i 时，是没有注解的
                if (views != null) {
                    //当注解不为null，获取其参数
                    //通过反射获取findViewById方法
                    try {
                        if (finder != null) {
                            View annotations = finder.findViewById(views.value(), views.id());
                            if (annotations != null) {
                                declaredField.setAccessible(true);
                                declaredField.set(hander, annotations);
                            }
                        } else {
                            Method method = clazz.getMethod("findViewById", int.class);
                            Object o = method.invoke(hander, views.value());
                            //这里要注意，类中的成员变量为private,故必须进行此操作，否则无法给控件赋值（即初始化的捆绑）
                            declaredField.setAccessible(true);
                            //将初始化后的控件赋值到MainActivity里的对应控件上
                            declaredField.set(hander, o);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
