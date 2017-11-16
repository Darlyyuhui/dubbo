package com.darly.dubbo.base;

import android.app.Dialog;

/**
 * @author zhangyh2 BasePresenter 上午11:08:51 TODO 基础业务逻辑类
 */
public interface FramePresenter {

	/**
	 * 业务逻辑进行启动
	 */
	void onStart(Dialog loading);

	/**
	 * 业务逻辑运行完成
	 */
	void onStop(Dialog loading);

}
