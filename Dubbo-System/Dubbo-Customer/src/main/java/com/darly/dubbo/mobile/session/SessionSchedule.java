package com.darly.dubbo.mobile.session;

import com.darly.dubbo.framework.systemlog.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

/** Session 超时检测器
 * Author : ZhangYuHui
 * Date : 2017/12/5
 */
@Component
public class SessionSchedule {
    public Logger logger = new Logger(getClass());

    private int time = SessionConfig.getValue("customer-session-TimeOut",0);

    // 每15秒执行一次
    @Scheduled(cron = "0/15 * * * * ?")
    public void reportCurrentByCron() {
        if (time== 0) {
            return;
        }
        SessionData sd = null;
        Date lastDate = null;
        for (String key : SessionUtil.SESSION_MAP.keySet()) {
            sd = SessionUtil.SESSION_MAP.get(key);
            //获取最后操作时间
            lastDate = SessionUtil.LAST_OPERATION_MAP.get(key);
            if (isTimeOut(sd.getLoginDate(), lastDate, time)) {
                logger.info(key+"登陆超时，清除登陆信息");
                SessionUtil.SESSION_MAP.remove(key);
                SessionUtil.LAST_OPERATION_MAP.remove(key);
            }
        }
    }
    /**
     * 判断是否超时
     * @param loginDate 登录时间
     * @param lastDate 最后操作时间
     * @param timeOut 时长
     * @return boolean
     */
    private boolean isTimeOut(Date loginDate, Date lastDate, int timeOut) {
        Calendar c = Calendar.getInstance();
        c.setTime(loginDate);
        c.add(Calendar.MINUTE, timeOut);
        //如果登录后未操作过，则取当前时间
        if (lastDate == null) {
            lastDate = new Date();
        }
        //当前登录
        if (c.getTime().before(lastDate)) {
            return true;
        }
        return false;
    }
}
