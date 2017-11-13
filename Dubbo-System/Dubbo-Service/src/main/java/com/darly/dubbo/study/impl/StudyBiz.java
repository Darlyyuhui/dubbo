package com.darly.dubbo.study.impl;

import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.framework.cache.BaseCache;
import com.darly.dubbo.framework.cache.Cache;
import com.darly.dubbo.study.api.StudyApi;
import com.darly.dubbo.study.bean.Study;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/9
 * TODO : 调用API中的接口，实现接口完成的内容，跳转页面或者返回数据
 */
@Service
public class StudyBiz extends BaseController implements StudyApi {

    //直接使用Cache进行展示，获取数据库中的数据，进行展示。展示之前进行缓存刷新操作
    @Resource
    Cache cache;

    @Override
    public String studybuild(ModelMap model) {
        setModel(model);
        logger.info("--->[方法 studybuild 进入学习功能菜单...]");
        model.addAttribute("itmsname", applicationName);
        List<Study> studies = (List<Study>) cache.get(BaseCache.STUDY_CACHE);
        model.addAttribute("studys", studies);
        return "study/howtobuildthisnet";
    }

    @Override
    public String checkjson(ModelMap model) {
        setModel(model);
        logger.info("--->[方法 checkjson 进入验证JSON页面...]");
        model.addAttribute("itmsname", applicationName);
        return "json/checkjson";
    }
}
