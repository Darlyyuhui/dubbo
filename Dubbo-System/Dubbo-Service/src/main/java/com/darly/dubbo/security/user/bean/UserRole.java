package com.darly.dubbo.security.user.bean;

import java.io.Serializable;


/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 用户角色关系
 */

public class UserRole implements Serializable {
    //用户id
    private String userId;
    //角色id
    private String roleId;

    public UserRole() {
        super();
    }

    /**
     * @param userId
     * @param roleId
     */
    public UserRole(String userId, String roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
