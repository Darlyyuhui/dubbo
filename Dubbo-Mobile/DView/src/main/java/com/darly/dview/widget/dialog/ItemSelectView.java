package com.darly.dview.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.darly.dview.R;


/**
 *  选择器
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2018/9/4 14:03
 * @version  1.0/cn.com.darly.studentguide.widget.dialog
 */

public class ItemSelectView extends Dialog {
    private Context mContext = null;
    private View mCustomView = null;
    private String[] clearItems;
    private String[] classTags;
    private String mTitle = null;
    private TextView mTvCancle = null;
    private TextView mTvPublishSelectTitle = null;
    private ListView mLvPublishTypes = null;
    private AffairsTypeAdapter adapter;
    private String result;

    public ItemSelectView(Context context, String[] clearItems, String title) {
        super(context, R.style.PublishDialog);
        this.mContext = context;
        this.clearItems = clearItems;
        mTitle = title;
        init();
    }
    public ItemSelectView(Context context, String[] clearItems,String[] classTags, String title) {
        super(context, R.style.PublishDialog);
        this.mContext = context;
        this.clearItems = clearItems;
        mTitle = title;
        this.classTags = classTags;
        init();
    }

    private void init() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mCustomView = inflater.inflate(R.layout.item_select_dialog, null);
        setContentView(mCustomView);
        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(dm);
        float scale = mContext.getResources().getDisplayMetrics().density;
        lp.width = dm.widthPixels - (int) (5.0f * scale + 0.5f);
        lp.height = LayoutParams.WRAP_CONTENT;
        initView();
    }

    @Override
    public void show() {
        super.show();
    }

    private void initView() {
        mTvCancle = (TextView) mCustomView.findViewById(R.id.tv_publish_select_dialog_cancle);
        mTvPublishSelectTitle = (TextView) mCustomView.findViewById(R.id.tv_publish_select_dialog_title);
        mTvPublishSelectTitle.setText(mTitle);
        mLvPublishTypes = (ListView) mCustomView.findViewById(R.id.lv_publish_select_dialog);
        adapter = new AffairsTypeAdapter(mContext, clearItems);
        mLvPublishTypes.setAdapter(adapter);
        mLvPublishTypes.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                result = clearItems[0];
                if (selectResultItemClick != null) {
                    result = clearItems[position];
                    if (classTags!=null&&classTags.length == clearItems.length){
                        selectResultItemClick.resultOnClick(result, classTags[position]);
                    }else {
                        selectResultItemClick.resultOnClick(result, mTitle);
                    }
                }
                dismiss();
            }
        });

        mTvCancle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public class AffairsTypeAdapter extends BaseAdapter {
        private String[] clearItems = null;
        private LayoutInflater mInflater = null;

        public AffairsTypeAdapter(Context context, String[] clearItems) {
            mInflater = LayoutInflater.from(context);
            this.clearItems = clearItems;
        }

        @Override
        public int getCount() {
            return clearItems.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_select_dialog_show, null);
                holder = new ViewHolder();
                holder.mTvStyleName = (TextView) convertView.findViewById(R.id.tv_publish_slect_dialog_string);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mTvStyleName.setText(clearItems[position] + "");
            return convertView;
        }

        private class ViewHolder {
            private TextView mTvStyleName = null;
        }
    }

    private SelectResultItemClick selectResultItemClick;

    public void setSelectResultItemClick(SelectResultItemClick selectResultItemClick) {
        this.selectResultItemClick = selectResultItemClick;
    }

    public interface SelectResultItemClick {
        public void resultOnClick(String result, String title);
    }

}
