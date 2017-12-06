package com.darly.dubbo.root;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/5
 * TODO :
 */
public class ApplicationProperties {
    private static final String path = "dev/props/producer-application.properties";//从src的根目录开始
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
            return new String(props.getProperty(key).getBytes("ISO8859-1"), encode);
        } catch (Exception e) {
            return def;
        }
    }

    public static int getValue(String key, int def) {
        try {
            return Integer.valueOf(new String(props.getProperty(key).getBytes("ISO8859-1"), encode));
        } catch (Exception e) {
            return def;
        }
    }
}
