package com.darly.dubbo.mobile.session;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 根据配置文件获取参数
 * Author : ZhangYuHui
 * Date : 2017/12/5
 */
public class SessionConfig {

    private static final String path = "dev/props/customer-session.properties";//从src的根目录开始
    private static final String encode = "UTF-8";//文件的编码格式
    private static Properties props = new Properties();

    static {
        try {
            props.load(Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key, String def) {
        try {
            return new String(props.getProperty(key).getBytes("ISO8859-1"), encode).trim();
        } catch (Exception e) {
            return def;
        }
    }

    public static int getValue(String key, int def) {
        try {
            return Integer.valueOf(new String(props.getProperty(key).getBytes("ISO8859-1"), encode).trim());
        } catch (Exception e) {
            return def;
        }
    }
}
