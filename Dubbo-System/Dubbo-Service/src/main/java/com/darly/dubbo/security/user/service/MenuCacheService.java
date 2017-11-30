package com.darly.dubbo.security.user.service;

import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 8:50
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 菜单cache服务类
 */
public interface MenuCacheService {
	
	/***
	 * 根据用户缓存对应的可操作菜单
	 */
	public void cacheMenu(String userId);
	
	
	/***
	 * 对可操作的菜单进行cache
	 */
	public void cacheUserMenu(String userId, String parentId, List<String> menuTexts);

	/***
	 * 获取缓存的菜单
	 */
	public List<String> getMenuCache(String userId, String parentId);
	
	
	/***
	 * 根据角色，刷新操作缓存 
	 */
	public void refreshCache(String roleid);
		
	
}
