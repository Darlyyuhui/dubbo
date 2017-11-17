package com.darly.dubbo;

import android.content.Context;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import com.darly.dubbo.base.BaseWebView;
import com.darly.dubbo.common.DLog;

/**
 * Created by Darly on 2017/11/17.
 */
public class DubboAndroidListener {

    private WebView webView;
    private BaseWebView context;

    public DubboAndroidListener(Context context,WebView webView) {
        this.context = (BaseWebView) context;
        this.webView = webView;
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
    public void creadt(){
        DLog.i("----------creadt>");
    }

    /**
     * JS调用的方法
     */
    @JavascriptInterface
    public void reloadUrl(final String url) {
        DLog.i("----------reloadUrl>"+url);
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
