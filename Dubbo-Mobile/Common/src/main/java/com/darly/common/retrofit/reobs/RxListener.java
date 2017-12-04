package com.darly.common.retrofit.reobs;

import okhttp3.Request;

/**
 * 設計者，將觀察者集中註冊到這裡。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public interface RxListener {

    void addObserver(RxobsListener ob);

    void delObserver(RxobsListener ob);

    Request.Builder initHeader(Request.Builder builder);
}
