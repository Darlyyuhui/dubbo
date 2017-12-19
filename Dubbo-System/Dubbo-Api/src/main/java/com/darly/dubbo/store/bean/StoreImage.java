package com.darly.dubbo.store.bean;

import java.io.Serializable;
import java.util.Date;

public class StoreImage implements Serializable {
    private String id;

    private String productTypeId;

    private String imageUrl;

    private String imageDesc;

    private Date imageUploadtime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId == null ? null : productTypeId.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getImageDesc() {
        return imageDesc;
    }

    public void setImageDesc(String imageDesc) {
        this.imageDesc = imageDesc == null ? null : imageDesc.trim();
    }

    public Date getImageUploadtime() {
        return imageUploadtime;
    }

    public void setImageUploadtime(Date imageUploadtime) {
        this.imageUploadtime = imageUploadtime;
    }
}