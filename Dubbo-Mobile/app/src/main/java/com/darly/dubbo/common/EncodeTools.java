package com.darly.dubbo.common;

import android.util.Base64;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Locale;

/**
 * @package: com.huatek.api.utils
 * @ClassName: EncodeTools
 * @Description: url签名工具
 * @author: aaron_han
 * @data: 2015-1-16 下午5:01:52
 */
public class EncodeTools {
	public static String UCENTER_KEY = "58dfae3488089cf63608b005a9973dfd";

	public static String Utf8URLencode(String text) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i); // 遍历每个字符
			if (c >= 0 && c <= 255 && c != 13 && c != 10 && c != 32) { // 若为英文
				result.append(c); // 直接拼接
			} else { // 若为 中文
				byte[] b = new byte[0];
				try {
					b = Character.toString(c).getBytes("UTF-8");
				} catch (Exception ex) {
					DLog.e(ex.toString());
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					if (c == 10 || c == 13) {
						result.append("%" + "0" + Integer.toHexString(k).toUpperCase(Locale.getDefault()));
					} else {
						result.append("%" + Integer.toHexString(k).toUpperCase(Locale.getDefault()));
					}
				}
			}
		}
		return result.toString();
	}

	/**
	 * 产生 sign 值，将所有参数值拼接后 获取其 MD5 值，同时由于中文的原因，所以先进行 encode 函数
	 * 
	 * @param url
	 * @param key
	 *            常量
	 * @return
	 */

	public static String getSign(String url, String key) {

		StringBuilder sb = new StringBuilder();
		String postfix = null;
		if (url.contains("\u003F")) {
			postfix = "&sign=";
			String mUrl = url.split("\\?")[1]; // uid=11111133&wd=0&usm=10
			String[] strs = mUrl.split("&"); // { uid=11111133,wd=0,usm=10 }
			int begin = -1;

			if (strs[0].contains("=")) {
				for (String str : strs) {
					// sb.append(str.split("=")[1]);
					// 用最后一个等号为标记
					if ((begin = str.indexOf("=")) != str.length() - 1) {
						String sub = str.substring(begin + 1);
						sb.append(sub);
					}
				}
			}
		} else {
			postfix = "?sign=";
		}

		// 先进行 UrlEncode 编码
		String text = "";
		try {
			text = java.net.URLEncoder.encode(sb.append(key).toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if (text.contains("\u002A")) {
			text = text.replace("*", "%2A");
		}

		if (text.contains("\u002B")) {
			text = text.replace("+", "%20");
		}

		/**
		 * 1. + %2B 2. %20 3. / %2F 4. ? %3F 5. % %25 6. # %23 7. & %26 8. = %3D
		 * 
		 * 点的转义： . ==> u002E 美元符号的转义： $ ==> u0024 乘方符号的转义： ^ ==> u005E 左大括号的转义：
		 * { ==> u007B 左方括号的转义： [ ==> u005B 左圆括号的转义： ( ==> u0028 竖线的转义： | ==>
		 * u007C 右圆括号的转义： ) ==> u0029 星号的转义： * ==> u002A 加号的转义： + ==> u002B
		 * 问号的转义： ? ==> u003F 反斜杠的转义： \ ==> u005C
		 */

		return postfix + getMD5(text);
	}

	/**
	 * 无签名标识的Url
	 * 
	 * @param url
	 * @return
	 */
	public static String getEnUrl(String url) {
		return url;
	}

	/**
	 * 有签名标识的Url
	 * 
	 * @param url
	 * @param key
	 * @return
	 */
	public static String getEnUrlSign(String url) {
		return url + getSign(url, UCENTER_KEY);
	}

	public static String getMD5(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		char[] charArray = str.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * 对登录数据进行加密，格式为：loginName=xxx\tpwd=yyy
	 * 
	 * @param content
	 *            要加密的字符串
	 * @param key
	 *            默认为 ""
	 * @param expiry
	 *            默认为 "0"
	 * @return
	 */
	public static String encode(String content, String key, String expiry) {
		int cKeyLen = 4;
		String key1 = getMD5(key != "" ? key : UCENTER_KEY);
		String keya = getMD5(key1.substring(0, 16));
		String keyb = getMD5(key1.substring(8, 32));
		String tmpTime = String.valueOf(System.currentTimeMillis() / 1000);

		String keyc = getMD5(tmpTime).substring(32 - cKeyLen);
		String cryptKey = keya + getMD5(keya + keyc);
		int keyLen = cryptKey.length();

		String content1 = String.format("%010d", expiry != "" ? Integer.valueOf(expiry) + System.currentTimeMillis() / 1000 : 0) + getMD5(content + keyb).substring(0, 16) + content;
		int strLen = content1.length();

		int[] box = new int[256];
		int[] rndKey = new int[256];
		for (int i = 0; i <= 255; i++) {
			rndKey[i] = cryptKey.getBytes()[i % keyLen];
			box[i] = i;
		}

		for (int i = 0, j = 0; i < 256; i++) {
			j = (j + box[i] + rndKey[i]) % 256;
			int tmp = box[i];
			box[i] = box[j];
			box[j] = tmp;
		}

		byte[] bytes1 = new byte[strLen];
		for (int a = 0, j = 0, i = 0; i < strLen; i++) {
			a = (a + 1) % 256;
			j = (j + box[a]) % 256;
			int tmp = box[a];
			box[a] = box[j];
			box[j] = tmp;
			bytes1[i] = (byte) (content1.getBytes()[i] ^ (box[(box[a] + box[j]) % 256]));
		}

		return keyc + Base64.encodeToString(bytes1, Base64.DEFAULT).replace("=", "");
	}
}
