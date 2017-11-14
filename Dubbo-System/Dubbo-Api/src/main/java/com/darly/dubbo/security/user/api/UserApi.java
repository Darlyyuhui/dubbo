package com.darly.dubbo.security.user.api;

import com.darly.dubbo.security.user.bean.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
public interface UserApi {

    ModelMap forwardLogin();

    ModelMap addUser(User user);

    String  accountExist(HttpServletRequest req, @RequestParam(value = "account") String account);
}
