package com.darly.dubbo.security.securitycfg.encoder;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 16:14
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public interface PwdEncoder {
    String encodePassword(String pwd);

    String encodePassword(String pwd, String pws);

    boolean isPasswordValid(String pwd, String code);

    boolean isPasswordValid(String pwd, String code, String pws);
}
