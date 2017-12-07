package com.darly.chartlib.highlight;

import com.darly.chartlib.charts.PieChart;
import com.darly.chartlib.data.Entry;
import com.darly.chartlib.interfaces.datasets.IPieDataSet;

/**
 * 
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/12/7 16:36
 * @version  1.0/com.darly.chartlib.highlight
 */

public class PieHighlighter extends PieRadarHighlighter<PieChart> {

    public PieHighlighter(PieChart chart) {
        super(chart);
    }

    @Override
    protected Highlight getClosestHighlight(int index, float x, float y) {

        IPieDataSet set = mChart.getData().getDataSet();

        final Entry entry = set.getEntryForIndex(index);

        return new Highlight(index, entry.getY(), x, y, 0, set.getAxisDependency());
    }
}
