package com.darly.dubbo.root;

import com.darly.dubbo.framework.listener.SystemInitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ImportResource;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/13
 * TODO :
 */
public class ApplicationListener extends SystemInitListener {

    /**
     * #项目名称
     */
    private String applicationName = "全球经济管理系统";
    /**
     * #静态文件路径参数
     */
    private String resourceUrl = "http://10.10.15.110:8111/resource";

    public ApplicationListener() {
        super();
        logger.info(getClass().getSimpleName() + "[系统<" + applicationName + ">启动完成]");
        //设置系统参数
        showinfo.notifyApplicationName(applicationName);
        showinfo.initResource(resourceUrl);
    }
}
