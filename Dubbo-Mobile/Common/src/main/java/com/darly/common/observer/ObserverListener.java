package com.darly.common.observer;

import android.content.Context;

/**
 * Created by Darly on 2017/11/16.
 *  观察者接口，实现此接口者，皆调用接口里面的方法
 */
public interface ObserverListener {

    void initConfig(Context context,String name);

    void initDlog(boolean isDebug,String name);
}
