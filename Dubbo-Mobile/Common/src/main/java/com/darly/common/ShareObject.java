package com.darly.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/**
 * 保存对象到SharedPreferences中，进行缓存
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class ShareObject {

    private static  Context context ;

    private String fileName = "app_object";

    private static ShareObject instance = null;

    private ShareObject() {
    }

    public static ShareObject getInstance() {
        if (instance == null) {
            instance = new ShareObject();
        }
        return instance;
    }

    public void setContext(Context cxt) {
        ShareObject.context = cxt;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public static void putValue(String key, int postion) {
        Editor sp = context.getSharedPreferences(getInstance().getFileName(), Context.MODE_PRIVATE)
                .edit();
        sp.putInt(key, postion);
        sp.commit();
    }
    public static int getValue(String key, int df) {
        SharedPreferences sp = context.getSharedPreferences(getInstance().getFileName(),
                Context.MODE_PRIVATE);
        return sp.getInt(key,df);
    }

    /**保存对象
     * @param key 保存的标签
     * @param obj 要保存的对象，只能保存实现了serializable的对象
     */
    public static void putValue(String key, Object obj) {
        try {
            // 保存对象
            Editor sp = context.getSharedPreferences(getInstance().getFileName(), Context.MODE_PRIVATE)
                    .edit();
            //先将序列化结果写到byte缓存中，其实就分配一个内存空间
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            //将对象序列化写入byte缓存
            os.writeObject(obj);
            //将序列化的数据转为16进制保存
            String bytesToHexString = bytesToHexString(bos.toByteArray());
            //保存该16进制数组
            sp.putString(key, bytesToHexString);
            sp.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**将数组转为16进制
     * @param bArray 字节数组
     * @return String
     */
    public static String bytesToHexString(byte[] bArray) {
        if (bArray == null) {
            return null;
        }
        if (bArray.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }


    /**获取保存的Object对象
     * @param key 对象标签
     * @return Object
     */
    public static Object getValue(String key) {
        try {
            SharedPreferences sp = context.getSharedPreferences(getInstance().getFileName(),
                    Context.MODE_PRIVATE);
            if (sp.contains(key)) {
                String string = sp.getString(key, null);
                if (TextUtils.isEmpty(string)) {
                    return null;
                } else {
                    //将16进制的数据转为数组，准备反序列化
                    byte[] stringToBytes = StringToBytes(string);
                    ByteArrayInputStream bis = new ByteArrayInputStream(stringToBytes);
                    ObjectInputStream is = new ObjectInputStream(bis);
                    //返回反序列化得到的对象
                    Object readObject = is.readObject();
                    return readObject;
                }
            }
        } catch (StreamCorruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //所有异常返回null
        return null;

    }

    /**将16进制的数据转为数组
     * @param data 原数据
     * @return byte[]
     */
    public static byte[] StringToBytes(String data) {
        String hexString = data.toUpperCase().trim();
        if (hexString.length() % 2 != 0) {
            return null;
        }
        byte[] retData = new byte[hexString.length() / 2];
        for (int i = 0; i < hexString.length(); i++) {
            int int_ch;  // 两位16进制数转化后的10进制数
            char hex_char1 = hexString.charAt(i); ////两位16进制数中的第一位(高位*16)
            int int_ch3;
            if (hex_char1 >= '0' && hex_char1 <= '9')
                int_ch3 = (hex_char1 - 48) * 16;   //// 0 的Ascll - 48
            else if (hex_char1 >= 'A' && hex_char1 <= 'F')
                int_ch3 = (hex_char1 - 55) * 16; //// A 的Ascll - 65
            else
                return null;
            i++;
            char hex_char2 = hexString.charAt(i); ///两位16进制数中的第二位(低位)
            int int_ch4;
            if (hex_char2 >= '0' && hex_char2 <= '9')
                int_ch4 = (hex_char2 - 48); //// 0 的Ascll - 48
            else if (hex_char2 >= 'A' && hex_char2 <= 'F')
                int_ch4 = hex_char2 - 55; //// A 的Ascll - 65
            else
                return null;
            int_ch = int_ch3 + int_ch4;
            retData[i / 2] = (byte) int_ch;//将转化后的数放入Byte里
        }
        return retData;
    }


    /**移除某项
     * @param key 对象标签
     */
    public static void remove(String key) {
        SharedPreferences sp = context.getSharedPreferences(getInstance().getFileName(),
                Context.MODE_PRIVATE);
        Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

}
