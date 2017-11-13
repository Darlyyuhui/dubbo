package com.darly.dubbo.framework.cache;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.ObjectExistsException;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.ConfigurationFactory;
import net.sf.ehcache.config.DiskStoreConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 14:17
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： 缓存管理类
 */
public class CacheManagerFactoryBean implements FactoryBean<CacheManager>, InitializingBean, DisposableBean {
    protected Log logger = LogFactory.getLog(CacheManagerFactoryBean.class);
    private Resource configLocation;
    private String diskStoreLocation;
    private String cacheManagerName;
    private CacheManager cacheManager;

    public CacheManagerFactoryBean() {
    }

    public void setConfigLocation(Resource configLocation) {
        this.configLocation = configLocation;
    }

    public void setDiskStoreLocation(String diskStoreLocation) {
        this.diskStoreLocation = diskStoreLocation;
    }

    public void afterPropertiesSet() throws Exception {
        logger.info("------>Initializing EHCache CacheManager");
        Configuration config = null;
        if (this.configLocation != null) {
            config = ConfigurationFactory.parseConfiguration(this.configLocation.getInputStream());
            if (this.diskStoreLocation != null) {
                DiskStoreConfiguration dc = new DiskStoreConfiguration();
                String path = ResourceUtils.getFile(this.diskStoreLocation).getAbsolutePath();
                logger.info("------>cache path :" + path);
                dc.setPath(path);

                try {
                    config.addDiskStore(dc);
                } catch (ObjectExistsException var5) {
                    logger.warn("------>if you want to config distStore in spring, please remove diskStore in config file!", var5);
                }
            }
        }

        if (config != null) {
            this.cacheManager = new CacheManager(config);
        } else {
            this.cacheManager = new CacheManager();
        }

        if (this.cacheManagerName != null) {
            this.cacheManager.setName(this.cacheManagerName);
        }

    }

    public CacheManager getObject() throws Exception {
        return this.cacheManager;
    }

    public Class<?> getObjectType() {
        return this.cacheManager != null ? this.cacheManager.getClass() : CacheManager.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void destroy() throws Exception {
        logger.info("------>Shutting down EHCache CacheManager");
        this.cacheManager.shutdown();
    }
}
