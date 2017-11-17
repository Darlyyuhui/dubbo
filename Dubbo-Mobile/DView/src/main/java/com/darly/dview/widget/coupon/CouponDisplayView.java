package com.darly.dview.widget.coupon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Zhangyuhui/Darly on 2017/5/19.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO:边缘凹凸的卡劵效果View
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
