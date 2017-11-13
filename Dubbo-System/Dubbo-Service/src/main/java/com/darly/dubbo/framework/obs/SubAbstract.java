package com.darly.dubbo.framework.obs;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :观察者实现类
 */
public class SubAbstract implements SubListener {
    private Vector<ObsListener> vector = new Vector();

    public SubAbstract() {
    }

    public void addObserver(ObsListener ob) {
        this.vector.add(ob);
    }

    public void delObserver(ObsListener ob) {
        this.vector.remove(ob);
    }

    public void notifyApplicationName(String ob) {
        Enumeration enumd = this.vector.elements();
        while(enumd.hasMoreElements()) {
            ObsListener observerListener = (ObsListener)enumd.nextElement();
            observerListener.obsApplicationName(ob);
        }
    }

}
