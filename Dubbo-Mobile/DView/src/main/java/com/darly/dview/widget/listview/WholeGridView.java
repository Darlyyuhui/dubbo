package com.darly.dview.widget.listview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * GridView布满屏幕
 * @author  Darly/张宇辉/2017/11/23 14:47
 * @version  1.0/com.darly.dview.widget.listview
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

public class WholeGridView extends GridView {
	  
    public WholeGridView(Context context) {
        // TODO Auto-generated method stub  
        super(context);  
    }  
  
    public WholeGridView(Context context, AttributeSet attrs) {
        // TODO Auto-generated method stub  
        super(context, attrs);  
    }  
  
    public WholeGridView(Context context, AttributeSet attrs, int defStyle) {
        // TODO Auto-generated method stub  
        super(context, attrs, defStyle);  
    }  
  
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {  
        // TODO Auto-generated method stub  
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);  
    }  
}  