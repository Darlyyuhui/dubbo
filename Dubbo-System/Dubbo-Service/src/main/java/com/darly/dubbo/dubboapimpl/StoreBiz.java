package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.security.user.api.UserApi;
import com.darly.dubbo.security.user.bean.User;
import com.darly.dubbo.security.user.service.UserService;
import com.darly.dubbo.store.api.StoreApi;
import com.darly.dubbo.store.bean.StoreBlog;
import com.darly.dubbo.store.service.StoreBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO : 在这里添加一些不同功能模块的商品
 */
@Service
public class StoreBiz extends BaseController implements StoreApi {

    @Autowired
    StoreBlogService storeBlogService;

    @Override
    public ModelMap storehome() {
        ModelMap model = new ModelMap();
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), applicationName);
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute("storename", "达理全球连锁商城");
        model.addAttribute(ApplicationConst.getForwordUrl(),"dlstore/storehome");
        List<StoreBlog> stores =  storeBlogService.findAll();
        if (stores!=null){
            model.addAttribute("storeblog", objectToJson(stores));
        }
        return model;
    }
}
