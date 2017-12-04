package com.darly.common.retrofit.reobs;

import okhttp3.Request;

/**
 * 观察者接口，实现此接口者，皆调用接口里面的方法。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public interface RxobsListener {
    Request.Builder initHeader(Request.Builder builder);
}
