/**
 * 
 */
package com.darly.dview.widget.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageView;
/**
 * 加载本地图片自定义视图
 * @author  Darly/张宇辉/2017/11/23 14:51
 * @version  1.0/com.darly.dview.widget.camera
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

public class LocalNetWorkView extends ImageView {
	public String filePath;// 本地路径
	public String url;
	public Bitmap bm;
	public boolean isFlag = false;
	public boolean isInWindow = false;

	public LocalNetWorkView(Context context) {
		super(context);
	}

	public LocalNetWorkView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		isInWindow = true;
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		isInWindow = false;
	}

}
