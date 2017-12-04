package com.darly.common.retrofit;

/**
 * 基础View层类
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/4 14:43
 * @version  1.0/com.darly.common.retrofit
 */

public interface FrameView {
    /**
     * 用户不可以进行点击操作
     */
    void setDisableClick();

    /**
     * 用户可以进行点击操作
     */
    void setEnableClick();

}
