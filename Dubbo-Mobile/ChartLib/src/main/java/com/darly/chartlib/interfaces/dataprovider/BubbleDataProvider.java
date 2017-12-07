package com.darly.chartlib.interfaces.dataprovider;

import com.darly.chartlib.data.BubbleData;
/**
 *
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/7 16:37
 * @version  1.0/com.darly.chartlib.interfaces.dataprovider
 */

public interface BubbleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    BubbleData getBubbleData();
}
