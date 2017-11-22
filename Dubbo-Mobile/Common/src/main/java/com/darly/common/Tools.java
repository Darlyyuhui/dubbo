package com.darly.common;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @package: com.huatek.api.utils
 * @ClassName: Tools
 * @Description: 工具类
 * @author: aaron_han
 * @data: 2015-07-16 下午5:03:23
 */
@SuppressLint("SimpleDateFormat")
public class Tools {

    /**
     * @param IDStr
     * @return
     * @throws ParseException
     * @Description: 校验驾驶证号合法性
     */
    public static boolean isIDCardValidate(String IDStr) {
        String[] ValCodeArr = {"1", "0", "x", "9", "8", "7", "6", "5", "4",
                "3", "2"};
        String[] Wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7",
                "9", "10", "5", "8", "4", "2"};
        String Ai = "";
        // ================ 号码的长度 15位或18位 ================
        if (IDStr.length() != 15 && IDStr.length() != 18) {
            ToastApp.showToast("驾驶证号码长度应该为15位或18位。");
            return false;
        }
        // =======================(end)========================  

        // ================ 数字 除最后以为都为数字 ================  
        if (IDStr.length() == 18) {
            Ai = IDStr.substring(0, 17);
        } else if (IDStr.length() == 15) {
            Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
        }
        if (isNumeric(Ai) == false) {
            ToastApp.showToast("驾驶证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。");
            return false;
        }
        // =======================(end)========================  

        // ================ 出生年月是否有效 ================  
        String strYear = Ai.substring(6, 10);// 年份
        String strMonth = Ai.substring(10, 12);// 月份
        String strDay = Ai.substring(12, 14);// 月份
        if (isDataFormat(strYear + "-" + strMonth + "-" + strDay) == false) {
            ToastApp.showToast("驾驶证号中生日无效。");
            return false;
        }
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(
                    strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                ToastApp.showToast("驾驶证号中生日不在有效范围。");
                return false;
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
        if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
            ToastApp.showToast("驾驶证号中月份无效");
            return false;
        }
        if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
            ToastApp.showToast("驾驶证号中日期无效");
            return false;
        }
        // =====================(end)=====================  

        // ================ 地区码时候有效 ================  
        Hashtable h = GetAreaCode();
        if (h.get(Ai.substring(0, 2)) == null) {
            ToastApp.showToast("驾驶证号码地区编码错误。");
            return false;
        }
        // ==============================================  

        // ================ 判断最后一位的值 ================  
        int TotalmulAiWi = 0;
        for (int i = 0; i < 17; i++) {
            TotalmulAiWi = TotalmulAiWi
                    + Integer.parseInt(String.valueOf(Ai.charAt(i)))
                    * Integer.parseInt(Wi[i]);
        }
        int modValue = TotalmulAiWi % 11;
        String strVerifyCode = ValCodeArr[modValue];
        Ai = Ai + strVerifyCode;

        if (IDStr.length() == 18) {
            if (Ai.equals(IDStr) == false) {
                ToastApp.showToast("驾驶证无效，不是合法的驾驶证号码");
                return false;
            }
        } else {
            return true;
        }
        // =====================(end)=====================  
        return true;
    }

    /**
     * 功能：设置地区编码
     *
     * @return Hashtable 对象
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static Hashtable GetAreaCode() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     * 验证日期字符串是否是YYYY-MM-DD格式
     *
     * @param str
     * @return
     */
    private static boolean isDataFormat(String str) {
        boolean flag = false;
        // String  
        // regxStr="[1-9][0-9]{3}-[0-1][0-2]-((0[1-9])|([12][0-9])|(3[01]))";  
        String regxStr = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
        Pattern pattern1 = Pattern.compile(regxStr);
        Matcher isNo = pattern1.matcher(str);
        if (isNo.matches()) {
            flag = true;
        }
        return flag;
    }

    // 判断字符串是否为邮件格式
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isSpecialCharacter(String str) {

        String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static boolean isSpecialCharacterBut(String str) {

        String regEx = "[`~!@#$%^&*()+=|{}':;'\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static boolean isCarnumberNO(String carnumber) {
        /*
         * 车牌号格式：汉字 + A-Z + 5位A-Z或0-9 （只包括了普通车牌号，教练车和部分部队车等车牌号不包括在内）
		 */
        String carnumRegex = "[\u4e00-\u9fa5]{1}[A-Z]{1}([A-Z_0-9]{5}|[A-Z_0-9]{4}[\u4e00-\u9fa5]{1})";
        if (TextUtils.isEmpty(carnumber))
            return false;
        else
            return carnumber.matches(carnumRegex);
    }

    public static boolean isSpecialCharacterContact(String str) {
        String regEx = "[{~!@#$￥%^&*<>,.:;?'=\\+|}/()]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    // 判断是否为手机号码
    public static boolean isPhoneNumber(String number) {
        if (number != null) {
            String value = number;
            if (number.length() == 11) {
                String regExp = "^[1]([38][0-9]{1}|[4][75]|[5][012356789]|[7][0678])[0-9]{8}$";
                Pattern p = Pattern.compile(regExp);
                Matcher m = p.matcher(value);
                return m.find();
            } else if (number.length() == 12 || number.length() == 13) {
                String regExp = "^\\d{3}-\\d{8}|\\d{4}-\\d{7,8}$";
                Pattern p = Pattern.compile(regExp);
                Matcher m = p.matcher(value);
                return m.find();
            }
            return false;
        } else {
            return false;
        }
    }

    public static boolean isCardNo(String idNum) {
        idNum = idNum.toUpperCase();
        String regex = "([0-9]{17}([0-9]|X))|([0-9]{15})";
        Pattern birthDatePattern = Pattern.compile(regex);
        Matcher birthDateMather = birthDatePattern.matcher(idNum);
        if (birthDateMather.find()) {
            return true;
        } else {
            return false;
        }
    }

    // 格式化日期
    public static String getCurrentDate(String dateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(Long.valueOf(dateTime) * 1000);
        return date;
    }

    // 格式化日期
    public static String getConsumerNoteTime(String dateTime) {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = formatter.format(Long.valueOf(dateTime) * 1000);
        // 今年不显示年份
        if (date.substring(0, 4).equals(String.valueOf(year))) {
            return date.substring(5, date.length());
        } else {
            return date;
        }
    }

    public static String getDateFormat(long l) {
        Date d = new Date(l);
        GregorianCalendar g1 = new GregorianCalendar();
        GregorianCalendar g2 = new GregorianCalendar();
        g2.setTime(d);
        if (g1.get(Calendar.YEAR) == g2.get(Calendar.YEAR)) {
            SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd");
            return sdf2.format(d);
        } else {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            return sdf1.format(d);
        }
    }

    // 只显示月-日格式的日期字符串_by_maogy
    public static String getMDData(String dateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
        return formatter.format(Long.valueOf(dateTime) * 1000);
    }

    /**
     * 设置前景色
     *
     * @param str   目标字符串
     * @param start 开始位置
     * @param end   结束位置
     * @param color 颜色值 如Color.BLACK
     * @return
     */
    public static SpannableString getForegroundColorSpan(String str, int start, int end, int color) {
        SpannableString ss = new SpannableString(str);
        ss.setSpan(new ForegroundColorSpan(color), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }

    // 获取手机唯一标识
    public static String getDeviceId(Activity act) {
        TelephonyManager mTelephonyMgr = (TelephonyManager) act.getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyMgr.getDeviceId();
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int Px2Dp(Context context, float px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @param fontScale （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 设置字体大小，用px
     *
     * @param context
     * @param str     目标字符串
     * @param start   开始位置
     * @param end     结束位置
     * @param pxSize  像素大小
     * @return
     */
    public static SpannableString getSizeSpanUsePx(String str, int start, int end, int pxSize) {
        SpannableString ss = new SpannableString(str);
        ss.setSpan(new AbsoluteSizeSpan(pxSize), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ss;
    }

    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 1500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    // 获取屏幕分辨率
    public static int[] getScreenPixel(Activity context) {
        int[] pixel = new int[2];
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        int width = mDisplayMetrics.widthPixels;
        int height = mDisplayMetrics.heightPixels;
        pixel[0] = width;
        pixel[1] = height;
        return pixel;
    }

    /**
     * @throws
     * @Title:
     * @Description:递归统计文件夹大小
     * @param: @param f
     * @param: @return
     * @param: @throws Exception
     * @return: long
     */
    public static long getFileSize(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSize(flist[i]);
            } else {
                size = size + flist[i].length();
            }
        }
        return size;
    }

    public static void deleteFile(File file) {
        if (file.exists()) { // 判断文件是否存在
            if (file.isFile()) { // 判断是否是文件
                file.delete(); // delete()方法 你应该知道 是删除的意思;
            } else if (file.isDirectory()) { // 否则如果它是一个目录
                File files[] = file.listFiles(); // 声明目录下所有的文件 files[];
                for (int i = 0; i < files.length; i++) { // 遍历目录下所有的文件
                    deleteFile(files[i]); // 把每个文件 用这个方法进行迭代
                }
            }
            file.delete();
        } else {
            System.out.println("所删除的文件不存在！" + '\n');
        }
    }

    public static StringBuilder sb;

    static {
        sb = new StringBuilder();
    }

    public static StringBuilder getSB() {
        return sb.delete(0, sb.length());
    }

    /**
     * @return
     * @throws
     * @Title:
     * @Description: 计算总页数
     * @param: @param result
     * @return: void
     */
    public static int getTotalPage(int k) {
        float i = (float) (k / 10.0);
        int j = k / 10;
        if (i > j) {
            return k / 10 + 1;
        } else {
            return k / 10;
        }
    }

    public static String getDecimalFormatTwo(float d) {
        DecimalFormat df = new DecimalFormat("#.#");
        if (d > (int) d) {
            return df.format(d);
        } else {
            return "" + (int) d;
        }
    }

    public static void ETDecimalFormatTwo(final EditText et) {
        et.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String temp = s.toString();
                int d = temp.indexOf(".");
                if (d < 0) {
                    return;
                } else {
                    if (temp.length() - d - 1 > 2) {
                        s.delete(d + 3, d + 4);
                    } else if (d == 0) {
                        s.delete(d, d + 1);
                    } else if (d == 6) {
                        s.delete(d, d + 1);
                    }
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    // 重新计算lisView 的高度
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    // 重新计算lisView 的高度
    public static boolean getUpdataOneDay(long time_start, long time_end) {
        long time = 0;
        if (time_start > time_end) {
            time = time_end - time_start;
        } else {
            time = time_start - time_end;
        }
        if (time > 86400000) {
            return true;
        } else {
            return false;
        }
    }

    // 字符串大于多少省略号结尾
    public static String subStringCN(final String str, final int maxLength) {
        if (str == null) {
            return str;
        }
        String suffix = "...";
        int suffixLen = suffix.length();

        final StringBuffer sbuffer = new StringBuffer();
        final char[] chr = str.trim().toCharArray();
        int len = 0;
        for (int i = 0; i < chr.length; i++) {

            if (chr[i] >= 0xa1) {
                len += 2;
            } else {
                len++;
            }
        }

        if (len <= maxLength) {
            return str.replace(" ", "");
        }

        len = 0;
        for (int i = 0; i < chr.length; i++) {

            if (chr[i] >= 0xa1) {
                len += 2;
                if (len + suffixLen > maxLength) {
                    break;
                } else {
                    sbuffer.append(chr[i]);
                }
            } else {
                len++;
                if (len + suffixLen > maxLength) {
                    break;
                } else {
                    sbuffer.append(chr[i]);
                }
            }
        }
        sbuffer.append(suffix);
        return sbuffer.toString().replace(" ", "");
    }

    public static String number3Add(String str1) {
        str1 = new StringBuilder(str1).reverse().toString(); // 先将字符串颠倒顺序
        String str2 = "";
        for (int i = 0; i < str1.length(); i++) {
            if (i * 3 + 3 > str1.length()) {
                str2 += str1.substring(i * 3, str1.length());
                break;
            }
            str2 += str1.substring(i * 3, i * 3 + 3) + ",";
        }
        if (str2.endsWith(",")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        // 最后再将顺序反转过来
        // System.err.println(new StringBuilder(str2).reverse().toString());
        return new StringBuilder(str2).reverse().toString();
    }

    // 判断是否是汉字
    public static boolean chontainsChinese(String s) {
        if (null == s || "".equals(s.trim()))
            return false;
        return !s.matches("[\\u4E00-\\u9FA5A-Za-z]+");
    }

    /**
     * @throws
     * @Title:
     * @Description: 没有一个汉字和字母
     * @param: @param s
     * @param: @return
     * @return: boolean
     */
    public static boolean iSnullityString(String s) {
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (!chontainsChinese(s.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isChinese(char ch) {

        if (Character.getType(ch) == Character.OTHER_LETTER) {
            DLog.e("chinese_leter:" + ch);
        }
        // 数字
        else if (Character.isDigit(ch)) {
            DLog.e("digit:" + ch);
        }
        // 字母
        else if (Character.isLetter(ch)) {
            DLog.e("letter:" + ch);
        }
        // 其它字符
        else {
            DLog.e("others:" + ch);
        }
        int c = (int) ch;
        if ((c >= 0x0391 && c <= 0xFFE5) // 中文字符
                || (c >= 0x0000 && c <= 0x00FF)) // 英文字符
            return true;
        return false;
    }

    public static String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            DLog.e("WifiPreference IpAddress" + ex.toString());
        }
        return null;
    }

    /**
     * 获取当前ip地址
     *
     * @param context
     * @return
     */
    public static String getLocalIpAddress(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            int i = wifiInfo.getIpAddress();
            return int2ip(i);
        } catch (Exception ex) {
            return " 获取IP出错鸟!!!!请保证是WIFI,或者请重新打开网络!\n" + ex.getMessage();
        }
    }

    /**
     * 将ip的整数形式转换成ip形式
     *
     * @param ipInt
     * @return
     */
    public static String int2ip(int ipInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(ipInt & 0xFF).append(".");
        sb.append((ipInt >> 8) & 0xFF).append(".");
        sb.append((ipInt >> 16) & 0xFF).append(".");
        sb.append((ipInt >> 24) & 0xFF);
        return sb.toString();
    }

    public static String dayToMonth(float day) {
        if (day >= 30) {
            int month = (int) (day / 30);
            int day2 = (int) (day - month * 30);
            if (day2 <= 0) {
                return Tools.getSB().append(month).append("个月").toString();
            } else {
                return Tools.getSB().append(month).append("个月").append(day2).append("天").toString();
            }
        } else {
            // if (day < 1) {
            // day = 1;
            // }
            return Tools.getSB().append((int) day).append("天").toString();
        }
    }

    public static String MonthToMD(float mPeriod) {
        StringBuilder sBuilder = new StringBuilder();
        int periodM = (int) mPeriod;
        int periodD = (int) ((mPeriod - periodM) * 30);
        if (periodM != 0) {
            sBuilder.append(periodM).append("个月");
        }
        if (periodM == 0 || periodD != 0) {
            sBuilder.append(periodD).append("天");
        }
        return sBuilder.toString();
    }
}
