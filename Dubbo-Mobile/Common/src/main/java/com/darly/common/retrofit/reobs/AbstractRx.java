package com.darly.common.retrofit.reobs;

import java.util.Enumeration;
import java.util.Vector;

import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * 调用方法类。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class AbstractRx implements RxListener {
    private Vector<RxobsListener> vector = new Vector();

    public AbstractRx() {
    }

    @Override
    public void addObserver(RxobsListener ob) {
        this.vector.add(ob);
    }

    @Override
    public void delObserver(RxobsListener ob) {
        this.vector.remove(ob);
    }

    @Override
    public Request.Builder initHeader(Request.Builder builder) {
        Enumeration enumd = this.vector.elements();
        while(enumd.hasMoreElements()) {
            RxobsListener observerListener = (RxobsListener)enumd.nextElement();
            return observerListener.initHeader(builder);
        }
        return builder;
    }
}
