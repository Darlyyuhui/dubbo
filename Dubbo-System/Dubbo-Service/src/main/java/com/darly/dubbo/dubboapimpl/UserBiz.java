package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.security.user.api.UserApi;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.service.UserService;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
@Service
public class UserBiz extends BaseController implements UserApi {

    @Resource
    UserService userService;
    @Override
    public ModelMap forwardLogin() {
        ModelMap model = new ModelMap();
        setModel(model);
        model.addAttribute(ApplicationConst.getApplicationName(), "新增用户");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(),"login/adduser");
        return model;
    }

    @Override
    public ModelMap addUser(User user) {
        ModelMap model = new ModelMap();
        setModel(model);
        model.addAttribute(ApplicationConst.getApplicationName(), "用户列表");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        if (user.getDisabled() == null) {
            user.setDisabled(false);
        }
        user.setId(UuidGenerateUtil.getUUIDLong());
        //对密码进行md5加密
        Md5PasswordEncoder encoder = new Md5PasswordEncoder();
        String pwd = encoder.encodePassword(user.getPwd(), user.getName());
        user.setPwd(pwd);
        //对IP控制规则进行赋值
        if (StringDiyUtils.isNotEmpty(user.getIprule1()) && StringDiyUtils.isNotEmpty(user.getIprule2()) && StringDiyUtils.isNotEmpty(user.getIprule3()) && StringDiyUtils.isNotEmpty(user.getIprule4())) {
            String iprule = user.getIprule1() + "." + user.getIprule2() + "." + user.getIprule3() + "." + user.getIprule4();
            user.setIprule(iprule);
        }
        if (StringDiyUtils.isEmpty(user.getPuserId())) {
            user.setPuserId(" ");
        }
        if (StringDiyUtils.isEmpty(user.getMemo())) {
            user.setMemo(" ");
        }
        userService.save(user);
        model.addAttribute("message", "用户添加成功");
        List<User> users = userService.findAll(false);
        model.addAttribute("users", users);
        model.addAttribute(ApplicationConst.getForwordUrl(),"login/userlist");
        return model;
    }

    @Override
    public String accountExist(HttpServletRequest req, String account) {
        logger.info("--->[方法 accountExist 运行中...]");
        User user = userService.findUserByLoginName(account);
        String returnStr = Boolean.FALSE.toString();
        if (user == null) {
            returnStr = Boolean.TRUE.toString();
        }
        String oper = req.getParameter("oper");
        //不为空说明是修改
        if (StringDiyUtils.isNotEmpty(oper)) {
            if (account.equals(oper)) {
                return Boolean.TRUE.toString();
            }
        }
        return returnStr;
    }
}
