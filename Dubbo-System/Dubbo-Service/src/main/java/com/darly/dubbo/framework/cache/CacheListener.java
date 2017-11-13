package com.darly.dubbo.framework.cache;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 14:16
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：缓存监听类
 */
public class CacheListener implements ServletContextListener {
    private CacheFactory cacheFactory;

    public CacheListener() {
    }

    public void contextInitialized(ServletContextEvent arg0) {
        try {
            this.doListener(arg0.getServletContext());
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    public void doListener(ServletContext servletContext) throws ServletException {
        WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        this.setCacheFactory((CacheFactory)wac.getBean("cacheFactory"));
        if (!this.getCacheFactory().isCacheInitialized()) {
            this.getCacheFactory().initCache();
        }

    }

    public void contextDestroyed(ServletContextEvent arg0) {
    }

    public CacheFactory getCacheFactory() {
        return this.cacheFactory;
    }

    public void setCacheFactory(CacheFactory cacheFactory) {
        this.cacheFactory = cacheFactory;
    }
}
