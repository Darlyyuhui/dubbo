package com.darly.common.observer;

import android.content.Context;

import com.darly.common.retrofit.reobs.RxobsListener;

/**
 * 設計者，將觀察者集中註冊到這裡。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public interface DesignListener {

    void addObserver(ObserverListener ob);

    void delObserver(ObserverListener ob);

    void init(Context context,String name);

    void initDlog(boolean isDebug,String name);

    void initRetrofit(int VersionCode,String baseUrl,RxobsListener cls);
}
