package com.darly.common.dlog;

import android.text.TextUtils;
import android.util.Log;
/**
 * 日志工具类
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class DLogUtil {

    public static boolean isEmpty(String line) {
        return TextUtils.isEmpty(line) || line.equals("\n") || line.equals("\t") || TextUtils.isEmpty(line.trim());
    }

    public static void printLine(String tag, boolean isTop) {
        if (isTop) {
            Log.d(tag, "╔═══════════════════════════════════════════════════════════════════════════════════════");
        } else {
            Log.d(tag, "╚═══════════════════════════════════════════════════════════════════════════════════════");
        }
    }

}
