package com.darly.dubbo.security.user.service;

import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.bean.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 用户角色关系接口
 */

public interface UserRoleService {

	/***
	 * 添加关联映射
	 */
	void save(UserRole... userRole);
	
	/***
	 * 根据用户id批量删除用户角色关系
	 */
	int batchDeleteByUsers(@Param("records") String... values);
	
	/***
	 * 根据角色id批量删除用户角色关系
	 */
	int batchDeleteByRoles(@Param("records") String... values);
	
	/**
	 * 根据角色id，获取该角色下的所有用户
	 */
	List<User> getUserByRoleId(String roleid);
	
}
