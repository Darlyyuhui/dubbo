package com.darly.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 网络工具类
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class NetUtils {
	public static final String SUCCESS = "success";
	public static final String FAILED = "failed";
    public static String Ping(String str) {
            Process p;
            try {
                //ping -c 3 -w 100  ��  ��-c ��ָping�Ĵ��� 3��ָping 3�� ��-w 2  ����Ϊ��λָ����ʱ�������ָ��ʱʱ��Ϊ2��
                p = Runtime.getRuntime().exec("ping -c 3 -w 2 " + str);
  
                InputStream input = p.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = in.readLine()) != null){
                  buffer.append(line);
                }
                Log.d("NetUtils.Ping", "ping result is " + buffer.toString());
                String ex = "[0-9]*%";
                Pattern pattern = Pattern.compile(ex);
                Matcher matcher = pattern.matcher(buffer.toString());
                if (matcher.find() && matcher.group().startsWith("0")) {
                	return SUCCESS;
                } else {
                	return FAILED;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } 

        return FAILED;
    } 
    
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager connectivity = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) {
			return false;
		} else {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void networkStateTips(Context context) {
		if (!isNetworkAvailable(context)) {
			Toast.makeText(context, "未连接网络，请检查网络设置！", Toast.LENGTH_LONG).show();
		}
	}

	public static boolean isWifiEnabled(Context context) {
		ConnectivityManager mgrConn = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		TelephonyManager mgrTel = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return ((mgrConn.getActiveNetworkInfo() != null && mgrConn
				.getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || mgrTel
				.getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);
	}

	public static boolean isWifi(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		if (activeNetInfo != null
				&& activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
			return true;
		}
		return false;
	}

	public static boolean is3G(Context context) {
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		if (activeNetInfo != null
				&& activeNetInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
			return true;
		}
		return false;
	}
    
}
