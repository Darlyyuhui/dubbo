package com.darly.dview.observer;

import android.content.Context;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Darly on 2017/11/16.
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
