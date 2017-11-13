package com.darly.dubbo.framework.systemlog.resource;



import com.darly.dubbo.framework.common.ObjectUtils;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.systemlog.constant.Constant;
import com.darly.dubbo.framework.systemlog.constant.SystemPropNaming;
import org.apache.commons.io.FilenameUtils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

/**
 * <p>
 * Title: MessageResources
 * </p>
 * <p>
 * Description: 从配置文件里读取错误配置信息或资源配置信息。 <br>
 * <br>
 * 在配置信息里，可以设置一些参数，这些参数以两个大括号，中间以从0开始的数字表示，例如： {0}表示第一个参数，{1}表示第二个参数，依次类推。 <br>
 * <br>
 * 在调用的时候，统一调用该类提供的getMessage()方法群。 <br>
 * <br>
 * 该方法群的第二个及以后的参数表示了在配置里的参数，例如： <br>
 * <br>
 * 你的配置行里如果有两个参数，则你可以调用的方法就是：
 * 
 * <pre>
 * 　　getMessge(String, Object[])
 * </pre>
 * 
 * 或者
 * 
 * <pre>
 * 　　getMessge(String, Object, Object)
 * </pre>
 * 
 * @version 1.1
 * @since 1.1 抽象Resouces接口方式，增加对于XML文件的配置，同时保留同一接口。
 */

public class MessageResources extends Resources {
	private static HashMap messageMap = new HashMap();

	private Properties props = new Properties();

	private MessageResources(String _file, String _module, Locale _locale) {
		file = _file;
		module = _module;
		locale = _locale;

		// 读取配置文件路径定义在全局定义类里
		props = CfgFileUtil.loadCfgFile(genFilePath(_file, _module, _locale));
	}

	/**
	 * 获取每个模块的资源消息配置的唯一单例。
	 * 
	 * @param _file
	 *            String 配置文件名称，为空则取默认值：resource.properties
	 * @param _module
	 *            String 业务模块名称，为空则取空字符串
	 * @param _locale
	 *            Locale 本地信息，为空则取当前操作系统的缺省值
	 * @return MessageResources 业务模块对应的资源消息配置的唯一单例
	 */
	@SuppressWarnings("unchecked")
	public synchronized static MessageResources getMessageInstance(String _file, String _module, Locale _locale) {
		// 如果path为空，则取缺省资源消息配置文件名称
		if (StringDiyUtils.isEmpty(_file)) {
			_file = SystemPropNaming.CFG_MESSAGE_FILE_NAME;
		}

		// 如果module为空，则取空字符串""
		if (StringDiyUtils.isEmpty(_module)) {
			_module = Constant.CONST_EMPTY;
		}

		// 如果locale为空，则取当前操作系统的缺省值
		if (ObjectUtils.isNull(_locale)) {
			_locale = Locale.getDefault();
		}

		String key = FilenameUtils.getBaseName(_file) + Constant.SEPARATOR_UNDERLINE + _module + _locale.toString();

		MessageResources resource = (MessageResources) messageMap.get(key);

		if (ObjectUtils.isNull(resource)) {
			resource = new MessageResources(_file, _module, _locale);

			messageMap.put(key, resource);

			// 启动文件监控
			resource.startMonitor();
		}

		return resource;
	}

	/**
	 * 获取每个模块的资源消息配置的唯一单例，本地信息取当前操作系统的缺省值。
	 * 
	 * @param _file
	 *            String 配置文件名称，为空则取默认值：resource.properties
	 * @param _module
	 *            String 业务模块名称，为空则取空字符串
	 * @return MessageResources 业务模块对应的资源消息配置的唯一单例
	 */
	public synchronized static MessageResources getMessageInstance(String _file, String _module) {
		return getMessageInstance(_file, _module, null);
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * 获取整个框架错误码及其消息定义配置的唯一单例。
	 * 
	 * @param _file
	 *            String 配置文件名称，为空则取默认值：errorcode.properties
	 * @param _locale
	 *            Locale 本地信息，为空则取当前操作系统的缺省值
	 * @return MessageResources 框架错误码及其消息定义配置的唯一单例
	 */
	@SuppressWarnings("unchecked")
	public synchronized static MessageResources getErrorMessageInstance(String _file, Locale _locale) {
		// 如果path为空，则取缺省错误信息配置文件名称
		if (StringDiyUtils.isEmpty(_file))
			_file = SystemPropNaming.CFG_ERRORCODE_FILE_NAME;

		// 如果locale为空，则取当前操作系统的缺省值
		if (ObjectUtils.isNull(_locale))
			_locale = Locale.getDefault();

		String key = _locale.toString() + Constant.SEPARATOR_UNDERLINE + "errorcode";

		MessageResources errorCode = (MessageResources) messageMap.get(key);

		if (ObjectUtils.isNull(errorCode)) {
			errorCode = new MessageResources(_file, null, _locale);

			messageMap.put(key, errorCode);

			// 启动文件监控
			errorCode.startMonitor();
		}

		return errorCode;
	}

	/**
	 * 获取整个框架错误码及其消息定义配置的唯一单例，本地信息取当前操作系统的缺省值。
	 * 
	 * @param _file
	 *            String 配置文件名称，为空则取默认值：errorcode.properties
	 * @return MessageResources 框架错误码及其消息定义配置的唯一单例
	 */
	public synchronized static MessageResources getErrorMessageInstance(String _file) {
		return MessageResources.getErrorMessageInstance(_file, null);
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * 从对应配置文件读取配置信息，并结合参数进行转化返回。
	 * 
	 * @param key
	 *            String 配置项的名称
	 * @param args
	 *            Object[] 配置信息参数
	 * @return String 把参数值填充到配置后的配置信息
	 */
	public String getMessage(String key, Object[] args) {
		if (ObjectUtils.isNull(props))
			return Constant.CONST_EMPTY;

		// 获取配置内容，缺省为空字符串
		String msg = StringDiyUtils.escape(props.getProperty(key, Constant.CONST_EMPTY));

		// 如果配置文件里没有该项配置信息，直接返回空字符串
		if (StringDiyUtils.isEmpty(msg))
			return Constant.CONST_EMPTY;

		if (ObjectUtils.isNull(args))
			return StringDiyUtils.replace(msg, "{0}", "", true);

		MessageFormat format = new MessageFormat(msg);
		return format.format(args);
	}

	/**
	 * 重新装载配置文件。
	 */
	public void reloadConfig() {
		// 清除以前的引用，防止内存泄漏
		if (props != null) {
			props.clear();
			props = null;
		}
		// 重新加载
		props = CfgFileUtil.loadCfgFile(genFilePath(file, module, locale));
	}

	// //////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws InterruptedException {
		MessageResources msg = MessageResources.getMessageInstance("mapconfig.properties", null, Locale.CHINA);
		String s = msg.getMessage("current.version");
		System.out.println("msg is -->>" + s + "");
		System.out.println(msg.getMessage("ServerHostName"));

		MessageResources err = MessageResources.getErrorMessageInstance(null, null);
		String e = err.getMessage("COMMON-0001");
		System.out.println("err is -->>" + e + "");

		Thread.sleep(1000 * 120);
	}
}
