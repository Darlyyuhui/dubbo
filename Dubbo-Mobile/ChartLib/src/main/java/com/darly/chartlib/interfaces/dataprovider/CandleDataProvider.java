package com.darly.chartlib.interfaces.dataprovider;

import com.darly.chartlib.data.CandleData;
/**
 * 
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/7 16:38
 * @version  1.0/com.darly.chartlib.interfaces.dataprovider
 */

public interface CandleDataProvider extends BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
