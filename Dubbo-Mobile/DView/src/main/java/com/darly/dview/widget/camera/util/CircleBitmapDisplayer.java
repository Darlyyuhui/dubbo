package com.darly.dview.widget.camera.util;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
/**
 * 显示原型图片的ImageLoader使用的显示器图片工具
 * @author  Darly/张宇辉/2017/11/23 14:50
 * @version  1.0/com.darly.dview.widget.camera.util
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

public class CircleBitmapDisplayer implements BitmapDisplayer {

    protected final int margin;

    public CircleBitmapDisplayer() {
        this(0);
    }

    public CircleBitmapDisplayer(int margin) {
        this.margin = margin;
    }

    @Override
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (!(imageAware instanceof ImageViewAware)) {
            throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
        }

        imageAware.setImageDrawable(new CircleDrawable(bitmap, margin));
    }


}
