package com.darly.common.observer;

import android.content.Context;

import com.darly.common.retrofit.reobs.RxobsListener;

import java.util.Enumeration;
import java.util.Vector;
/**
 * 调用方法类。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class AbstractDesigner implements DesignListener {
    private Vector<ObserverListener> vector = new Vector();

    public AbstractDesigner() {
    }

    @Override
    public void addObserver(ObserverListener ob) {
        this.vector.add(ob);
    }

    @Override
    public void delObserver(ObserverListener ob) {
        this.vector.remove(ob);
    }

    @Override
    public void init(Context context,String name) {
        Enumeration enumd = this.vector.elements();
        while(enumd.hasMoreElements()) {
            ObserverListener observerListener = (ObserverListener)enumd.nextElement();
            observerListener.initConfig(context,name);
        }
    }

    @Override
    public void initDlog(boolean isDebug, String name) {
        Enumeration enumd = this.vector.elements();
        while(enumd.hasMoreElements()) {
            ObserverListener observerListener = (ObserverListener)enumd.nextElement();
            observerListener.initDlog(isDebug,name);
        }
    }

    @Override
    public void initRetrofit(int VersionCode, String baseUrl, RxobsListener cls) {
        Enumeration enumd = this.vector.elements();
        while(enumd.hasMoreElements()) {
            ObserverListener observerListener = (ObserverListener)enumd.nextElement();
            observerListener.initRetrofit(VersionCode,baseUrl,cls);
        }
    }
}
