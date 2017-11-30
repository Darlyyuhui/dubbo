package com.darly.dubbo;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.amap.api.location.AMapLocation;
import com.darly.common.DLog;
import com.darly.common.Tools;
import com.darly.common.Utils;
import com.darly.dubbo.base.AppConst;
import com.darly.dubbo.base.BaseWebView;
import com.darly.dubbo.base.SystemCfg;
import com.darly.dubbo.common.LocationTools;
import com.darly.dubbo.common.LocationTools.LocationToolsListener;
import com.darly.dview.common.SCfg;
import com.darly.dview.widget.camera.OwnerPhotoPop;
import com.google.gson.Gson;

import java.util.List;

/**
 * 
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 * @author  Darly/张宇辉/2017/11/30 9:06
 * @version  1.0/com.darly.dubbo
 */

public class DubboAndroidListener implements LocationToolsListener {

    private WebView webView;
    private BaseWebView context;
    private String localKey = "http://file/";

    private OwnerPhotoPop pop;

    public DubboAndroidListener(Context context, WebView webView, OwnerPhotoPop pop) {
        this.context = (BaseWebView) context;
        this.webView = webView;
        this.pop = pop;
    }

    /**
     * JS启动页面调用接口
     */
    @JavascriptInterface
    public void init() {
        LocationTools.getInstance().setLocationToolsListener(this);
        LocationTools.getInstance().start();
    }

    @Override
    public void locationSuccess(AMapLocation amapLocation) {
        String json = new Gson().toJson(amapLocation);
        DLog.i(json);
        webView.loadUrl("javascript:locationSuccess('" + json+ "')");
    }


    @Override
    public void locationFail() {

    }

    /**
     * JS調用相機功能
     */
    @JavascriptInterface
    public void onCamera() {
        pop.show(webView, 0,4, AppConst.getVido().concat("tour"),false);
    }

    public void cameraSuccess(List<String> url) {
        //添加图片路径，并且进行大小分配展示
        webView.loadUrl("javascript:cameraSuccess('"+localKey + url.get(0)+"','"+ Tools.Px2Dp(context,SCfg.getWidth()/4)+"','"+ Tools.Px2Dp(context,SCfg.getWidth()/4)+ "')");
    }
    /**
     * JS调用的方法
     */
    @JavascriptInterface
    public void goToIndex() {
        context.finish();
    }

    /**
     * JS调用的方法
     */
    @JavascriptInterface
    public void creadt() {
        DLog.i("----------creadt>");
    }

    /**
     * JS调用的方法
     */
    @JavascriptInterface
    public void reloadUrl(final String url) {
        DLog.i("----------reloadUrl>" + url);
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl(url);
            }
        });

    }

    /**
     * JS调用的方法
     */
    @JavascriptInterface
    public void goToActivity(String packageName, String className,
                             boolean isCloseCurrent) {
        Intent intent = new Intent();
        intent.setClassName(packageName, className);
        context.startActivity(intent);
        if (isCloseCurrent)
            context.finish();
    }

    public String getLocalKey() {
        return localKey;
    }
}
