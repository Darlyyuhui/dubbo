package com.darly.video.wedget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.darly.video.R;


/**
 * Created by Zhangyuhui/Darly on 2017/6/13.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO:新增一个自定义功能控件，仿照微信录制视频时的点击按钮，一个圆形外环，跟随时间进行加载。
 */
public class ProgressImage extends View {


    public interface OnFinishListener {
        void progressDown();
    }

    private OnFinishListener listener;

    /**
     * 画笔对象的引用
     */
    private Paint paint;

    /**
     * 圆环的颜色
     */
    private int roundColor;

    /**
     * 圆环进度的颜色
     */
    private int roundProgressColor;

    /**
     * 中间进度百分比的字符串的颜色
     */
    private int textColor;

    /**
     * 中间进度百分比的字符串的字体
     */
    private float textSize;

    /**
     * 圆环的宽度
     */
    private float roundWidth;

    /**
     * 最大进度
     */
    private int max;

    /**
     * 当前进度
     */
    private int progress;
    /**
     * 是否显示中间的进度
     */
    private boolean textIsDisplayable;

    /**
     * 进度的风格，实心或者空心
     */
    private int style;

    public static final int STROKE = 0;
    public static final int FILL = 1;


    private volatile State mState = State.PAUSE;

    private long currTime;

    public ProgressImage(Context context) {
        this(context, null);
    }

    public ProgressImage(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProgressImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        TypedArray mTypedArray = context.obtainStyledAttributes(attrs,
                R.styleable.RoundProgressBar);
        //获取自定义属性和默认值
        roundColor = mTypedArray.getColor(R.styleable.RoundProgressBar_roundColor, Color.RED);
        roundProgressColor = mTypedArray.getColor(R.styleable.RoundProgressBar_roundProgressColor, Color.GREEN);
        textColor = mTypedArray.getColor(R.styleable.RoundProgressBar_textColor, Color.GREEN);
        textSize = mTypedArray.getDimension(R.styleable.RoundProgressBar_textSize, 15);
        roundWidth = mTypedArray.getDimension(R.styleable.RoundProgressBar_roundWidth, 5);
        max = mTypedArray.getInteger(R.styleable.RoundProgressBar_max, 100);
        textIsDisplayable = mTypedArray.getBoolean(R.styleable.RoundProgressBar_textIsDisplayable, true);
        style = mTypedArray.getInt(R.styleable.RoundProgressBar_style, 0);
        mTypedArray.recycle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * 画最外层的大圆环,实心底色，不画的话背景透明
         */
        int centre = getWidth() / 2; //获取圆心的x坐标
        int bigradius = centre - 2; //圆环的半径
        paint.setColor(roundColor); //设置大圆环的颜色
        paint.setStyle(Paint.Style.FILL); //设置空心
        paint.setStrokeWidth(roundWidth); //设置圆环的宽度
        paint.setAntiAlias(true);  //消除锯齿
        canvas.drawCircle(centre, centre, bigradius, paint); //画出圆环
        /**
         * 画圆弧 ，画圆环的进度
         */
        long time = System.currentTimeMillis();

        if (mState == State.START) {
            /**
             * 画最外层的大圆环
             */
            int radius = (int) (centre - roundWidth / 2); //圆环的半径
            paint.setColor(roundColor); //设置大圆环的颜色
            paint.setStyle(Paint.Style.STROKE); //设置空心
            paint.setStrokeWidth(roundWidth); //设置圆环的宽度
            paint.setAntiAlias(true);  //消除锯齿
            canvas.drawCircle(centre, centre, radius, paint); //画出圆环

            /**
             * 画小圆
             */
            int radiuss = (int) (centre - 4 * roundWidth / 2); //圆环的半径
            paint.setColor(Color.WHITE); //设置小圆的颜色
            paint.setStyle(Paint.Style.FILL); //设置空心
            paint.setStrokeWidth(roundWidth); //设置圆环的宽度
            paint.setAntiAlias(true);  //消除锯齿
            canvas.drawCircle(centre, centre, radiuss, paint); //画出圆环

            int measuredWidth = getMeasuredWidth();
            float top = measuredWidth / 2.0f / max;
            float tmp = (time - currTime);
            top *= tmp;
            //设置进度是实心还是空心
            paint.setStrokeWidth(roundWidth); //设置圆环的宽度
            paint.setColor(roundProgressColor);  //设置进度的颜色
            RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius);  //用于定义的圆弧的形状和大小的界限
            switch (style) {
                case STROKE: {
                    paint.setStyle(Paint.Style.STROKE);
                    canvas.drawArc(oval, 270, 360 * tmp / max, false, paint);  //根据进度画圆弧
                    break;
                }
                case FILL: {
                    paint.setStyle(Paint.Style.FILL_AND_STROKE);
                    if (progress != 0)
                        canvas.drawArc(oval, 270, 360 * tmp / max, true, paint);  //根据进度画圆弧
                    break;
                }
            }
            if (top < measuredWidth / 2.0f) {
                invalidate();
            }
            if (tmp >= max) {
                listener.progressDown();
                return;
            }
        } else {
            /**
             * 画最外层的大圆环
             */
            int radius = (int) (centre - roundWidth / 2); //圆环的半径
            paint.setColor(roundColor); //设置圆环的颜色
            paint.setStyle(Paint.Style.STROKE); //设置空心
            paint.setStrokeWidth(roundWidth); //设置圆环的宽度
            paint.setAntiAlias(true);  //消除锯齿
            canvas.drawCircle(centre, centre, radius, paint); //画出圆环

            /**
             * 画小圆
             */
            int radiuss = (int) (centre - roundWidth / 2); //圆环的半径
            paint.setColor(Color.WHITE); //设置圆环的颜色
            paint.setStyle(Paint.Style.FILL); //设置空心
            paint.setStrokeWidth(roundWidth); //设置圆环的宽度
            paint.setAntiAlias(true);  //消除锯齿
            canvas.drawCircle(centre, centre, radiuss, paint); //画出圆环
        }


    }

    public synchronized int getMax() {
        return max;
    }

    /**
     * 设置进度的最大值
     *
     * @param max
     */
    public synchronized void setMax(int max) {
        if (max < 0) {
            throw new IllegalArgumentException("max not less than 0");
        }
        this.max = max;
    }

    /**
     * 获取进度.需要同步
     *
     * @return
     */
    public synchronized int getProgress() {
        return progress;
    }

    /**
     * 设置进度，此为线程安全控件，由于考虑多线的问题，需要同步
     * 刷新界面调用postInvalidate()能在非UI线程刷新
     *
     * @param progress
     */
    public synchronized void setProgress(int progress) {
        if (progress < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (progress > max) {
            progress = max;
        }
        if (progress <= max) {
            this.progress = progress;
            postInvalidate();
        }

    }

    public void start() {
        this.mState = State.START;
        this.currTime = System.currentTimeMillis();
        postInvalidate();
    }

    public void stop() {
        this.mState = State.PAUSE;
        postInvalidate();
    }


    public int getCricleColor() {
        return roundColor;
    }

    public void setCricleColor(int cricleColor) {
        this.roundColor = cricleColor;
    }

    public int getCricleProgressColor() {
        return roundProgressColor;
    }

    public void setCricleProgressColor(int cricleProgressColor) {
        this.roundProgressColor = cricleProgressColor;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public float getTextSize() {
        return textSize;
    }

    public void setTextSize(float textSize) {
        this.textSize = textSize;
    }

    public float getRoundWidth() {
        return roundWidth;
    }

    public void setRoundWidth(float roundWidth) {
        this.roundWidth = roundWidth;
    }


    public void setStyle(int style) {
        this.style = style;
    }

    public void setOnFinishListener(OnFinishListener listener) {
        this.listener = listener;
    }

    enum State {
        START(1, "开始"),
        PAUSE(2, "暂停");

        State(int code, String message) {
            this.code = code;
            this.message = message;
        }

        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }
}
