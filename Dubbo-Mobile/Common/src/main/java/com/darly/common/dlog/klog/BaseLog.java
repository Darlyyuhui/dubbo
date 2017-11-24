package com.darly.common.dlog.klog;

import android.util.Log;

import com.darly.common.DLog;
/**基础日志类。
 * @author Darly/张宇辉/2017/11/23 14:18
 * @version 1.0/com.darly.common
 */
public class BaseLog {

    private static final int MAX_LENGTH = 4000;

    public static void printDefault(int type, String tag, String msg) {

        int index = 0;
        int length = msg.length();
        int countOfSub = length / MAX_LENGTH;

        if (countOfSub > 0) {
            for (int i = 0; i < countOfSub; i++) {
                String sub = msg.substring(index, index + MAX_LENGTH);
                printSub(type, tag, sub);
                index += MAX_LENGTH;
            }
            printSub(type, tag, msg.substring(index, length));
        } else {
            printSub(type, tag, msg);
        }
    }

    private static void printSub(int type, String tag, String sub) {
        switch (type) {
            case DLog.V:
                Log.v(tag, sub);
                break;
            case DLog.D:
                Log.d(tag, sub);
                break;
            case DLog.I:
                Log.i(tag, sub);
                break;
            case DLog.W:
                Log.w(tag, sub);
                break;
            case DLog.E:
                Log.e(tag, sub);
                break;
            case DLog.A:
                Log.wtf(tag, sub);
                break;
        }
    }

}
