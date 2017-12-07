package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.cfg.ApplicationConst;
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
    public ModelMap studybuild() {
        ModelMap model = new ModelMap();
        logger.info("--->[方法 studybuild 进入学习功能菜单...]");
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "如何建立"+applicationName+"网站？");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        List<Study> studies = (List<Study>) cache.get(BaseCache.STUDY_CACHE);
        model.addAttribute("studys", studies);
        model.addAttribute(ApplicationConst.getForwordUrl(), "study/howtobuildthisnet");
        return model;
    }

    @Override
    public ModelMap checkjson() {
        ModelMap model = new ModelMap();
        logger.info("--->[方法 checkjson 进入验证JSON页面...]");
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "Json验证页面");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(), "study/checkjson");
        return model;
    }

    @Override
    public ModelMap nginxftp() {
        ModelMap model = new ModelMap();
        logger.info("--->[方法 landy 进入Nginx+Ftp 完成静态页面...]");
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "Nginx Ftp静态服务器");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(), "study/nginxftp");
        return model;
    }

    @Override
    public ModelMap landy() {
        ModelMap model = new ModelMap();
        logger.info("--->[方法 landy 进入外接静态页面...]");
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "美好的一天");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(), "landy/phoneshow");
        return model;
    }

    @Override
    public ModelMap gradle() {
        ModelMap model = new ModelMap();
        logger.info("--->[方法 gradle 进入Android Gradle 私服上传aar 完成静态页面...]");
        model.addAttribute(ApplicationConst.getApplicationName(), applicationName);
        model.addAttribute(ApplicationConst.getPageTitle(), "Android Gradle 上传aar");
        model.addAttribute(ApplicationConst.getResourceUrl(), resourceUrl);
        model.addAttribute(ApplicationConst.getForwordUrl(), "study/gradle");
        return model;
    }
}
