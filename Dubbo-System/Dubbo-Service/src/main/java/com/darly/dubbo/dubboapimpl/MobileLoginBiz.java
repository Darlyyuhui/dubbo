package com.darly.dubbo.dubboapimpl;

import com.darly.dubbo.framework.base.BaseController;
import com.darly.dubbo.mobile.api.MobileLoginApi;
import com.darly.dubbo.security.system.bean.SystemLog;
import com.darly.dubbo.security.system.service.SystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : ZhangYuHui
 * Date : 2017/11/14
 * TODO :
 */
@Service
public class MobileLoginBiz extends BaseController implements MobileLoginApi {
    @Resource
    SystemLogService systemLogService;

    @Override
    public List<SystemLog> loginLog() throws Exception {
        logger.info("--->[方法 loginLog 前端接口請求用戶...]");
        return systemLogService.selectByExample(null);
    }
}
