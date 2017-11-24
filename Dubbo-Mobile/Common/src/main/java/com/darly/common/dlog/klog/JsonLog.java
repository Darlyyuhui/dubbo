package com.darly.common.dlog.klog;

import android.util.Log;
import com.darly.common.DLog;
import com.darly.common.dlog.DLogUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * 输出JSON工具类。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class JsonLog {

    public static void printJson(String tag, String msg, String headString) {

        String message;

        try {
            if (msg.startsWith("{")) {
                JSONObject jsonObject = new JSONObject(msg);
                message = jsonObject.toString(DLog.JSON_INDENT);
            } else if (msg.startsWith("[")) {
                JSONArray jsonArray = new JSONArray(msg);
                message = jsonArray.toString(DLog.JSON_INDENT);
            } else {
                message = msg;
            }
        } catch (JSONException e) {
            message = msg;
        }

        DLogUtil.printLine(tag, true);
        message = headString + DLog.LINE_SEPARATOR + message;
        String[] lines = message.split(DLog.LINE_SEPARATOR);
        for (String line : lines) {
            Log.d(tag, "║ " + line);
        }
        DLogUtil.printLine(tag, false);
    }
}
