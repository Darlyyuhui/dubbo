package com.darly.dubbo.security.user.dao;

import com.darly.dubbo.security.user.bean.Role;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.bean.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/***
 * 用户与角色管理映射器
 */
public interface UserRoleMapper {

	/***
	 * 添加关联映射
	 */
	void save(UserRole userRole);
	
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
	
	/***
	 * 根据用户id获取该用户拥有的所有角色
	 */
	List<Role> getRolesByUserId(String userid);
}
