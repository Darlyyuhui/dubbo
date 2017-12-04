package com.darly.dubbo.retrofit;

import com.google.gson.JsonObject;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author Darly/张宇辉/2017/12/4 9:04
 * @version 1.0/com.darly.dubbo.retrofit
 */
public interface HttpInterface  {
    /**
     * @TODO:用户登录POST接口，传递参数为<b>route</b>
     */
    //@FormUrlEncoded//添加这行注解，否则参数报错。Post请求
    @GET("mobile/api/list")
    Observable<JsonObject> getList();
    /**
     * @TODO:用户登录POST接口，传递参数为<b>route</b>
     */
    @POST("mobile/login")
    Observable<JsonObject> postlogin(@Body RequestBody route);
}
