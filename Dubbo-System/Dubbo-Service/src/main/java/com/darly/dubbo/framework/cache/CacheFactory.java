package com.darly.dubbo.framework.cache;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 14:12
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：缓存初始化输出工程
 */
public class CacheFactory {
    public static Logger log = Logger.getLogger(CacheFactory.class);
    private boolean cacheInitialized = false;
    private List<Object> items;

    public CacheFactory() {
    }

    @PostConstruct
    public void initCache() {
        if (log.isDebugEnabled()) {
            log.info("------>Start the data cache service......");
            log.info("------>Pre-cache memory（free/total）:" + String.valueOf(this.getMemorySize("free")) + " M/ " + this.getMemorySize("total") + " M");
        }

        this.initItems();
        if (log.isDebugEnabled()) {
            log.info("------>After memory memory（free/total）:" + String.valueOf(this.getMemorySize("free")) + " M/ " + this.getMemorySize("total") + " M");
            log.info("------>The data cache service ends......");
        }

    }

    private void initItems() {
        if (this.getItems() != null && this.getItems().size() != 0) {
            try {
                for(int i = 0; i < this.getItems().size(); ++i) {
                    if (!(this.items.get(i) instanceof BaseCache)) {
                        throw new Exception("------>The cache object must be BaseCache Interface implementation");
                    }

                    BaseCache baseCache = (BaseCache)this.getItems().get(i);
                    baseCache.init();
                }

                this.cacheInitialized = true;
            } catch (Exception var3) {
                var3.printStackTrace();
            }

        }
    }

    public long getMemorySize(String mode) {
        if ("total".equals(mode)) {
            return Runtime.getRuntime().totalMemory() / 1048576L;
        } else {
            return "free".equals(mode) ? Runtime.getRuntime().freeMemory() / 1048576L : 0L;
        }
    }

    public boolean isCacheInitialized() {
        return this.cacheInitialized;
    }

    public List<Object> getItems() {
        return this.items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }
}
