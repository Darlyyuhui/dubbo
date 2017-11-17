package com.darly.dubbo.common;


import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 16:17
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public class DeEncryptUtil {
    private static String strDefaultKey = "darlyyuhui@hotmail.com";
    private Cipher encryptCipher;
    private Cipher decryptCipher;

    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        StringBuffer sb = new StringBuffer(iLen * 2);

        for(int i = 0; i < iLen; ++i) {
            int intTmp;
            for(intTmp = arrB[i]; intTmp < 0; intTmp += 256) {
            }

            if (intTmp < 16) {
                sb.append("0");
            }

            sb.append(Integer.toString(intTmp, 16));
        }

        return sb.toString();
    }

    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        byte[] arrOut = new byte[iLen / 2];

        for(int i = 0; i < iLen; i += 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte)Integer.parseInt(strTmp, 16);
        }

        return arrOut;
    }

    public DeEncryptUtil() throws Exception {
        this(strDefaultKey);
    }

    public DeEncryptUtil(String strKey) throws Exception {
        this.encryptCipher = null;
        this.decryptCipher = null;
        Key key = this.getKey(strKey.getBytes());
        this.encryptCipher = Cipher.getInstance("DES");
        this.encryptCipher.init(1, key);
        this.decryptCipher = Cipher.getInstance("DES");
        this.decryptCipher.init(2, key);
    }

    public byte[] encrypt(byte[] arrB) throws Exception {
        return this.encryptCipher.doFinal(arrB);
    }

    public String encrypt(String strIn) throws Exception {
        return byteArr2HexStr(this.encrypt(strIn.getBytes()));
    }

    public byte[] decrypt(byte[] arrB) throws Exception {
        return this.decryptCipher.doFinal(arrB);
    }

    public String decrypt(String strIn) throws Exception {
        try {
            return new String(this.decrypt(hexStr2ByteArr(strIn)));
        } catch (Exception var3) {
            return "";
        }
    }

    private Key getKey(byte[] arrBTmp) throws Exception {
        byte[] arrB = new byte[8];

        for(int i = 0; i < arrBTmp.length && i < arrB.length; ++i) {
            arrB[i] = arrBTmp[i];
        }

        Key key = new SecretKeySpec(arrB, "DES");
        return key;
    }
}
