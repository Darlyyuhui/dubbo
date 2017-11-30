package com.darly.dubbo.framework.common;

import java.util.Calendar;
import java.util.UUID;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description：生成数据库主键,大数据量表 采用getUUIDLong方法 普通表采用 getUUID方法
 */

public class UuidGenerateUtil
{

	
	/**
	 * 产生一个全局唯一的序列标  20位（适用于一般用户界面操作插入的主键生成）
	 * 
	 * @return 年（2位）＋月（2位）＋日（2痊）＋时（2位）＋分（2位）＋秒（2位）＋毫秒（3位）＋UUID（随机5位）
	 */
	public static synchronized String getUUID()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calendar.getTime());

		StringBuffer u1 = new StringBuffer(formatNumber(calendar.get(Calendar.YEAR), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.MONTH) + 1, 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.DAY_OF_MONTH), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.HOUR_OF_DAY), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.MINUTE), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.SECOND), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.MILLISECOND), 3, '0'));

		String u2 = UUID.randomUUID().toString();
		u2 = u2.replaceAll("-", "");
		return u1.toString() + u2.substring(27);
	}

	/**
	 * 产生一个全局唯一的序列标  32位（适用于数据量密集插入的主键生成，非人工产生数据都用这个方法）
	 * 
	 * @return 年（2位）＋月（2位）＋日（2痊）＋时（2位）＋分（2位）＋秒（2位）＋毫秒（3位）＋UUID（随机15位）
	 */
	public static synchronized String getUUIDLong()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calendar.getTime());

		StringBuffer u1 = new StringBuffer(formatNumber(calendar.get(Calendar.YEAR), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.MONTH) + 1, 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.DAY_OF_MONTH), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.HOUR_OF_DAY), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.MINUTE), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.SECOND), 2, '0'));
		u1.append(formatNumber(calendar.get(Calendar.MILLISECOND), 3, '0'));

		String u2 = UUID.randomUUID().toString();
		u2 = u2.replaceAll("-", "");
		return u1.toString() + u2.substring(15);
	}
	
	
	
	
	public static synchronized String formatNumber(int number, int destLength, char paddedChar)
	{
		String oldString = String.valueOf(number);
		StringBuffer newString = new StringBuffer("");
		int oldLength = oldString.length();
		if (oldLength > destLength)
		{
			newString.append(oldString.substring(oldLength - destLength));
		}
		else if (oldLength == destLength)
		{
			newString.append(oldString);
		}
		else
		{
			for (int i = 0; i < destLength - oldLength; i++)
			{
				newString.append(paddedChar);
			}
			newString.append(oldString);
		}
		return newString.toString();
	}
	
	

}

