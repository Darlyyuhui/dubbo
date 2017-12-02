package com.darly.dubbo.framework.cache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 14:19
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：缓存实现类
 */
public class EhcacheImplementation implements Cache {
    protected Log logger = LogFactory.getLog(EhcacheImplementation.class);
    private net.sf.ehcache.Cache cache;
    private String cacheKey = "dicCache";
    @Resource
    CacheManager ehcacheManager;

    public EhcacheImplementation() {
    }

    @PostConstruct
    public void init() {
        this.cache = this.ehcacheManager.getCache(this.cacheKey);
    }

    public Object get(String key) {
        Element element = this.cache.get(key);
        return element == null ? null : element.getObjectValue();
    }

    public void put(String key, Object value) {
        logger.debug("------>日期缓存成功......");
        logger.debug("------>key:" + key);
        Element element = new Element(key, value);

        try {
            this.cache.put(element);
        } catch (CacheException e) {
            this.removeCacheByKey(key);
            this.cache.put(element);
        }

    }

    public void removeCacheByKey(String key) {
        this.cache.remove(key);
    }

    public void removeAll() {
        this.cache.removeAll();
    }

    public void flush() {
        this.cache.flush();
    }

    public void setCacheKey(String cacheKey) {
        this.cacheKey = cacheKey;
        this.cache = this.ehcacheManager.getCache(cacheKey);
    }

    public String getCacheKey() {
        return this.cacheKey;
    }
}
