package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.framework.systemlog.resource.MessageResources;
import com.darly.dubbo.security.securitycfg.UserDetials;
import com.darly.dubbo.security.user.api.LoginApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Locale;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
@Service
public class LoginBiz extends BaseController implements LoginApi {


    @Autowired
    private SessionRegistry sessionRegistry;//这个类会自动注入 不用我们自己去手动注入

    @Override
    public ModelMap login(String error) {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getSourceUrl(), sourceUrl);
        logger.info("--->[方法 login 运行中...]");
        if ("true".equals(error)) {
            this.logger.info("用户登陆失败！");
        }
        model.addAttribute(ApplicationConst.getForwordUrl(),"login");
        return model;
    }

    @Override
    public ModelMap sameuser() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getSourceUrl(), sourceUrl);
        logger.info("--->[方法 sameuser 运行中...]");
        model.addAttribute(ApplicationConst.getForwordUrl(),"/error/sameuser");
        return model;
    }

    @Override
    public ModelMap timeout() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getSourceUrl(), sourceUrl);
        logger.info("--->[方法 timeout 运行中...]");
        model.addAttribute(ApplicationConst.getForwordUrl(),"/error/timeout");
        return model;
    }

    @Override
    public ModelMap forwardLogin() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getSourceUrl(), sourceUrl);
        logger.info("--->[方法 forwardLogin 运行中...]");
        model.addAttribute(ApplicationConst.getForwordUrl(),"login/relogin");
        return model;
    }

    @Override
    public ModelMap index() {
        ModelMap model = new ModelMap();
        setModel(model);
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getSourceUrl(), sourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(),"login/index");
        return model;
    }

    @Override
    public ModelMap home( HttpServletRequest request) {
        ModelMap model = new ModelMap();
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        for (int i = 0,len=allPrincipals.size(); i < len; i++) {
            logger.info("--->[已经登录的用户信息：------>]"+allPrincipals.get(i));
        }
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getSourceUrl(), sourceUrl);
        boolean isRealse = this.isRealse(request.getSession().getServletContext());
        String resCode = null;
        if (isRealse) {
            MessageResources resource = MessageResources.getMessageInstance((String)null, (String)null, Locale.CHINA);
            resCode = resource.getMessage("res.code");
        }
        UserDetials user = getCurrentUser();
        if (user == null) {
            model.addAttribute("hasUser", false);
            logger.info("--->没有登录用户--->[方法 home 运行中...]");
            throw new UsernameNotFoundException("用户不存在");
        } else {
            logger.info("--->用户"+user.getAccount()+"--->[方法 home 运行中...]");
            model.addAttribute("hasUser", true);
            model.addAttribute("userName", user.getRealName());
            model.addAttribute("account", user.getId());
            request.getSession().setAttribute("userName", user.getRealName());
            HttpSession session = request.getSession();
            String index = request.getParameter("index");
            if (index != null && index.length() > 0) {
                session.setAttribute("index", index);
            }
            model.addAttribute(ApplicationConst.getForwordUrl(),"home/admin");
            return model;
        }
     }
}