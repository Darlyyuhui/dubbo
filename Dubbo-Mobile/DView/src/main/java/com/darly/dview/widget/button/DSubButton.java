package com.darly.dview.widget.button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.darly.dview.R;


public class DSubButton extends FrameLayout {
    private Button mButton;
    private ProgressBar mProgressBar;
    private FrameLayout mContainer;

    //	private int mState = STATE_NORMAL;
    public final static int STATE_NORMAL = 0;
    public final static int STATE_SUBMITTING = 1;

    private String mClickBefore;
    private String mClickAfter;
    private View[] mViewS;

    public DSubButton(Context context) {
        super(context);
    }

    public DSubButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        mContainer = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.dv_submit_button, null);
        mButton = (Button) mContainer.findViewById(R.id.btn_sub);
        mProgressBar = (ProgressBar) mContainer.findViewById(R.id.pb_wait);
        mButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                setSubmitting();
                performClick();
            }
        });
        addView(mContainer);
    }

    public DSubButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setViewInit(String clickBefore, String clickAfter, View... viewS) {
        mClickBefore = clickBefore;
        mClickAfter = clickAfter == null ? mClickBefore : clickAfter;
        mViewS = viewS;
        setState(STATE_NORMAL);
    }

    private void setState(int state) {
        boolean enabled = false;
        if (state == STATE_NORMAL) {
            mButton.setText(mClickBefore);
            enabled = true;
            mProgressBar.setVisibility(View.GONE);
        } else if (state == STATE_SUBMITTING) {
            mButton.setText(mClickAfter);
            enabled = false;
            mProgressBar.setVisibility(View.VISIBLE);
        }
        mButton.setEnabled(enabled);
        for (View view : mViewS) {
            view.setEnabled(enabled);
        }
    }

    public void setNormal() {
        setState(STATE_NORMAL);
    }

    public void setSubmitting() {
        setState(STATE_SUBMITTING);
    }

    // 直接暴露外包控制
    public void setEnabled(boolean isClick) {
        mButton.setEnabled(isClick);
    }

}
