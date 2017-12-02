package com.darly.dubbo.security.securitycfg;

import com.darly.dubbo.security.user.bean.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 15:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 用戶詳細信息
 */
@Service
public class UserDetailServer implements UserDetailsService {
    @Resource
    SecurityApi api;
    //登陆验证时，通过username获取用户的所有权限信息，
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.api.findUserByLoginName(username);
        if(user != null){
            Set<GrantedAuthority> grantedAuths = api.getRoleListByUser(user.getId());
            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;
            UserDetials userDetails = new UserDetials(user.getName(), user.getPwd(), enabled,accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
            //加入登录时间信息和用户角色
            userDetails.setLoginTime(new Date());
            userDetails.setId(user.getId());
            userDetails.setAccount(user.getAccount());
            userDetails.setRealName(user.getName());
            userDetails.setMobileNo(user.getMobile());
            userDetails.setDeptId(user.getDeptid());
            return userDetails;
        }else {
            throw new  UsernameNotFoundException("找不到该用户");
        }
    }
}
