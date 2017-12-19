package com.darly.dubbo.mobile.cfg;

import com.darly.dubbo.fileupload.cfg.FTPUtils;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.mobile.session.SessionData;
import com.darly.dubbo.mobile.session.SessionUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/14
 * TODO :
 */
public class MobileBaseController {
    public Logger logger = new Logger(getClass());
    //--------------------------实现前端接口返回格式-----------------------------------------
    Map<String, Object> resultMap;
    /**
     * 默认页码
     */
    int pageNo = 1;

    /**
     * 默认页数
     */
    int pageSize = 20;

    /**
     * 初始化返回结果集
     */
    protected void initResultMap() {
        resultMap = new HashMap<>();
    }

    /**
     *  正确接口数据返回
     */
    protected void dataResult(String code, String desc, Object data, HttpServletRequest request, HttpServletResponse response) {
        this.initResultMap();
        resultMap.put(ResponseUtil.RES_KEY_CODE, code);
        resultMap.put(ResponseUtil.RES_KEY_DESC, desc);
        resultMap.put(ResponseUtil.RES_KEY_RESULT, data);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /**
     * 简单格式返回
     */
    protected void simpleResult(String code, String desc, HttpServletRequest request, HttpServletResponse response) {
        this.initResultMap();
        resultMap.put(ResponseUtil.RES_KEY_CODE, code);
        resultMap.put(ResponseUtil.RES_KEY_DESC, desc);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }


    /**
     * 获取当前登录人信息
     * @param request
     * @return
     */
    public SessionData getLoginData(HttpServletRequest request) {
        Object user = SessionUtil.SESSION_MAP.get(SessionUtil.makeSessionKey(request));

        return (SessionData)user;
    }
    /**
     * 获取登录人信息
     * @param account
     * @param imei
     * @return
     */
    protected SessionData getLoginUser(String account,String imei){
        Object user = SessionUtil.SESSION_MAP.get(SessionUtil.makeSessionKey(account, imei));

        return (SessionData)user;
    }
    /**
     * 获取当前登录人ID
     * @param request
     * @return
     */
    public String getLoginId(HttpServletRequest request) {
        SessionData sd = this.getLoginData(request);
        return sd.getId();
    }


    /** 图片上传到FTP服务器中
     * @param file 传递的图片信息集合
     * @param request
     * @param response
     * @throws IOException
     */
    public void fileupload(MultipartFile[] file,
                           HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获得物理路径webapp所在路径
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<String> listImagePath=new ArrayList<String>();
        try {
            FTPUtils t = new FTPUtils();
            for (MultipartFile mf : file) {
                if(!mf.isEmpty()){
                    // 获取旧的名字
                    String oldName = mf.getOriginalFilename();
                    //新名字
                    String uuid = UUID.randomUUID().toString().replaceAll("-","");
                    String filename = uuid+oldName.substring(oldName.lastIndexOf("."));
                    File dest = new File(filename);
                    mf.transferTo(dest);
                    t.upload(dest);
                    listImagePath.add(t.getFtpsavepath()+"/"+filename);
                }
            }
            t.destroy();
            resultMap.put(ResponseUtil.RES_KEY_RESULT, listImagePath);
            ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
        }catch (Exception e){
            ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
        }
    }
}
