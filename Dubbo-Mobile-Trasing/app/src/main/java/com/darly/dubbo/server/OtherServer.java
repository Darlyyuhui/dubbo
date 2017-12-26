package com.darly.dubbo.server;

import android.annotation.SuppressLint;
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
 * @author Darly/张宇辉/2017/12/25 9:23
 * @version 1.0/com.darly.dubbo.server
 */
public class OtherServer extends Service {
    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case 1:
                    startService1();
                    break;

                default:
                    break;
            }

        }

        ;
    };

    /**
     * 使用aidl 启动Service1
     */
    private StrongServer strongServer = new StrongServer.Stub() {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void stopService() throws RemoteException {
            Intent i = new Intent(getBaseContext(), MainServer.class);
            getBaseContext().stopService(i);
        }

        @Override
        public void startService() throws RemoteException {
            Intent i = new Intent(getBaseContext(), MainServer.class);
            getBaseContext().startService(i);

        }
    };

    /**
     * 在内存紧张的时候，系统回收内存时，会回调OnTrimMemory， 重写onTrimMemory当系统清理内存时从新启动Service1
     */
    @Override
    public void onTrimMemory(int level) {
        startService1();
    }

    @SuppressLint("NewApi")
    public void onCreate() {
        Toast.makeText(OtherServer.this, "Service2 启动中...", Toast.LENGTH_SHORT)
                .show();
        startService1();
        while (true) {
            boolean isRun = Utils.isServiceWork(OtherServer.this,
                    "com.darly.dubbo.server.MainServer");
            if (!isRun) {
                Message msg = Message.obtain();
                msg.what = 1;
                handler.sendMessage(msg);
            }
            DLog.i("OtherServer在進程中無限循環"+ isRun);
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 判断Service1是否还在运行，如果不是则启动Service1
     */
    private void startService1() {
        boolean isRun = Utils.isServiceWork(OtherServer.this,
                "com.darly.dubbo.server.MainServer");
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
        startForeground(1, buildForegroundNotification());
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
