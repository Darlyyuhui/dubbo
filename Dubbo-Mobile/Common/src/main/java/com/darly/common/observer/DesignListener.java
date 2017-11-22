package com.darly.common.observer;

import android.content.Context;

/**
 * Created by Darly on 2017/11/16.
 * 設計者，將觀察者集中註冊到這裡。
 */
public interface DesignListener {

    void addObserver(ObserverListener ob);

    void delObserver(ObserverListener ob);

    void init(Context context,String name);

    void initDlog(boolean isDebug,String name);

}
