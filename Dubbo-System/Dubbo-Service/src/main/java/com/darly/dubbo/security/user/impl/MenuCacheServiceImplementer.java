package com.darly.dubbo.security.user.impl;

import com.darly.dubbo.framework.cache.Cache;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.security.user.MenuType;
import com.darly.dubbo.security.user.bean.SystemResource;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.service.MenuCacheService;
import com.darly.dubbo.security.user.service.ResourceService;
import com.darly.dubbo.security.user.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 8:50
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 菜单cache服务类
 */
@Service
public class MenuCacheServiceImplementer implements MenuCacheService {
	
	private Logger logger =new Logger(getClass());
	@Resource
	Cache cache;
	
	@Resource
	ResourceService menuService;
	
	@Resource
	UserRoleService userRoleService;
	
	@Override
	public void cacheMenu(String userid) {
		//获取用户拥有的可操作的菜单
		List<SystemResource> menus = menuService.getMenusByUserId(userid, MenuType.MODULE);
		for (SystemResource menu : menus) {
			List<String> btns = menuService.getMenuButtonsByParentId(userid,menu.getId());
			logger.info("btns:"+btns);
			//对菜单进行缓存处理
			cacheUserMenu(userid,menu.getId(),btns);
		}
	}

	/***
	 * 对可操作的菜单进行cache
	 */
	public void cacheUserMenu(String userId,String parentId,List<String> menuTexts){
		logger.info("正在缓存按钮菜单 ");
		try{
			logger.info("menuTexts");
			cache.put(getMenuButtonCacheKey(userId, parentId), menuTexts);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 获取缓存的菜单
	 */
	@SuppressWarnings("unchecked")
	public List<String> getMenuCache(String userId,String parentId){
		return (List<String>) cache.get(getMenuButtonCacheKey(userId, parentId));
	}
	


	/***
	 * 获取缓存的菜单cache的key值
	 */
	private String getMenuButtonCacheKey(String userId,String parentId){
		String key = userId+"_"+parentId;
		return key;
	}

	@Override
	public void refreshCache(String roleid) {
		List<User> users =userRoleService.getUserByRoleId(roleid);
		for (User user : users) {
			cacheMenu(user.getId());
		}
	}
}
