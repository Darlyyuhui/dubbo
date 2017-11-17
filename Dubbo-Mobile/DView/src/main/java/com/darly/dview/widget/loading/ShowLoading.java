package com.darly.dview.widget.loading;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.darly.dview.R;


/**
 * @author zhangyh2
 *         ShowLoading
 *         下午2:44:57
 *         TODO 加载数据的等候旋转
 */
public class ShowLoading extends Dialog {
    protected Context context;

    private CircleProgress progress;

    private int coutloading = 0;


    public ShowLoading(Context context) {
        super(context, R.style.Custom_Progress);
        this.context = context;
        init();
    }

    public ShowLoading(Context context, int theme) {
        super(context, theme);
        this.context = context;
        init();
    }


    @Override
    public void show() {
        coutloading++;
        if (isShowing()) {
            return;
        }
        if (progress != null) {
            progress.startAnim();
        }

        super.show();
    }

    public void radius(float factor) {
        if (progress != null) {
            progress.setRadius(factor);
        }
    }

    @Override
    public void dismiss() {
        coutloading--;
        if (coutloading != 0) {
            return;
        }
        if (progress != null) {
            progress.stopAnim();
        }
        super.dismiss();
    }

    /**
     * 给Dialog设置提示信息
     *
     * @param message
     */
    public void setMessage(CharSequence message) {
        if (message != null && message.length() > 0) {
            TextView txt = (TextView) findViewById(R.id.message);
            txt.setVisibility(View.VISIBLE);
            txt.setText(message);
            txt.invalidate();
        }
    }

    public void setMessage(int message) {
        if (message != 0) {
            TextView txt = (TextView) findViewById(R.id.message);
            txt.setVisibility(View.VISIBLE);
            txt.setText(message);
            txt.invalidate();
        }
    }

    private void init() {
        setContentView(R.layout.progress_custom);
        // 按返回键是否取消
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        // 监听返回键处理
        // setOnCancelListener(cancelListener);
        // 设置居中
        progress = (CircleProgress) findViewById(R.id.progress);
        progress.setRadius(20);
        getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        // 设置背景层透明度
        lp.dimAmount = 0.2f;
        getWindow().setAttributes(lp);
    }

}
