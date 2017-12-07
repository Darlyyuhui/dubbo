
package com.darly.chartlib.renderer;

import com.darly.chartlib.utils.ViewPortHandler;

/**
 * Abstract baseclass of all Renderers.
 * 
  *
  * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
  * @author  Darly/张宇辉/2017/12/7 16:47
  * @version  1.0/com.darly.chartlib.renderer
  */
 
public abstract class Renderer {

    /**
     * the component that handles the drawing area of the chart and it's offsets
     */
    protected ViewPortHandler mViewPortHandler;

    public Renderer(ViewPortHandler viewPortHandler) {
        this.mViewPortHandler = viewPortHandler;
    }
}
