package test;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2018/2/28
 * TODO :
 */
public class HttpClientHelper {


    /**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param params 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static byte[]  sendPost(String url, Map<String, String> params) {
        PrintWriter out = null;
        byte[] result = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            String paramsStr = "";   //拼接Post 请求的参数
            for(String param : params.keySet()){
                paramsStr += "&" + param + "=" + params.get(param);
            }
            if(!paramsStr.isEmpty()){
                paramsStr = paramsStr.substring(1);
            }
            out.print(paramsStr);
            // flush输出流的缓冲
            out.flush();
            InputStream is = conn.getInputStream();
            result = new byte[is.available()];
            is.read(result);
            is.close();
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
                if(out!=null){
                    out.close();
                }
        }
        return result;
    }
    /**
     * 向指定 URL 发送POST方法的请求
     * @param url 发送请求的 URL
     * @param params 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String  sendPost(String url, Map<String, String> params,String chaster) {
        PrintWriter out = null;
        String  result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            String paramsStr = "";   //拼接Post 请求的参数
            for(String param : params.keySet()){
                paramsStr += "&" + param + "=" + params.get(param);
            }
            if(!paramsStr.isEmpty()){
                paramsStr = paramsStr.substring(1);
            }
            out.print(paramsStr);
            // flush输出流的缓冲
            out.flush();
            //读取响应
            InputStream is = conn.getInputStream();
            byte[] results = new byte[is.available()];
            is.read(results);
            is.close();
            result = new String(results,chaster);
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
                if(out!=null){
                    out.close();
                }
        }
        return result;
    }
}

