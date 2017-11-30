package com.darly.dubbo.security.user.impl;

import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.bean.UserRole;
import com.darly.dubbo.security.user.dao.UserRoleMapper;
import com.darly.dubbo.security.user.service.MenuCacheService;
import com.darly.dubbo.security.user.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 用户角色管理接口实现
 */

@Service
public class UserRoleServiceImplementer implements UserRoleService {
	
	@Resource
	UserRoleMapper userRoleMapper;

	@Resource
	MenuCacheService menuCacheService;
	
	@Override
	public int batchDeleteByRoles(String... values) {
		return userRoleMapper.batchDeleteByRoles(values);
	}
	@Override
	public int batchDeleteByUsers(String... values) {
		return userRoleMapper.batchDeleteByUsers(values);
	}

	@Override
	@Transactional
	public void save(UserRole... userRole) {
		for (UserRole ur : userRole) {
			String userId = ur.getUserId();
			batchDeleteByUsers(userId);
			userRoleMapper.save(ur);
			//刷新用户拥有的菜单缓存
			menuCacheService.cacheMenu(userId);
		}
		
	}

	@Override
	public List<User> getUserByRoleId(String roleid) {
		return userRoleMapper.getUserByRoleId(roleid);
	}
	
	

}
