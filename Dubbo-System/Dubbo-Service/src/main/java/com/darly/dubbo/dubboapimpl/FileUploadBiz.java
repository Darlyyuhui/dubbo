package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.fileupload.FileUploadApi;
import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.store.bean.StoreImage;
import com.darly.dubbo.store.service.StoreImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/12/15
 * TODO :
 */
@Service
public class FileUploadBiz extends BaseController implements FileUploadApi {
    @Autowired
    StoreImageService storeImageService;

    @Override
    public boolean fileupload(List<StoreImage> images) {
        if (images == null) {
            return false;
        }
        for (StoreImage image : images) {
            boolean ist = storeImageService.insertImage(image);
            if (!ist){
                return false;
            }
        }
        return true;
    }
}
