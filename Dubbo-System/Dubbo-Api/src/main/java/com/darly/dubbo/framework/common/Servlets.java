package com.darly.dubbo.framework.common;

import org.springframework.util.Assert;

import javax.servlet.ServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/5 17:01
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public class Servlets {
    public Servlets() {
    }

    public static Map<String, Object> getParametersStartingWith(ServletRequest request, String prefix) {
        Assert.notNull(request, "Request must not be null");
        Enumeration paramNames = request.getParameterNames();
        Map<String, Object> params = new TreeMap();
        if (prefix == null) {
            prefix = "";
        }

        while(paramNames != null && paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            if ("".equals(prefix) || paramName.startsWith(prefix)) {
                String unprefixed = paramName.substring(prefix.length());
                String[] values = request.getParameterValues(paramName);
                String[] var10 = values;
                int var9 = values.length;

                for(int var8 = 0; var8 < var9; ++var8) {
                    String string = var10[var8];
                    string = StringDiyUtils.getUTF8(string);
                }

                if (values != null && values.length != 0) {
                    if (values.length > 1) {
                        params.put(unprefixed, values);
                    } else if (!"".equals(values[0])) {
                        params.put(unprefixed, values[0].trim());
                    }
                }
            }
        }

        return params;
    }

    public static String encodeParameterStringWithPrefix(Map<String, Object> params, String prefix) {
        if (params != null && params.size() != 0) {
            if (prefix == null) {
                prefix = "";
            }

            StringBuilder queryStringBuilder = new StringBuilder();

            try {
                Iterator it = params.entrySet().iterator();

                while(it.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry)it.next();
                    if (entry.getValue() != null) {
                        queryStringBuilder.append(prefix).append((String)entry.getKey()).append('=').append(URLEncoder.encode(entry.getValue().toString(), "utf-8"));
                        if (it.hasNext()) {
                            queryStringBuilder.append('&');
                        }
                    }
                }
            } catch (UnsupportedEncodingException var5) {
            }

            return queryStringBuilder.toString();
        } else {
            return "";
        }
    }

    public static String encodeParameterStringWithPrefixByPost(Map<String, Object> params, String prefix) {
        if (params != null && params.size() != 0) {
            if (prefix == null) {
                prefix = "";
            }

            StringBuilder queryStringBuilder = new StringBuilder();

            try {
                Iterator it = params.entrySet().iterator();

                while(it.hasNext()) {
                    Map.Entry<String, Object> entry = (Map.Entry)it.next();
                    if (entry.getValue() != null) {
                        String valuestr = entry.getValue().toString();
                        String valuetemp = StringDiyUtils.removets(valuestr);
                        queryStringBuilder.append(prefix).append((String)entry.getKey()).append('=').append(valuetemp);
                        if (it.hasNext()) {
                            queryStringBuilder.append('&');
                        }
                    }
                }
            } catch (Exception var7) {
            }

            return queryStringBuilder.toString();
        } else {
            return "";
        }
    }
}
