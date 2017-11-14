/*
 * Copyright 2011-2012 xiangxun Technology.
 *
 */
package com.darly.dubbo.framework.systemlog.constant;


import com.darly.dubbo.framework.common.StringDiyUtils;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 系统常用配置文件名称
 */
public final class SystemPropNaming {
	
	 /**
     * 指定配置文件路径
     */
	static String CONFIG_ROOT = "../";
	static
	{
		init();
	}
	
	public static void init()
	{
		synchronized(new Object())
		{
			CONFIG_ROOT = "";
			String env = System.getProperty("FRAMEWORK_COMMON_CONFIG_ROOT");
			if(!StringDiyUtils.isEmpty(env))
			{
				CONFIG_ROOT = env;
				if(!( env.endsWith("/") || env.endsWith("\\")) )
				{
					CONFIG_ROOT += "/";
				}
			}
			CFG_ROOT_NAME = CONFIG_ROOT;
			System.out.println("read config file in "+CONFIG_ROOT);
		}
	}
	//请不要直接使用该常量，否则会导致静态变量初始化顺序问题
    public static String CFG_ROOT_NAME;
    
    public static String getConfigRoot()
    {
    	if(CONFIG_ROOT == null)
    	{
    		init();
    	}
    	
    	return CONFIG_ROOT;
    }
	
    /**
     *Log4j的配置文件的路径及文件名
     */
    public static final String CFG_LOG4J_FILE_NAME = "dev/props/log4j.properties";
    
	   /**
     * 系统定义提示、错误信息的配置文件名称
     */
    public static final String CFG_MESSAGE_FILE_NAME = "resource.properties";

    /**
     * 系统定义错误码文件格式
     */
    public static final String CFG_ERRORCODE_FILE_NAME = "errorcode.properties";

}
