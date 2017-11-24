package com.darly.dview.observer;

import android.content.Context;
/**
 * 观察者接口，实现此接口者，皆调用接口里面的方法
 * @author  Darly/张宇辉/2017/11/23 14:44
 * @version  1.0/com.darly.dview.observer
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

public interface ObserverListener {

    void initConfig(boolean isDebug,Context context);
}
