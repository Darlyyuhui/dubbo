package com.darly.dubbo.fileupload;

import com.darly.dubbo.store.bean.StoreImage;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/9
 * TODO :
 */
public interface FileUploadApi {
     //图片上传，后台交互接口
     boolean fileupload(List<StoreImage> images);
}
