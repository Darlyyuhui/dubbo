package com.darly.common.retrofit;

/**
 * 业务请求对应接口
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/4 14:41
 * @version  1.0/com.darly.common.retrofit
 */

public interface FrameListener<T> {

    /**
     * @param result  请求出现正确结果
     */
    void onSucces(T result);

    /**
     * @param code 編碼
     * @param info   请求出现错误结果,由于现在loading的存在，故而返回code就起到很重要的作用。
     *             0是专门展示给用户提示信息，非0则跳入对应逻辑块
     */
    void onFaild(int code, String info);
}
