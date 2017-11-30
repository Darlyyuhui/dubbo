package com.darly.dubbo.framework.base;

import com.darly.dubbo.framework.systemlog.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 系统自动导入综合类。
 */

public abstract class ApplicationContextHolder implements ApplicationContextAware {
    protected static Logger log = new Logger(ApplicationContextHolder.class);
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext context) throws BeansException {

        if (applicationContext != null) {
            log.info("# ApplicationContextHolder hold 'applicationContext'.#");
        } else {
            applicationContext = context;
        }

        log.info("# hold applicationContext,Name:" + applicationContext.getDisplayName());
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException(" # 'applicationContext' property is null,ApplicationContextHolder not init.");
        } else {
            return applicationContext;
        }
    }

    public static Object getBean(String beanName) {
        return getApplicationContext().getBean(beanName);
    }

    public static <T> T getBean(Class<T> bean) {
        return getApplicationContext().getBean(bean);
    }

    public static void loadBean(String[] configLocations) {
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext)applicationContext;
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader((BeanDefinitionRegistry)configurableApplicationContext.getBeanFactory());
        xmlBeanDefinitionReader.setResourceLoader(configurableApplicationContext);
        xmlBeanDefinitionReader.setEntityResolver(new ResourceEntityResolver(configurableApplicationContext));

        try {
            String[] confing = configLocations;
            int lenth = configLocations.length;

            for(int i = 0; i < lenth; ++i) {
                String string = confing[i];
                xmlBeanDefinitionReader.loadBeanDefinitions(configurableApplicationContext.getResource(string));
            }

            configurableApplicationContext.refresh();
        } catch (BeansException e) {
            log.error(" # "+e);
        }

    }
}

