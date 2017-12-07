package com.darly.chartlib.highlight;

/**
 * 
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  com.darly.chartlib/张宇辉/2017/12/7 16:37
 * @version  1.0/com.darly.chartlib.highlight
 */

public interface IHighlighter
{

    /**
     * Returns a Highlight object corresponding to the given x- and y- touch positions in pixels.
     *
     * @param x
     * @param y
     * @return
     */
    Highlight getHighlight(float x, float y);
}
