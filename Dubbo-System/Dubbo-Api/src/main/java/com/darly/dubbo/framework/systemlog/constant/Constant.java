package com.darly.dubbo.framework.systemlog.constant;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 常用的常量定义
 */
public final class Constant
{

	/**  空字符串 */
    public final static String CONST_EMPTY = "";

    /**  分割符号：点 */
    public final static String SEPARATOR_DOT = ".";

    /**  分割符号：下划线 */
    public final static String SEPARATOR_UNDERLINE = "_";

    /**  分割符号：空格 */
    public final static String SEPARATOR_BLANK = " ";

    /**  分割符号：目录分割 */
    public final static String SEPARATOR_FOLDER = "/";

    /**  分割符号：目录分割（windows格式） */
    public final static String SEPARATOR_FOLDER_WINDOWS = "\\";

    /**  分割符号：URL分割 */
    public final static String SEPARATOR_URL = ":";

    /**  分割符号：与  */
    public final static String SEPARATOR_AND = "&";

    /**  分隔符号：或  */
    public final static String SEPARATOR_OR = "|";

    /** 换行  */
    public final static char SEPARATOR_LINEFEED = '\n';

    /** TAB符号  */
    public final static char SEPARATOR_TAB = '\t';

    /** 4个空格  */
    public final static String SEPARATOR_4_TABSPACE = "    ";

    /** 左括号 */
    public final static String BRACKET_LEFT = "(";

    /** 右括号  */
    public final static String BRACKET_RIGHT = ")";

    /** 上级目录标识  */
    public final static String PATH_TOP = "..";

    /**  当前目录路径标识 */
    public final static String PATH_CURRENT = ".";
    
    /**  模块标识：公共模块 */
    public final static String MODULE_COMMON = "common";
    
    /**excel 文件扩展名*/
    public final static String XLS_FILE_FORMAT=".xls";
    public final static String XLSX_FILE_FORMAT=".xlsx";

    /**  缺省的包路径前（缀）部分 */
    public final static String PREFIX_PACKAGE_NAME = "cn.com.darly.sysbase.framework";
    
    //需从Session中删除的对象(错误页面使用)    
    public static final String SESSION_DELETE="session_Delete";
    
    //正常记录
	public final static String RECORD_STATUS_VALID = "0";

	//已被删除的记录
	public final static String RECORD_STATUS_REMOVED = "-1";
	
	//产品发布模式
	public final static String RELEASE_MODE="release";
	
	//存储在application中得key
	public static final String APPLICATION_CONTEXT_MODE= "system.application.context.mode";
	
	//log4j路径
	public static final String APPLICATION_LOG4J_CONTEXT= "system.log4j.path";

	//系统功能编码
	public static final String[] SYSTEM_MODULE_CODE = new String[]{"isCross","isVideo"};
	
	//系统的部署路径
	public static final String CONTEXT_REALPATH ="ssms.app.web.dir";
	//系统GIS图层配置文件
	public static final String MAP_LAYER_XML="baselayer.xml";
	
	
	/**
	 * UTF-8编码
	 */
	public static final String UTF8 = "UTF-8";
	/**
	 * cookie中的JSESSIONID名称
	 */
	public static final String JSESSION_COOKIE = "JSESSIONID";
	/**
	 * url中的jsessionid名称
	 */
	public static final String JSESSION_URL = "jsessionid";
	/**
	 * HTTP POST请求
	 */
	public static final String POST = "POST";
	/**
	 * HTTP GET请求
	 */
	public static final String GET = "GET";
	
	//流量分析阀值 1
	public final static int fazhi1 = 10;
	
	//流量分析阀值 2
	public final static int fazhi2 = 80;
	
	//流量分析状态 阻塞2
	public final static String ZUSE = "<span style='background:red;color:white;'>阻&nbsp;&nbsp;&nbsp;&nbsp;塞</span>";
	
	//流量分析状态 拥堵1
	public final static String YONGDU = "<span style='background:orange;color:white;'>拥&nbsp;&nbsp;&nbsp;&nbsp;堵</span>";
	
	//流量分析状态 畅通0
	public final static String CHANGTONG = "<span style='background:green;color:white;'>畅&nbsp;&nbsp;&nbsp;&nbsp;通</span>";
	
	//流量分析状态 无数据-1
	public final static String NODATA = "<span style='background:#CCC;color:white;padding: 2px;'>无数据</span>";
} 
