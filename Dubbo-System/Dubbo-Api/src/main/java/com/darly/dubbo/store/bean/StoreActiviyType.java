package com.darly.dubbo.store.bean;

import java.io.Serializable;
import java.util.Date;

public class StoreActiviyType implements Serializable {
    private String id;

    private String storeType;

    private String storeDesc;

    private Date storeStartTime;

    private Date storeEndTime;

    private String storeTypeOp;

    private Date storeCreatetime;

    private Date storeUpdatetime;

    private String storeUpdatereason;

    private String storeTypeIcon;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType == null ? null : storeType.trim();
    }

    public String getStoreDesc() {
        return storeDesc;
    }

    public void setStoreDesc(String storeDesc) {
        this.storeDesc = storeDesc == null ? null : storeDesc.trim();
    }

    public Date getStoreStartTime() {
        return storeStartTime;
    }

    public void setStoreStartTime(Date storeStartTime) {
        this.storeStartTime = storeStartTime;
    }

    public Date getStoreEndTime() {
        return storeEndTime;
    }

    public void setStoreEndTime(Date storeEndTime) {
        this.storeEndTime = storeEndTime;
    }

    public String getStoreTypeOp() {
        return storeTypeOp;
    }

    public void setStoreTypeOp(String storeTypeOp) {
        this.storeTypeOp = storeTypeOp == null ? null : storeTypeOp.trim();
    }

    public Date getStoreCreatetime() {
        return storeCreatetime;
    }

    public void setStoreCreatetime(Date storeCreatetime) {
        this.storeCreatetime = storeCreatetime;
    }

    public Date getStoreUpdatetime() {
        return storeUpdatetime;
    }

    public void setStoreUpdatetime(Date storeUpdatetime) {
        this.storeUpdatetime = storeUpdatetime;
    }

    public String getStoreUpdatereason() {
        return storeUpdatereason;
    }

    public void setStoreUpdatereason(String storeUpdatereason) {
        this.storeUpdatereason = storeUpdatereason == null ? null : storeUpdatereason.trim();
    }

    public String getStoreTypeIcon() {
        return storeTypeIcon;
    }

    public void setStoreTypeIcon(String storeTypeIcon) {
        this.storeTypeIcon = storeTypeIcon;
    }
}