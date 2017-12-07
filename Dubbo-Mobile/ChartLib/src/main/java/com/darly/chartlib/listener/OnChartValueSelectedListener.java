package com.darly.chartlib.listener;

import com.darly.chartlib.data.Entry;
import com.darly.chartlib.highlight.Highlight;

/**
 * Listener for callbacks when selecting values inside the chart by
 * touch-gesture.
  * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
  * @author  Darly/张宇辉/2017/12/7 16:42
  * @version  1.0/com.darly.chartlib.listener
  */

public interface OnChartValueSelectedListener {

    /**
     * Called when a value has been selected inside the chart.
     *
     * @param e The selected Entry
     * @param h The corresponding highlight object that contains information
     *          about the highlighted position such as dataSetIndex, ...
     */
    void onValueSelected(Entry e, Highlight h);

    /**
     * Called when nothing has been selected or an "un-select" has been made.
     */
    void onNothingSelected();
}
