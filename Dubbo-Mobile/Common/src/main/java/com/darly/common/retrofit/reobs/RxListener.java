package com.darly.common.retrofit.reobs;

import okhttp3.Request;
/**
 * 設計者，將觀察者集中註冊到這裡。
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/4 14:45
 * @version  1.0/com.darly.common.retrofit.reobs
 */

public interface RxListener {

    void addObserver(RxobsListener ob);

    void delObserver(RxobsListener ob);

    Request.Builder initHeader(Request.Builder builder);
}
