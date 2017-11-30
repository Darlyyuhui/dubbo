package com.darly.dubbo.framework.systemlog.exception;


import com.darly.dubbo.framework.common.ObjectUtils;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 系统异常类
 */
public class SystemException extends RuntimeException {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -6467805382279763493L;

	/** 错误编码 */
	private String errorCode;

	private Object[] errorArgs = null;

	public SystemException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}

	/**
	 * @param errorCode
	 *            错误编号
	 * @param params
	 *            参数数组
	 */
	public SystemException(String errorCode,Object[] errorArgs) {
		super();
		this.errorCode = errorCode;
		this.errorArgs = errorArgs;
	}

	/**
	 * 构造函数。以附加异常（一般是当时捕获的异常对象）作为参数，构造异常类。
	 * @param root Throwable
	 */
	public SystemException(Throwable root) {
		super(root);
	}

	/**
	 * 构造函数。以资源配置文件中定义的配置项和附加异常（一般是当时捕获的异常对象）作为参数，构造异常类。
	 * @param errorCode String  错误标识代码
	 * @param root Throwable    异常
	 */
	public SystemException(String errorCode, Throwable root) {
		super(root);
		this.errorCode = errorCode;
	}

	/**
	 * 构造函数。以资源配置文件中定义的配置项、一个字符串格式化参数和附加异常（一般是当时捕获的异常对象）作为参数，构造异常类。
	 * @param errorCode String  错误标识代码
	 * @param errorArg String   可变参数
	 * @param root Throwable    异常
	 */
	public SystemException(String errorCode, String errorArg, Throwable root) {
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
	public SystemException(String errorCode, Object[] errorArgs,
			Throwable root) {
		super(root);
		this.errorCode = errorCode;
		this.errorArgs = errorArgs;
	}
	
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 返回错误编码
	 * 
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

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
//			errorMsg = "Invoke SystemException.getMessage() except: "+ ex.toString();
//		}
//		return errorMsg;
//	}
	
}
