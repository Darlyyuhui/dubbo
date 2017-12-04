package com.darly.common.retrofit.reobs;

import okhttp3.Request;
/**
 * 观察者接口，实现此接口者，皆调用接口里面的方法。
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/4 14:45
 * @version  1.0/com.darly.common.retrofit.reobs
 */

public interface RxobsListener {
    Request.Builder initHeader(Request.Builder builder);
}
