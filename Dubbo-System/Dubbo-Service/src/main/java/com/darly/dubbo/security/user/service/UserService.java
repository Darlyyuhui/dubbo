package com.darly.dubbo.security.user.service;


import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.framework.base.Page;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.bean.UserSearch;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 8:50
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 用户信息数据库接口
 */
public interface UserService extends BaseService<User,UserSearch> {
    /***
     * 获取用户的分页列表数据
     */
    public Page getUsersByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType);

    /***
     * 获取所有的用户 false 是找到所有用户，true 找不到
     */
    public List<User> findAll(boolean disabled);


    /***
     *  通过用户帐号查询该用户
     */
    User findUserByLoginName(String userName);

    /***
     * 通过用户Id获取其角色
     */
    Set<GrantedAuthority> getRoleListByUser(String userId);

    /***
     * 通过用户Id获取其角色名称集合
     */
    List<String> getRoleNameListByUser(String userId);

    /***
     * 删除用户
     */
    public int deleteUser(String ids);

    /**
     * 刷新缓存
     */
    void refreshCache();

    /**
     查询在ids中的用户信息
     */
    List<User> findByIds(List<String> ids);
}