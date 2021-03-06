package com.darly.dubbo.store;

import com.darly.dubbo.cfg.ApplicationConst;
import com.darly.dubbo.fileupload.FileUploadApi;
import com.darly.dubbo.framework.common.StringDiyUtils;
import com.darly.dubbo.framework.common.UuidGenerateUtil;
import com.darly.dubbo.mobile.cfg.ResponseUtil;
import com.darly.dubbo.security.BaseSecurityController;
import com.darly.dubbo.store.api.StoreOptionApi;
import com.darly.dubbo.store.bean.StoreActiviyType;
import com.darly.dubbo.store.bean.StoreImage;
import com.darly.dubbo.store.bean.StoreProduct;
import com.darly.dubbo.store.bean.StoreSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

    /**
     * 商城管理页面首页
     *
     * @return
     */
    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String optionIndex(ModelMap model) {
        hasUser(model);
        model.putAll(storeOptionApi.optionIndex());
        return (String) model.get(ApplicationConst.getForwordUrl());
    }

    /**
     * ajax请求接口
     *
     * @return
     */
    @RequestMapping(value = {"/productentryser"}, method = RequestMethod.POST)
    public void productentryser(@RequestBody String s, HttpServletRequest request, HttpServletResponse response) {
        List<StoreProduct> products = (List<StoreProduct>) storeOptionApi.productentry(s).get("STOREPRODUCT");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("status", "success");
        resultMap.put("totals", products.size());
        resultMap.put("data", products);
        logger.info("-------->resultMap" + resultMap);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }


    /**
     * 商品录入操作
     *
     * @return
     */
    @RequestMapping(value = {"/addProducet"}, method = RequestMethod.POST)
    public String addProducet(StoreProduct product, @RequestParam(value = "file", required = false) MultipartFile[] file, RedirectAttributes attr) {
        logger.info(product);
        if (product != null) {
            product.setId(UuidGenerateUtil.getUUIDLong());
            storeOptionApi.insertProduct(product);
        }
        List<String> urls = fileupload(file);
        List<StoreImage> images = new ArrayList<StoreImage>();
        if (urls != null) {
            for (String arg : urls) {
                StoreImage image = new StoreImage();
                image.setId(UuidGenerateUtil.getUUIDLong());
                image.setProductTypeId(product == null ? null : product.getId());
                image.setImageUrl(arg);
                image.setImageDesc("新增图片");
                image.setImageUploadtime(new Date());
                images.add(image);
            }
        } else {
            logger.info("--------->没有传递图片！");
        }
        boolean isgood = fileUploadApi.fileupload(images);
        attr.addFlashAttribute("success", isgood);
        return "redirect:/option/productentry";
    }


    /**
     * 商品录入更新操作ajax
     *
     * @return
     */
    @RequestMapping(value = {"/addProduceter"}, method = RequestMethod.POST)
    public void addProduceter(@RequestParam(value = "file", required = false) MultipartFile[] file, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        StoreProduct product = new StoreProduct();
        try {
            Field[] e = product.getClass().getDeclaredFields();
            for (Field field : e) {
                String name = field.getName();
                if ("serialVersionUID".equals(name)) {
                    continue;
                }
                field.setAccessible(true);
                String type = field.getType().toString();
                if (type.contains("String")) {
                    field.set(product, request.getParameter(name));
                } else if (type.contains("Integer")) {
                    field.set(product, Integer.parseInt(request.getParameter(name)));
                } else if (type.contains("List")) {
                } else {
                    field.set(product, BigDecimal.valueOf(Double.parseDouble(request.getParameter(name))));
                }
            }
            if (StringDiyUtils.isEmpty(product.getId())) {
                product.setId(UuidGenerateUtil.getUUIDLong());
                if (storeOptionApi.insertProduct(product)) {
                    //沒有圖片
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "商品上传成功");
                    if (file != null && file.length > 0) {
                        for (MultipartFile multipartFile : file) {
                            if (!multipartFile.isEmpty()) {
                                //直接傳遞到數據庫保存
                                StoreImage image = new StoreImage();
                                image.setId(UuidGenerateUtil.getUUIDLong());
                                image.setProductTypeId(product == null ? null : product.getId());
                                image.setImageUrl(fileupload(multipartFile));
                                image.setImageDesc("商品图片");
                                image.setImageUploadtime(new Date());

                                boolean isgood = fileUploadApi.fileupload(image);
                                if (isgood) {
                                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                                    resultMap.put(ResponseUtil.RES_KEY_DESC, "商品和图片上传成功");
                                } else {
                                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                                    resultMap.put(ResponseUtil.RES_KEY_DESC, "图片无法上传到数据库，请检查数据库连接");
                                }
                            }
                        }
                    } else {
                        //沒有圖片
                        resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                        resultMap.put(ResponseUtil.RES_KEY_DESC, "商品上传成功");
                    }
                } else {
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "商品无法上传到数据库，请检查数据库连接");
                }
            } else {
                //--------------商品更新修改-------------------
                if (storeOptionApi.updateProduct(product)) {
                    //防止图片为空
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "商品更新成功");
                    //这里进行图片是否更新判断
                    if (file != null && file.length > 0) {
                        for (MultipartFile mf : file) {
                            if (!mf.isEmpty()) {
                                //直接傳遞到數據庫保存
                                StoreImage image = new StoreImage();
                                image.setId(UuidGenerateUtil.getUUIDLong());
                                image.setProductTypeId(product == null ? null : product.getId());
                                image.setImageUrl(fileupload(mf));
                                image.setImageDesc("商品图片更新");
                                image.setImageUploadtime(new Date());
                                if (fileUploadApi.fileupload(image)) {
                                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                                    resultMap.put(ResponseUtil.RES_KEY_DESC, "商品和图片更新成功");
                                } else {
                                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                                    resultMap.put(ResponseUtil.RES_KEY_DESC, "图片无法上传到数据库，请检查数据库连接");
                                }
                            }
                        }
                    } else {
                        //没有图片
                        resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                        resultMap.put(ResponseUtil.RES_KEY_DESC, "商品更新成功");
                    }
                } else {
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "商品无法编辑，请检查数据库连接");
                }
            }
            ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
        } catch (Exception e) {
            resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
            resultMap.put(ResponseUtil.RES_KEY_DESC, "参数传递错误，请检查参数" + e.getMessage());
            ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
        }
    }

    /**
     * 商品移除操作ajax
     */
    @RequestMapping(value = {"/productdelete"}, method = RequestMethod.POST)
    public void productdelete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String id = request.getParameter("ID");
        if (StringDiyUtils.isEmpty(id)) {
            resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
            resultMap.put(ResponseUtil.RES_KEY_DESC, "参数传递错误，请检查参数");

        } else {
            //先查看商品是否正在参加活动，没有参加活动则可以直接删除，否则提示用户，需要解除活动绑定方可删除。
            if (storeOptionApi.checkactivitysale(id, null)) {
                //已經參與了活動。提示用戶，解除活動。
                resultMap.put(ResponseUtil.RES_KEY_CODE, "205");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "商品正在参与活动，请在活动中解除商品绑定，方可删除商品");
            } else {
                boolean ok = storeOptionApi.productdelete(id);
                if (ok) {
                    //商品移除成功后，移除圖片
                    storeOptionApi.deleteImage(id);
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "商品删除成功");
                } else {
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "无法删除数据，请检查数据库连接");
                }
            }
        }
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /**
     * 商品編輯操作ajax
     */
    @RequestMapping(value = {"/productedit"}, method = RequestMethod.POST)
    public void productedit(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String id = request.getParameter("ID");
        if (StringDiyUtils.isEmpty(id)) {
            resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
            resultMap.put(ResponseUtil.RES_KEY_DESC, "参数传递错误，请检查参数");
        } else {
            StoreProduct product = storeOptionApi.productedit(id);
            if (product != null) {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "商品查詢成功");
                resultMap.put(ResponseUtil.RES_KEY_RESULT, product);
            } else {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "无法查询数据，请检查数据库连接");
            }
        }
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /**
     * ajax请求接口
     *
     * @return
     */
    @RequestMapping(value = {"/activityentryser"}, method = RequestMethod.POST)
    public void activityentryser(@RequestBody String s, HttpServletRequest request, HttpServletResponse response) {
        List<StoreActiviyType> types = (List<StoreActiviyType>) storeOptionApi.activityentry(s).get("STORETYPE");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("status", "success");
        resultMap.put("totals", types.size());
        resultMap.put("data", types);
        logger.info("-------->resultMap" + resultMap);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /**
     * 活动录入更新操作ajax
     *
     * @return
     */
    @RequestMapping(value = {"/activityinsert"}, method = RequestMethod.POST)
    public void activityinsert(@RequestParam(value = "file", required = false) MultipartFile[] file, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        StoreActiviyType product = new StoreActiviyType();
        try {
            Field[] e = product.getClass().getDeclaredFields();
            for (Field field : e) {
                String name = field.getName();
                if ("serialVersionUID".equals(name)) {
                    continue;
                }
                field.setAccessible(true);
                String type = field.getType().toString();
                if (type.contains("String")) {
                    field.set(product, request.getParameter(name));
                } else if (type.contains("Date")) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    field.set(product, dateFormat.parse(request.getParameter(name)));
                } else if (type.contains("List")) {
                } else {
                    field.set(product, BigDecimal.valueOf(Double.parseDouble(request.getParameter(name))));
                }
            }
            if (StringDiyUtils.isEmpty(product.getId())) {
                product.setId(UuidGenerateUtil.getUUIDLong());
                if (storeOptionApi.insertActivity(product)) {
                    //沒有圖片
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "活动上传成功");

                    if (file != null && file.length > 0) {
                        for (MultipartFile multipartFile : file) {
                            if (!multipartFile.isEmpty()) {
                                //直接傳遞到數據庫保存
                                StoreImage image = new StoreImage();
                                image.setId(UuidGenerateUtil.getUUIDLong());
                                image.setProductTypeId(product == null ? null : product.getId());
                                image.setImageUrl(fileupload(multipartFile));
                                image.setImageDesc("活动标签");
                                image.setImageUploadtime(new Date());

                                boolean isgood = fileUploadApi.fileupload(image);
                                if (isgood) {
                                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                                    resultMap.put(ResponseUtil.RES_KEY_DESC, "活动和图片上传成功");
                                } else {
                                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                                    resultMap.put(ResponseUtil.RES_KEY_DESC, "图片无法上传到数据库，请检查数据库连接");
                                }
                            }
                        }
                    } else {
                        //沒有圖片
                        resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                        resultMap.put(ResponseUtil.RES_KEY_DESC, "活动上传成功");
                    }
                } else {
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "活动无法上传到数据库，请检查数据库连接");
                }
            } else {
                //--------------商品更新修改-------------------
                if (storeOptionApi.updateActivity(product)) {
                    //这里进行图片是否更新判断
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "活动更新成功");
                    if (file != null && file.length > 0) {
                        for (MultipartFile mf : file) {
                            if (!mf.isEmpty()) {
                                //直接傳遞到數據庫保存
                                StoreImage image = new StoreImage();
                                image.setId(UuidGenerateUtil.getUUIDLong());
                                image.setProductTypeId(product == null ? null : product.getId());
                                image.setImageUrl(fileupload(mf));
                                image.setImageDesc("活动图标更新");
                                image.setImageUploadtime(new Date());
                                if (fileUploadApi.fileupload(image)) {
                                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                                    resultMap.put(ResponseUtil.RES_KEY_DESC, "活动和图片更新成功");
                                } else {
                                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                                    resultMap.put(ResponseUtil.RES_KEY_DESC, "图片无法上传到数据库，请检查数据库连接");
                                }
                            }
                        }
                    } else {
                        //没有图片
                        resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                        resultMap.put(ResponseUtil.RES_KEY_DESC, "活动更新成功");
                    }
                } else {
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "活动无法编辑，请检查数据库连接");
                }
            }
            ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
        } catch (Exception e) {
            resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
            resultMap.put(ResponseUtil.RES_KEY_DESC, "参数传递错误，请检查参数" + e.getMessage());
            ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
        }
    }

    /**
     * 商品移除操作ajax
     */
    @RequestMapping(value = {"/activitydelete"}, method = RequestMethod.POST)
    public void activitydelete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String id = request.getParameter("ID");
        if (StringDiyUtils.isEmpty(id)) {
            resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
            resultMap.put(ResponseUtil.RES_KEY_DESC, "参数传递错误，请检查参数");

        } else {
            //删除之前查看有没有绑定的商品。没有商品绑定则可以直接删除，否则提示用户，需要解除活动绑定方可删除。
            if (storeOptionApi.checkactivitysale(null, id)) {
                //有商品参与活动，删除活动前，需要解绑商品
                resultMap.put(ResponseUtil.RES_KEY_CODE, "205");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "活动有商品还在参与，请解除商品绑定，方可删除活动");
            } else {
                boolean ok = storeOptionApi.activitydelete(id);
                if (ok) {
                    //活動移除后，移除圖標
                    storeOptionApi.deleteImage(id);
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "活动删除成功");
                } else {
                    resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                    resultMap.put(ResponseUtil.RES_KEY_DESC, "无法删除数据，请检查数据库连接");
                }
            }
        }
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /**
     * 商品移除操作ajax
     */
    @RequestMapping(value = {"/activityedit"}, method = RequestMethod.POST)
    public void activityedit(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String id = request.getParameter("ID");
        if (StringDiyUtils.isEmpty(id)) {
            resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
            resultMap.put(ResponseUtil.RES_KEY_DESC, "参数传递错误，请检查参数");
        } else {
            StoreActiviyType type = storeOptionApi.activityedit(id);
            if (type != null) {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "活动查询成功");
                resultMap.put(ResponseUtil.RES_KEY_RESULT, type);
            } else {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "无法删除数据，请检查数据库连接");
            }
        }
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /**
     * ajax请求接口
     *
     * @return
     */
    @RequestMapping(value = {"/actproduct"}, method = RequestMethod.POST)
    public void actproduct(@RequestBody String s, HttpServletRequest request, HttpServletResponse response) {
        List<StoreProduct> products = (List<StoreProduct>) storeOptionApi.actproduct(s);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("status", "活动商品查询成功");
        resultMap.put("totals", products.size());
        resultMap.put("data", products);
        logger.info("-------->resultMap" + resultMap);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }


    /**
     * ajax 添加新的商品进入活动
     *
     * @return
     */
    @RequestMapping(value = {"/activityproductinsert"}, method = RequestMethod.POST)
    public void activityproductinsert(@RequestBody String s, HttpServletRequest request, HttpServletResponse response) {
        List<StoreProduct> products = (List<StoreProduct>) storeOptionApi.activityproductinsert(s);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("status", "非活动商品查询成功");
        resultMap.put("totals", products.size());
        resultMap.put("data", products);
        logger.info("-------->resultMap" + resultMap);
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /**
     * ajax 添加新的商品进入活动
     *
     * @return
     */
    @RequestMapping(value = {"/activitysaleinsert"}, method = RequestMethod.POST)
    public void activitysaleinsert(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String storeType = request.getParameter("storeType");
        String id = request.getParameter("id");
        String[] ids = id.split(",");
        StoreSale sale = new StoreSale();
        for (String str : ids) {
            sale.setId(UuidGenerateUtil.getUUIDLong());
            sale.setStoreType(storeType);
            sale.setProductId(str);
            if (storeOptionApi.activitysaleinsert(sale)) {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "商品参与活动成功");
            } else {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "无法关联，请检查数据库连接");
            }
        }
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }


    /**
     * ajax 从活动中移除已有商品，通过商品id
     */
    @RequestMapping(value = {"/activityproductremove"}, method = RequestMethod.POST)
    public void activityproductremove(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String id = request.getParameter("ID");
        if (StringDiyUtils.isEmpty(id)) {
            resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
            resultMap.put(ResponseUtil.RES_KEY_DESC, "参数传递错误，请检查参数");

        } else {
            boolean ok = storeOptionApi.activityproductremove(id);
            if (ok) {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "商品移除成功");
            } else {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "无法移除商品，请检查数据库连接");
            }
        }
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

    /**
     * ajax 从活动中移除已有商品，通过商品id
     */
    @RequestMapping(value = {"/imagedelete"}, method = RequestMethod.POST)
    public void imagedelete(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String id = request.getParameter("ID");
        if (StringDiyUtils.isEmpty(id)) {
            resultMap.put(ResponseUtil.RES_KEY_CODE, "203");
            resultMap.put(ResponseUtil.RES_KEY_DESC, "参数传递错误，请检查参数");
        } else {
            if (storeOptionApi.deleteImageByID(id)) {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "200");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "图片移除成功");
            }else {
                resultMap.put(ResponseUtil.RES_KEY_CODE, "202");
                resultMap.put(ResponseUtil.RES_KEY_DESC, "图片移除失败，请检查数据库");
            }
        }
        ResponseUtil.printWriteResponse(request.getParameter("callback"), resultMap, response);
    }

}
