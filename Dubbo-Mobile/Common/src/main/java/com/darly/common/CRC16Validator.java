package com.darly.common;

import android.text.TextUtils;
import android.util.Log;

/**
 * 用于CRC校验码计算
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class CRC16Validator {

    private CRC16Validator(){
        throw new IllegalStateException("Utility class");
    }

    /***
     *判断是否数据一致
     * @param data 原始数据
     * @param orilCRC  原始的CRC码
     * @return boolean
     */
    public static boolean isValid(String data, String orilCRC){
    	
        if(TextUtils.isEmpty(data)) return false;
        if(TextUtils.isEmpty(orilCRC)) return false;
        String crc = getCRC(data.getBytes());
        Log.d("CRC16Validator","系统计算出的crc:"+crc);
        if(crc.length()<orilCRC.length()){
            StringBuilder sb = new StringBuilder();
            Log.d("CRC16Validator","crc位数不一致，正在补0");
            for (int i=0;i<orilCRC.length()-crc.length();i++){
                sb.append("0");
            }
            crc = sb.toString()+crc;
            Log.d("CRC16Validator","补位后的crc码："+crc);
        }
        return crc.toUpperCase().equals(orilCRC.toUpperCase());
    }


    /***
     *  计算CRC数据校验码
     * @param data 原始数据
     * @return String
     */
    public static String getCRC(byte[] data) {
        int high;
        int flag;
        // 16位寄存器，所有数位均为1
        int wcrc = 0xffff;
        for (int i = 0; i < data.length; i++) {
            // 16 位寄存器的高位字节
            high = wcrc >> 8;
            // 取被校验串的一个字节与 16 位寄存器的高位字节进行“异或”运算
            wcrc = high ^ data[i];

            for (int j = 0; j < 8; j++) {
                flag = wcrc & 0x0001;
                // 把这个 16 寄存器向右移一位
                wcrc = wcrc >> 1;
                // 若向右(标记位)移出的数位是 1,则生成多项式 1010 0000 0000 0001 和这个寄存器进行“异或”运算
                if (flag == 1){
                    wcrc ^= 0xa001;
                }
            }
        }
        return  Integer.toHexString(wcrc);

    }


}
