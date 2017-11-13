package com.darly.dubbo.security.user.impl;

import com.darly.dubbo.framework.base.AbstractBaseService;
import com.darly.dubbo.framework.base.BaseMapper;
import com.darly.dubbo.framework.base.Page;
import com.darly.dubbo.framework.cache.Cache;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.bean.UserSearch;
import com.darly.dubbo.security.user.dao.UserMapper;
import com.darly.dubbo.security.user.service.UserRoleService;
import com.darly.dubbo.security.user.service.UserService;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/6 11:41
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */

@Service
public class UserServiceImplementer extends AbstractBaseService<User,UserSearch> implements UserService {
    public String USERNAME_CACHE ="username_cache";
    public String USERNAMEBYZH = "usernamebyzh";
    @Resource
    Cache cache;
    @Resource
    UserMapper userMapper;
    @Resource
    UserRoleService userRoleService;


    public UserServiceImplementer() {
    }

    @Override
    protected BaseMapper<User, UserSearch> getBaseMapper() {
        return userMapper;
    }

    @Override
    public Page getUsersByCondition(Map<String, Object> map, int pageNo, int pageSize, String sortType) {
        return null;
    }

    public List<User> findAll(boolean disabled) {
        UserSearch search = new UserSearch();
        search.createCriteria().andDisabledEqualTo(disabled);
        return this.userMapper.selectByExample(search);
    }

    public User findUserByLoginName(String userName) {
        UserSearch search = new UserSearch();
        search.createCriteria().andAccountEqualTo(userName);
        List<User> user = this.userMapper.selectByExample(search);
        return user != null && !user.isEmpty() ? (User)user.get(0) : null;
    }

    @Override
    public Set<GrantedAuthority> getRoleListByUser(String userId) {
        List<String> roles = userMapper.getRoleListByUser(userId);
        Set<GrantedAuthority> set = new HashSet<GrantedAuthority>();
        for (String role : roles) {
            GrantedAuthority authority = new SimpleGrantedAuthority(role);
            set.add(authority);
        }
        return set;
    }

    @Override
    public List<String> getRoleNameListByUser(String userId) {
        return userMapper.getRoleNameListByUser(userId);
    }

    @Override
    public int deleteUser(String ids) {
        try {
            String[] id = ids.split(",");
            userRoleService.batchDeleteByUsers(id);
            for (String string : id) {
                deleteById(string);
            }
            if(id.length > 0){
                refreshCache();
            }
            return id.length;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public void refreshCache() {
        List<User> users = this.findAll(false);
        cache.put(User.class.getSimpleName(), users);
        Table<String, String, String> table = HashBasedTable.create();
        for (User user : users) {
            //存储的对象为table
            table.put(user.getId(), USERNAME_CACHE, user.getName());
        }
        cache.put(USERNAME_CACHE, table);
        Table<String, String, String> table2 = HashBasedTable.create();
        for (User user : users) {
            //存储的对象为table
            table2.put(user.getAccount(), USERNAMEBYZH, user.getName());
        }
        cache.put(USERNAMEBYZH, table2);
    }

    @Override
    public List<User> findByIds(List<String> ids) {
        UserSearch example = new UserSearch();
        UserSearch.Criteria criteria = example.createCriteria();
        if(ids != null && ids.size() != 0){
            criteria.andIdIn(ids);
            return userMapper.selectByExample(example);
        }
        return null;
    }


}
