package com.darly.dubbo.security.securitycfg.encoder;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 16:12
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：MD5给密码加密
 */
public class Md5PwdEncoder implements PwdEncoder {
    private String defaultSalt;

    public Md5PwdEncoder() {
        System.out.println("------>Md5PwdEncoder");
    }

    public String encodePassword(String rawPass) {
        return this.encodePassword(rawPass, this.defaultSalt);
    }

    public String encodePassword(String rawPass, String salt) {
        String saltedPass = this.mergePasswordAndSalt(rawPass, salt, false);
        MessageDigest messageDigest = this.getMessageDigest();

        byte[] digest;
        try {
            digest = messageDigest.digest(saltedPass.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported!");
        }

        return new String(Hex.encodeHex(digest));
    }

    public boolean isPasswordValid(String encPass, String rawPass) {
        return this.isPasswordValid(encPass, rawPass, this.defaultSalt);
    }

    public boolean isPasswordValid(String encPass, String rawPass, String salt) {
        if (encPass == null) {
            return false;
        } else {
            String pass2 = this.encodePassword(rawPass, salt);
            return encPass.equals(pass2);
        }
    }

    protected final MessageDigest getMessageDigest() {
        String algorithm = "MD5";

        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm [" + algorithm + "]");
        }
    }

    protected String mergePasswordAndSalt(String password, Object salt, boolean strict) {
        if (password == null) {
            password = "123456";
        }

        if (strict && salt != null && (salt.toString().lastIndexOf("{") != -1 || salt.toString().lastIndexOf("}") != -1)) {
            throw new IllegalArgumentException("Cannot use { or } in salt.toString()");
        } else {
            return salt != null && !"".equals(salt) ? password + "{" + salt.toString() + "}" : password;
        }
    }


    public String getDefaultSalt() {
        return this.defaultSalt;
    }

    public void setDefaultSalt(String defaultSalt) {
        this.defaultSalt = defaultSalt;
    }
}
