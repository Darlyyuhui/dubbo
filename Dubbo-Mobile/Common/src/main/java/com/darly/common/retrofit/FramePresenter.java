package com.darly.common.retrofit;

import android.app.Dialog;

/**
 * 基础业务逻辑类
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/4 14:42
 * @version  1.0/com.darly.common.retrofit
 */

public interface FramePresenter {

	/**
	 * 业务逻辑进行启动
	 * @param loading 加載類
	 */
	void onStart(Dialog loading);

	/**
	 * 业务逻辑运行完成
	 * @param loading 加載類
	 */
	void onStop(Dialog loading);

}
