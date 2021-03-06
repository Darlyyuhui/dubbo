package com.darly.dubbo.presenter;

import android.content.Context;
import android.content.Intent;

import com.darly.common.ToastApp;
import com.darly.common.retrofit.FrameListener;
import com.darly.dubbo.MainActivity;
import com.darly.dubbo.base.AppApplication;
import com.darly.dubbo.biz.MainBiz;
import com.darly.dubbo.server.MainServer;
import com.darly.dubbo.server.OtherServer;
import com.darly.dview.widget.loading.ShowLoading;

/**
 * @author Darly/张宇辉/2017/12/4 9:43
 * @version 1.0/com.darly.dubbo.presenter
 */
public class MainPresenter {
    private MainBiz biz;
    private MainBiz.MainInterface view;

    private ShowLoading loading;

    public MainPresenter( MainBiz.MainInterface view) {
        this.biz = new MainBiz();
        this.view = view;
        loading = new ShowLoading((MainActivity)view);
    }

    public void net(){
        biz.onStart(loading);
        biz.onList(new FrameListener<String>() {
            @Override
            public void onSucces(String s) {
                biz.onStop(loading);
                ToastApp.showToast(AppApplication.getInstance(),s);
            }

            @Override
            public void onFaild(int i, String s) {

            }
        });
    }

    public void login(String account, String pwd) {
        biz.onStart(loading);
        biz.login(account,pwd,new FrameListener<String>() {
            @Override
            public void onSucces(String s) {
                biz.onStop(loading);
                ToastApp.showToast(AppApplication.getInstance(),s);
            }

            @Override
            public void onFaild(int i, String s) {

            }
        });
    }
    //启动两个服务进行测试
    public void startServer(Context context) {
        Intent i1 = new Intent(context, MainServer.class);
        context.startService(i1);

        Intent i2 = new Intent(context, OtherServer.class);
        context.startService(i2);
    }
}
