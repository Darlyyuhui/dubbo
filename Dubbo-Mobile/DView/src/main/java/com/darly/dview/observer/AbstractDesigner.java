package com.darly.dview.observer;

import android.content.Context;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 通知类
 * @author  Darly/张宇辉/2017/11/23 14:43
 * @version  1.0/com.darly.dview.observer
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
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
    public void notifyInit(boolean debug,Context context) {
        Enumeration enumd = this.vector.elements();
        while(enumd.hasMoreElements()) {
            ObserverListener observerListener = (ObserverListener)enumd.nextElement();
            observerListener.initConfig(debug,context);
        }
    }
}
