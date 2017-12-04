package com.darly.dubbo.retrofit;

/**
 * Created by Zhangyuhui/Darly on 2017/7/18.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO:登录使用的参数集合
 */
public class LoginParamer {
    private String account;
    private String pwd;
    private String imei;

    public LoginParamer(String account, String pwd, String imei) {
        this.account = account;
        this.pwd = pwd;
        this.imei = imei;
    }

}
