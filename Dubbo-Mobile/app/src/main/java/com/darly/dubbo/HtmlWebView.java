package com.darly.dubbo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.darly.common.DLog;
import com.darly.dubbo.base.BaseWebView;
import com.darly.dview.framework.ContentBinder;
import com.darly.dview.framework.ViewsBinder;
import com.darly.dview.widget.camera.OwnerPhotoPop;

import java.util.List;

/**
 * Created by Darly on 2017/11/16.
 */
@SuppressLint("JavascriptInterface")
@ContentBinder(R.layout.activity_html)
public class HtmlWebView extends BaseWebView  {
    private String start  = "http://10.10.15.110:8082/dubbo/index";
    @ViewsBinder(R.id.id_web_html)
    WebView webView;
    private boolean isPageLoaded;

    private OwnerPhotoPop pop;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setWebSet(webView);
        pop= new OwnerPhotoPop(this);
        // js调用安卓方法
        DubboAndroidListener listener = new DubboAndroidListener(this,webView,pop);
        webView.addJavascriptInterface(listener, "DubboAndroidListener");
        webView.loadUrl(start);
        //webView.loadUrl("javascript:shareCheck('" + true + "')");
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (title != null && title.length() < 30) {
                    DLog.i("----------->"+title);
                }
            }
        });
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                DLog.i("------------->shouldOverrideUrlLoading");
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                DLog.i("------------->onPageStarted"+url);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                DLog.i("------------->onPageFinished"+url);
                super.onPageFinished(view, url);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                DLog.i("------------->onLoadResource"+url);
                super.onLoadResource(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                DLog.i("------------->onReceivedError"+error);
                super.onReceivedError(view, request, error);
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isPageLoaded) {
                webView.loadUrl("javascript:CommonRedirect.goBack()");
            } else {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
            }
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1){

        }else {

        }
        if (resultCode == -1 && requestCode == 99) {
            List<String> photos = (List<String>) data.getSerializableExtra("album_picture");
            String video = data.getStringExtra("path");
        } else if (resultCode == -1 && requestCode == 1) {
            List<String> photos = (List<String>) data.getSerializableExtra("camera_picture");
        }
    }
}
