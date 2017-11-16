package com.darly.dubbo;

import android.os.Bundle;
import android.webkit.WebView;

import com.darly.dubbo.base.BaseWebView;
import com.darly.dubbo.binder.ContentBinder;
import com.darly.dubbo.binder.ViewsBinder;

/**
 * Created by Darly on 2017/11/16.
 */
@ContentBinder(R.layout.activity_html)
public class HtmlWebView extends BaseWebView {
    private String start  = "http://10.10.15.110/dubbo/index";
    @ViewsBinder(R.id.id_web_html)
    WebView webView;
    @Override
    protected void initView(Bundle savedInstanceState) {
        setWebSet(webView);
        webView.loadUrl(start);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {

    }
}
