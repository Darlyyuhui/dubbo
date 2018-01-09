package com.darly.video.wedget.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.darly.video.R;
import com.darly.video.adapter.ParentAdapter;

import java.util.List;

/**
 * Created by Zhangyuhui/Darly on 2017/6/8.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO：巡检页面弹窗的列表适配器。
 */
public class TourSelectAdapter extends ParentAdapter<TourSelectListener> {
    private String title;


    public TourSelectAdapter(String title, List<TourSelectListener> data, int resID, Context context) {
        super(data, resID, context);
        this.title = title;
    }

    @Override
    public View HockView(int i, View view, ViewGroup viewGroup, int i1, Context context, TourSelectListener s) {
        ViewHocker hocker = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(i1, null);
            hocker = new ViewHocker();
            hocker.tv = (TextView) view.findViewById(R.id.id_select_flp_tv);
            view.setTag(hocker);
        } else {
            hocker = (ViewHocker) view.getTag();
        }
        if ("选择分辨率".equals(title)) {
            hocker.tv.setText(s.width + " x " + s.height);
        }
        if ("选择录像时长".equals(title)) {
            hocker.tv.setText(s.time / 1000 + "秒");
        }
        if ("选择模式".equals(title)) {
            hocker.tv.setText(s.isAuto == false ? "自动录像" : "手动录像");
        }
        return view;
    }

    class ViewHocker {
        TextView tv;
    }
}
