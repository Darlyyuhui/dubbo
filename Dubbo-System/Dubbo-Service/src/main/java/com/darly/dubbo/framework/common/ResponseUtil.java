package com.darly.dubbo.framework.common;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Author : ZhangYuHui
 * Date : 2017/10/20
 * TODO :
 */
public class ResponseUtil {

	/**
	 * 返回的结果或结果集存放的键值
	 */
	public static final String RES_KEY_RESULT = "result";
	/**
	 * 返回的状态编号存放的键值
	 */
	public static final String RES_KEY_CODE = "resCode";
	/**
	 * 返回访问的时间
	 */
	public static final String RES_KEY_TIME ="resTime";
	/**
	 * 返回访问需要的id
	 */
	public static final String RES_KEY_ID ="resId";
	/**
	 * 返回访问需要的id
	 */
	public static final String RES_REGION_ID ="regionId";
	/**
	 * 返回的状态描述存放的键值
	 */
	public static final String RES_KEY_DESC = "resDesc";
	
	public static final String RES_KEY_PAGESIZE = "pageSize";
	
	public static final String RES_KEY_PAGE = "pageNo";
	
	public static final String RES_KEY_TOTALSIZE = "totalSize";
	
	public static final String RES_KEY_TOTALPAGE = "totalPage";
	
	@Deprecated
	public static void writeResponse(String jsonpStr, Object obj, HttpServletResponse response) {
		response.setContentType("text/json;charset=UTF-8");
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			String str = JsonUtil.toJson(obj);
			if (jsonpStr != null && !"".equals(jsonpStr)) {
				str = jsonpStr + "(" + str + ")";
			}
			os.write(str.getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null) {
					os.flush();
					os.close();
				}
			} catch (IOException e) {
				os = null;
			}
		}
	}
	
	public static void printWriteResponse(String jsonpStr, Object obj, HttpServletResponse response) {
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String str = JsonUtil.toJson(obj);
			if (jsonpStr != null && !"".equals(jsonpStr)) {
				str = jsonpStr + "(" + str + ")";
			}
			out.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}
	
}
