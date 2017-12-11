package com.darly.dubbo;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.darly.common.DLog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Darly/张宇辉/2017/11/30 10:46
 * @version 1.0/com.darly.dubbo
 */
public class DubboWebViewClient extends WebViewClient {
    private DubboAndroidListener listener;

    public DubboWebViewClient(DubboAndroidListener listener) {
        this.listener = listener;
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {
                    /*如果请求包含约定的字段 说明是要拿本地的图片*/
            if (url.contains(listener.getLocalKey())) {
                String imgPath = url.replace(listener.getLocalKey(), "");
                DLog.i("本地图片路径：" + imgPath.trim());
                try {
                        /*重新构造WebResourceResponse  将数据已流的方式传入*/
                    FileInputStream input = new FileInputStream(new File(imgPath.trim()));
                    WebResourceResponse response = new WebResourceResponse("image/jpg", "UTF-8", input);
                        /*返回WebResourceResponse*/
                    return response;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.shouldInterceptRequest(view, url);
    }

    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            String url = request.getUrl().toString();
                    /*如果请求包含约定的字段 说明是要拿本地的图片*/
            if (url.contains(listener.getLocalKey())) {
                String imgPath = url.replace(listener.getLocalKey(), "");
                DLog.i("本地图片路径：" + imgPath.trim());
                try {
                        /*重新构造WebResourceResponse  将数据已流的方式传入*/
                    FileInputStream  input = new FileInputStream(new File(imgPath.trim()));
                    WebResourceResponse response = new WebResourceResponse("image/jpg", "UTF-8", input);
                        /*返回WebResourceResponse*/
                    return response;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return super.shouldInterceptRequest(view, request);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
    }
}
