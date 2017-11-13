package com.darly.dubbo.security.system.bean;

import java.util.Date;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 9:13
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public class SystemLog {
    private String id;
    private String operatorId;
    private String ipAddress;
    private String operatorName;
    private Long type;
    private Long logLevel;
    private Date operationTime;
    private Date createDate;
    private String createBy;
    private String updateBy;
    private Date updateDate;
    private String status;
    private String content;
    private String startTime;
    private String endtime;
    private String browser;


    public SystemLog() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOperatorId() {
        return this.operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public String getOperatorName() {
        return this.operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Long getType() {
        return this.type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getLogLevel() {
        return this.logLevel;
    }

    public void setLogLevel(Long logLevel) {
        this.logLevel = logLevel;
    }

    public Date getOperationTime() {
        return this.operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndtime() {
        return this.endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}
