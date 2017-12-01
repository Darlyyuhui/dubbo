package com.darly.dubbo.framework.common;



import java.io.UnsupportedEncodingException;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Description：处理字符串的公共方法。
 */
public class StringDiyUtils {

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * 空字符串 － ""。
	 */
	public static final String EMPTY_STRING = "";

	/**
	 * 四个空格（SPACE）的缩进字符串。
	 */
	public static final String SPACE_INDENT = "    ";

	/**
	 * 一个制表位（TAB）的缩进字符串。
	 */
	public static final String TAB_INDENT = "	";

	/**
	 * 缺省的缩进字符串 － 四个空格。
	 */
	public static final String DEFAULT_INDENT = SPACE_INDENT;

	/**
	 * 缺省的省略号 － 三个半角句号（...）。
	 */
	public static final String DEFAULT_ELLIPSIS = "...";

	// ////////////////////////////// 判断类的公共方法 ////////////////////////////////

	/**
	 * 判断字符串对象是否为空（null）。
	 * 
	 * @param s
	 *            String - 待判断字符串
	 * @return boolean - 返回是否为空，true表示空，false表示非空
	 */
	public static boolean isNull(String s) {
		return (s == null);
	}

	public static boolean isNotEmpty(String s) {

		if (s != null && !EMPTY_STRING.equals(s)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串对象是否为空，包括空（null）和空字符串（""）。
	 * 
	 * @param s
	 *            String - 待判断字符串
	 * @param trimmed
	 *            boolean - 判断时是否删除前后空格（trim）
	 * @return boolean - 返回是否为空，true表示空，false表示非空
	 */
	public static boolean isEmpty(String s, boolean trimmed) {
		if (trimmed)
			return (s == null || EMPTY_STRING.equals(s.trim()));
		else
			return (s == null || EMPTY_STRING.equals(s));
	}

	/**
	 * 判断字符串对象是否为空，包括空（null）和空字符串（""）。
	 * 
	 * @param s
	 *            String - 待判断字符串
	 * @return boolean - 返回是否为空，true表示空，false表示非空
	 */
	public static boolean isEmpty(String s) {
		return isEmpty(s, true);
	}

	/**
	 * 判断字符串的长度是否大于0。
	 * 
	 * @param s
	 *            String - 待判断字符串
	 * @return boolean - 返回是否有长度，true表示有长度（>0），false表示没有长度（<=0）
	 */
	public static boolean hasLength(String s) {
		return (s != null && s.length() > 0);
	}

	/**
	 * 比较两个字符串对象是否相等。
	 * 
	 * @param s1
	 *            String - 字符串1
	 * @param s2
	 *            String - 字符串2
	 * @return boolean - 是否相等，true表示相等，false表示不相等
	 */
	public static boolean isEqual(String s1, String s2) {
		if (s1 == null) {
			return (s2 == null);
		} else {
			return s1.equals(s2);
		}
	}

	/**
	 * 比较两个字符串是否存在包含关系。
	 * 
	 * @param string
	 *            String - 父字符串
	 * @param subString
	 *            String - 子字符串
	 * @return boolean - 返回父字符串是否包含子字符串，true表示包含，false表示不包含
	 */
	public static boolean isSubString(String string, String subString) {
		if (string == null) {
			return false;
		} else {
			return (string.indexOf(subString) >= 0);
		}
	}

	/**
	 * 判断String是否为空
	 */
	public static boolean notEmpty(String str) {
		if (str == null || "".equals(str) || "null".equals(str))
			return false;
		return true;
	}

	/**
	 * 判断传入的字符串是否表示“真”。
	 * 
	 * @param s
	 *            String - 要判断的字符串
	 * @return boolean - 如果传入的字符串为“1”、“Y”、“Yes”、“T”或者
	 *         “True”就返回true，不区分大小写，否则返回false
	 */
	public static boolean isTrue(String s) {
		return (!StringDiyUtils.isEmpty(s) && ("1".equalsIgnoreCase(s)
				|| "Y".equalsIgnoreCase(s) || "Yes".equalsIgnoreCase(s)
				|| "T".equalsIgnoreCase(s) || "True".equalsIgnoreCase(s)));
	}

	/**
	 * 判断传入的字符串是否表示“假”。
	 * 
	 * @param s
	 *            String - 要判断的字符串
	 * @return boolean - 如果传入的字符串为“1”、“Y”、“Yes”、“T”或者
	 *         “True”就返回false，不区分大小写，否则返回true
	 */
	public static boolean isFalse(String s) {
		return !isTrue(s);
	}

	// ////////////////////////////// 生成类的公共方法 ////////////////////////////////

	/**
	 * 根据传入的单位缩进字符串生成指定级别的缩进字符串。
	 * 
	 * @param level
	 *            int - 缩进级别
	 * @param indent
	 *            String - 单位缩进字符串，缺省为四个空格
	 * @return String - 生成的缩进字符串
	 */
	public static String indents(int level, String indent) {
		if (isEmpty(indent))
			indent = DEFAULT_INDENT;

		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < level; i++) {
			buf.append(indent);
		}
		return buf.toString();
	}

	/**
	 * 生成指定级别的缩进字符串，每级缩进使用四个空格。
	 * 
	 * @param level
	 *            int - 缩进级别
	 * @return String - 生成的缩进字符串
	 */
	public static String indents(int level) {
		return indents(level, DEFAULT_INDENT);
	}

	/**
	 * 根据给定的字符和宽度构造字符串。
	 * 
	 * @param _char
	 *            char - 被构造字符
	 * @param _width
	 *            int - 构造之后生成的新字符串的宽度
	 * @return String - 构造之后生成的新字符串
	 */
	public static String stringOfChar(char _char, int _width) {
		StringBuffer ret = new StringBuffer(EMPTY_STRING);
		for (int i = 0; i < _width; i++) {
			ret.append(_char);
		}
		return ret.toString();
	}

	/**
	 * 根据给定的字符串和宽度构造字符串。
	 * 
	 * @param _string
	 *            String - 被构造的字符串
	 * @param _width
	 *            int - 构造之后生成的新字符串的宽度的宽度
	 * @return String - 构造之后生成的新字符串的宽度
	 */
	public static String stringOfString(String _string, int _width) {
		StringBuffer ret = new StringBuffer(EMPTY_STRING);
		for (int i = 0; i < _width; i++) {
			ret.append(_string);
		}
		return ret.toString();
	}

	// ///////////////////////////// 替换处理类的公共方法 //////////////////////////////

	/**
	 * 替换传入字符串中的老字符串为新字符串。
	 * 
	 * @param s
	 *            String - 传入字符串
	 * @param oldPattern
	 *            String - 老字符串
	 * @param newPattern
	 *            String - 新字符串
	 * @param ignoreCase
	 *            boolean - 是否忽略大小写
	 * @param replaceAll
	 *            boolean - 是否全部替换
	 * @return String - 返回被替换后的字符串
	 */
	public static String replace(String s, String oldPattern,
			String newPattern, boolean ignoreCase, boolean replaceAll) {
		if (isEmpty(s))
			return "";

		if (isEmpty(oldPattern))
			return s;

		// 如果匹配字符串为null，则自动替换为""
		newPattern = isNull(newPattern) ? EMPTY_STRING : newPattern;

		int iPos = -1;
		if (ignoreCase) {
			iPos = s.toLowerCase().indexOf(oldPattern.toLowerCase());
		} else {
			iPos = s.indexOf(oldPattern);
		}

		if (iPos != -1) {
			String before = s.substring(0, iPos);
			String after = s.substring(iPos + oldPattern.length());

			s = before + newPattern + after;

			if (replaceAll)
				s = replace(s, oldPattern, newPattern, ignoreCase, replaceAll);

			return s;
		} else {
			return s;
		}
	}

	/**
	 * 全部替换传入字符串中的老字符串为新字符串。
	 * 
	 * @param s
	 *            String - 传入字符串
	 * @param oldPattern
	 *            String - 老字符串
	 * @param newPattern
	 *            String - 新字符串
	 * @param ignoreCase
	 *            boolean - 是否忽略大小写
	 * @return String - 返回被替换后的字符串
	 */
	public static String replace(String s, String oldPattern,
			String newPattern, boolean ignoreCase) {
		return replace(s, oldPattern, newPattern, ignoreCase, true);
	}

	/**
	 * 全部替换传入字符串中的老字符串为新字符串，忽略大小写。
	 * 
	 * @param s
	 *            String - 传入字符串
	 * @param oldPattern
	 *            String - 老字符串
	 * @param newPattern
	 *            String - 新字符串
	 * @return String - 返回被替换后的字符串
	 */
	public static String replace(String s, String oldPattern, String newPattern) {
		return replace(s, oldPattern, newPattern, true, true);
	}

	/**
	 * 替换传入字符串中的老字符串为新字符串，忽略大小写。
	 * 
	 * @param s
	 *            String - 传入字符串
	 * @param oldPattern
	 *            String - 老字符串
	 * @param newPattern
	 *            String - 新字符串
	 * @param replaceAll
	 *            boolean - 是否全部替换
	 * @return String - 返回被替换后的字符串
	 */
	public static String replaceIgnoreCase(String s, String oldPattern,
			String newPattern, boolean replaceAll) {
		return replace(s, oldPattern, newPattern, true, replaceAll);
	}

	/**
	 * 全部替换传入字符串中的老字符串为新字符串。
	 * 
	 * @param s
	 *            String - 传入字符串
	 * @param oldPattern
	 *            String - 老字符串
	 * @param newPattern
	 *            String - 新字符串
	 * @param ignoreCase
	 *            boolean - 是否忽略大小写
	 * @return String - 返回被替换后的字符串
	 */
	public static String replaceAll(String s, String oldPattern,
			String newPattern, boolean ignoreCase) {
		return replace(s, oldPattern, newPattern, ignoreCase, true);
	}

	/**
	 * 全部替换传入字符串中的老字符串为新字符串，忽略大小写。
	 * 
	 * @param s
	 *            String - 传入字符串
	 * @param oldPattern
	 *            String - 老字符串
	 * @param newPattern
	 *            String - 新字符串
	 * @return String - 返回被替换后的字符串
	 */
	public static String replaceAllIgnoreCase(String s, String oldPattern,
			String newPattern) {
		return replace(s, oldPattern, newPattern, true, true);
	}

	// ///////////////////////////// 删除处理类的公共方法 //////////////////////////////

	/**
	 * 删除传入字符串中的指定子字符串。
	 * 
	 * @param s
	 *            String - 要处理的字符串
	 * @param pattern
	 *            String - 要删除的匹配字符串
	 * @param ignoreCase
	 *            boolean - 是否忽略大小写
	 * @param deleteAll
	 *            boolean - 是否全部删除
	 * @return String - 返回处理后的字符串
	 */
	public static String delete(String s, String pattern, boolean ignoreCase,
			boolean deleteAll) {
		return replace(s, pattern, EMPTY_STRING, ignoreCase, deleteAll);
	}

	/**
	 * 全部删除传入字符串中的指定子字符串。
	 * 
	 * @param s
	 *            String - 要处理的字符串
	 * @param pattern
	 *            String - 要删除的匹配字符串
	 * @param ignoreCase
	 *            boolean - 是否忽略大小写
	 * @return String - 返回处理后的字符串
	 */
	public static String delete(String s, String pattern, boolean ignoreCase) {
		return delete(s, pattern, ignoreCase, true);
	}

	/**
	 * 全部删除传入字符串中的指定子字符串，大小写敏感。
	 * 
	 * @param s
	 *            String - 要处理的字符串
	 * @param pattern
	 *            String - 要删除的匹配字符串
	 * @return String - 返回处理后的字符串
	 */
	public static String delete(String s, String pattern) {
		return delete(s, pattern, false, true);
	}

	/**
	 * 删除传入字符串中的指定子字符串，忽略大小写。
	 * 
	 * @param s
	 *            String - 要处理的字符串
	 * @param pattern
	 *            String - 要删除的匹配字符串
	 * @param deleteAll
	 *            boolean - 是否全部删除
	 * @return String - 返回处理后的字符串
	 */
	public static String deleteIgnoreCase(String s, String pattern,
			boolean deleteAll) {
		return delete(s, pattern, true, deleteAll);
	}

	/**
	 * 全部删除传入字符串中的指定子字符串。
	 * 
	 * @param s
	 *            String - 要处理的字符串
	 * @param pattern
	 *            String - 要删除的匹配字符串
	 * @param ignoreCase
	 *            boolean - 是否忽略大小写
	 * @return String - 返回处理后的字符串
	 */
	public static String deleteAll(String s, String pattern, boolean ignoreCase) {
		return delete(s, pattern, ignoreCase, true);
	}

	/**
	 * 全部删除传入字符串中的指定子字符串，忽略大小写。
	 * 
	 * @param s
	 *            String - 要处理的字符串
	 * @param pattern
	 *            String - 要删除的匹配字符串
	 * @return String - 返回处理后的字符串
	 */
	public static String deleteAllIgnoreCase(String s, String pattern) {
		return delete(s, pattern, true, true);
	}

	/**
	 * 删除字符串尾部的指定字符串。即如果传入的字符串s的尾部有指定的字符串tail， 则会将s尾部的tail字符串删除返回，否则原样返回字符串s。
	 * 
	 * @param s
	 *            String - 要处理的字符串
	 * @param tail
	 *            String - 指定的要删除的尾部字符串
	 * @param ignoreCase
	 *            boolean - 是否忽略大小写
	 * @return String - 返回处理后的字符串
	 */
	public static String deleteTail(String s, String tail, boolean ignoreCase) {
		if (isEmpty(s))
			return s;

		if (isEmpty(tail))
			return s;

		boolean hasTail = ignoreCase ? (s.substring(s.length() - tail.length())
				.equalsIgnoreCase(tail)) : (s.substring(s.length()
				- tail.length()).equals(tail));

		if (hasTail)
			return s.substring(0, s.length() - tail.length());
		else
			return s;
	}

	/**
	 * 删除字符串尾部的指定字符串。即如果传入的字符串s的尾部有指定的字符串tail， 则会将s尾部的tail字符串删除返回，否则原样返回字符串s。
	 * 
	 * @param s
	 *            String - 要处理的字符串
	 * @param tail
	 *            String - 指定的要删除的尾部字符串
	 * @return String - 返回处理后的字符串
	 */
	public static String deleteTail(String s, String tail) {
		return deleteTail(s, tail, true);
	}

	/**
	 * 删除传入字符串中的任何匹配的单个字符，即该方法将传入字符串s中所有在chars字符串中 包涵的字符都删除。
	 * 
	 * @param s
	 *            String - 给定操作的字符串
	 * @param chars
	 *            String - 被匹配的字符串
	 * @return String - 返回删除chars之后生成的新字符串
	 */
	public static String deleteAny(String s, String chars) {
		if (isEmpty(s))
			return EMPTY_STRING;

		if (isEmpty(chars))
			return s;

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (chars.indexOf(c) == -1) {
				buf.append(c);
			}
		}

		return buf.toString();
	}

	// //////////////////////////// 截断/省略类的公共方法 //////////////////////////////

	/**
	 * 按照指定宽度截断传入的字符串，即如果传入的字符串长度小于等于指定宽度，则不截取而原样
	 * 返回；如果传入的字符串长度大于指定宽度，则将传入字符串按指定宽度截断后返回。
	 * 
	 * @param s
	 *            String - 传入的字符串
	 * @param width
	 *            int - 指定的宽度
	 * @return String - 返回截断后的字符串
	 */
	public static String truncate(String s, int width) {
		if (isEmpty(s))
			return s;

		if (s.length() > width) {
			return s.substring(0, width);
		} else {
			return s;
		}
	}

	/**
	 * 按照指定宽度省略传入的字符串，即如果传入的字符串长度小于等于指定宽度，则不截取/省略
	 * 而原样返回；如果传入的字符串长度大于指定宽度，则将传入字符串截断后补上传入的省略符号， 但如果传入的省略号参数为空，则仅仅按照指定宽度截断。
	 * 
	 * @param s
	 *            String - 传入的字符串
	 * @param width
	 *            int - 指定的宽度
	 * @param ellipsis
	 *            String - 省略号，如果该参数为空，则仅仅按宽度截断
	 * @return String - 返回省略或截断后的字符串
	 */
	public static String omit(String s, int width, String ellipsis) {
		if (isEmpty(s))
			return EMPTY_STRING;

		if (s.length() > width) {
			if (isEmpty(ellipsis))
				return s.substring(0, width);
			else
				return s.substring(0, width - ellipsis.length()) + ellipsis;
		} else {
			return s;
		}
	}

	/**
	 * 按照指定宽度省略传入的字符串，即如果传入的字符串长度小于等于指定宽度，则不省略原样返
	 * 回；而如果传入的字符串长度大于指定宽度，则将传入字符串截断后补上省略符号“...”。
	 * 
	 * @param s
	 *            String - 传入的字符串
	 * @param width
	 *            int - 指定的宽度
	 * @return String - 返回省略或截断后的字符串
	 */
	public static String omit(String s, int width) {
		return omit(s, width, DEFAULT_ELLIPSIS);
	}

	// ///////////////////////////// 逻辑转换类的公共方法 //////////////////////////////

	/**
	 * 根据传入字符串是否为空返回缺省值，即传入字符串为空时，返回缺省值，否则返回自己。
	 * 
	 * @param s
	 *            String - 传入字符串
	 * @param defaultValue
	 *            String - 缺省值
	 * @return String - 返回值
	 */
	public static String nvl(String s, String defaultValue) {
		if (isEmpty(s))
			return defaultValue;
		else
			return s;
	}

	/**
	 * 格式化一个字符串，把其中只有一个引号（'）的转换为两个。
	 * 
	 * @param s
	 *            String - 需要处理的字符串
	 * @return String - 转换后的字符串
	 */
	public static String escape(String s) {
		if (isEmpty(s))
			return EMPTY_STRING;

		if (s.indexOf('\'') < 0)
			return s;

		int len = s.length();

		StringBuffer buf = new StringBuffer(len);

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);

			if (c == '\'') {
				buf.append('\'');
			}
			buf.append(c);
		}

		return buf.toString();
	}

	/**
	 * 字符串数组的字符编码转换。
	 * 
	 * @param string
	 *            String - 原始操作字符串
	 * @param transCode
	 *            String - 过渡转换编码
	 * @param destCode
	 *            String - 目标字符编码
	 * @return String - 编码转换之后的字符串
	 */
	public static String strCode(String string, String transCode,
			String destCode) {

		if (isEmpty(transCode) || isEmpty(destCode) || isEmpty(string)) {
			return string;
		}

		try {
			string = new String(string.getBytes(transCode), destCode);
		} catch (Exception ex) {
			// 忽略
		}

		return string;
	}

	// //////////////////////////// 大小写转换类的公共方法 /////////////////////////////

	/**
	 * 对字符串的首字母进行处理。
	 * 
	 * @param s
	 *            String - 待处理的字符串
	 * @param upperCase
	 *            boolean - 是否需要将首字母置成大写，true表示转换成大写， false表示转换成小写
	 * @return String - 返回处理后的字符串
	 */
	public static String changeInitialCase(String s, boolean upperCase) {
		// 为空，则直接返回
		if (isEmpty(s))
			return s;

		StringBuffer buf = new StringBuffer(s.length());

		if (upperCase)
			buf.append(Character.toUpperCase(s.charAt(0)));
		else
			buf.append(Character.toLowerCase(s.charAt(0)));

		buf.append(s.substring(1));

		return buf.toString();
	}

	/**
	 * 将字符串的首字母改成大写，其他字符大小写不变。
	 * 
	 * @param s
	 *            String - 需要处理的字符串，如果为null，则直接返回null
	 * @return String - 处理后的字符串
	 */
	public static String changeInitialUpperCase(String s) {
		return changeInitialCase(s, true);
	}

	/**
	 * 将字符串的首字母改成小写，其他字符大小写不变。
	 * 
	 * @param s
	 *            String - 需要处理的字符串，如果为null，则直接返回null
	 * @return String - 处理后的字符串
	 */
	public static String changeInitialLowerCase(String s) {
		return changeInitialCase(s, false);
	}

	/**
	 * 逻辑首字母大写，即将传入字符串的首字母以及被空格、下划线分隔后的第一个字母变为大写， 其他的字符全部变为小写后返回。
	 * 
	 * @param s
	 *            String - 需要处理的字符串，如果为null，则直接返回null
	 * @param removeSep
	 *            boolean - 处理后是否删除空格、下划线分隔符
	 * @return String - 处理后的字符串
	 */
	public static String capitalize(String s, boolean removeSep) {
		if (isEmpty(s))
			return s;

		int len = s.length();

		StringBuffer buf = new StringBuffer(len);

		boolean passSep = true;

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);

			if (c == ' ' || c == '_') {
				if (!removeSep)
					buf.append(c);

				passSep = true;
			} else {
				if (passSep)
					buf.append(Character.toUpperCase(c));
				else
					buf.append(Character.toLowerCase(c));

				passSep = false;
			}
		}

		return buf.toString();
	}

	/**
	 * 转换为UTF-8
	 */
	public static String getUTF8(String str) {
		try {
			String english = str;
			byte[] change = english.getBytes("ISO8859-1");
			String chinese = new String(change, "UTF-8");
			return chinese;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/** 中文乱码处理 */
	public static String getCN(String str) {
		try {
			String english = str;
			byte[] change = english.getBytes("ISO8859-1");
			String chinese = new String(change, "GBK");
			return chinese;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/***************************************************************************
	 * 检测字符编码
	 */
//	public static Charset getFileCharset(String str) {
//		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
//		detector.add(new ParsingDetector(false));
//		detector.add(JChardetFacade.getInstance());
//		detector.add(ASCIIDetector.getInstance());
//		detector.add(UnicodeDetector.getInstance());
//		try {
//			return detector.detectCodepage(new URL(str));
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	//移除特殊符号
	public static String removets(String value){
		if(value != null) {
			int lengthh = value.length();
			StringBuffer filtered = new StringBuffer(lengthh);
			char prevChar = '\u0000';
			char c;
			for (int i = 0; i < lengthh; i++) {
			  c = value.charAt(i);
			  if (c == '"') {
			    filtered.append("\\\"");
			  } else if (c == '\'') {
			    filtered.append("\\'");
			  } else if (c == '\\') {
			    filtered.append("\\\\");
			  } else if (c == '\t') {
			    filtered.append("\\t");
			  } else if (c == '\n') {
			     if (prevChar != '\r') {
			       filtered.append("\\n");
			     }
			  } else if (c == '\r') {
			    filtered.append(" , ");
			  } else if (c == '\f') {
			    filtered.append("\\f");
			  } else if (c == '/') {
			    filtered.append("\\/");
			  } else {
			    filtered.append(c);
			  }
			    prevChar = c;
			  }
			  value = String.valueOf(filtered);
		}
		return value;
	 }

	// //////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
	}
}
