/**
 *
 */
package com.darly.dubbo.security.user.impl;


import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.security.user.MenuType;
import com.darly.dubbo.security.user.bean.SystemResource;
import com.darly.dubbo.security.user.bean.SystemResourceSearch;
import com.darly.dubbo.security.user.dao.SystemResourceMapper;
import com.darly.dubbo.security.user.service.MenuCacheService;
import com.darly.dubbo.security.user.service.ResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 18:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 系统资源服务接口
 */
@Service
public class ResourceServiceImplementer extends AbstractBaseService<SystemResource, SystemResourceSearch> implements ResourceService {

    @Resource
    SystemResourceMapper systemResourceMapper;

    @Resource
    MenuCacheService menuCacheService;

    protected BaseMapper<SystemResource, SystemResourceSearch> getBaseMapper() {
        return systemResourceMapper;
    }

    @Override
    public void grantRoleResource(String roleid, String... resid) {
        systemResourceMapper.deleteResourceByRoleId(roleid);
        for (String string : resid) {
            systemResourceMapper.addRoleResource(roleid, string);
        }
        menuCacheService.refreshCache(roleid);
    }

    /* (non-Javadoc)
     */
    @Override
    public List<SystemResource> getChildren(String menuid, MenuType type) {
        SystemResourceSearch search = new SystemResourceSearch();
        search.createCriteria().andParentidEqualTo(menuid).andDisabledEqualTo(false).andTypeEqualTo(type.toString());
        return systemResourceMapper.selectByExample(search);
    }

    /* (non-Javadoc)
     */
    @Override
    public boolean hasChild(String menuid, MenuType type) {
        SystemResourceSearch search = new SystemResourceSearch();
        search.createCriteria().andParentidEqualTo(menuid).andDisabledEqualTo(false).andTypeEqualTo(type.toString());
        int result = systemResourceMapper.countByExample(search);
        return result > 0;
    }


    /* (non-Javadoc)
     */
    @Override
    public List<SystemResource> findAll(boolean disabled) {
        SystemResourceSearch search = new SystemResourceSearch();
        search.setOrderByClause("SORT_ORDER asc");
        search.createCriteria().andCodeIsNotNull().andDisabledEqualTo(disabled);
        return systemResourceMapper.selectByExample(search);
    }


    /* (non-Javadoc)
     */
    @Override
    public List<SystemResource> findAllMenuByKeyWord(String keyWord, String exinclude) {
        SystemResourceSearch search = new SystemResourceSearch();
        search.setOrderByClause("SORT_ORDER asc");
        SystemResourceSearch.Criteria cri = search.createCriteria();
        cri.andCodeIsNotNull()
                .andDisabledEqualTo(false)
//		.andNameLike("%"+keyWord+"%")
                .andNameEqualTo(keyWord)
                .andTypeEqualTo(MenuType.MODULE.toString());
        if (exinclude != null) {
            cri.andNameNotIn(Arrays.asList(exinclude.split(",")));
        }

        List<SystemResource> res = systemResourceMapper.selectByExample(search);
        //添加节点的孩子节点
        List<SystemResource> resultList = new ArrayList<SystemResource>();
        for (SystemResource systemResource : res) {
            getChildResource(res, resultList, systemResource);
        }
        if (exinclude != null) {
            String[] exincludeMenus = exinclude.split(",");

            for (Iterator<SystemResource> iterator = resultList.iterator(); iterator.hasNext(); ) {
                SystemResource systemResource = (SystemResource) iterator.next();
                for (int i = 0; i < exincludeMenus.length; i++) {
                    if (systemResource.getName().equals(exincludeMenus[i])) {
                        iterator.remove();
                    }
                }
            }
        }

        res.addAll(resultList);
        return res;
    }

    /***
     * 递归查找子节点
     */
    private void getChildResource(List<SystemResource> res, List<SystemResource> resultList, SystemResource systemResource) {
        String id = systemResource.getId();
        List<SystemResource> children = getChildren(id, MenuType.MODULE);
        for (SystemResource resource : children) {
            if (!res.contains(resource) && !resultList.contains(resource)) {
                if (resource.getType().equals(MenuType.MODULE.toString())) {
                    resultList.add(resource);
                }
            }
            getChildResource(res, resultList, resource);
        }

    }

    /* (non-Javadoc)
     */
    @Override
    public List<SystemResource> getDeskTopMenuByuserId(String userId) {
        return systemResourceMapper.getDeskTopMenuByuserId(userId);
    }

    /* (non-Javadoc)
     */
    @Override
    public List<SystemResource> getLeafMenusByUserId(String userId) {
        return systemResourceMapper.getLeafMenusByUserId(userId);
    }

    /* (non-Javadoc)
     */
    @Override
    public List<String> getMenuButtonsByParentId(String userId, String menuId) {
        return systemResourceMapper.getMenuButtonsByParentId(userId, menuId);
    }

    @Override
    public List<SystemResource> getMenuButtonsByUserId(String userId) {
        return systemResourceMapper.getMenusByUserId(userId, MenuType.BUTTON.toString());
    }

    @Override
    public List<SystemResource> getMenusByUserId(String userId, MenuType menuType) {
        return systemResourceMapper.getMenusByUserId(userId, menuType.toString());
    }

    @Override
    public List<SystemResource> getChildMenusByUserId(String userId, String parentId, MenuType menuType) {
        return systemResourceMapper.getChildMenusByUserId(userId, parentId, menuType.toString());
    }

    @Override
    public boolean hasResourceByRoleId(String roleid, String resid) {
        return systemResourceMapper.getRecordByResIdAndRoleId(roleid, resid) > 0;
    }


    @Override
    public int deleteById(String id) {
        List<SystemResource> btns = getChildren(id, MenuType.BUTTON);

        List<SystemResource> menus = new ArrayList<SystemResource>();

        List<SystemResource> children = getChildren(id, MenuType.MODULE);

        getAllChildResource(children, menus);
        getButtonsByMenuid(children, btns);

        children.addAll(btns);
        children.addAll(menus);

        List<String> ids = new ArrayList<String>();
        for (SystemResource res : children) {
            ids.add(res.getId());
        }

        ids.add(id);

        SystemResourceSearch search = new SystemResourceSearch();
        search.createCriteria().andIdIn(ids);
        return deleteByExample(search);
    }

    /**
     * 递归查找所有的子菜单
     */
    private void getAllChildResource(List<SystemResource> children, List<SystemResource> menus) {
        for (SystemResource systemResource : children) {
            List<SystemResource> chs = getChildren(systemResource.getId(), MenuType.MODULE);
            menus.addAll(chs);
            getAllChildResource(chs, menus);
        }
    }

    /***
     * 递归查找按钮
     */
    private void getButtonsByMenuid(List<SystemResource> children, List<SystemResource> btns) {
        for (SystemResource systemResource : children) {
            List<SystemResource> childrens = getChildren(systemResource.getId(), MenuType.BUTTON);
            if (childrens != null && !childrens.isEmpty()) {
                btns.addAll(childrens);
            } else {
                getButtonsByMenuid(getChildren(systemResource.getId(), MenuType.MODULE), btns);
            }
        }
    }

    @Override
    public List<SystemResource> getChildMenusByUserIdAndParentId(String userId,
                                                                 String parentId) {
        return systemResourceMapper.getChildMenusByUserIdAndParentId(userId, parentId);
    }


}
