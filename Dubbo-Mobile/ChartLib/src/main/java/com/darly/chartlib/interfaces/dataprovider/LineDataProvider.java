package com.darly.chartlib.interfaces.dataprovider;

import com.darly.chartlib.components.YAxis;
import com.darly.chartlib.data.LineData;

/**
 * 
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/7 16:29
 * @version  1.0/com.darly.chartlib.interfaces.dataprovider
 */

public interface LineDataProvider extends BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
