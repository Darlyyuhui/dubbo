package com.darly.dubbo.chart;

import com.darly.chartlib.components.AxisBase;
import com.darly.chartlib.formatter.IAxisValueFormatter;

import java.util.List;

/**
 * @author Darly/张宇辉/2017/12/8 9:51
 * @version 1.0/com.darly.dubbo.chart
 */
public class StringAxisValueFormatter implements IAxisValueFormatter {

    //区域值
    private List<String> mStrs;

    /**
     * 对字符串类型的坐标轴标记进行格式化
     * @param strs
     */
    public StringAxisValueFormatter(List<String> strs){
        this.mStrs =strs;
    }

    @Override
    public String getFormattedValue(float v, AxisBase axisBase) {
        return mStrs.get((int)v);
    }
}