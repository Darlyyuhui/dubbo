package com.darly.dubbo.framework.systemlog.constant;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description： 格式常量定义
 */
public final class FORMAT
{

    public static final class DATETIME
    {
        public static final String LONG = "yyyy-MM-dd HH:mm:ss:SSS";
        public static final String SHORT = "yy-MM-dd HH:mm:ss";
        public static final String DEFAULT = "yyyy-MM-dd HH:mm:ss";
        public static final String CN_DEFAULT = "yyyy年MM月dd HH:mm:ss";
        public static final String YYYYMMDDHHmmss="yyyyMMddHHmmss";
        
        /**
         * 调用Oracle数据库to_date做日期转换的时候的日期时间格式。
         */
        public static final String QUERY_DATE_FORMAT = "'yyyy-mm-dd hh24.mi.ss'";

        /**
         * Java的日期转换的标准格式
         */
        public static final String SQL_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
        
    }

    public static final class DATE
    {
    	public static String CN_DATEPATTERN = "yyyy年MM月dd";
        public static final String LONG = "yyyy-MM-dd";
        public static final String SHORT = "yy-MM-dd";
        public static final String DEFAULT = "yyyy-MM-dd";
        public static final String YYYYMMDD="yyyyMMdd";
        public static final String YEAR = "yyyy";
        public static final String MONTH = "MM";
        public static final String WEEKDAY = "E";
        public static final String DAY = "dd";
    }

    public static final class TIME
    {
        public static final String LONG = "HH:mm:ss:SSS";
        public static final String SHORT = "HH:mm:ss";
        public static final String DEFAULT = "HH:mm:ss";

        public static final String HOUR = "HH";
        public static final String MINUTE = "mm";
        public static final String SECOND = "ss";
        public static final String MILLISECOND = "SSS";
    }

////////////////////////////////////////////////////////////////////////////////

    public static final class NUMERIC
    {
        public static final String INTEGER = "#";
        public static final String FLOAT = "0.00########";
        public static final String PERCENT = "0.00";
        public static final String CURRENCY = "#,###,###,##0.00";
    }
}
