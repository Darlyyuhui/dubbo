package com.darly.dubbo.store;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.fileupload.FileUploadApi;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.mobile.cfg.ResponseUtil;
import com.darly.dubbo.security.BaseSecurityController;
import com.darly.dubbo.store.api.StoreOptionApi;
import com.darly.dubbo.store.bean.StoreActiviyType;
import com.darly.dubbo.store.bean.StoreImage;
import com.darly.dubbo.store.bean.StoreProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @Author: Darly Fronch（张宇辉）
 * @Date：Create in 2017/9/12 18:40
 * @Modified By：Darly Fronch（张宇辉）
 * @Description：
 */
@Controller
@RequestMapping({"/option"})
public class StoreOperationController extends BaseSecurityController {

    @Autowired
    StoreOptionApi storeOptionApi;
    @Autowired
    FileUploadApi fileUploadApi;

    /** 商城管理页面首页
     * @param model
     * @return
     */
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String optionIndex(ModelMap model){
        hasUser(model);
        model.putAll(storeOptionApi.optionIndex());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }
    /** 商品录入界面
     * @param model
     * @return
     */
    @RequestMapping(value = {"/productentry"}, method = RequestMethod.GET)
    public String productentry(ModelMap model){
        if (model.get("success")!=null){
            if ((boolean)model.get("success")){
                model.addAttribute("addProducet","添加成功！");
            }else {
                model.addAttribute("addProducet","添加失败，请查看数据库连接！");
            }
        }
        hasUser(model);
        model.putAll(storeOptionApi.productentry());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }
    /** ajax请求接口
     * @param model
     * @return
     */
    @RequestMapping(value = {"/productentryser"}, method = RequestMethod.POST)
    public void productentryser(ModelMap model,HttpServletRequest request, HttpServletResponse response){
        logger.info(model);
        List<StoreProduct> products = (List<StoreProduct>) storeOptionApi.productentry().get("STOREPRODUCT");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("status", "success");
        resultMap.put("totals", products.size());
        resultMap.put("data", products);
        logger.info("-------->resultMap"+resultMap);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }
    /** ajax请求接口
     * @param model
     * @return
     */
    @RequestMapping(value = {"/activityentryser"}, method = RequestMethod.POST)
    public void activityentryser(ModelMap model,HttpServletRequest request, HttpServletResponse response){
        logger.info(model);
        List<StoreActiviyType> types = (List<StoreActiviyType>) storeOptionApi.activityentry().get("STORETYPE");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("status", "success");
        resultMap.put("totals", types.size());
        resultMap.put("data", types);
        logger.info("-------->resultMap"+resultMap);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /** 商品录入操作
     * @param model
     * @return
     */
    @RequestMapping(value = {"/addProducet"}, method = RequestMethod.POST)
    public String addProducet(StoreProduct product, @RequestParam(value="file",required=false) MultipartFile[] file,RedirectAttributes attr){
        logger.info(product);
        if (product!=null){
            product.setId(UuidGenerateUtil.getUUIDLong());
            storeOptionApi.insertProduct(product);
        }
        List<String> urls= fileupload(file);
        List<StoreImage> images = new ArrayList<StoreImage>();
        if (urls!=null){
            for (String arg : urls) {
                StoreImage image = new StoreImage();
                image.setId(UuidGenerateUtil.getUUIDLong());
                image.setProductTypeId(product == null?null:product.getId());
                image.setImageUrl(arg);
                image.setImageDesc("新增图片");
                image.setImageUploadtime(new Date());
                images.add(image);
            }
        }else {
            logger.info("--------->没有传递图片！");
        }
        boolean isgood =  fileUploadApi.fileupload(images);
        attr.addFlashAttribute("success", isgood);
        return "redirect:/option/productentry";
    }

    /** 活动录入界面
     * @param model
     * @return
     */
    @RequestMapping(value = {"/activityentry"}, method = RequestMethod.GET)
    public String activityentry(ModelMap model){
        hasUser(model);
        model.putAll(storeOptionApi.activityentry());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }
}
