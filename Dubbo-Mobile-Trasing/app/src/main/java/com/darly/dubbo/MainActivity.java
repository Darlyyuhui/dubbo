package com.darly.dubbo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.darly.dubbo.base.AppConst;
import com.darly.dubbo.base.BaseActivity;
import com.darly.dubbo.biz.MainBiz.MainInterface;
import com.darly.dubbo.presenter.MainPresenter;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.camera.OwnerPhotoPop;
import com.darly.dview.widget.header.TitleView;
/**
 * 
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/11/30 9:06
 * @version  1.0/com.darly.dubbo
 */
@ContentBinder(R.layout.activity_main)
public class MainActivity extends BaseActivity implements OnClickListener ,MainInterface{

    @ViewsBinder(R.id.id_title)
    TitleView title;

    @ViewsBinder(R.id.id_forword_html)
    Button btn;
    @ViewsBinder(R.id.id_accout)
    TextView id_accout;
    @ViewsBinder(R.id.id_pwd)
    TextView id_pwd;
    @ViewsBinder(R.id.id_common_login)
    Button id_common_login;
    @ViewsBinder(R.id.id_common_retrofit)
    Button id_common_retrofit;
    @ViewsBinder(R.id.id_chart)
    Button id_chart;

    private MainPresenter presenter;
    private OwnerPhotoPop pop;

    @Override
    protected void initView(Bundle savedInstanceState) {
        title.setTitle("测试首页");
        title.setRightViewRightOneListener(this);
        pop = new OwnerPhotoPop(this);
        presenter = new MainPresenter(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        btn.setOnClickListener(this);
        id_common_login.setOnClickListener(this);
        id_common_retrofit.setOnClickListener(this);
        id_chart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_forword_html:
                startActivity(new Intent(this,HtmlWebView.class));
                break;
            case R.id.id_chart:
                startActivity(new Intent(this,ChartActivity.class));
                break;
            case R.id.id_common_login:
                presenter.login(id_accout.getText().toString().trim(),id_pwd.getText().toString().trim());
                break;
            case R.id.id_common_retrofit:
                presenter.net();
                break;
            case com.darly.dview.R.id.title_view_operation_imageview_right:
                pop.show(view,0, 3, AppConst.getVido().concat("tour"),false);
                break;
            default:
                break;
        }

    }

    @Override
    public void setDisableClick() {

    }

    @Override
    public void setEnableClick() {

    }
}
