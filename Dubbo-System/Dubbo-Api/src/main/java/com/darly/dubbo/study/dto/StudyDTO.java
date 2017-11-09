package com.darly.dubbo.study.dto;

import java.io.Serializable;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/9
 * TODO :
 */
public class StudyDTO implements Serializable{
    private static final long serialVersionUID = 7447924757767536890L;
    private String id;
    private String code;
    private String name;
    private String remark;
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

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name + ",code = " + code + ",remark = " + remark;
    }
}
