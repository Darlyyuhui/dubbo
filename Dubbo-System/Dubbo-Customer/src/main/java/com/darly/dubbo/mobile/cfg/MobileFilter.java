package com.darly.dubbo.mobile.cfg;

import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.mobile.session.SessionData;
import com.darly.dubbo.mobile.session.SessionUtil;
import com.darly.dubbo.security.securitycfg.SpringSecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/4
 * TODO : 请求拦截
 */
public class MobileFilter extends MobileBaseController implements HandlerInterceptor {
    private Logger logger = new Logger(MobileFilter.class);

    private int time =1000;
    //在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (SpringSecurityUtils.getCurrentUser() != null) {
            return true;
        } else {
            Map<String, Object> resultMap = new HashMap<>();
            Object user = SessionUtil.SESSION_MAP.get(SessionUtil.makeSessionKey(request));
            if (user == null) {
                //用户未登录。session中无值
                logger.info("This user is not logged in. session is null.");
                resultMap.put(ResponseUtil.RES_KEY_CODE, "201");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "用户未登录。");
                ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
                return false;
            }
            SessionData sd = (SessionData)user;
            String imei = request.getHeader("imei");
            if (!imei.equals(sd.getImei())) {
                //用户已在其他设备登录
                logger.info("The user has logged on to another device.");
                resultMap.put(ResponseUtil.RES_KEY_CODE, "202");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "用户已在其他设备登录。");
                ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
                return false;
            }
            String account = request.getHeader("account");
            if (!account.equals(sd.getAccount())) {
                //该用户未登录。session中用户信息与请求信息不一致
                logger.info("This user is not logged in. User information is not consistent with request information in session.");
                resultMap.put(ResponseUtil.RES_KEY_CODE, "201");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "该用户未登录。");
                ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
                return false;
            }
            //记录用户最后操作时间
            Date da = SessionUtil.LAST_OPERATION_MAP.get(SessionUtil.makeSessionKey(request));
            if (da.getTime()+time*1000<System.currentTimeMillis()){
                resultMap.put(ResponseUtil.RES_KEY_CODE, "201");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "登录超时，请重新登录");
                ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
                return false;
            }
            SessionUtil.LAST_OPERATION_MAP.put(SessionUtil.makeSessionKey(request), new Date());
            return true;
        }
    }

    /**
     * 该方法将在Controller执行之后，返回视图之前执行，ModelMap表示请求Controller处理之后返回的Model对象，所以可以在
     * 这个方法中修改ModelMap的属性，从而达到改变返回的模型的效果。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 该方法将在整个请求完成之后，也就是说在视图渲染之后进行调用，主要用于进行一些资源的释放
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}