package com.darly.dubbo.framework.common;


import com.darly.dubbo.framework.systemlog.constant.Constant;
import com.darly.dubbo.framework.systemlog.exception.FrameworkException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * @Author: Darly Fronch（张宇辉）
 * @Description：对象判断null,和字符传判断null
 */

public class ObjectUtils {

	/**
	 * 对象为null
	 * @param obj
	 *            Object
	 * @return boolean
	 */
	public static boolean isNull(Object obj) {
		return (null == obj);
	}

	/**
	 * 判断字符串是否为null或空字符串，等同于StringUtils的isEmpty方法
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNull(String str) {
		return ((null == str) || (Constant.CONST_EMPTY.equals(str)));
	}
	
	/**
	 * 对象不为null
	 * @param obj
	 *            Object
	 * @return boolean
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	/**
	 * 判断字符串不是null也是不是空字符串，等同于StringUtils的isNotEmpty方法
	 * @param str
	 *            String
	 * @return boolean
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}
	
	/**
	 * @param props
	 *            Properties
	 * @param map
	 *            Map
	 * @throws FrameworkException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void transProperty2Map(Properties props, Map map)
			throws FrameworkException {
		if (isNull(props)) {
			throw new FrameworkException("FRM-31001");
		}

		if (isNull(map)) {
			map = new HashMap();
		}

		Enumeration coll = props.propertyNames();

		Object obj = null;
		while (coll.hasMoreElements()) {
			obj = coll.nextElement();
			map.put(obj, props.get(obj));
		}
	}
	@SuppressWarnings({ "rawtypes"})
	// 将原对象拷贝到目标对象
	public static void copyProperties(Object target, Object source)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Map map = BeanUtils.describe(target);

		Set set = map.keySet();
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			String item = (String) iter.next();
			if (PropertyUtils.isWriteable(target, item)
					&& PropertyUtils.isReadable(source, item))
				if (PropertyUtils.getProperty(source, item) != null
						&& !"".equals(PropertyUtils.getProperty(source, item))) {
					BeanUtils.copyProperty(target, item, PropertyUtils
							.getSimpleProperty(source, item));
				} else {
					PropertyDescriptor pro = PropertyUtils
							.getPropertyDescriptor(target, item);
					if (!pro.getPropertyType().isPrimitive())
						PropertyUtils.setProperty(target, item, null);
				}
		}

	}
}
