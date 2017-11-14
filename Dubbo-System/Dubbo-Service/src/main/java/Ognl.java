import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 17:13
 * @Modified By：Darly Fronch（张宇辉）
 * @Description： <if test="@Ognl@isNotEmpty(mobile)" >mapper裡面出現判斷兑现参数是否为空时需要用到
 */
public class Ognl {
    public Ognl() {
    }

    public static boolean isTrue(int a, int b) {
        return a == b;
    }

    public static boolean isTrue(Object a, Object b) {
        return a.equals(b);
    }

    public static boolean le(int a, int b) {
        return a < b;
    }

    public static boolean ge(int a, int b) {
        return a > b;
    }

    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if (o == null) {
            return true;
        } else {
            if (o instanceof String) {
                if (((String)o).length() == 0) {
                    return true;
                }
            } else if (o instanceof Collection) {
                if (((Collection)o).isEmpty()) {
                    return true;
                }
            } else if (o.getClass().isArray()) {
                if (Array.getLength(o) == 0) {
                    return true;
                }
            } else {
                if (!(o instanceof Map)) {
                    return false;
                }

                if (((Map)o).isEmpty()) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    public static boolean isNotBlank(Object o) {
        return !isBlank(o);
    }

    public static boolean isNumber(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Number) {
            return true;
        } else if (o instanceof String) {
            String str = (String)o;
            if (str.length() == 0) {
                return false;
            } else if (str.trim().length() == 0) {
                return false;
            } else {
                try {
                    Double.parseDouble(str);
                    return true;
                } catch (NumberFormatException var3) {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public static boolean isBlank(Object o) {
        if (o == null) {
            return true;
        } else if (o instanceof String) {
            String str = (String)o;
            return isBlank(str);
        } else {
            return false;
        }
    }

    public static boolean isNull(Object o) {
        if (o == null) {
            return true;
        } else if (o instanceof String) {
            String str = (String)o;
            return isNull(str);
        } else {
            return false;
        }
    }

    public static boolean isNull(String str) {
        return str == null;
    }

    public static boolean isNotNull(Object o) {
        return !isNull(o);
    }

    public static boolean isNotNull(String str) {
        return !isNull(str);
    }

    public static boolean isBlank(String str) {
        if (str != null && str.length() != 0) {
            for(int i = 0; i < str.length(); ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
}
