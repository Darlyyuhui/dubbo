package com.darly.dubbo.biz;

import android.app.Dialog;
import android.text.TextUtils;

import com.darly.common.DLog;
import com.darly.common.NetUtils;
import com.darly.common.Utils;
import com.darly.common.retrofit.FrameListener;
import com.darly.common.retrofit.FramePresenter;
import com.darly.common.retrofit.FrameView;
import com.darly.common.retrofit.RxjavaRetrofitRequestUtil;
import com.darly.dubbo.base.AppApplication;
import com.darly.dubbo.retrofit.HttpInterface;
import com.darly.dubbo.retrofit.LoginParamer;
import com.google.gson.JsonObject;

import okhttp3.RequestBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * @author Darly/张宇辉/2017/12/4 9:41
 * @version 1.0/com.darly.dubbo.biz
 */
public class MainBiz implements FramePresenter {
    @Override
    public void onStart(Dialog dialog) {

    }

    @Override
    public void onStop(Dialog dialog) {

    }
    public void onList(final FrameListener<String> listener){
        RxjavaRetrofitRequestUtil.getInstance().get(HttpInterface.class).getList()
                .subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<JsonObject, String >() {
                    @Override
                    public String call(JsonObject s) {
                        DLog.json("Func1", s.toString());
                        return s.toString();
                    }
                })
                .subscribe(new Observer<String >() {
                               @Override
                               public void onCompleted() {

                               }

                               @Override
                               public void onError(Throwable e) {
                                   listener.onFaild(1, "网络连接异常，请检查网络");
                               }

                               @Override
                               public void onNext(String data) {
                                   if (!TextUtils.isEmpty(data)){
                                       listener.onSucces(data);
                                   } else {
                                       listener.onFaild(0, "解析错误");
                                   }
                                }
                });
        }

    public void login(String account, String pwd,final FrameListener<String> listener) {
        if (!NetUtils.isNetworkAvailable(AppApplication.getInstance())) {
            listener.onFaild(0, "网络异常,请检查网络");
            return;
        }
        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/x-www-form-urlencoded"), RxjavaRetrofitRequestUtil.getParamers(new LoginParamer(account, Utils.getCipherText(pwd), "123"), "UTF-8"));
        RxjavaRetrofitRequestUtil.getInstance().post(HttpInterface.class).postlogin(body)
                .subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<JsonObject, String >() {
                    @Override
                    public String call(JsonObject s) {
                        DLog.json("Func1", s.toString());
                        return s.toString();
                    }
                })
                .subscribe(new Observer<String >() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFaild(1, "网络连接异常，请检查网络");
                    }

                    @Override
                    public void onNext(String data) {
                        if (!TextUtils.isEmpty(data)){
                            listener.onSucces(data);
                        } else {
                            listener.onFaild(0, "解析错误");
                        }
                    }
                });
    }

    public interface MainInterface extends FrameView{

    }
}
