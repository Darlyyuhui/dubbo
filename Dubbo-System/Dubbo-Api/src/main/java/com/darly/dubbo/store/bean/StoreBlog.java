package com.darly.dubbo.store.bean;

import java.io.Serializable;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/13
 * TODO :
 */
public class StoreBlog  implements Serializable {
    private String id;
    private String product_id;
    private String auther_id;
    private String blog_title;
    private String blog_article;
    private String blog_image;
    private String blog_updatetime;
    private String blog_creattime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getAuther_id() {
        return auther_id;
    }

    public void setAuther_id(String auther_id) {
        this.auther_id = auther_id;
    }

    public String getBlog_title() {
        return blog_title;
    }

    public void setBlog_title(String blog_title) {
        this.blog_title = blog_title;
    }

    public String getBlog_article() {
        return blog_article;
    }

    public void setBlog_article(String blog_article) {
        this.blog_article = blog_article;
    }

    public String getBlog_image() {
        return blog_image;
    }

    public void setBlog_image(String blog_image) {
        this.blog_image = blog_image;
    }

    public String getBlog_updatetime() {
        return blog_updatetime;
    }

    public void setBlog_updatetime(String blog_updatetime) {
        this.blog_updatetime = blog_updatetime;
    }

    public String getBlog_creattime() {
        return blog_creattime;
    }

    public void setBlog_creattime(String blog_creattime) {
        this.blog_creattime = blog_creattime;
    }

}
