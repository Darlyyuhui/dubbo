package com.darly.dubbo.security.user.dao;


import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.bean.UserSearch;

import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 11:14
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */

public interface UserMapper extends BaseMapper<User,UserSearch> {
    /***
     * 通过用户Id获取其角色
     */
    List<String> getRoleListByUser(String userId);


    /***
     * 根据用户id获取角色编码列表
     */
    List<String> getRoleNameListByUser(String userid);
}
