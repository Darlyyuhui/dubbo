package com.darly.dubbo.framework.systemlog.resource;


import com.darly.dubbo.framework.common.ObjectUtils;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.framework.systemlog.constant.Constant;
import com.darly.dubbo.framework.systemlog.constant.PltMessage;
import com.darly.dubbo.framework.systemlog.constant.SystemPropNaming;
import com.darly.dubbo.framework.systemlog.exception.FrameworkException;
import org.apache.log4j.helpers.FileWatchdog;

import java.util.List;
import java.util.Locale;


/**
 * <p>Title: Resources</p>
 * <p>Description: 从配置文件里读取系统配置信息的抽象类。
 * <br>
 * <br>在配置信息里，可以设置一些参数，这些参数以两个大括号，中间以从0开始的数字表示，例如：
 * {0}表示第一个参数，{1}表示第二个参数，依次类推。
 * <br>
 * <br>在调用的时候，统一调用该类提供的getMessage()方法群。
 * <br>
 * <br>该方法群的第二个及以后的参数表示了在配置里的参数，例如：
 * <br>
 * <br>你的配置行里如果有两个参数，则你可以调用的方法就是：
 * <br>
 * <pre>
 * 　　getMessge(String, Object[])
 * </pre>
 * 或者
 * <pre>
 * 　　getMessge(String, Object, Object)
 * </pre>
 * @version 1.1
 * @since 1.1 抽象Resouces接口方式，增加对于XML文件的配置，同时保留同一接口
 */

public abstract class Resources {
	//file 和 module 为文件名称和模块业务名称，由具体业务实现时确定。
	protected String file = null; // 配置文件路径（相对路径或者绝对路径）
	protected String module = null; // 业务模块标识
	protected Locale locale = null;

	//资源文件监控对象定义
	ResourceWatchdog watchdog = null;

	private static Logger logger = new Logger(Resources.class);

	/**
	 * 从对应配置文件读取配置信息，并结合参数进行转化返回。<br>
	 * 抽象接口，具体方法需要在其子类中实现。
	 * @param key String		配置项的名称
	 * @param args Object[]		配置信息参数
	 * @return String			把参数值填充到配置后的配置信息
	 */
	public abstract String getMessage(String key, Object[] args);

	/**
	 * 从对应配置文件读取配置信息，并结合参数进行转化返回。
	 * @param key String		配置项的名称
	 * @return String			把参数值填充到配置后的配置信息
	 */
	public String getMessage(String key) {
		Object[] args = new Object[0];
		return getMessage(key, args);
	}

	/**
	 * 从对应配置文件读取配置信息，并结合参数进行转化返回。
	 * @param key String		配置项的名称
	 * @param arg0 Object		配置信息参数1
	 * @return String			把参数值填充到配置后的配置信息
	 */
	public String getMessage(String key, Object arg0) {
		Object[] args = new Object[1];
		args[0] = arg0;
		return getMessage(key, args);
	}

	/**
	 * 从对应配置文件读取配置信息，并结合参数进行转化返回。
	 * @param key String		配置项的名称
	 * @param arg0 Object		配置信息参数1
	 * @param arg1 Object		配置信息参数2
	 * @return String			把参数值填充到配置后的配置信息
	 */
	public String getMessage(String key, Object arg0, Object arg1) {
		Object[] args = new Object[2];
		args[0] = arg0;
		args[1] = arg1;
		return getMessage(key, args);
	}

	/**
	 * 从对应配置文件读取配置信息，并结合参数进行转化返回。
	 * @param key String		配置项的名称
	 * @param arg0 Object		配置信息参数1
	 * @param arg1 Object		配置信息参数2
	 * @param arg2 Object		配置信息参数3
	 * @return String			把参数值填充到配置后的配置信息
	 */
	public String getMessage(String key, Object arg0, Object arg1, Object arg2) {
		Object[] args = new Object[3];
		args[0] = arg0;
		args[1] = arg1;
		args[2] = arg2;
		return getMessage(key, args);
	}

	/**
	 * 从对应配置文件读取配置信息，并结合参数进行转化返回。
	 * @param key String		配置项的名称
	 * @param args List			配置信息参数
	 * @return String			把参数值填充到配置后的配置信息
	 */
	@SuppressWarnings("rawtypes")
	public String getMessage(String key, List args) {
		return getMessage(key, args.toArray());
	}

	/**
	 * 重新装载系统配置文件。<br>
	 * 抽象接口，具体方法需要在其子类中实现。
	 * @throws FrameworkException
	 */
	public abstract void reloadConfig() throws FrameworkException;

	/**
	 * 根据基本路径和模块名称获取配置文件的路径。
	 * <p>
	 * 配置文件的路径及名称为如下格式：
	 * <pre>
	 * 　　${DOMAIN_HOME}\config\文件名 + 国际化信息 + 业务模块名称 + 文件后缀
	 * </pre>
	 * 例如：
	 * <pre>
	 * 　　错误信息配置的中文文件名称　： ${DOMAIN_HOME}\config\errorcode_zh_CN.properties
	 * 　　资源配置文件的中文文件名称　： ${DOMAIN_HOME}\config\resource_zh_CN_common.properties
	 * </pre>
	 * <br>其中：
	 * <br>　　1、错误信息配置文件不区分模块，需要支持国际化；
	 * <br>　　2、SQL 配置文件区分模块，不需要支持国际化；
	 * <br>　　3、资源配置文件既需要区分模块，又需要支持国际化。
	 * </p>
	 * @param file String		配置文件名称
	 * @param module String		业务模块名称，不需要则传null
	 * @param locale Locale		本地信息，不需要支持国际化则传null
	 * @return String			解析之后的全路径名称
	 */
	public String genFilePath(String file, String module, Locale locale) {
		if (StringDiyUtils.isEmpty(file)) {
			return Constant.CONST_EMPTY;
		}

		int lastPos = file.lastIndexOf(Constant.SEPARATOR_DOT);

		String fileName = null;

		// 如果不带文件名后缀，则直接引用全部作为基本名称
		if (lastPos == -1) {
			fileName = file;

			// 防止后面统一取文件后缀出错，重新赋值
			lastPos = file.length();
		} else {
			// 取基本名称
			fileName = file.substring(0, lastPos);
		}

		if (!ObjectUtils.isNull(locale)) {
			fileName += Constant.SEPARATOR_UNDERLINE + locale.toString();
		}

		if (!StringDiyUtils.isEmpty(module)) {
			fileName += Constant.SEPARATOR_UNDERLINE + module.toLowerCase();
		}

		fileName = SystemPropNaming.CFG_ROOT_NAME + fileName
				+ file.substring(lastPos);

		return fileName;
	}

	/**
	 * 创建监控线程，执行监控。
	 */
	protected void startMonitor() {
		// 启动监控线程，如果有更动，一分钟之内自动重新加载
		watchdog = new ResourceWatchdog(genFilePath(file, module, locale));

		watchdog.start();
	}

	/**
	 * <p>Title: ResourceWatchdog</p>
	 * <p>Description: 实现Resource的自动监控线程。</p>
	 * @version 1.1
	 */
	class ResourceWatchdog extends FileWatchdog {
		/**
		 * 构造函数。
		 * @param url String
		 */
		ResourceWatchdog(String url) {
			super(url);
		}

		/**
		 * 状态更改时，调用的接口。
		 */
		public void doOnChange() {
			try {
				logger.info(PltMessage.RES_CFGFILE_TO_RELOAD,new Object[] { super.filename });

				reloadConfig();

				logger.info(PltMessage.RES_CFGFILE_RELOAD_SUCC,new Object[] { super.filename });
			} catch (Exception ex) {
				logger.error("Execute doOnChange except: " + ex.getMessage());
			}
		}
	}

}
