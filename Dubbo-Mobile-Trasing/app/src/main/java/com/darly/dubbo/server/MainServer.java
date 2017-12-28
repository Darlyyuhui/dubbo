package com.darly.dubbo.server;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.widget.Toast;

import com.darly.common.DLog;
import com.darly.dubbo.R;

/**
 * 主服务
 *
 * @author Darly/张宇辉/2017/12/25 9:21
 * @version 1.0/com.darly.dubbo.server
 */
public class MainServer extends Service {
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    startService2();
                    break;

                default:
                    break;
            }

        }
    };
    /**
     * 使用aidl 启动Service2
     */
    private StrongServer strongServer = new StrongServer.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void stopService() throws RemoteException {
            Intent i = new Intent(getBaseContext(), OtherServer.class);
            getBaseContext().stopService(i);
        }

        @Override
        public void startService() throws RemoteException {
            Intent i = new Intent(getBaseContext(), OtherServer.class);
            getBaseContext().startService(i);
        }
    };

    /**
     * 在内存紧张的时候，系统回收内存时，会回调OnTrimMemory， 重写onTrimMemory当系统清理内存时从新启动Service2
     */
    @Override
    public void onTrimMemory(int level) {
        /*
		 * 启动service2
		 */
        startService2();

    }

    @Override
    public void onCreate() {
        Toast.makeText(MainServer.this, "Service1 正在启动...", Toast.LENGTH_SHORT)
                .show();
        startService2();
		/*
		 * 此线程用监听Service2的状态
		 */
        while (true) {
            boolean isRun = Utils.isServiceWork(MainServer.this,
                    "com.darly.dubbo.server.OtherServer");
            if (!isRun) {
                Message msg = Message.obtain();
                msg.what = 1;
                handler.sendMessage(msg);
            }
            DLog.i("MainServer在主进程中进行无限循环"+isRun);
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * 判断Service2是否还在运行，如果不是则启动Service2
     */
    private void startService2() {
        boolean isRun = Utils.isServiceWork(MainServer.this,
                "com.darly.dubbo.server.OtherServer");
        if (isRun == false) {
            try {
                strongServer.startService();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(2, buildForegroundNotification());
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return (IBinder) strongServer;
    }


    private Notification buildForegroundNotification() {
        Notification.Builder builder = new Notification.Builder(this);

        builder.setOngoing(true);

        builder.setContentTitle(getClass().getSimpleName())
                .setContentText(System.currentTimeMillis() + "")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("Time");
        builder.setPriority(Notification.PRIORITY_MAX);
        return builder.build();
    }
}