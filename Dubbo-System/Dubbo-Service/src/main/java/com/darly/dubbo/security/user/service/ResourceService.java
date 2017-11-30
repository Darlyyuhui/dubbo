package com.darly.dubbo.security.user.service;




import com.darly.dubbo.framework.base.BaseService;
import com.darly.dubbo.security.user.MenuType;
import com.darly.dubbo.security.user.bean.SystemResource;
import com.darly.dubbo.security.user.bean.SystemResourceSearch;

import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 18:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 系统资源服务接口
 */
public interface ResourceService extends BaseService<SystemResource, SystemResourceSearch> {

    public List<SystemResource> findAll(boolean disabled);

    /***
     * 获取所有的菜单
     */
    public List<SystemResource> findAllMenuByKeyWord(String keyWord, String exIncludes);

    /**
     * 获取资源的孩子节点
     */
    public List<SystemResource> getChildren(String menuid, MenuType type);

    /***
     * 判断该资源是否有孩子
     */
    public boolean hasChild(String menuid, MenuType type);

    /***
     * 获取用户拥有的菜单权限
     */
    public List<SystemResource> getMenusByUserId(String userId, MenuType menuType);

    /***
     * 获取用户拥有的菜单权限
     */
    public List<SystemResource> getChildMenusByUserId(String userId, String parentId, MenuType menuType);

    /***
     * 获取用户拥有的所有的叶菜单
     */
    public List<SystemResource> getLeafMenusByUserId(String userId);

    /***
     *  获取用户拥有的快捷方式
     */
    public List<SystemResource> getDeskTopMenuByuserId(String userId);

    /****
     * 获取menu下的所有按钮
     */
    public List<String> getMenuButtonsByParentId(String userId, String menuId);

    public List<SystemResource> getMenuButtonsByUserId(String userId);

    /***
     * 授权角色资源
     */
    public void grantRoleResource(String roleid, String... resid);


    /***
     * 根据角色id和资源id查找是否有记录
     * @param roleid
     * @return
     */
    public boolean hasResourceByRoleId(String roleid, String resid);

    /**
     * 根据用户权限和菜单名称获取所有子菜单，不包括操作资源
     */
    public List<SystemResource> getChildMenusByUserIdAndParentId(String userId, String parentId);

}
