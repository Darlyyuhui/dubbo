package com.darly.dubbo.security;

import com.darly.dubbo.fileupload.cfg.FTPUtils;
import com.darly.dubbo.framework.systemlog.Logger;
import com.darly.dubbo.framework.systemlog.constant.Constant;
import com.darly.dubbo.mobile.cfg.ResponseUtil;
import com.darly.dubbo.security.securitycfg.SpringSecurityUtils;
import com.darly.dubbo.security.securitycfg.UserDetials;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/1
 * TODO :
 */
public class BaseSecurityController {

    public Logger logger = new Logger(getClass());

    protected void hasUser(ModelMap model){
        UserDetials user = getCurrentUser();
        if (user == null) {
            model.addAttribute("hasUser", false);
            logger.info("--->没有登录用户--->[方法 home 运行中...]");
        } else {
            logger.info("--->用户" + user.getAccount() + "--->[方法 home 运行中...]");
            model.addAttribute("hasUser", true);
            model.addAttribute("userName", user.getRealName());
            model.addAttribute("account", user.getId());
        }
    }

    /***
     * 获取登陆用户
     * @return
     */
    protected UserDetials getCurrentUser() {
        return SpringSecurityUtils.getCurrentUser();
    }

    /***
     * 获取登陆用户id
     * @return
     */
    protected String getCurrentUserId() {
        UserDetials userInfo = getCurrentUser();
        if (userInfo == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return userInfo.getId();
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


    /** 图片上传到FTP服务器中
     * @param file 传递的图片信息集合
     * @throws IOException
     */
    public List<String> fileupload(MultipartFile[] file) {
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
            return listImagePath;
        }catch (Exception e){
            return null;
        }
    }
    /** 图片上传到FTP服务器中
     * @param file 传递的图片信息集合
     * @throws IOException
     */
    public String fileupload(MultipartFile file) {
        //获得物理路径webapp所在路径
        String load = null;
        try {
            FTPUtils t = new FTPUtils();
                if(!file.isEmpty()){
                    // 获取旧的名字
                    String oldName = file.getOriginalFilename();
                    //新名字
                    String uuid = UUID.randomUUID().toString().replaceAll("-","");
                    String filename = uuid+oldName.substring(oldName.lastIndexOf("."));
                    File dest = new File(filename);
                    file.transferTo(dest);
                    t.upload(dest);
                    load = t.getFtpsavepath()+"/"+filename;
                }
            t.destroy();
            return load;
        }catch (Exception e){
            return null;
        }
    }

}
