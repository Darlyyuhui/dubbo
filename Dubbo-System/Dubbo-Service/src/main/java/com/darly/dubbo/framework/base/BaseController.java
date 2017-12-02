package com.darly.dubbo.framework.base;

import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.obs.ObsApplication;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.framework.systemlog.constant.Constant;
import com.google.gson.JsonObject;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 18:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
public class BaseController {
    public static String applicationName = ObsApplication.getInstance().getApplicationName();
    public  static String resourceUrl = ObsApplication.getInstance().getResourceUrl();


    public static void refreshPar(){
        applicationName = ObsApplication.getInstance().getApplicationName();
        resourceUrl = ObsApplication.getInstance().getResourceUrl();
    }

    public Logger logger = new Logger(getClass());

    /***
     * 返回成功的json字符
     */
    protected  String returnJson(){
        JsonObject json = new JsonObject();
        json.addProperty("result", "ok");
        return json.toString();
    }


    /***
     * 返回失败的json字符
     */
    protected  String returnErrorJson(){
        JsonObject json = new JsonObject();
        json.addProperty("result", "error");
        return json.toString();
    }



    /***
     * 获取本产品是否为发布模式
     */
    protected boolean isRealse(ServletContext sc){
        Object object = sc.getAttribute(Constant.APPLICATION_CONTEXT_MODE);
        if(object!=null){
            String contextMode = object.toString();
            if(Constant.RELEASE_MODE.equals(contextMode)){
                return true;
            }
        }
        return false;
    }


    /**
     * 增加对模糊查询参数的修改，用于查询
     */
    protected void addLikeParmMap(Map<String, Object> searchParams, String[] parms) {
        if (parms == null) {
            return;
        }
        for (String parm : parms) {
            if(StringDiyUtils.notEmpty(searchParams.get(parm)+"") && null != searchParams.get(parm)) {
                searchParams.put(parm, "'%"+searchParams.get(parm).toString()+"%'");
            }
        }
    }
    /**
     * 删除对模糊查询参数的修改，用于展示
     */
    protected void removeLikeParmMap(Map<String, Object> searchParams, String[] parms) {
        if (parms == null) {
            return;
        }
        for (String parm : parms) {
            if(StringDiyUtils.notEmpty(searchParams.get(parm)+"") && null != searchParams.get(parm)) {
                searchParams.put(parm, searchParams.get(parm).toString().replace("'", "").replace("%", ""));
            }
        }
    }
}
