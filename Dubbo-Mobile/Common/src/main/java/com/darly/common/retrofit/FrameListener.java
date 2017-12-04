package com.darly.common.retrofit;

/**
 * @author zhangyh2 BaseListener 下午4:10:16 TODO 业务请求对应接口
 */
public interface FrameListener<T> {

    /**
     * @param result TODO 请求出现正确结果
     */
    void onSucces(T result);

    /**
     * @param code
     * @param info TODO 请求出现错误结果,由于现在loading的存在，故而返回code就起到很重要的作用。
     *             0是专门展示给用户提示信息，非0则跳入对应逻辑块
     */
    void onFaild(int code, String info);
}
