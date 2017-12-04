package com.darly.dubbo.mobile.api;

import com.darly.dubbo.security.user.bean.User;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/14
 * TODO :
 */
public interface MobileUserApi {

    ModelMap noRight();

    List<User> apiUsers() throws Exception;

    User login(String account);

}
