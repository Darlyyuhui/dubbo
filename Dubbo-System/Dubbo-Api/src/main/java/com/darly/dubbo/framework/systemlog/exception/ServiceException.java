package com.darly.dubbo.framework.systemlog.exception;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description：
///////////////////////////////////////////////////////////////////////////
 * Service层公用的Exception.
		 *
		 * 继承自FrameworkException, 从由Spring管理事务的函数中抛出时会触发事务回滚.
		 *
		 * @author
///////////////////////////////////////////////////////////////////////////
 */
public class ServiceException extends FrameworkException {

	private static final long serialVersionUID = 1401593546385403720L;


	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
