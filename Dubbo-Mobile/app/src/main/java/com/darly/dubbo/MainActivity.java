package com.darly.dubbo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.darly.dubbo.base.BaseActivity;
import com.darly.dubbo.binder.ContentBinder;
import com.darly.dubbo.binder.ViewsBinder;

@ContentBinder(R.layout.activity_main)
public class MainActivity extends BaseActivity implements OnClickListener{

    @ViewsBinder(R.id.id_forword_html)
    Button btn;

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,HtmlWebView.class));
    }
}
