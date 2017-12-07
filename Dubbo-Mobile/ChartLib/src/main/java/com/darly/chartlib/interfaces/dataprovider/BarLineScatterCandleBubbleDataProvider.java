package com.darly.chartlib.interfaces.dataprovider;

import com.darly.chartlib.components.YAxis;
import com.darly.chartlib.data.BarLineScatterCandleBubbleData;
import com.darly.chartlib.utils.Transformer;

/**
 * 
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/7 16:29
 * @version  1.0/com.darly.chartlib.interfaces.dataprovider
 */

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(YAxis.AxisDependency axis);
    boolean isInverted(YAxis.AxisDependency axis);
    
    float getLowestVisibleX();
    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
