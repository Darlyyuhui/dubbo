package com.darly.dubbo.framework.systemlog.resource;

import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.framework.systemlog.constant.Constant;
import com.darly.dubbo.framework.systemlog.constant.PltMessage;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;


/**
 * <p>Description: 读取配置文件的助手类，配置文件支持国际化信息。
 * 针对国际化的版本，你需要的配置文件名一般如下：
 * <pre>
 * 资源配置文件：resource_&lt;Language Code&gt;_&lt;Country Code&gt;_&lt;Module Name&gt;.properties
 * 示例：
 * resource_zh_CN_custmgt.properties
 * resource_zh_TW_custmgt.properties
 * resource_zh_HK_custmgt.properties
 * resource_en_custmgt.properties
 *
 * 错误码配置文件：errorcode_&lt;Language Code&gt;_&lt;Country Code&gt;.properties
 * errorcode_en.properties		－ 英文
 * errorcode_zh_CN.properties	－ 简体中文（中国）
 * errorcode_zh_TW.properties	－ 繁体中文（台湾）
 * errorcode_zh_HK.properties	－ 繁体中文（香港）
 * ……
 * </pre>
 * @version 1.0
 */

public class CfgFileUtil {
	/**
	 * 日志记录器
	 */
	private static Logger logger = new Logger(CfgFileUtil.class);

	/**
	 * 通过标准的配置文件载入方式读取配置文件，配置文件可以放置在指定的目录下。通过指定的国际化标识
	 * 指定文件的名称
	 * @param fileUrl 源文件名
	 * @param locale  需要获取的国际化版本
	 * @return        读取到的信息存放的Properties
	 * @see #loadCfgFile(String fileUrl)
	 */
	public static Properties loadCfgFile(String fileUrl, Locale locale) {
		return loadFile(fileUrl);
	}

	/**
	 * 通过标准的配置文件载入方式读取配置文件，配置文件可以放置在指定的目录下。采用操作系统当前的
	 * 国际化信息。
	 * @param fileUrl 源文件名
	 * @return        读取到的信息存放的Properties
	 * @see #loadCfgFile(String fileUrl, Locale locale)
	 */
	public static Properties loadCfgFile(String fileUrl) {
		return loadFile(fileUrl);
	}

	/**
	 * 通过标准的配置文件载入方式读取配置文件，配置文件可以放置在指定的目录下。
	 * 支持国际化配置文件载入。
	 * @param fileUrl 配置文件地址
	 * @return        读取到的信息存放的Properties
	 */
	private static synchronized Properties loadFile(String fileUrl) {
	
		//获取系统配置文件的名称
		if (StringDiyUtils.isEmpty(fileUrl)) {
			return null;
		}

		String url = fileUrl;

		String cfgFileName = null;
		if (url.indexOf(Constant.SEPARATOR_URL) > 1) {
			cfgFileName = url;
		} else { //尝试从文件名获取其绝对路径
			try {
				//通过文件方式的转换，得到绝对路径
				cfgFileName = ResourceUtils.getFile("classpath:"+url).getPath();
				
			} catch (Exception ie) {
				logger.fatal((Object) (PltMessage.RES_CFGFILE_FORMAT_ERROR + cfgFileName),ie);
				//              配置文件读取出现问题要通过printStackTrace输出栈轨迹，因为此时日志系统也可能无法正常运行,而此种错误是致命级别的
				ie.printStackTrace();
			}
		}

		//如果没有获取配置文件名，则直接返回
		if (null == cfgFileName) {
			return null;
		}

		//判断文件是否存在
		if (!new File(cfgFileName).exists()) {
			//        	配置文件读取出现问题要通过printStackTrace输出栈轨迹，因为此时日志系统也可能无法正常运行,而此种错误是致命级别的
			new FileNotFoundException(cfgFileName).printStackTrace();
			logger.fatal(PltMessage.RES_CFGFILE_NOT_FOUND,
					new Object[] { cfgFileName });

			return null;
		}

		InputStream is = null;

		Properties props = null;
		props = new Properties();
		try {
			is = new FileInputStream(cfgFileName);
			props.load(is);
		} catch (Exception ex) {
			logger.fatal(PltMessage.RES_CFGFILE_LOAD_FAIL,new Object[] { cfgFileName });
			//配置文件读取出现问题要通过printStackTrace输出栈轨迹，因为此时日志系统也可能无法正常运行,而此种错误是致命级别的
			ex.printStackTrace();
		} finally {
			try {
				//防止对象空指针错误
				if (is != null) {
					is.close();
				}
			} catch (java.io.IOException ie) {
				//如果关闭出错，简单的忽略
				logger.fatal(PltMessage.RES_CFGFILE_LOAD_FAIL,new Object[] { cfgFileName });
				//配置文件读取出现问题要通过printStackTrace输出栈轨迹，因为此时日志系统也可能无法正常运行,而此种错误是致命级别的
				ie.printStackTrace();
			}
		}
		return props;
	}
}
