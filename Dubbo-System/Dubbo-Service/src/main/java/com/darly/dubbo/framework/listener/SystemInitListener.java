package com.darly.dubbo.framework.listener;

import com.darly.dubbo.framework.obs.ObsApplication;
import com.darly.dubbo.framework.obs.SubAbstract;
import com.darly.dubbo.framework.obs.SubListener;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.framework.systemlog.constant.Constant;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * 系统启动监听器
 */
public class SystemInitListener implements ServletContextListener {
	public static final Logger logger = new Logger(SystemInitListener.class);

    protected SubListener showinfo;

    public SystemInitListener() {
        this.showinfo = new SubAbstract();
        this.showinfo.addObserver(ObsApplication.getInstance());
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

	public void contextInitialized(ServletContextEvent sce) {
    	//获取产品发布模式
    	String runMode = sce.getServletContext().getInitParameter("run.mode");
    	if(Constant.RELEASE_MODE.equals(runMode)){
    		logger.debugLine();
    	    logger.info("********************************************");
    	    logger.info("检测到本系统运行模式为：发布模式]");
    		sce.getServletContext().setAttribute(Constant.APPLICATION_CONTEXT_MODE,runMode);
    	}else{
    		logger.warn("检测到本系统运行模式为：开发调试模式]");
    	}
        systemStartup(sce.getServletContext());
    }

    /**
     * 应用平台启动 
     */
	private void systemStartup(ServletContext servletContext) {
        // 用户对应用初始化的一些处理，需要可以加。
        logger.info("********************************************");
        logger.info("[系统正在启动...]");
        logger.info("[系统正在加载系统参数...]");
        //设置web应用路径
        servletContext.setAttribute("contextPath", servletContext.getContextPath());
        System.setProperty("deployname",servletContext.getContextPath());
        String path = servletContext.getRealPath("/");
        //设置应用部署的路径
        System.setProperty(Constant.CONTEXT_REALPATH, path);
        String webroot = System.getProperty("ssms.root");
        if(StringUtils.isBlank(webroot)){
        	System.setProperty("ssms.root",path);
        }
        logger.info("[系统参数加载完成]");
        logger.info("********************************************");
    }
	
}
