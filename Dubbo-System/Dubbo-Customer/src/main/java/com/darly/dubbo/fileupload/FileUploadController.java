package com.darly.dubbo.fileupload;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.security.BaseSecurityController;
import com.darly.dubbo.security.user.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/19
 * TODO :
 */
@Controller
@RequestMapping("/file")
public class FileUploadController extends BaseSecurityController{

    @Autowired
    FileUploadApi fileupload;
    /**
     * @return 图片上传到静态服务器
     */
    @RequestMapping(value = {"/upload"}, method = RequestMethod.POST)
    public String fileupload(ModelMap model,User user , @RequestParam(value="file",required=false) MultipartFile[] file,
                             HttpServletRequest request, HttpServletResponse response) throws IOException {
        //基本表单
        System.out.println(user.toString());
        //获得物理路径webapp所在路径
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
        }catch (Exception e){
            System.out.println(e);
        }
        model.putAll(fileupload.fileupload());
        return  "redirect:"+model.get(ApplicationConst.getResourceUrl())+listImagePath.get(0);
    }
}
