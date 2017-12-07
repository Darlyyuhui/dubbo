package com.darly.chartlib.animation;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
/**
 * Interface for creating custom made easing functions. Uses the
 TimeInterpolator interface provided by Android.
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/7 16:14
 * @version  1.0/com.darly.chartlib.animation
 */

@SuppressLint("NewApi")
public interface EasingFunction extends TimeInterpolator {

    @Override
    float getInterpolation(float input);
}
