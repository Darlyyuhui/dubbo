package com.darly.dubbo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.darly.chartlib.charts.BarChart;
import com.darly.chartlib.charts.LineChart;
import com.darly.chartlib.components.Legend;
import com.darly.chartlib.components.XAxis;
import com.darly.chartlib.components.YAxis;
import com.darly.chartlib.data.BarData;
import com.darly.chartlib.data.BarDataSet;
import com.darly.chartlib.data.BarEntry;
import com.darly.chartlib.data.Entry;
import com.darly.chartlib.data.LineData;
import com.darly.chartlib.data.LineDataSet;
import com.darly.chartlib.formatter.IAxisValueFormatter;
import com.darly.chartlib.interfaces.datasets.IBarDataSet;
import com.darly.chartlib.interfaces.datasets.ILineDataSet;
import com.darly.dubbo.base.BaseActivity;
import com.darly.dubbo.chart.StringAxisValueFormatter;
import com.darly.dubbo.chart.ValueFormatter;
import com.darly.dview.common.SCfg;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.header.TitleView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Darly/张宇辉/2017/12/8 8:32
 * @version 1.0/com.darly.dubbo
 */
@ContentBinder(R.layout.activity_chart)
public class ChartActivity extends BaseActivity implements OnClickListener {

    @ViewsBinder(R.id.id_title)
    TitleView title;

    @ViewsBinder(R.id.id_chart_barchart)
    BarChart id_chart_barchart;
    @ViewsBinder(R.id.id_chart_linechart)
    LineChart id_chart_linechart;

    List<Float> yarr = new ArrayList<Float>();
    List<String> xAxisValue = new ArrayList<String>();

    SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");

    int count = 60;
    long now = System.currentTimeMillis() - count * 1000;
    long oneDay = 1 * 1000;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            //在这里刷新数据，重新进行展示。
            yarr.remove(0);
            yarr.add(new Random().nextFloat() * 100);
            xAxisValue.remove(0);
            now += oneDay;
            xAxisValue.add(s.format(new Date(now)));
            setLineChart(id_chart_linechart, xAxisValue, yarr, "线图", false);
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        title.setTitle("图表页面");
        id_chart_barchart.setLayoutParams(new LinearLayout.LayoutParams(SCfg.getWidth(), SCfg.getWidth()));
        ChartInit(id_chart_barchart);
        id_chart_linechart.setLayoutParams(new LinearLayout.LayoutParams(SCfg.getWidth(), SCfg.getWidth()));
    }

    private void ChartInit(BarChart chart) {
        chart.getDescription().setEnabled(false);//描述信息
        chart.setPinchZoom(true);//设置同比缩放
        //X轴设置
        XAxis x = chart.getXAxis();
        x.setPosition(XAxis.XAxisPosition.BOTTOM);
        x.setDrawGridLines(false);
        x.setGranularity(1f);
        x.setLabelCount(12);
        x.setAxisLineWidth(2f);
        //Y轴设置
        YAxis y = chart.getAxisLeft();
        y.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        y.setDrawGridLines(false);
        y.setDrawLabels(false);

        chart.getAxisRight().setEnabled(false);
        //图例设置
        Legend l = chart.getLegend();
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        l.setForm(Legend.LegendForm.LINE);
        l.setTextSize(12);

        chart.setExtraOffsets(10, 10, 10, 10);
        chart.animateX(50);
    }

    @Override
    protected void loadData() {

        for (int i = 0; i < count; i++) {
            yarr.add(new Random().nextFloat() * 100);
            now += oneDay;
            xAxisValue.add(s.format(new Date(now)));
        }
        setBarChartData(id_chart_barchart, yarr, "柱图", Color.CYAN);
        setLineChart(id_chart_linechart, xAxisValue, yarr, "线图", false);
    }

    private void setBarChartData(BarChart barChart, List<Float> yAxisValue, String title, Integer barColor) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0, n = yAxisValue.size(); i < n; ++i) {
            entries.add(new BarEntry(i, yAxisValue.get(i)));
        }
        BarDataSet set1;

        if (barChart.getData() != null && barChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) barChart.getData().getDataSetByIndex(0);
            set1.setValues(entries);
            barChart.getData().notifyDataChanged();
            barChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(entries, title);
            if (barColor == null) {
                set1.setColor(ContextCompat.getColor(barChart.getContext(), R.color.colordf7b39));//设置set1的柱的颜色
            } else {
                set1.setColor(barColor);
            }

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.9f);
            data.setValueFormatter(new ValueFormatter());

            barChart.setData(data);
        }
    }

    @Override
    protected void initListener() {
        title.setLeftBackOneListener(R.mipmap.ic_title_back, this);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, 0, 1000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_view_back_img:
                finish();
                break;
        }
    }


    public static final int[] LINE_COLORS = {
            Color.rgb(140, 210, 118), Color.rgb(159, 143, 186), Color.rgb(233, 197, 23)
    };//绿色，紫色，黄色
    public static final int[] LINE_FILL_COLORS = {
            Color.rgb(222, 239, 228), Color.rgb(246, 234, 208), Color.rgb(235, 228, 248)
    };

    /**
     * 单线单y轴图。
     *
     * @param lineChart
     * @param xAxisValue
     * @param yAxisValue
     * @param title
     * @param showSetValues 是否在折线上显示数据集的值。true为显示，此时y轴上的数值不可见，否则相反。
     */
    public static void setLineChart(LineChart lineChart, List<String> xAxisValue, List<Float> yAxisValue, String title, boolean showSetValues) {
        List<List<Float>> entriesList = new ArrayList<>();
        entriesList.add(yAxisValue);

        List<String> titles = new ArrayList<>();
        titles.add(title);

        setLinesChart(lineChart, xAxisValue, entriesList, titles, showSetValues, null);
    }

    /**
     * 绘制线图，默认最多绘制三种颜色。所有线均依赖左侧y轴显示。
     *
     * @param lineChart
     * @param xAxisValue    x轴的轴
     * @param yXAxisValues  y轴的值
     * @param titles        每一个数据系列的标题
     * @param showSetValues 是否在折线上显示数据集的值。true为显示，此时y轴上的数值不可见，否则相反。
     * @param lineColors    线的颜色数组。为null时取默认颜色，此时最多绘制三种颜色。
     */
    public static void setLinesChart(LineChart lineChart, List<String> xAxisValue, List<List<Float>> yXAxisValues, List<String> titles, boolean showSetValues, int[] lineColors) {
        lineChart.getDescription().setEnabled(false);//设置描述
        lineChart.setPinchZoom(true);//设置按比例放缩柱状图

        //x坐标轴设置
        IAxisValueFormatter xAxisFormatter = new StringAxisValueFormatter(xAxisValue);
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(true);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(xAxisValue.size()/6);
        xAxis.setValueFormatter(xAxisFormatter);

        //y轴设置
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setDrawGridLines(true);
        if (showSetValues) {
            leftAxis.setDrawLabels(false);//折线上显示值，则不显示坐标轴上的值
        }
        lineChart.getAxisRight().setEnabled(false);

        //图例设置
        Legend legend = lineChart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(12f);

        //设置折线图数据
        setLinesChartData(lineChart, yXAxisValues, titles, showSetValues, lineColors);

        lineChart.setExtraOffsets(10, 30, 20, 10);
        lineChart.animateX(10);//数据显示动画，从左往右依次显示
    }

    private static void setLinesChartData(LineChart lineChart, List<List<Float>> yXAxisValues, List<String> titles, boolean showSetValues, int[] lineColors) {

        List<List<Entry>> entriesList = new ArrayList<>();
        for (int i = 0; i < yXAxisValues.size(); ++i) {
            ArrayList<Entry> entries = new ArrayList<>();
            for (int j = 0, n = yXAxisValues.get(i).size(); j < n; j++) {
                entries.add(new Entry(j, yXAxisValues.get(i).get(j)));
            }
            entriesList.add(entries);
        }

        if (lineChart.getData() != null && lineChart.getData().getDataSetCount() > 0) {

            for (int i = 0; i < lineChart.getData().getDataSetCount(); ++i) {
                LineDataSet set = (LineDataSet) lineChart.getData().getDataSetByIndex(i);
                set.setValues(entriesList.get(i));
                set.setLabel(titles.get(i));
            }

            lineChart.getData().notifyDataChanged();
            lineChart.notifyDataSetChanged();
        } else {
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();

            for (int i = 0; i < entriesList.size(); ++i) {
                LineDataSet set = new LineDataSet(entriesList.get(i), titles.get(i));
                if (lineColors != null) {
                    set.setColor(lineColors[i % entriesList.size()]);
                    set.setCircleColor(lineColors[i % entriesList.size()]);
                    set.setCircleColorHole(Color.WHITE);
                } else {
                    set.setColor(LINE_COLORS[i % 3]);
                    set.setCircleColor(LINE_COLORS[i % 3]);
                    set.setCircleColorHole(Color.WHITE);
                }

                if (entriesList.size() == 1) {
                    set.setDrawFilled(true);
                    set.setFillColor(LINE_FILL_COLORS[i % 3]);
                }
                dataSets.add(set);
            }

            LineData data = new LineData(dataSets);
            if (showSetValues) {
                data.setValueTextSize(10f);
                data.setValueFormatter(new ValueFormatter());
            } else {
                data.setDrawValues(false);
            }

            lineChart.setData(data);
        }
    }


}
