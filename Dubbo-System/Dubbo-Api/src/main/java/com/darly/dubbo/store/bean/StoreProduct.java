package com.darly.dubbo.store.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class StoreProduct implements Serializable {
    private String id;

    private String productName;

    private BigDecimal productPrice;

    private BigDecimal productOrprice;

    private String productDesc;

    private String productImage;

    private Integer productNum;

    private Integer productStars;

    private List<StoreImage> images;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductOrprice() {
        return productOrprice;
    }

    public void setProductOrprice(BigDecimal productOrprice) {
        this.productOrprice = productOrprice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc == null ? null : productDesc.trim();
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage == null ? null : productImage.trim();
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Integer getProductStars() {
        return productStars;
    }

    public void setProductStars(Integer productStars) {
        this.productStars = productStars;
    }


    public List<StoreImage> getImages() {
        return images;
    }

    public void setImages(List<StoreImage> images) {
        this.images = images;
    }
}