package com.darly.dubbo.security.user.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 系统资源
 */

public class SystemResource implements Serializable{
	private String id;
    //资源类型
    private String type;
    //名称
    private String name;
    //是否叶节点
    private Boolean leaf;
    //是否可用
    private Boolean disabled;
    //编码
    private String code;
    //图片地址
    private String icon;
    //排序
    private Long sortOrder;
    //地址
    private String content;
    //备注
    private String memo;
    //添加日期
    private Date createDate;
    //添加用户名
    private String createBy;
    //修改者
    private String updateBy;
    //修改日期
    private Date updateDate;
    //状态  0 为合法  
    private String status;
    //父节点id
    private String parentid;
    //模块编码
    private String moduleCode;
    //资源名称（用于区别角色name）
    private String resourceName;
    
    //属性扩展 页面显示的图片名称 add by kouyunhao
    private String picName;
    
    //子资源
    private List<SystemResource> sonResourceList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Long getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Long sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode == null ? null : moduleCode.trim();
    }

	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public List<SystemResource> getSonResourceList() {
		return sonResourceList;
	}

	public void setSonResourceList(List<SystemResource> sonResourceList) {
		this.sonResourceList = sonResourceList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;
		if (obj instanceof SystemResource) {
			SystemResource res = (SystemResource) obj;
			if(res.getId()==null) return false;
			return res.getId().equals(this.getId());
		}
		return false;
	}

	/**
	 * @return the picName
	 */
	public String getPicName() {
		return picName;
	}

	/**
	 * @param picName the picName to set
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}

    
    
}