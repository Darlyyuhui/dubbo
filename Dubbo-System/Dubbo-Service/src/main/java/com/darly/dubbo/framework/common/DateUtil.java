package com.darly.dubbo.framework.common;




import com.darly.dubbo.framework.systemlog.constant.FORMAT;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 日期 时间 工具类
 */
public class DateUtil {
	
	static final String COMMON_CHAR = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// 得到当前日期的字符串
	public static String getCurrentDateStr(String formatStr) {
		Date d = new Date();
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		String curDate = format.format(d);
		return curDate;
	}

	// date 依据传入的 formatStr 转型 String
	public static String dateFormatToString(Date date, String formatStr) {
		String str = "";
		//lhh修改，date为空时返回""字符串
		if(ObjectUtils.isNull(date)){
			return str;
		}
		Format mat = new SimpleDateFormat(formatStr);
		str = mat.format(date);
		return str;
	}

	// date 依据传入的 formatStr 转型 Long
	public static Long dateFormatToLong(Date date, String formatStr) {
		String str = "";
		if(ObjectUtils.isNull(date)){
			return 0l;
		}
		Format mat = new SimpleDateFormat(formatStr);
		str = mat.format(date);
		return Long.valueOf(str);
	}

	// String 依据传入的 formatStr date
	public static Date stringFormatToDate(String dateStr, String formatStr) {
		SimpleDateFormat dateformat = new SimpleDateFormat(formatStr);
		Date date = null;
		try {
			date = dateformat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	// 给 date 时间增加或减去（减去传入负数） offset 年
	public static Date AddYear(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, offset);
		return calendar.getTime();
	}

	// 给 date 时间增加或减去（减去传入负数） offset 月
	public static Date AddMonth(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, offset);
		return calendar.getTime();
	}

	// 给 date 时间增加或减去（减去传入负数） offset 日
	public static Date AddDay(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, offset);
		return calendar.getTime();
	}

	// 给 date 时间增加或减去（减去传入负数） offset 秒
	public static Date AddSecond(Date date, int offset) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, offset);
		return calendar.getTime();
	}

	// 对于此 Calendar 的时间值而言，给定日历字段的最大值
	public static int DayofMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getActualMaximum(Calendar.DATE);
	}

	public static long getTimeHourLong() {
		Calendar ca = Calendar.getInstance();
		return getTimeHourLong(ca);
	}

	public static long getTimeMinuteLong() {
		Calendar ca = Calendar.getInstance();
		return getTimeMinuteLong(ca);
	}

	public static long getTimeSecondLong() {
		Calendar ca = Calendar.getInstance();
		return getTimeSecondLong(ca);
	}

	public static long getTimeMsLong() {
		Calendar ca = Calendar.getInstance();
		return getTimeMsLong(ca);
	}

	public static int getTimeDayInt() {
		int n = 0;
		Calendar ca = Calendar.getInstance();
		n = ca.get(Calendar.YEAR);
		n = n * 100;
		n = n + ca.get(Calendar.MONTH) + 1;
		n = n * 100;
		n = n + ca.get(Calendar.DAY_OF_MONTH);
		return n;
	}

	public static int getTimeMonthInt() {
		int n = 0;
		Calendar ca = Calendar.getInstance();
		n = ca.get(Calendar.YEAR);
		n = n * 100;
		n = n + ca.get(Calendar.MONTH) + 1;
		return n;
	}

	public static long getTimeHourLong(Calendar ca) {
		long n = 0;
		n = ca.get(Calendar.YEAR);
		n = n * 100;
		n = n + ca.get(Calendar.MONTH) + 1;
		n = n * 100;
		n = n + ca.get(Calendar.DAY_OF_MONTH);
		n = n * 100;
		n = n + ca.get(Calendar.HOUR_OF_DAY);
		return n;
	}

	public static long getTimeMinuteLong(Calendar ca) {
		long n = 0;
		n = ca.get(Calendar.YEAR);
		n = n * 100;
		n = n + ca.get(Calendar.MONTH) + 1;
		n = n * 100;
		n = n + ca.get(Calendar.DAY_OF_MONTH);
		n = n * 100;
		n = n + ca.get(Calendar.HOUR_OF_DAY);
		n = n * 100;
		n = n + ca.get(Calendar.MINUTE);
		return n;
	}

	public static long getTimeSecondLong(Calendar ca) {
		long n = 0;
		n = ca.get(Calendar.YEAR);
		n = n * 100;
		n = n + ca.get(Calendar.MONTH) + 1;
		n = n * 100;
		n = n + ca.get(Calendar.DAY_OF_MONTH);
		n = n * 100;
		n = n + ca.get(Calendar.HOUR_OF_DAY);
		n = n * 100;
		n = n + ca.get(Calendar.MINUTE);
		n = n * 100;
		n = n + ca.get(Calendar.SECOND);
		return n;
	}

	public static long getTimeMsLong(Calendar ca) {
		long n = 0;
		n = ca.get(Calendar.YEAR);
		n = n * 100;
		n = n + ca.get(Calendar.MONTH) + 1;
		n = n * 100;
		n = n + ca.get(Calendar.DAY_OF_MONTH);
		n = n * 100;
		n = n + ca.get(Calendar.HOUR_OF_DAY);
		n = n * 100;
		n = n + ca.get(Calendar.MINUTE);
		n = n * 1000;
		n = n + ca.get(Calendar.MILLISECOND);
		return n;
	}

	public static int getTimeMonthInt(Calendar ca) {
		int n = 0;
		n = ca.get(Calendar.YEAR);
		n = n * 100;
		n = n + ca.get(Calendar.MONTH) + 1;
		return n;
	}

	public static int getHourInt() {
		Calendar ca = Calendar.getInstance();
		int n = ca.get(Calendar.HOUR_OF_DAY);
		return n;
	}

	// 得到当前时间的上一个月的日期
	public static String getLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);    // 得到前一个月
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;

		String yearStr = String.valueOf(year);

		String monthStr = "";

		if (month < 10) {
			monthStr = "0" + month;
		}

		String temp = "" + yearStr + monthStr;
		temp = temp.substring(2);

		return temp;
	}

	public static Date formatToDate(String dateYYYY, String dateMM, String datedd) {
		StringBuffer dateStr = new StringBuffer();
		dateStr.append(dateYYYY);
		dateStr.append(dateMM);
		dateStr.append(datedd);
		Date date = DateUtil.stringFormatToDate(dateStr.toString(), "yyyyMMdd");
		return date;
	}

	/**
	 *
	 * @param nowDate
	 *            当前日期
	 * @param choseDate
	 *            前台页面选择的日期
	 * @return 上个月的日期
	 */
	public static String isMonth(String choseDate) {
		String year = choseDate.substring(0, 4); // 年
		String month = choseDate.substring(5, 7); // 月
		String day = choseDate.substring(8, 10); // 日
		StringBuffer sb = new StringBuffer();
		int iYear = 0;
		int iMonth = 0;
		int iDay = 0;
		if ("01".equals(month)) {
			iYear = Integer.parseInt(year) - 1;
			iMonth = 12;
			iDay = Integer.parseInt(day);
		}
		if ("03".equals(month)) {
			iYear = Integer.parseInt(year);
			iMonth = Integer.parseInt(month) - 1;
			if ("29".equals(day) || "30".equals(day) || "31".equals(day)) {
				if ((iYear % 4 == 0 && iYear % 100 != 0) || iYear % 400 == 0) {
					iDay = 29;
				}
				else {
					iDay = 28;
				}

			}
			else {
				iDay = Integer.parseInt(day);
			}
		}
		if ("05".equals(month) || "07".equals(month) || "10".equals(month) || "12".equals(month)) {
			iYear = Integer.parseInt(year);
			iMonth = Integer.parseInt(month) - 1;
			if ("31".equals(day)) {
				iDay = 30;
			}
			else {
				iDay = Integer.parseInt(day);
			}
		}
		if ("02".equals(month) || "04".equals(month) || "06".equals(month) || "08".equals(month) || "09".equals(month) || "11".equals(month)) {
			iYear = Integer.parseInt(year);
			iMonth = Integer.parseInt(month) - 1;
			iDay = Integer.parseInt(day);
		}
		if (iMonth < 10) {
			sb.append(String.valueOf(iYear)).append("-").append("0").append(String.valueOf(iMonth));
		}
		else {
			sb.append(String.valueOf(iYear)).append("-").append(String.valueOf(iMonth));
		}
		if (iDay < 10) {
			sb.append("-").append("0").append(String.valueOf(iDay));
		}
		else {
			sb.append("-").append(String.valueOf(iDay));
		}
		return sb.toString();
	}

	/**
	 * 输入某一天判断这几天属于星期几
	 *
	 * @param sDate
	 * @return
	 */
	public static String getWeekStartEnd(String sDate) {
		Date date = stringFormatToDate(sDate, "yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance(Locale.CHINA);
		calendar.setTime(date);
		int wd = calendar.get(Calendar.DAY_OF_WEEK);
		String x = "";
		switch (wd) {
		case 1:
			x = "日";
			break;
		case 2:
			x = "一";
			break;
		case 3:
			x = "二";
			break;
		case 4:
			x = "三";
			break;
		case 5:
			x = "四";
			break;
		case 6:
			x = "五";
			break;
		case 7:
			x = "六";
			break;
		}

		return x;
	}

	// 根据某一天得到上一周的某一天
	public static String getLastWeekByDay(String localDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(stringFormatToDate(localDay, "yyyy-MM-dd"));
		int day = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, day - 7);
		return dateFormatToString(cal.getTime(), "yyyy-MM-dd");

	}

	// 根据某一天得到上一天
	public static String getLastDayByDay(String localDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(stringFormatToDate(localDay, "yyyy-MM-dd"));
		int day = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, day - 1);
		return dateFormatToString(cal.getTime(), "yyyy-MM-dd");
	}

	// 根据某一天得到下一天
	public static String getTomorrowByDay(String localDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(stringFormatToDate(localDay, "yyyy-MM-dd"));
		int day = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, day + 1);
		return dateFormatToString(cal.getTime(), "yyyy-MM-dd");
	}

	// 根据某一个月得到上个月
	public static String getLastMonthByMonth(String localMonth) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(stringFormatToDate(localMonth, "yyyy-MM"));
		int day = cal.get(Calendar.MONTH);
		cal.set(Calendar.MONTH, day - 1);
		return dateFormatToString(cal.getTime(), "yyyy-MM");
	}

	// 根据某一天得到这个月的第一天
	public static String getMonthFirstDay(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(stringFormatToDate(date, "yyyy-MM-dd"));
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return dateFormatToString(cal.getTime(), "yyyy-MM-dd");
	}

	// 根据某一天得到这个月的最后一天
	public static String getMonthLastDay(String date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(stringFormatToDate(date, "yyyy-MM-dd"));
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return dateFormatToString(cal.getTime(), "yyyy-MM-dd");
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * 获得当前日期时间。
	 *
	 * @return Date - 返回java.util.Date类型的当前日期
	 */
	public static Date now() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 获得当前日期时间。
	 *
	 * @return Date - 返回java.util.Date类型的当前日期
	 */
	public static Date currentUtilDate() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 获得当前日期时间。
	 *
	 * @return Date - 返回java.sql.Date类型的当前日期
	 */
	public static java.sql.Date currentSqlDate() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * 根据传入的格式格式化传入的日期时间。
	 *
	 * @param pattern
	 *            String - 格式，请参见SimpleDateFormat的帮助部分
	 * @param dateTime
	 *            Date - 要格式化的日期时间
	 * @return String - 格式后的日期时间字符串
	 */
	public static String formatDateTime(String pattern, Date dateTime) {
		if (ObjectUtils.isNull(pattern)) {
			pattern = FORMAT.DATETIME.DEFAULT;
		}

		return new SimpleDateFormat(pattern).format(dateTime);
	}

	/**
	 * 根据传入的格式格式化传入的日期。
	 *
	 * @param pattern
	 *            String - 格式，请参见SimpleDateFormat的帮助部分
	 * @param date
	 *            Date - 要格式化的日期
	 * @return String - 格式后的日期字符串
	 */
	public static String formatDate(String pattern, Date date) {
		if (ObjectUtils.isNull(pattern)) {
			pattern = FORMAT.DATE.DEFAULT;
		}

		return new SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 根据传入的格式格式化传入的时间。
	 *
	 * @param pattern
	 *            String - 格式，请参见SimpleDateFormat的帮助部分
	 * @param time
	 *            Date - 要格式化的时间
	 * @return String - 格式后的时间字符串
	 */
	public static String formatTime(String pattern, Date time) {
		if (ObjectUtils.isNull(pattern)) {
			pattern = FORMAT.TIME.DEFAULT;
		}

		return new SimpleDateFormat(pattern).format(time);
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * 格式化成起始日期。
	 *
	 * @param startDate
	 *            Date - 要格式化的起始日期
	 * @return Date - 格式化后的起始日期
	 * @throws ParseException
	 */
	public static Date formatStartDate(Date startDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT.DATETIME.LONG);
		String s = sdf.format(startDate);
		s = s.substring(0, 10) + " 00:00:00:000";
		return sdf.parse(s);
	}

	/**
	 * 格式化成结束日期。
	 *
	 * @param endDate
	 *            Date - 要格式化的结束日期
	 * @return Date - 格式化后的结束日期
	 * @throws ParseException
	 */
	public static Date formatEndDate(Date endDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT.DATETIME.LONG);
		String s = sdf.format(endDate);
		s = s.substring(0, 10) + " 23:59:59:999";
		return sdf.parse(s);
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * 按照ISO的格式（yyyy-MM-dd HH:mm:ss[:SSS]）格式化传入的日期时间。
	 *
	 * @param dateTime
	 *            Date - 要格式化的日期时间
	 * @param needMillisecond
	 *            boolean - 是否需要毫秒
	 * @return String - 格式后的日期时间字符串
	 */
	public static String isoDateTime(Date dateTime, boolean needMillisecond) {
		if (needMillisecond) {
			return formatDateTime(FORMAT.DATE.LONG + " " + FORMAT.TIME.LONG, dateTime);
		}
		else {
			return formatDateTime(FORMAT.DATE.LONG + " " + FORMAT.TIME.SHORT, dateTime);
		}
	}

	/**
	 * 按照ISO的格式（yyyy-MM-dd HH:mm:ss:SSS）格式化传入的日期时间。
	 *
	 * @param dateTime
	 *            Date - 要格式化的日期时间
	 * @return String - 格式后的日期时间字符串
	 */
	public static String isoDateTime(Date dateTime) {
		return isoDateTime(dateTime, true);
	}

	/**
	 * 按照ISO的格式（yyyy-MM-dd）格式化传入的日期。
	 *
	 * @param date
	 *            Date - 要格式化的日期
	 * @return String - 格式后的日期字符串
	 */
	public static String isoDate(Date date) {
		return formatDateTime(FORMAT.DATE.LONG, date);
	}

	/**
	 * 按照ISO的格式（HH:mm:ss[:SSS]）格式化传入的时间。
	 *
	 * @param time
	 *            Date - 要格式化的时间
	 * @param needMillisecond
	 *            boolean - 是否需要毫秒
	 * @return String - 格式后的时间字符串
	 */
	public static String isoTime(Date time, boolean needMillisecond) {
		if (needMillisecond) {
			return formatDateTime(FORMAT.TIME.LONG, time);
		}
		else {
			return formatDateTime(FORMAT.TIME.SHORT, time);
		}
	}

	/**
	 * 按照ISO的格式（HH:mm:ss:SSS）格式化传入的时间。
	 *
	 * @param time
	 *            Date - 要格式化的时间
	 * @return String - 格式后的时间字符串
	 */
	public static String isoTime(Date time) {
		return isoTime(time, true);
	}

	/**
	 * 返回ISO格式（yyyy-MM-dd HH:mm:ss[:SSS]）的当前日期时间。
	 *
	 * @param needMillisecond
	 *            boolean - 是否需要毫秒
	 * @return String - 当前日期时间的字符串
	 */
	public static String currentDateTime(boolean needMillisecond) {
		return isoDateTime(now(), needMillisecond);
	}

	/**
	 * 返回ISO格式（yyyy-MM-dd HH:mm:ss:SSS）的当前日期时间。
	 *
	 * @return String - 当前日期时间的字符串
	 */
	public static String currentDateTime() {
		return currentDateTime(true);
	}

	/**
	 * 返回ISO格式（yyyy-MM-dd）的当前日期。
	 *
	 * @return String - 当前日期的字符串
	 */
	public static String currentDate() {
		return isoDate(now());
	}

	/**
	 * 返回ISO格式（HH:mm:ss[:SSS]）的当前时间。
	 *
	 * @param needMillisecond
	 *            boolean - 是否需要毫秒
	 * @return String - 当前时间的字符串
	 */
	public static String currentTime(boolean needMillisecond) {
		return isoTime(now(), needMillisecond);
	}

	/**
	 * 返回ISO格式（HH:mm:ss:SSS）的当前时间。
	 *
	 * @return String - 当前时间的字符串
	 */
	public static String currentTime() {
		return currentTime(true);
	}

	/**
	 * 返回yyyy格式的当前年份。
	 *
	 * @return String - 当前年份的字符串
	 */
	public static String currentYear() {
		return formatDate(FORMAT.DATE.YEAR, now());
	}

	/**
	 * 返回MM格式的当前月份。
	 *
	 * @return String - 当前月份的字符串
	 */
	public static String currentMonth() {
		return formatDate(FORMAT.DATE.MONTH, now());
	}

	/**
	 * 返回dd格式的当前日期。
	 *
	 * @return String - 当前日期的字符串
	 */
	public static String currentDay() {
		return formatDate(FORMAT.DATE.DAY, now());
	}

	/**
	 * 返回E格式的当前星期几。
	 *
	 * @return String - 当前星期几的字符串
	 */
	public static String currentWeekDay() {
		return formatDate(FORMAT.DATE.WEEKDAY, now());
	}

	/**
	 * 返回HH格式的当前小时。
	 *
	 * @return String - 当前小时的字符串
	 */
	public static String currentHour() {
		return formatDate(FORMAT.TIME.HOUR, now());
	}

	/**
	 * 返回mm格式的当前分钟。
	 *
	 * @return String - 当前分钟的字符串
	 */
	public static String currentMinute() {
		return formatDate(FORMAT.TIME.MINUTE, now());
	}

	/**
	 * 返回ss格式的当前秒钟。
	 *
	 * @return String - 当前秒钟的字符串
	 */
	public static String currentSecond() {
		return formatDate(FORMAT.TIME.SECOND, now());
	}

	/**
	 * 返回SSS格式的当前毫秒。
	 *
	 * @return String - 当前毫秒的字符串
	 */
	public static String currentMillisecond() {
		return formatDate(FORMAT.TIME.MILLISECOND, now());
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * 根据传入的字符串和格式生成日期。
	 *
	 * @param s
	 *            String - 传入的字符串
	 * @param pattern
	 *            String - 传入字符串日期时间的格式
	 * @return Date - 返回生成的java.util.Date日期
	 * @throws ParseException
	 */
	public static Date parseDate(String s, String pattern) throws ParseException {
		return new SimpleDateFormat(pattern).parse(s);
	}

	/**
	 * 根据传入的字符串和格式生成日期。
	 *
	 * @param s
	 *            String - 传入的字符串
	 * @param pattern
	 *            String - 传入字符串日期时间的格式
	 * @return Date - 返回生成的java.util.Date日期
	 * @throws ParseException
	 */
	public static Date parseUtilDate(String s, String pattern) throws ParseException {
		return new SimpleDateFormat(pattern).parse(s);
	}

	/**
	 * 根据传入的字符串和格式生成日期。
	 *
	 * @param s
	 *            String - 传入的字符串
	 * @param pattern
	 *            String - 传入字符串日期时间的格式
	 * @return Date - 返回生成的java.sql.Date日期
	 * @throws ParseException
	 */
	public static java.sql.Date parseSqlDate(String s, String pattern) throws ParseException {
		return new java.sql.Date(parseUtilDate(s, pattern).getTime());
	}

	/**
	 * java.util.Date转换为java.sql.Date。
	 *
	 * @param date
	 *            java.util.Date - 要转换的java.util.Date
	 * @return java.sql.Date - 转换后的java.sql.Date
	 */
	public static java.sql.Date util2SqlDate(Date date) {
		if (date == null) {
			return null;
		}
		else {
			return new java.sql.Date(date.getTime());
		}
	}

	/**
	 * java.sql.Date转换为java.util.Date。
	 *
	 * @param date
	 *            java.sql.Date - 要转换的java.sql.Date
	 * @return java.util.Date - 转换后的java.util.Date
	 */
	public static Date sql2UtilDate(java.sql.Date date) {
		if (date == null) {
			return null;
		}
		else {
			return new Date(date.getTime());
		}
	}

	/**
	 * java.util.Dat转换为java.sql.Timestamp。
	 *
	 * @param date
	 *            java.util.Date - 要转换的java.sql.Date
	 * @return java.sql.Timestamp - 转换后的java.sql.Timestamp
	 */
	public static java.sql.Timestamp uitl2Timestamp(Date date) {
		if (date == null) {
			return null;
		}
		else {
			return new java.sql.Timestamp(date.getTime());
		}
	}

	/**
	 * java.sql.Timestamp转换为java.util.Date。
	 *
	 * @param timestamp
	 *            java.sql.Timestamp - 要转换的java.sql.Timestamp
	 * @return java.util.Date - 转换后的java.util.Date
	 */
	public static Date timestamp2UtilDate(java.sql.Timestamp timestamp) {
		if (timestamp == null) {
			return null;
		}
		else {
			return new Date(timestamp.getTime());
		}
	}

	public static Date getBeginOfMonth(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (months != 0) {
			calendar.add(GregorianCalendar.MONTH, months);
		}
		calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
		return (Date) calendar.getTime().clone();
	}

	public static Date getEndOfMonth(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (months != 0) {
			calendar.add(GregorianCalendar.MONTH, months);
		}
		calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		return (Date) calendar.getTime().clone();
	}

	public static Date getBeginOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(GregorianCalendar.MONTH, calendar.getActualMinimum(GregorianCalendar.MONTH));
		calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
		calendar.set(GregorianCalendar.HOUR_OF_DAY, calendar.getActualMinimum(GregorianCalendar.HOUR_OF_DAY));
		calendar.set(GregorianCalendar.MINUTE, calendar.getActualMinimum(GregorianCalendar.MINUTE));
		calendar.set(GregorianCalendar.SECOND, calendar.getActualMinimum(GregorianCalendar.SECOND));
		calendar.set(GregorianCalendar.MILLISECOND, calendar.getActualMinimum(GregorianCalendar.MILLISECOND));
		return (Date) calendar.getTime().clone();
	}

	public static Date getEndOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(GregorianCalendar.MONTH, calendar.getActualMaximum(GregorianCalendar.MONTH));
		calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		calendar.set(GregorianCalendar.HOUR_OF_DAY, calendar.getActualMaximum(GregorianCalendar.HOUR_OF_DAY));
		calendar.set(GregorianCalendar.MINUTE, calendar.getActualMaximum(GregorianCalendar.MINUTE));
		calendar.set(GregorianCalendar.SECOND, calendar.getActualMaximum(GregorianCalendar.SECOND));
		calendar.set(GregorianCalendar.MILLISECOND, calendar.getActualMaximum(GregorianCalendar.MILLISECOND));
		return (Date) calendar.getTime().clone();
	}

	public static int getYearOfDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	public static Date getBeginOfYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, calendar.getActualMinimum(GregorianCalendar.MONTH));
		calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMinimum(GregorianCalendar.DAY_OF_MONTH));
		calendar.set(GregorianCalendar.HOUR_OF_DAY, calendar.getActualMinimum(GregorianCalendar.HOUR_OF_DAY));
		calendar.set(GregorianCalendar.MINUTE, calendar.getActualMinimum(GregorianCalendar.MINUTE));
		calendar.set(GregorianCalendar.SECOND, calendar.getActualMinimum(GregorianCalendar.SECOND));
		calendar.set(GregorianCalendar.MILLISECOND, calendar.getActualMinimum(GregorianCalendar.MILLISECOND));
		return (Date) calendar.getTime().clone();
	}

	public static Date getEndOfYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(GregorianCalendar.YEAR, year);
		calendar.set(GregorianCalendar.MONTH, calendar.getActualMaximum(GregorianCalendar.MONTH));
		calendar.set(GregorianCalendar.DAY_OF_MONTH, calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));
		calendar.set(GregorianCalendar.HOUR_OF_DAY, calendar.getActualMaximum(GregorianCalendar.HOUR_OF_DAY));
		calendar.set(GregorianCalendar.MINUTE, calendar.getActualMaximum(GregorianCalendar.MINUTE));
		calendar.set(GregorianCalendar.SECOND, calendar.getActualMaximum(GregorianCalendar.SECOND));
		calendar.set(GregorianCalendar.MILLISECOND, calendar.getActualMaximum(GregorianCalendar.MILLISECOND));
		return (Date) calendar.getTime().clone();
	}

	/***
	 * 获取两个日期间距离的月份
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int monthsBetween(Date startDate, Date endDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		int startMonth = calendar.get(GregorianCalendar.MONTH);
		int startYear = calendar.get(GregorianCalendar.YEAR);
		calendar.setTime(endDate);
		int endMonth = calendar.get(GregorianCalendar.MONTH);
		int endYear = calendar.get(GregorianCalendar.YEAR);
		return (endYear - startYear) * 12 + (endMonth - startMonth);
	}

	/***
	 * 获取两个日期距离多少天
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int daysBetween(Date startDate, Date endDate) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(startDate);
		c2.setTime(endDate);
		return daysBetween(c1, c2);
	}

	/**
	 * 获取指定日期对应月份的第一天
	 * 
	 * @param date
	 *            指定日期
	 * @return 月份的第一天
	 */
	public static Date getFirstDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期对应月份的最后一天
	 * 
	 * @param date
	 *            指定日期
	 * @return 月份的最后一天
	 */
	public static Date getLastDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DATE, 1);
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/***
	 * 获取指定日期的第二天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
		return (Date) calendar.getTime().clone();
	}

	/***
	 * 获取指定日期的下一个月
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.MONTH, 1);
		return (Date) calendar.getTime().clone();
	}

	/***
	 * 获取指定日期的下一年
	 * 
	 * @param date
	 * @return
	 */
	public static Date getNextYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.YEAR, 1);
		return (Date) calendar.getTime().clone();
	}

	/**
	 * 获取指定日期的n天后的日期
	 * 
	 * @param date
	 * @param n
	 * @return
	 */
	public static Date getNextNDay(Date date, int n) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.DAY_OF_MONTH, n);
		return (Date) calendar.getTime().clone();
	}

	public static int daysBetween(Calendar early, Calendar late) {
		return (int) (toJulian(late) - toJulian(early));
	}

	public static final float toJulian(Calendar c) {
		int Y = c.get(Calendar.YEAR);
		int M = c.get(Calendar.MONTH);
		int D = c.get(Calendar.DATE);
		int A = Y / 100;
		int B = A / 4;
		int C = 2 - A + B;
		float E = (int) (365.25f * (Y + 4716));
		float F = (int) (30.6001f * (M + 1));
		float JD = (C + D + E + F) - 1524.5f;
		return JD;
	}
	
	/***
	 * 获取与系统当前时间的间隔多少秒
	 * @param date
	 * @return
	 */
	public static long getDateBetweenSeconds(Date date){
		Date now = new Date();
		return (now.getTime()-date.getTime())/1000;
	}
	
	/***
	 * 大于当前时间多少秒
	 * @param date
	 * @param interval
	 * @return
	 */
	public static boolean isGreaterNow(Date date,int interval){
		Date now = new Date();
		long inter = (long) 1000 * interval;
		long result = date.getTime()-now.getTime();
		if(result < 0 || result < inter) return false;
		else  return true;
		
	}

	/***
	 * 通用日期转换
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date extendConvertStringToDate(String dateStr) {
		String[] datePatterns = { "yyyyMMddHHmmss", "yyyy/MM/dd", "yyMMdd", "yy/MM/dd", "yyMd", "yy/M/d", "yyyy/M/d", "yyyyMd" };
		Date returnDate = null;
		String source = StringDiyUtils.replace(dateStr, ".", "/");
		// 年月日汉字
		source = StringDiyUtils.replace(source, "年", "/");
		source = StringDiyUtils.replace(source, "月", "/");
		source = StringDiyUtils.replace(source, "日", "");
		// 反斜线
		source = StringDiyUtils.replace(source, "\\", "/");
		// 句号
		source = StringDiyUtils.replace(source, "。", "/");
		source = StringDiyUtils.replace(source, ".", "/");
		// 逗号
		source = StringDiyUtils.replace(source, "，", "/");
		source = StringDiyUtils.replace(source, ",", "/");
		// 顿号
		source = StringDiyUtils.replace(source, "、", "/");
		// 下划线
		source = StringDiyUtils.replace(source, "_", "/");
		// 中划线
		source = StringDiyUtils.replace(source, "—", "/");
		source = StringDiyUtils.replace(source, "-", "/");
		// 空格
		source = StringDiyUtils.replace(source, "　", "/");
		source = StringDiyUtils.replace(source, " ", "/");
		// 冒号
		source = StringDiyUtils.replace(source, "：", "/");
		source = StringDiyUtils.replace(source, ":", "/");
		// 问号
		source = StringDiyUtils.replace(source, "?", "/");
		source = StringDiyUtils.replace(source, "？", "/");
		// 分号
		source = StringDiyUtils.replace(source, ";", "/");
		source = StringDiyUtils.replace(source, "；", "/");

		source = StringDiyUtils.replace(source, "＼", "/");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		for (String pattern : datePatterns) {
			simpleDateFormat.applyPattern(pattern);
			try {
				returnDate = simpleDateFormat.parse(source);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(returnDate);
				int year = calendar.get(Calendar.YEAR);
				if (year < 100) {
					calendar.set(Calendar.YEAR, year + 2000);
				}
				returnDate = calendar.getTime();
			} catch (ParseException e) {
				continue;
			}
			break;
		}
		return returnDate;
	}

	/***
	 * 获取指定开始及结束日期的所有日期
	 * 
	 * @param paramString1
	 *            开始日期 格式如:yyyy-MM-dd
	 * @param paramString2
	 *            结束日期 格式如:yyyy-MM-dd
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getAllDatesByDate(String paramString1, String paramString2) {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(FORMAT.DATE.DEFAULT);
		ArrayList localArrayList = new ArrayList();
		try {
			Date localDate1 = localSimpleDateFormat.parse(paramString1);
			Date localDate2 = localSimpleDateFormat.parse(paramString2);
			Calendar localCalendar = Calendar.getInstance();
			while (localDate1.compareTo(localDate2) <= 0) {
				localCalendar.setTime(localDate1);

				String str = localSimpleDateFormat.format(localDate1);
				localArrayList.add(str);
				localCalendar.add(5, 1);
				localDate1 = localCalendar.getTime();
			}
			return localArrayList;
		} catch (ParseException localParseException) {

		}
		return null;
	}
	
	/***
	 * 获取指定开始及结束日期的所有日期
	 * 
	 * @param paramString1
	 * @param paramString2
	 *  @param pattern
	 * @return
	 */
	public static List<String> getAllDatesByDate(String paramString1, String paramString2,String pattern) {
		ArrayList<String> localArrayList = new ArrayList<String>();
		try {
			Date localDate1 = parseDate(paramString1, pattern);
			Date localDate2 = parseDate(paramString2, pattern);
			Calendar localCalendar = Calendar.getInstance();
			while (localDate1.compareTo(localDate2) <= 0) {
				localCalendar.setTime(localDate1);
				String str = formatDate(pattern, localCalendar.getTime());
				localArrayList.add(str);
				localCalendar.add(5, 1);
				localDate1 = localCalendar.getTime();
			}
			return localArrayList;
		} catch (ParseException localParseException) {

		}
		return null;
	}
	
	/***
	 * 获取指定开始及结束月份的所有月份
	 * 
	 * @param paramString1
	 * @param paramString2
	 *  @param pattern
	 * @return
	 */
	public static List<String> getAllMonthsByMonth(String paramString1, String paramString2,String pattern) {
		ArrayList<String> localArrayList = new ArrayList<String>();
		try {
			Date localDate1 = parseDate(paramString1, pattern);
			Date localDate2 = parseDate(paramString2, pattern);
			Calendar localCalendar = Calendar.getInstance();
			while (localDate1.compareTo(localDate2) <= 0) {
				localCalendar.setTime(localDate1);
				String str = formatDate(pattern, localCalendar.getTime());
				localArrayList.add(str);
				localCalendar.add(Calendar.MONTH, 1);
				localDate1 = localCalendar.getTime();
			}
			return localArrayList;
		} catch (ParseException localParseException) {

		}
		return null;
	}

	/***
	 * 获取指定日期所在月的开始日期 和 结束日期
	 * 
	 * @param paramString
	 *            开始日期 格式如:yyyy-MM-dd
	 * @return String[0] 表示开始日期 String[1] 表示结束日期
	 */
	public static String[] getMonthStartEndDateByDate(String paramString) {
		String[] arrayOfString = new String[2];
		try {
			SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(FORMAT.DATE.DEFAULT);
			Date localDate1 = localSimpleDateFormat.parse(paramString);
			Calendar localCalendar = Calendar.getInstance();
			localCalendar.setTime(localDate1);
			localCalendar.set(5, 1);
			localCalendar.roll(5, -1);
			Date localDate2 = localCalendar.getTime();
			String str1 = localSimpleDateFormat.format(localDate2);

			localCalendar.set(5, 1);
			Date localDate3 = localCalendar.getTime();
			String str2 = localSimpleDateFormat.format(localDate3);
			arrayOfString[0] = str2;
			arrayOfString[1] = str1;
			return arrayOfString;
		} catch (ParseException localParseException) {
		}
		return null;
	}

	// 获取某一天所在的周，周一为第一天
	public static String getThisWeek(String day) {
		Calendar ca = Calendar.getInstance();
		ca.set(Integer.valueOf(day.substring(0, 4)), Integer.valueOf(day.substring(5, 7)) - 1, Integer.valueOf(day.substring(8, 10)));
		int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
		ca.add(Calendar.DATE, -((dayOfWeek + 5) % 7));
		String result = "" + DateUtil.dateFormatToString(ca.getTime(), "yyyy-MM-dd") + "";
		for (int i = 1; i < 7; i++) {
			ca.add(Calendar.DATE, 1);
			result += "," + DateUtil.dateFormatToString(ca.getTime(), "yyyy-MM-dd") + "";
		}
		return result;
	}

	/***
	 * 获取距离现在时间的半小时集合
	 * @param date
	 * @return
	 */
	public static List<String> getListHalfTimeInterval(Date date){
		List<String> resultList = new ArrayList<String>();
		Date now = new Date();
		while(date.before(now)){
			String dateStr = getNextHalfHour(date);
			try {
				date = parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if(date.before(now)){
				resultList.add(dateStr);
			}
		}
		return resultList;
	}
	
	/***
	 * 获取半小时后的时间
	 * @param date
	 * @return
	 */
	public static String getNextHalfHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(GregorianCalendar.MINUTE, 30);
		return getHalfHourTime((Date) calendar.getTime().clone());
	}
	
	/***
	 * 返回半小时时间。
	 * 例如:   11:31   将返回11.30
	 *         11:28  将返回11:30
	 * @param date
	 * @return
	 */
	public static String getHalfHourTime(Date date){
		String str = formatDate("yyyy-MM-dd HH:mm:00", date);
		String munite  = str.substring(14, 16);
		String resultMunite="00";
		if(Integer.parseInt(munite)>=30){
			resultMunite = "30";
		}
	   return  str.substring(0, 14)+resultMunite+str.substring(16);
	}
	
	/***
	 * 获取某天是星期几
	 * @param day
	 * @return
	 */
	public static String getWeek(String day){
		Calendar ca = Calendar.getInstance();
		ca.set(Integer.valueOf(day.substring(0, 4)), Integer.valueOf(day.substring(5, 7)) - 1, Integer.valueOf(day.substring(8, 10)));
		int i = ca.get(Calendar.DAY_OF_WEEK);
		switch (i) {
			case 1: return "星期日";
			case 2: return "星期一";
			case 3: return "星期二";
			case 4: return "星期三";
			case 5: return "星期四";
			case 6: return "星期五";
			case 7: return "星期六";
		}
		return "";
	}
	
	/***
	 * 获取某天是星期几
	 * @param day
	 * @return
	 */
	public static Integer getWeekByTimestr(String day){
		Calendar ca = Calendar.getInstance();
		ca.set(Integer.valueOf(day.substring(0, 4)), Integer.valueOf(day.substring(5, 7)) - 1, Integer.valueOf(day.substring(8, 10)));
		int i = ca.get(Calendar.DAY_OF_WEEK);
		return i;
	}
	
	
	/***
	 * 获取某天是星期几
	 * @param day
	 * @return
	 */
	public static Integer getWeekByTime(Date day){
		Calendar ca = Calendar.getInstance();
		ca.setTime(day);
		int i = ca.get(Calendar.DAY_OF_WEEK);
		return i;
	}
	/***
	    * 获取给定日期所在周的开始日期和结束日期  格式为:"yyyy-MM-dd",星期一是第一天
	    * @return
	    * [0]  开始日期
	    * [1]  结束日期
	    */
	public static String[] getThisWeekStartAndEndByDate(String date) {
		String[] result = new String[2];
		String weekDay = getThisWeek(date);
		String[] array = weekDay.split(",");
		String sunDate = array[0];
		String satDate = array[6];
		result[0] = sunDate;
		result[1] = satDate;
		return result;
	}
	
	/***
	    * add by yantao 20120404
	    * 获得参数日期 上一周的所有天数的日期集合  格式为:"yyyy-MM-dd"
	    * @param date
	    * @return
	    * [0]  开始日期
	    * [1]  结束日期
	    */
	public static String getFrontWeek(String day) {
		Calendar ca = Calendar.getInstance();
		ca.set(Integer.valueOf(day.substring(0, 4)), Integer.valueOf(day.substring(5, 7)) - 1, Integer.valueOf(day.substring(8, 10)));
		int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
		ca.add(Calendar.DATE, 1-dayOfWeek-7);
		String result = formatDate("yyyy-MM-dd",ca.getTime());
		for (int i = 1; i < 7; i++) {
			ca.add(Calendar.DATE, 1);
			result += "," + formatDate("yyyy-MM-dd",ca.getTime());
		}
		return result;
	}
	
	/***
	    * add by yantao 20120404
	    * 获得参数日期 上一周的所有天数的日期集合  格式为:"yyyy-MM-dd" 从周一开始
	    * @param date
	    * @return
	    * [0]  开始日期
	    * [1]  结束日期
	    */
	public static String getFrontWeekDay(String day) {
		Calendar ca = Calendar.getInstance();
		ca.set(Integer.valueOf(day.substring(0, 4)), Integer.valueOf(day.substring(5, 7)) - 1, Integer.valueOf(day.substring(8, 10)));
		int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
		ca.add(Calendar.DATE, 2-dayOfWeek-7);
		String result = formatDate("yyyy-MM-dd",ca.getTime());
		for (int i = 1; i < 7; i++) {
			ca.add(Calendar.DATE, 1);
			result += "," + formatDate("yyyy-MM-dd",ca.getTime());
		}
		return result;
	}
	
	
	/***
	 * 获取某日期的开始日期,时间自动格式为00:00:00
	 * @param date
	 * @return
	 */
	public static Date getStartOfDay(Date date){
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(date);
		startDate.set(Calendar.HOUR_OF_DAY, 0);
		startDate.set(Calendar.MINUTE, 0);
		startDate.set(Calendar.SECOND, 0);
		return startDate.getTime();
	}
	
	/***
	 * 获取某日期的结束日期,时间自动格式为23:59:59
	 * @param date
	 * @return
	 */
	public static Date getEndOfDay(Date date){
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(date);
		endDate.set(Calendar.HOUR_OF_DAY, 23);
		endDate.set(Calendar.MINUTE, 59);
		endDate.set(Calendar.SECOND,59);
		return endDate.getTime();
	}
	
	public static void main(String[] args) {
		
		
	}
	
	
	// 获取某一天所在的周，周一为第一天
	public static String getThisWeekDay(String day) {
		Calendar ca = Calendar.getInstance();
		ca.set(Integer.valueOf(day.substring(0, 4)), Integer.valueOf(day.substring(5, 7)) - 1, Integer.valueOf(day.substring(8, 10)));
		int dayOfWeek = ca.get(Calendar.DAY_OF_WEEK);
		ca.add(Calendar.DATE, -((dayOfWeek + 6) % 7));
		String result = "" + DateUtil.dateFormatToString(ca.getTime(), "yyyy-MM-dd") + "";
		for (int i = 1; i < 7; i++) {
			ca.add(Calendar.DATE, 1);
			result += "," + DateUtil.dateFormatToString(ca.getTime(), "yyyy-MM-dd") + "";
		}
		return result;
	}
	
	/***
	    * add by yantao 20120408
	    * 获得参数日期 N天前的日期
	    * @param date
	    * @return
	    * [0]  开始日期
	    * [1]  结束日期
	    */
	public static Date getPerDay(Date date,int n){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.set(Calendar.DATE,ca.get(Calendar.DATE)-n);
		return ca.getTime();
	}
	
	
	
	
	// 根据系统时间生成数据库表的主键
	public static String CreateTableID(int longth) {

		Long ms = System.currentTimeMillis() % 1000000000000L * 10000000L;// 取当前时间的毫秒数作为前几位
		Long ns = System.nanoTime() % 10000000L;// 取当前系统纳秒级时间的后几位作为后几位
		Long time = ms + ns;// 组合时间
		StringBuffer id = new StringBuffer();
		for (int i = 0; i < longth; i++) {
			Integer mark = Integer.valueOf(time % COMMON_CHAR.length() + "");
			id.append(COMMON_CHAR.charAt(mark));
			time = time / COMMON_CHAR.length();
		}
		return id.toString();
	}

}
