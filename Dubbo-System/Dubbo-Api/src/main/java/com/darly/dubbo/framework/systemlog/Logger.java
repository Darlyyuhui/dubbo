package com.darly.dubbo.framework.systemlog;

import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.systemlog.constant.Constant;
import com.darly.dubbo.framework.systemlog.constant.PltMessage;
import com.darly.dubbo.framework.systemlog.constant.SystemPropNaming;
import com.darly.dubbo.framework.systemlog.resource.MessageResources;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Priority;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description：
 * <p>
 * 封装了log4j,是系统支持动态修改日志级别而无须重启系统
 * </p>
 * <p>
 * Description: 本类用于向日志文件中写入日志信息，封装了Log4J，单例类使用方法，在需要 使用日志记录的类里定义一个变量： <br>
 * <pre>
 * 　　private Logger logger = new Logger(YourClass.class);
 *     ......
 * 　　// 使用的时候直接使用
 * 　　logger.debug(?);
 * 　　logger.info(?);
 *    logger.infoMessage(?,?);
 * 　　......
 * </pre>
 *
 * 对于资源文件的引用，可以通过如下接口来引用：
 *
 * <pre>
 * 　　debugMessage() ： debug级别的日志，对应resource配置文件
 * 　　infoMessage()  ： info级别的日志， 对应resource配置文件
 * 　　warnMessage()  ： warn级别的日志， 对应errorcode配置文件
 * 　　errorMessage() ： error级别的日志，对应errorcode配置文件
 * 　　fatalMessage() ： fatal级别的日志，对应errorcode配置文件
 * </pre>
 *
 * @version 1.1 - 增加了对于resource和errorcode配置文件的支持
 */

public class Logger {
	private String module = null;
	
	private Locale locale = null;

	private static final int LOG_WIDTH = 77;
	
	private static final char LOG_CHAR = '-';

	// Log4j的日志记录器
	protected org.apache.log4j.Logger apacheLogger = null;


	/**
	 * 配置Log4j，如果在Classes根目录找不到Log4j配置文件，则采用Log4j系统默认配置
	 * 由于系统中Log4j只需要配置一次，所以采用静态代码来完成这个工作。
	 */
	static {
		try {
			// 采用configureAndWatch 配置接口，提供动态更新日志配置功能
			String path = Logger.class.getClassLoader().getResource(SystemPropNaming.CFG_LOG4J_FILE_NAME).getPath();
			// replacing spaces with "%20"
			String log4jpath = StringDiyUtils.replace(path, "%20", " ");
			PropertyConfigurator.configureAndWatch(log4jpath);
			// 如果日志配置文件不存在或者因为某种原因无法读取，系统不会抛出异常，所以在这里进行主动检测
			File file = new File(log4jpath);
			if (!file.exists() || !file.canRead()) {
				System.err.println("warn...  can't find file:" + file.getName());
				System.out.println("warn...  can't find file:" + file.getName());
				new FileNotFoundException(SystemPropNaming.CFG_ROOT_NAME + SystemPropNaming.CFG_LOG4J_FILE_NAME).printStackTrace();
			}

		} // 如果读取配置文件发生异常，则采用Log4j基本的配置
		catch (Exception ex) {
			System.out.println(PltMessage.SYS_LOG4J_CFG_NOT_FOUND);
			ex.printStackTrace();
			BasicConfigurator.configure();
		}
	}


	/**
	 * 构造函数
	 * @param cls
	 *            Class 日志记录类
	 */
	public Logger(Class cls) {
		this.apacheLogger = org.apache.log4j.Logger.getLogger(cls);

		// 设置模块名称
		module = extractModule(cls.getName());

		// 设置缺省的地域
		this.locale = Locale.getDefault();
	}

	/**
	 * 构造函数，提供模块名称
	 *
	 * @param cls
	 *            Class 日志记录类
	 * @param module
	 *            String 所属模块名称
	 */
	public Logger(Class cls, String module) {
		this.apacheLogger = org.apache.log4j.Logger.getLogger(cls);

		if (module == null) {
			// 设置模块名称
			this.module = extractModule(cls.getName());
		} else {
			this.module = module;
		}

		// 设置缺省的地域
		this.locale = Locale.getDefault();
	}

	/**
	 * 构造函数，提供Local信息
	 *
	 * @param cls
	 *            Class 日志记录类
	 * @param locale
	 *            Locale 语言环境信息
	 */
	public Logger(Class cls, Locale locale) {
		this.apacheLogger = org.apache.log4j.Logger.getLogger(cls);

		// 设置模块名称
		module = extractModule(cls.getName());

		// 设置缺省的地域
		this.locale = locale;
	}

	/**
	 * 构造函数，提供Local信息和模块名称
	 *
	 * @param cls
	 *            Class 日志记录类
	 * @param locale
	 *            Locale 语言环境信息
	 * @param module
	 *            String 所属模块名称
	 */
	public Logger(Class cls, Locale locale, String module) {
		this.apacheLogger = org.apache.log4j.Logger.getLogger(cls);

		if (module == null) {
			// 设置模块名称
			this.module = extractModule(cls.getName());
		} else {
			this.module = module;
		}

		// 设置缺省的地域
		this.locale = locale;
	}


	/**
	 * 返回当前的日志记录器
	 *
	 * @return Logger
	 */
	public org.apache.log4j.Logger getLogger() {
		return this.apacheLogger;
	}


	/**
	 * 提供日志级别判断功能，是否debug级别
	 * 
	 * @return boolean
	 */
	public boolean isDebugEnabled() {
		return apacheLogger.isDebugEnabled();
	}

	/**
	 * 提供日志级别判断功能，是否info级别
	 * 
	 * @return boolean
	 */
	public boolean isInfoEnabled() {
		return apacheLogger.isInfoEnabled();
	}

	/**
	 * 提供日志级别判断功能，是否warn级别
	 * 
	 * @return boolean
	 */
	public boolean isWarnEnabled() {
		return apacheLogger.isEnabledFor(Level.WARN);
	}

	/**
	 * 提供日志级别判断功能，是否error级别
	 * 
	 * @return boolean
	 */
	public boolean isErrorEnabled() {
		return apacheLogger.isEnabledFor(Level.ERROR);
	}

	/**
	 * 提供日志级别判断功能，是否fatal级别
	 * 
	 * @return boolean
	 */
	public boolean isFatalEnabled() {
		return apacheLogger.isEnabledFor(Level.FATAL);
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * debug日志，直接记录文件
	 * 
	 * @param message
	 *            Object
	 */
	public void debug(Object message) {
		apacheLogger.debug(message);
	}

	/**
	 * debug日志，直接记录文件
	 * 
	 * @param message
	 *            Object
	 * @param param
	 *            String
	 */
	public void debug(String message, String param) {
		if (apacheLogger.isDebugEnabled()) {
			MessageFormat mf = new MessageFormat((String) message);
			apacheLogger.debug(mf.format(new Object[] { param }));
		}
	}

	/**
	 * debug日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param param
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void debug(String message, Object param, Throwable t) {
		if (apacheLogger.isDebugEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.debug(mf.format(new Object[] { param }), t);
		}
	}

	/**
	 * debug日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void debug(String message, Object[] params) {
		if (apacheLogger.isDebugEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.debug(mf.format(params));
		}
	}

	/**
	 * debug日志，直接记录文件
	 * 
	 * @param message
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void debug(Object message, Throwable t) {
		apacheLogger.debug(message, t);
	}

	/**
	 * debug日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void debug(String message, Object[] params, Throwable t) {
		if (apacheLogger.isDebugEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.debug(mf.format(params), t);
		}
	}

	/**
	 * debugMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 */
	public void debugMessage(String key) {
		debugMessage(key, null);
	}

	/**
	 * debugMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 */
	public void debugMessage(String key, Object param1) {
		if (apacheLogger.isDebugEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			debugMessage(key, params);
		}
	}

	/**
	 * debugMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 */
	public void debugMessage(String key, Object param1, Object param2) {
		if (apacheLogger.isDebugEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			debugMessage(key, params);
		}
	}

	/**
	 * debugMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void debugMessage(String key, Object[] params) {
		if (apacheLogger.isDebugEnabled()) {
			apacheLogger.debug(getResource(this.module, this.locale, Level.DEBUG).getMessage(key, params));
		}
	}

	/**
	 * debugMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void debugMessage(String key, Object param1, Throwable t) {
		if (apacheLogger.isDebugEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			debugMessage(key, params, t);
		}
	}

	/**
	 * debugMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void debugMessage(String key, Object param1, Object param2, Throwable t) {
		if (apacheLogger.isDebugEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			debugMessage(key, params, t);
		}
	}

	/**
	 * debugMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void debugMessage(String key, Object[] params, Throwable t) {
		if (apacheLogger.isDebugEnabled()) {
			apacheLogger.debug(getResource(this.module, this.locale, Level.DEBUG).getMessage(key, params), t);
		}
	}

	/**
	 * 打印横线
	 * 
	 * @param _char
	 *            char
	 */
	public void debugLine(char _char) {
		if (apacheLogger.isDebugEnabled()) {
			apacheLogger.debug(StringDiyUtils.stringOfChar(_char, LOG_WIDTH));
		}
	}

	/**
	 * 打印横线
	 */
	public void debugLine() {
		if (apacheLogger.isDebugEnabled()) {
			debugLine(LOG_CHAR);
		}
	}

	/**
	 * 打印标题
	 * 
	 * @param _title
	 *            String
	 * @param _char
	 *            char
	 */
	public void debugTitle(String _title, char _char) {
		if (apacheLogger.isDebugEnabled()) {
			apacheLogger.debug(formatTitle(_title, _char));
		}
	}

	/**
	 * 打印标题
	 * 
	 * @param _title
	 *            String
	 */
	public void debugTitle(String _title) {
		debugTitle(_title, LOG_CHAR);
	}


	/**
	 * info日志，直接记录日志文件
	 * 
	 * @param message
	 *            Object
	 */
	public void info(Object message) {
		apacheLogger.info(message);
	}

	/**
	 * info日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param param
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void info(String message, Object param, Throwable t) {
		if (apacheLogger.isInfoEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.info(mf.format(new Object[] { param }), t);
		}
	}

	/**
	 * info日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void info(String message, Object[] params) {
		if (apacheLogger.isInfoEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.info(mf.format(params));
		}
	}

	/**
	 * info日志，直接记录文件
	 * 
	 * @param message
	 *            Object
	 * @param param
	 *            String
	 */
	public void info(String message, String param) {
		if (apacheLogger.isInfoEnabled()) {
			MessageFormat mf = new MessageFormat((String) message);
			apacheLogger.info(mf.format(new Object[] { param }));
		}
	}

	/**
	 * info日志，直接记录日志文件
	 * 
	 * @param message
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void info(Object message, Throwable t) {
		apacheLogger.info(message, t);
	}

	/**
	 * info日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void info(String message, Object[] params, Throwable t) {
		if (apacheLogger.isInfoEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.info(mf.format(params), t);
		}
	}

	/**
	 * infoMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 */
	public void infoMessage(String key) {
		infoMessage(key, null);
	}

	/**
	 * infoMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 */
	public void infoMessage(String key, Object param1) {
		if (apacheLogger.isInfoEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			infoMessage(key, params);
		}
	}

	/**
	 * infoMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 */
	public void infoMessage(String key, Object param1, Object param2) {
		if (apacheLogger.isInfoEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			infoMessage((String) key, params);
		}
	}

	/**
	 * infoMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void infoMessage(String key, Object[] params) {
		if (apacheLogger.isInfoEnabled()) {
			apacheLogger.info(getResource(this.module, this.locale, Level.INFO).getMessage(key, params));
		}
	}

	/**
	 * infoMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void infoMessage(String key, Object param1, Throwable t) {
		if (apacheLogger.isInfoEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			infoMessage(key, params, t);
		}
	}

	/**
	 * infoMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void infoMessage(String key, Object param1, Object param2, Throwable t) {
		if (apacheLogger.isInfoEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			infoMessage((String) key, params, t);
		}
	}

	/**
	 * infoMessage操作，和resource配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void infoMessage(String key, Object[] params, Throwable t) {
		if (apacheLogger.isInfoEnabled()) {
			apacheLogger.info(getResource(this.module, this.locale, Level.INFO).getMessage(key, params), t);
		}
	}

	/**
	 * 打印横线
	 * 
	 * @param _char
	 *            char
	 */
	public void infoLine(char _char) {
		if (apacheLogger.isInfoEnabled()) {
			apacheLogger.info(StringDiyUtils.stringOfChar(_char, LOG_WIDTH));
		}
	}

	/**
	 * 打印横线
	 */
	public void infoLine() {
		if (apacheLogger.isInfoEnabled()) {
			infoLine(LOG_CHAR);
		}
	}

	/**
	 * 打印标题
	 * 
	 * @param _title
	 *            String
	 * @param _char
	 *            char
	 */
	public void infoTitle(String _title, char _char) {
		if (apacheLogger.isInfoEnabled()) {
			apacheLogger.info(formatTitle(_title, _char));
		}
	}

	/**
	 * 打印标题
	 * 
	 * @param _title
	 *            String
	 */
	public void infoTitle(String _title) {
		infoTitle(_title, LOG_CHAR);
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * warn日志，直接记录日志文件
	 * 
	 * @param message
	 *            Object
	 */
	public void warn(Object message) {
		apacheLogger.warn(message);
	}

	/**
	 * warn日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param param
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void warn(String message, Object param, Throwable t) {
		if (this.isWarnEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.warn(mf.format(new Object[] { param }), t);
		}
	}

	/**
	 * warn日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void warn(String message, Object[] params) {
		if (this.isWarnEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.warn(mf.format(params));
		}
	}

	/**
	 * warn日志，直接记录文件
	 * 
	 * @param message
	 *            Object
	 * @param param
	 *            String
	 */
	public void warn(String message, String param) {
		if (this.isWarnEnabled()) {
			MessageFormat mf = new MessageFormat((String) message);
			apacheLogger.warn(mf.format(new Object[] { param }));
		}
	}

	/**
	 * warn日志，直接记录日志文件
	 * 
	 * @param message
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void warn(Object message, Throwable t) {
		apacheLogger.warn(message, t);
	}

	/**
	 * warn日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void warn(String message, Object[] params, Throwable t) {
		if (this.isWarnEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.warn(mf.format(params), t);
		}
	}

	/**
	 * warnMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 */
	public void warnMessage(String key) {
		warnMessage(key, null);
	}

	/**
	 * warnMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 */
	public void warnMessage(String key, Object param1) {
		if (this.isWarnEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			warnMessage(key, params);
		}
	}

	/**
	 * warnMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 */
	public void warnMessage(String key, Object param1, Object param2) {
		if (this.isWarnEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			warnMessage(key, params);
		}
	}

	/**
	 * warnMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void warnMessage(String key, Object[] params) {
		if (this.isWarnEnabled()) {
			apacheLogger.warn(getResource(this.module, this.locale, Level.WARN).getMessage(key, params));
		}
	}

	/**
	 * warnMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void warnMessage(String key, Object param1, Throwable t) {
		if (this.isWarnEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			warnMessage(key, params, t);
		}
	}

	/**
	 * warnMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void warnMessage(String key, Object param1, Object param2, Throwable t) {
		if (this.isWarnEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			warnMessage(key, params, t);
		}
	}

	/**
	 * warnMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void warnMessage(String key, Object[] params, Throwable t) {
		if (this.isWarnEnabled()) {
			apacheLogger.warn(getResource(this.module, this.locale, Level.WARN).getMessage(key, params), t);
		}
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * error日志，直接记录日志文件
	 * 
	 * @param message
	 *            Object
	 */
	public void error(Object message) {
		if (this.isErrorEnabled()) {
			if (message instanceof Throwable) {
				Throwable ex = (Throwable) message;
				this.error(ex.getMessage(), ex);
			} else {
				apacheLogger.error(message);
			}
		}
	}

	/**
	 * error日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param param
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void error(String message, Object param, Throwable t) {
		if (this.isErrorEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.error(mf.format(new Object[] { param }), t);
		}
	}

	/**
	 * error日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void error(String message, Object[] params) {
		if (this.isErrorEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.error(mf.format(params));
		}
	}

	/**
	 * error日志，直接记录文件
	 * 
	 * @param message
	 *            Object
	 * @param param
	 *            String
	 */
	public void error(String message, String param) {
		if (this.isErrorEnabled()) {
			MessageFormat mf = new MessageFormat((String) message);
			apacheLogger.error(mf.format(new Object[] { param }));
		}
	}

	/**
	 * error日志，直接记录日志文件
	 * 
	 * @param message
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void error(Object message, Throwable t) {
		apacheLogger.error(message, t);
	}

	/**
	 * error日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void error(String message, Object[] params, Throwable t) {
		if (this.isErrorEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.error(mf.format(params), t);
		}
	}

	/**
	 * errorMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 */
	public void errorMessage(String key) {
		errorMessage(key, null);
	}

	/**
	 * errorMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 */
	public void errorMessage(String key, Object param1) {
		if (this.isErrorEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			errorMessage(key, params);
		}
	}

	/**
	 * errorMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 */
	public void errorMessage(String key, Object param1, Object param2) {
		if (this.isErrorEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			errorMessage(key, params);
		}
	}

	/**
	 * errorMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void errorMessage(String key, Object[] params) {
		if (this.isErrorEnabled()) {
			apacheLogger.error(getResource(this.module, this.locale, Level.ERROR).getMessage(key, params));
		}
	}

	/**
	 * errorMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void errorMessage(String key, Object param1, Throwable t) {
		if (this.isErrorEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			errorMessage(key, params, t);
		}
	}

	/**
	 * errorMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void errorMessage(String key, Object param1, Object param2, Throwable t) {
		if (this.isErrorEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			errorMessage(key, params, t);
		}
	}

	/**
	 * errorMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void errorMessage(String key, Object[] params, Throwable t) {
		if (this.isErrorEnabled()) {
			apacheLogger.error(getResource(this.module, this.locale, Level.ERROR).getMessage(key, params), t);
		}
	}

	/**
	 * @Author: Darly Fronch（张宇辉）
	 * @Description： 輸出JSON
	 */
//	public void json(String json) {
//		String message;
//		try {
//			if (json.startsWith("{")) {
//				JSONObject jsonObject = JSONObject.fromObject(json);
//				message = jsonObject.toString(4);
//			} else if (json.startsWith("[")) {
//				JSONArray jsonArray = JSONArray.fromObject(json);
//				message = jsonArray.toString(4);
//			} else {
//				message = json;
//			}
//		} catch (JSONException e) {
//			message = json;
//		}
//		message = "\n" + message;
//		String[] lines = message.split("\n");
//		for (String line : lines) {
//			apacheLogger.debug( "║ " + line);
//		}
//	}
	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * fatal日志，直接记录日志文件
	 * 
	 * @param message
	 *            Object
	 */
	public void fatal(Object message) {
		apacheLogger.fatal(message);
	}

	/**
	 * fatal日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param param
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void fatal(String message, Object param, Throwable t) {
		if (this.isFatalEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.fatal(mf.format(new Object[] { param }), t);
		}
	}

	/**
	 * fatal日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void fatal(String message, Object[] params) {
		if (this.isFatalEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.fatal(mf.format(params));
		}
	}

	/**
	 * fatal日志，直接记录文件
	 * 
	 * @param message
	 *            Object
	 * @param param
	 *            Object
	 */
	public void fatal(String message, Object param) {
		if (this.isFatalEnabled()) {
			MessageFormat mf = new MessageFormat((String) message);
			apacheLogger.fatal(mf.format(new Object[] { param }));
		}
	}

	/**
	 * fatal日志，直接记录日志文件
	 * 
	 * @param message
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void fatal(Object message, Throwable t) {
		apacheLogger.fatal(message, t);
	}

	/**
	 * fatal日志，直接记录文件
	 * 
	 * @param message
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void fatal(String message, Object[] params, Throwable t) {
		if (this.isFatalEnabled()) {
			MessageFormat mf = new MessageFormat(message);
			apacheLogger.fatal(mf.format(params), t);
		}
	}

	/**
	 * fatalMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 */
	public void fatalMessage(String key) {
		fatalMessage(key, null);
	}

	/**
	 * fatalMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 */
	public void fatalMessage(String key, Object param1) {
		if (this.isFatalEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			fatalMessage(key, params);
		}
	}

	/**
	 * fatalMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 */
	public void fatalMessage(String key, Object param1, Object param2) {
		if (this.isFatalEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			fatalMessage(key, params);
		}
	}

	/**
	 * fatalMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 */
	public void fatalMessage(String key, Object[] params) {
		if (this.isFatalEnabled()) {
			apacheLogger.fatal(getResource(this.module, this.locale, Level.FATAL).getMessage(key, params));
		}
	}

	/**
	 * fatalMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void fatalMessage(String key, Object param1, Throwable t) {
		if (this.isFatalEnabled()) {
			Object[] params = new Object[1];
			params[0] = param1;
			fatalMessage(key, params, t);
		}
	}

	/**
	 * fatalMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param param1
	 *            Object
	 * @param param2
	 *            Object
	 * @param t
	 *            Throwable
	 */
	public void fatalMessage(String key, Object param1, Object param2, Throwable t) {
		if (this.isFatalEnabled()) {
			Object[] params = new Object[2];
			params[0] = param1;
			params[1] = param2;
			fatalMessage(key, params, t);
		}
	}

	/**
	 * fatalMessage操作，和errorcode配置文件绑定，可以支持参数替换
	 * 
	 * @param key
	 *            String
	 * @param params
	 *            Object[]
	 * @param t
	 *            Throwable
	 */
	public void fatalMessage(String key, Object[] params, Throwable t) {
		if (this.isFatalEnabled()) {
			apacheLogger.fatal(getResource(this.module, this.locale, Level.FATAL).getMessage(key, params), t);
		}
	}

	// //////////////////////////////////////////////////////////////////////////////

	public String formatTitle(String _title, char _char) {
		_title = " " + _title + " ";
		int l = (LOG_WIDTH - _title.length()) / 2;
		return StringDiyUtils.stringOfChar(_char, l) + _title + StringDiyUtils.stringOfChar(_char, LOG_WIDTH - l - _title.length());
	}

	public String formatTitle(String _title) {
		return formatTitle(_title, LOG_CHAR);
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * 根据传入对象的类路径名称获得当前的业务模块标识
	 * 
	 * @param className
	 *            String
	 * @return String
	 */
	private String extractModule(String className) {
		int pos = className.indexOf(Constant.PREFIX_PACKAGE_NAME);
		String tmpName = null;

		if (pos >= 0) {
			tmpName = className.substring(pos + Constant.PREFIX_PACKAGE_NAME.length() + 1);
			tmpName = tmpName.substring(0, tmpName.indexOf(Constant.SEPARATOR_DOT));
		}
		// 如果不是缺省的包路径前缀，则自动截取第四级包名称
		else {
			pos = className.indexOf(Constant.SEPARATOR_DOT);
			tmpName = className.substring(pos + 1);
			int count = 0;
			while (pos > 0 && count++ < 3) {
				tmpName = tmpName.substring(pos + 1);
				pos = tmpName.indexOf(Constant.SEPARATOR_DOT);
			}
			tmpName = tmpName.substring(0, tmpName.indexOf(Constant.SEPARATOR_DOT));
		}

		// 如果获取的模块为，则采用缺省模块
		return (tmpName == null) ? Constant.MODULE_COMMON : tmpName;
	}

	/**
	 * 返回错误配置信息资源。
	 */
	private MessageResources getResource(String module, Locale locale, Priority level) {
		// 如果级别大于警告，则返回错误配置信息
		if (level.toInt() >= Level.WARN.toInt()) {
			return MessageResources.getErrorMessageInstance(null);
		} else {
			return MessageResources.getMessageInstance(null, module, locale);
		}
	}
}
