package com.darly.dview.widget.camera.util;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期工具类
 * @author  Darly/张宇辉/2017/11/23 14:50
 * @version  1.0/com.darly.dview.widget.camera.util
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

@SuppressLint("SimpleDateFormat")
public class MDate {
	public static final String getDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		return format.format(d);
	}

	public static final String getDateAsFileName() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date d = new Date();
		return format.format(d);
	}

	public static final String getDate(String mformat) {
		SimpleDateFormat format = new SimpleDateFormat(mformat);
		Date d = new Date();
		return format.format(d);
	}

	public static final String getChsDate() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		Date d = new Date();
		return format.format(d);
	}

	public static final String getTodayDate(boolean isbegin) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String date = format.format(d);
		if (isbegin) {
			return date + " 00:00:00";
		} else {
			return date + " 23:59:59";
		}
	}

	public static String getGPSLimitTime() {
		long time = System.currentTimeMillis() - 1800000;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(time);
		return format.format(date);
	}

}
