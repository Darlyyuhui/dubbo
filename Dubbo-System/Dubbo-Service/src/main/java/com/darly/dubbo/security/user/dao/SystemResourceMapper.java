package com.darly.dubbo.security.user.dao;




import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.security.user.bean.SystemResource;
import com.darly.dubbo.security.user.bean.SystemResourceSearch;

import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 18:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 系统资源映射器
 */
public interface SystemResourceMapper extends BaseMapper<SystemResource,SystemResourceSearch> {
	/***
	 *  根据用户id获取桌面菜单
	 */
	public List<SystemResource> getDeskTopMenuByuserId(String userId);
	
	/***
	 * 获取用户拥有的菜单权限
	 */
	public List<SystemResource> getMenusByUserId(String userId, String menuType);


	/***
	 * 获取用户拥有的所有的叶菜单
	 */
	public List<SystemResource> getLeafMenusByUserId(String userId);

	/***
	 * 获取用户拥有的子菜单
	 */
	public List<SystemResource> getChildMenusByUserId(String userId, String parentId, String menuType);

	/***
	 * 根据用户以及菜单编号获取按钮的名称
	 */
	public List<String> getMenuButtonsByParentId(String userId, String menuId);

	/***
	 * 根据角色id删除与资源的关系
	 */
	public void deleteResourceByRoleId(String roleid);

	/***
	 * 添加角色与资源的关系
	 */
	public void addRoleResource(String roleid, String resid);

	/***
	 * 根据角色id和资源id查找是否有记录
	 */
	public int getRecordByResIdAndRoleId(String roleid, String resid);

	/**
	 * 熊杰添加<br/>
	 * 根据用户权限和指定的父菜单id查找所有子菜单，不包括操作权限
	 */
	public List<SystemResource> getChildMenusByUserIdAndParentId(String userId, String parentId);
}