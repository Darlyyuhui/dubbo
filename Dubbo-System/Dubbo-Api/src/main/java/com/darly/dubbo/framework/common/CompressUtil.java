package com.darly.dubbo.framework.common;

import org.apache.commons.codec.CharEncoding;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Author : ZhangYuHui
 * Date : 2018/2/28
 * TODO : 壓縮擠壓使用方案
 */
public class CompressUtil {
    // 压缩
    public static byte[] compress(byte[] data) throws IOException {
        if (data == null || data.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(data);
        gzip.close();
        return  out.toByteArray();//out.toString("ISO-8859-1");
    }

    // 解压缩
    public static byte[] uncompress(byte[] data) throws IOException {
        if (data == null || data.length == 0) {
            return data;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        gunzip.close();
        in.close();
        return out.toByteArray();
    }
    // 压缩
    public static String compreser(byte[] data) throws IOException {
        if (data == null || data.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(data);
        gzip.close();
        String result = new String(out.toByteArray(), CharEncoding.ISO_8859_1);
        System.out.println("compreser result = "+result);
        return  result;
    }

    // 解压缩
    public static String uncompreser(String str,String chaster) throws IOException {
        if (StringDiyUtils.isEmpty(str)) {
            return null;
        }
        byte[] data = str.getBytes(CharEncoding.ISO_8859_1);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        gunzip.close();
        in.close();
        String result = new String(out.toByteArray(),chaster);
        System.out.println("uncompreser result = "+result);
        return  result;
    }

    public static String uncompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        byte[] data = uncompress(str.getBytes("utf-8")); // ISO-8859-1
        return new String(data);
    }
    /**
     * @Title: unZip
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param unZipfile
     * @param @param destFile 指定读取文件，需要从压缩文件中读取文件内容的文件名
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    public static String unZip(String unZipfile, String destFile) {// unZipfileName需要解压的zip文件名
        InputStream inputStream;
        String inData = null;
        try {
            // 生成一个zip的文件
            File f = new File(unZipfile);
            ZipFile zipFile = new ZipFile(f);

            // 遍历zipFile中所有的实体，并把他们解压出来
            ZipEntry entry = zipFile.getEntry(destFile);
            if (!entry.isDirectory()) {
                // 获取出该压缩实体的输入流
                inputStream = zipFile.getInputStream(entry);

                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] bys = new byte[4096];
                for (int p = -1; (p = inputStream.read(bys)) != -1;) {
                    out.write(bys, 0, p);
                }
                inData = out.toString();
                out.close();
                inputStream.close();
            }
            zipFile.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return inData;
    }



    /**
     * 通过接口compactString()的压缩方式进行解压
     * @param tempString
     * @return
     */
    public static String decompressionString(String tempString){
        char[] tempBytes = tempString.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < tempBytes.length; i++) {
            char c = tempBytes[i];
            char firstCharacter = (char) (c >>> 8);
            char secondCharacter = (char) ((byte)c);
            sb.append(firstCharacter);
            if(secondCharacter != 0)
                sb.append(secondCharacter);
        }
        return sb.toString();
    }


    /**
     * 对需要进行压缩的字符串进行压缩，返回一个相对较小的字符串
     * @param tempString
     * @return
     */
    public static String compactString(String tempString) {
        StringBuffer sb = new StringBuffer();
        byte[] tempBytes = tempString.getBytes();
        for (int i = 0; i < tempBytes.length; i+=2) {
            char firstCharacter = (char)tempBytes[i];
            char secondCharacter = 0;
            if(i+1<tempBytes.length)
                secondCharacter = (char)tempBytes[i+1];
            firstCharacter <<= 8;
            sb.append((char)(firstCharacter+secondCharacter));
        }
        return sb.toString();
    }

}
