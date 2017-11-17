package com.darly.dview.widget.camera.util;


import com.darly.dview.widget.camera.LocalNetWorkView;

/**
 * @package: com.huatek.api.utils
 * @ClassName: ImageCacheLoader
 * @Description: 从本地加载图片工具
 * @author: aaron_han
 * @data: 2015-1-27 下午4:01:14
 */
public class ImageCacheLoader {
	private static ImageCacheLoader loader;

	public static ImageCacheLoader getInstance() {
		if (loader == null) {
			loader = new ImageCacheLoader();
		}
		return loader;
	}

	public void getLocalImage(String filePath, LocalNetWorkView lv, boolean isFlag) {
		if (filePath == null) {
			return;
		}
		lv.filePath = filePath;
		lv.isFlag = isFlag;
	}

}