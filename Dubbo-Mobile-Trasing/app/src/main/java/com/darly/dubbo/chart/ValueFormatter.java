package com.darly.dubbo.chart;

import com.darly.chartlib.data.Entry;
import com.darly.chartlib.formatter.IValueFormatter;
import com.darly.chartlib.utils.ViewPortHandler;

import java.text.NumberFormat;

/**
 * @author Darly/张宇辉/2017/12/8 9:12
 * @version 1.0/com.darly.dubbo.chart
 */
public class ValueFormatter implements IValueFormatter{
    @Override
    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {

        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);//保留两位小数
        nf.setGroupingUsed(false);//去掉数值中的千位分隔符

        String temp = nf.format(value);
        if (temp.contains(".")) {
            String s1 = temp.split("\\.")[0];
            String s2 = temp.split("\\.")[1];
            for (int i = s2.length(); i > 0; --i) {
                if (!s2.substring(i - 1, i).equals("0")) {
                    return s1 + "." + s2.substring(0, i);
                }
            }
            return s1;
        }
        return temp;
    }
}
