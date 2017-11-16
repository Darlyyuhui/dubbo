package com.darly.dubbo.common.retrofit.paramer;

/**
 * Created by Zhangyuhui/Darly on 2017/7/21.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO: 修改密码请求类
 */
public class ChangePassParamer {

    private String oldP;
    private String newP;

    public ChangePassParamer(String newP, String oldp) {
        this.newP = newP;
        this.oldP = oldp;
    }

    public String getOldp() {
        return oldP;
    }

    public void setOldp(String oldp) {
        this.oldP = oldp;
    }

    public String getNewP() {
        return newP;
    }

    public void setNewP(String newP) {
        this.newP = newP;
    }
}
