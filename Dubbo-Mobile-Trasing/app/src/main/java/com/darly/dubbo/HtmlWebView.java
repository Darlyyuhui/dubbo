package com.darly.dubbo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.darly.common.DLog;
import com.darly.dubbo.base.BaseWebView;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.camera.OwnerPhotoPop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 *
 * @author Darly/张宇辉/2017/11/30 9:06
 * @version 1.0/com.darly.dubbo
 */
@SuppressLint("JavascriptInterface")
@ContentBinder(R.layout.activity_html)
public class HtmlWebView extends BaseWebView {
    private String start = "http://10.10.15.110:8082/dubbo/index";
    @ViewsBinder(R.id.id_web_html)
    WebView webView;
    private OwnerPhotoPop pop;
    private DubboAndroidListener listener;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setWebSet(webView);
        pop = new OwnerPhotoPop(this);
        // js调用安卓方法
        listener = new DubboAndroidListener(this, webView, pop);
        webView.addJavascriptInterface(listener, "DubboAndroidListener");
        webView.loadUrl(start);
        //webView.loadUrl("javascript:shareCheck('" + true + "')");
    }

    @Override
    protected void loadData() {

    }


    @Override
    protected void initListener() {
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (title != null && title.length() < 30) {
                    DLog.i("----------->" + title);
                }
            }
        });
        webView.setWebViewClient(new DubboWebViewClient(listener));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                finish();
            }
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<String> photos = null;
        if (resultCode == Activity.RESULT_OK && requestCode == OwnerPhotoPop.SelectRequstCode) {
            photos = (List<String>) data.getSerializableExtra("album_picture");
        } else if (resultCode == Activity.RESULT_OK && requestCode == OwnerPhotoPop.CameraRequstCode) {
            photos = (List<String>) data.getSerializableExtra("camera_picture");
        }
        DLog.i(photos);
        listener.cameraSuccess(photos);
    }
}
