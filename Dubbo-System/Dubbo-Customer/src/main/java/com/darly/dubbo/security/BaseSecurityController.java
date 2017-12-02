package com.darly.dubbo.security;

import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.framework.systemlog.constant.Constant;
import com.darly.dubbo.security.securitycfg.SpringSecurityUtils;
import com.darly.dubbo.security.securitycfg.UserDetials;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.ModelMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/1
 * TODO :
 */
public class BaseSecurityController {

    public Logger logger = new Logger(getClass());

    protected void hasUser(ModelMap model){
        UserDetials user = getCurrentUser();
        if (user == null) {
            model.addAttribute("hasUser", false);
            logger.info("--->没有登录用户--->[方法 home 运行中...]");
        } else {
            logger.info("--->用户" + user.getAccount() + "--->[方法 home 运行中...]");
            model.addAttribute("hasUser", true);
            model.addAttribute("userName", user.getRealName());
            model.addAttribute("account", user.getId());
        }
    }

    /***
     * 获取登陆用户
     * @return
     */
    protected UserDetials getCurrentUser() {
        return SpringSecurityUtils.getCurrentUser();
    }

    /***
     * 获取登陆用户id
     * @return
     */
    protected String getCurrentUserId() {
        UserDetials userInfo = getCurrentUser();
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return userInfo.getId();
    }

    /***
     * 获取本产品是否为发布模式
     */
    protected boolean isRealse(ServletContext sc){
        Object object = sc.getAttribute(Constant.APPLICATION_CONTEXT_MODE);
        if(object!=null){
            String contextMode = object.toString();
            if(Constant.RELEASE_MODE.equals(contextMode)){
                return true;
            }
        }
        return false;
    }
}
