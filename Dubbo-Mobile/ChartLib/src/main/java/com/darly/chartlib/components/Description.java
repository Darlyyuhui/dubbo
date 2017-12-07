package com.darly.chartlib.components;

import android.graphics.Paint;

import com.darly.chartlib.utils.MPPointF;
import com.darly.chartlib.utils.Utils;
/**
 * 
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/7 16:20
 * @version  1.0/com.darly.chartlib.components
 */

public class Description extends ComponentBase {

    /**
     * the text used in the description
     */
    private String text = "Description Label";

    /**
     * the custom position of the description text
     */
    private MPPointF mPosition;

    /**
     * the alignment of the description text
     */
    private Paint.Align mTextAlign = Paint.Align.RIGHT;

    public Description() {
        super();

        // default size
        mTextSize = Utils.convertDpToPixel(8f);
    }

    /**
     * Sets the text to be shown as the description.
     * Never set this to null as this will cause nullpointer exception when drawing with Android Canvas.
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the description text.
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Sets a custom position for the description text in pixels on the screen.
     *
     * @param x - xcoordinate
     * @param y - ycoordinate
     */
    public void setPosition(float x, float y) {
        if (mPosition == null) {
            mPosition = MPPointF.getInstance(x, y);
        } else {
            mPosition.x = x;
            mPosition.y = y;
        }
    }

    /**
     * Returns the customized position of the description, or null if none set.
     *
     * @return
     */
    public MPPointF getPosition() {
        return mPosition;
    }

    /**
     * Sets the text alignment of the description text. Default RIGHT.
     *
     * @param align
     */
    public void setTextAlign(Paint.Align align) {
        this.mTextAlign = align;
    }

    /**
     * Returns the text alignment of the description.
     *
     * @return
     */
    public Paint.Align getTextAlign() {
        return mTextAlign;
    }
}
