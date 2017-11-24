package com.darly.dview.widget.coupon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * 边缘凹凸的卡劵效果View
 * @author  Darly/张宇辉/2017/11/23 14:49
 * @version  1.0/com.darly.dview.widget.coupon
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

public class CouponDisplayView extends LinearLayout {
    private Paint mPaint;
    /**
     * 圆间距
     */
    private float gap = 8;
    /**
     * 半径
     */
    private float radius = 5;
    /**
     * 圆数量
     */
    private int circleNum;

    private float remain;

    private boolean showDisplay;


    public CouponDisplayView(Context context) {
        super(context);
        init();
    }


    public CouponDisplayView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CouponDisplayView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setDither(true);
        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (remain == 0) {
            remain = (int) (w - gap) % (2 * radius + gap);
        }
        circleNum = (int) ((w - gap) / (2 * radius + gap));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (showDisplay) {
            for (int i = 0; i < circleNum; i++) {
                float x = gap + radius + remain / 2 + ((gap + radius * 2) * i);
                canvas.drawCircle(x, 0, radius, mPaint);
                canvas.drawCircle(x, getHeight(), radius, mPaint);
            }
        }
    }


    public void setShowDisplay(boolean showDisplay) {
        this.showDisplay = showDisplay;
        invalidate();
    }
}
