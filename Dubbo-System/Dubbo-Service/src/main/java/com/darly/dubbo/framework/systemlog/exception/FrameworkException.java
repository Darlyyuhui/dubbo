package com.darly.dubbo.framework.systemlog.exception;


import com.darly.dubbo.framework.common.ObjectUtils;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description：
///////////////////////////////////////////////////////////////////////////
 * <p>Title: FrameworkException</p>
 * <p>Description: 基本的异常类定义，业务逻辑层和业务逻辑访问层都需要继承该异常类，完成
 *                 自己的异常定义。
 * <br>
 * <br>主要提供的构造函数接口如下：
 * <br><br>
 * 1、以资源配置文件中定义的配置项作为参数，构造异常类：
 * <pre>
 *     public FrameworkException(String errorCode)
 * </pre>
 * 2、以资源配置文件中定义的配置项和一个字符串格式化参数作为参数，构造异常类：
 * <pre>
 *     public FrameworkException(String errorCode, String errorArg)
 * </pre>
 * 3、以资源配置文件中定义的配置项和格式化参数数组作为参数，构造异常类：
 * <pre>
 *     public FrameworkException(String errorCode, Object[] errorArgs)
 * </pre>
 * 4、以附加异常（一般是当时捕获的异常对象）作为参数，构造异常类：
 * <pre>
 *     public FrameworkException(Throwable root)
 * </pre>
 * 5、以资源配置文件中定义的配置项和附加异常（一般是当时捕获的异常对象）作为参数，构造异常类：
 * <pre>
 *     public FrameworkException(String errorCode, Throwable root)
 * </pre>
 * 6、以资源配置文件中定义的配置项、一个字符串格式化参数和附加异常（一般是当时捕获的异常对象）作为参数，构造异常类：
 * <pre>
 *     public FrameworkException(String errorCode, String errorArg, Throwable root)
 * </pre>
 * 7、以资源配置文件中定义的配置项、格式化参数数组和附加异常（一般是当时捕获的异常对象）作为参数，构造异常类：
 * <pre>
 *     public FrameworkException(String errorCode, Object[] errorArgs, Throwable root)
 * </pre>
 * <br>然后可以通过getMessage()方法组获取错误信息。错误描述信息的来源包括一下几个方面：
 * <pre>
 * 1、在errorcode.properties配置文件中，根据errorcode对应的配置描述信息；
 * 2、在errorcode.properties配置文件中，根据errorcode和格式化参数对应的配置描述信息；
 * 3、root异常类的异常描述信息。
 * </pre>
 * </p>
 * @version 1.1 - 扩展功能，增加了错误码标识和错误码配置管理机制。
///////////////////////////////////////////////////////////////////////////
 */
public class FrameworkException extends Exception {
	//序列化标识
	private final static long serialVersionUID = 2005091616071006L;

	private String errorCode = null;
	private Object[] errorArgs = null;

	////////////////////////////////////////////////////////////////////////////////

	/**
	 * 构造函数。以资源配置文件中定义的配置项作为参数，构造异常类。
	 * @param errorCode String     错误标识代码
	 */
	public FrameworkException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	/**
	 * 构造函数。以资源配置文件中定义的配置项和一个字符串格式化参数作为参数，构造异常类。
	 * @param errorCode String  错误标识代码
	 * @param errorArg String   可变参数
	 */
	public FrameworkException(String errorCode, String errorArg) {
		super();
		this.errorCode = errorCode;
		if (!ObjectUtils.isNull(errorArg)) {
			this.errorArgs = new Object[] { errorArg };
		}
	}

	/**
	 * 构造函数。以资源配置文件中定义的配置项和格式化参数数组作为参数，构造异常类。
	 * @param errorCode String    错误标识代码
	 * @param errorArgs Object[]  可变参数
	 */
	public FrameworkException(String errorCode, Object[] errorArgs) {
		super();
		this.errorCode = errorCode;
		this.errorArgs = errorArgs;
	}

	/**
	 * 构造函数。以附加异常（一般是当时捕获的异常对象）作为参数，构造异常类。
	 * @param root Throwable
	 */
	public FrameworkException(Throwable root) {
		super(root);
	}

	/**
	 * 构造函数。以资源配置文件中定义的配置项和附加异常（一般是当时捕获的异常对象）作为参数，构造异常类。
	 * @param errorCode String  错误标识代码
	 * @param root Throwable    异常
	 */
	public FrameworkException(String errorCode, Throwable root) {
		super(root);
		this.errorCode = errorCode;
	}

	/**
	 * 构造函数。以资源配置文件中定义的配置项、一个字符串格式化参数和附加异常（一般是当时捕获的异常对象）作为参数，构造异常类。
	 * @param errorCode String  错误标识代码
	 * @param errorArg String   可变参数
	 * @param root Throwable    异常
	 */
	public FrameworkException(String errorCode, String errorArg, Throwable root) {
		super(root);
		this.errorCode = errorCode;
		if (!ObjectUtils.isNull(errorArg)) {
			this.errorArgs = new Object[] { errorArg };
		}
	}

	/**
	 * 构造函数。以资源配置文件中定义的配置项、格式化参数数组和附加异常（一般是当时捕获的异常对象）作为参数，构造异常类。
	 * @param errorCode String    错误标识代码
	 * @param errorArgs Object[]  可变参数对象
	 * @param root Throwable      异常
	 */
	public FrameworkException(String errorCode, Object[] errorArgs,
			Throwable root) {
		super(root);
		this.errorCode = errorCode;
		this.errorArgs = errorArgs;
	}

	////////////////////////////////////////////////////////////////////////////////

	/**
	 * 设置错误码。
	 * @param errorCode String  错误标识代码
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 获取错误码。
	 * @return String            错误标识代码
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/**
	 * 设置错误参数。
	 * @param errorArgs Object[]
	 */
	public void setErrorArgs(Object[] errorArgs) {
		this.errorArgs = errorArgs;
	}

	/**
	 * 获取错误参数。
	 * @return Object[]
	 */
	public Object[] getErrorArgs() {
		return this.errorArgs;
	}

	////////////////////////////////////////////////////////////////////////////////

	/**
	 * 获取错误消息。
	 * @return String
	 */
//	public String getMessage() {
//		String errorMsg = null;
//		try {
//			if (null != this.errorCode) {
//				if (null != this.errorArgs) {
//					errorMsg = MessageResources.getErrorMessageInstance(null)
//							.getMessage(this.errorCode, this.errorArgs);
//				} else {
//					if (null != super.getCause()) {
//						errorMsg = MessageResources.getErrorMessageInstance(
//								null).getMessage(this.errorCode,
//								new Object[] { super.getMessage() });
//					} else {
//						errorMsg = MessageResources.getErrorMessageInstance(
//								null).getMessage(this.errorCode);
//					}
//				}
//
//				// 如果为空，则默认返回错误码
//				if (!StringUtils.isEmpty(errorMsg)) {
//					StringUtils.delete(errorMsg, ":null");
//				} else {
//					errorMsg = this.errorCode;
//				}
//			} else {
//				if (null != super.getCause()) {
//					errorMsg = super.getMessage();
//				} else {
//					errorMsg = "Unexpected exception happened";
//				}
//			}
//		} catch (Exception ex) {
//			errorMsg = "Invoke FrameworkException.getMessage() except: "
//					+ ex.toString();
//		}
//
//		return errorMsg;
//	}

	/**
	 * 根据不同的本地信息，获取错误消息。
	 * @param locale Locale
	 * @return String
	 */
//	public String getMessage(Locale locale) {
//		String errorMsg = null;
//
//		try {
//			if (null != this.errorCode) {
//				if (null != this.errorArgs) {
//					errorMsg = MessageResources.getErrorMessageInstance(null,
//							locale).getMessage(this.errorCode, this.errorArgs);
//				} else {
//					if (null != super.getCause()) {
//						errorMsg = MessageResources.getErrorMessageInstance(
//								null, locale).getMessage(this.errorCode,
//								new Object[] { super.getMessage() });
//					} else {
//						errorMsg = MessageResources.getErrorMessageInstance(
//								null, locale).getMessage(this.errorCode);
//					}
//				}
//
//				// 如果为空，则默认返回错误码
//				if (!StringUtils.isEmpty(errorMsg)) {
//					StringUtils.delete(errorMsg, ":null");
//				} else {
//					errorMsg = this.errorCode;
//				}
//			} else {
//				if (null != super.getCause()) {
//					errorMsg = super.getMessage();
//				} else {
//					errorMsg = "Unexpected exception happened";
//				}
//			}
//		} catch (Exception ex) {
//			errorMsg = "Invoke FrameworkException.getMessage("
//					+ locale.toString() + ") except: " + ex.toString();
//
//		}
//
//		return errorMsg;
//	}
}
