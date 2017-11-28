package com.darly.dubbo;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.amap.api.location.AMapLocation;
import com.darly.common.DLog;
import com.darly.dubbo.base.AppConst;
import com.darly.dubbo.base.BaseWebView;
import com.darly.dubbo.common.LocationTools;
import com.darly.dubbo.common.LocationTools.LocationToolsListener;
import com.darly.dview.widget.camera.OwnerPhotoPop;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Darly on 2017/11/17.
 */
public class DubboAndroidListener implements LocationToolsListener {

    private WebView webView;
    private BaseWebView context;

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


}
