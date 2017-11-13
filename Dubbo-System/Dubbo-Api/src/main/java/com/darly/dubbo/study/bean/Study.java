package com.darly.dubbo.study.bean;

import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/17
 * TODO :
 */
public class Study implements Comparator<Study>,Serializable {
    private String id;
    private String code;
    private String name;
    private String remark;

    public Study() {
    }

    public Study(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public int compare(Study o1, Study o2) {
        return Collator.getInstance(Locale.CHINESE).compare(o1.getName(), o2.getName());
    }
}
