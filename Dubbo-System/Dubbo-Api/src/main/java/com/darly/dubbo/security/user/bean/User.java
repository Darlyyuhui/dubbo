package com.darly.dubbo.security.user.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 8:51
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 用户表对应实体类
 */
public class User implements Serializable {
    private String id;
    private String account;
    private String pwd;
    private String name;
    private Boolean disabled;
    private String mobile;
    private String deptid;
    private String memo;
    private String iprule;
    private String deptName;

    //用户拥有的角色(code)
    private List<String> roleIds;
    //用户拥有的角色
    private String roles;
    //IP控制字段
    private String iprule1;
    private String iprule2;
    private String iprule3;
    private String iprule4;

    //移动平台使用 weixm
    private String puserId;
    private String pname;
    //警员编号
    private String puserCode;
    //警员名称
    private String puserName;

    //注册码
    private String regCode;

    //打印台头
    private String topName;
    //复议机关
    private String againDiscussDepartment;
    //行政法院
    private String courtName;
    //处罚地点
    private String punishAddress;
    //用户信息json字符串
    private String userdata;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccount() {
        return account;
    }

    public String getAgainDiscussDepartment() {
        return againDiscussDepartment;
    }

    public void setAgainDiscussDepartment(String againDiscussDepartment) {
        this.againDiscussDepartment = againDiscussDepartment;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid == null ? null : deptid.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    /**
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName the deptName to set
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return the roles
     */
    public String getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getIprule() {
        return iprule;
    }

    public void setIprule(String iprule) {
        this.iprule = iprule;
    }

    public String getIprule1() {
        return iprule1;
    }

    public void setIprule1(String iprule1) {
        this.iprule1 = iprule1;
    }

    public String getIprule2() {
        return iprule2;
    }

    public void setIprule2(String iprule2) {
        this.iprule2 = iprule2;
    }

    public String getIprule3() {
        return iprule3;
    }

    public void setIprule3(String iprule3) {
        this.iprule3 = iprule3;
    }

    public String getIprule4() {
        return iprule4;
    }

    public void setIprule4(String iprule4) {
        this.iprule4 = iprule4;
    }

    public String getPuserId() {
        return puserId;
    }

    public void setPuserId(String puserId) {
        this.puserId = puserId;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPuserCode() {
        return puserCode;
    }

    public void setPuserCode(String puserCode) {
        this.puserCode = puserCode;
    }

    public String getPuserName() {
        return puserName;
    }

    public void setPuserName(String puserName) {
        this.puserName = puserName;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public String getPunishAddress() {
        return punishAddress;
    }

    public String getTopName() {
        return topName;
    }

    public void setTopName(String topName) {
        this.topName = topName;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public void setPunishAddress(String punishAddress) {
        this.punishAddress = punishAddress;
    }

    public String getUserdata() {
        return userdata;
    }

    public void setUserdata(String userdata) {
        this.userdata = userdata;
    }


}
