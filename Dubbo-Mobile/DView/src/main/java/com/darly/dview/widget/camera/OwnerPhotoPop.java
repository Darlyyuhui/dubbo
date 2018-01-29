package com.darly.dview.widget.camera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.darly.dview.R;
import com.darly.dview.widget.camera.util.ImageUtils;
/**
 * 自定义的POP窗口
 * @author  Darly/张宇辉/2017/11/23 14:51
 * @version  1.0/com.darly.dview.widget.camera
 * Copyright (c) 2017 Organization D.L. zhangyuhui All rights reserved.
 */

public class OwnerPhotoPop extends PopupWindow {
    public static int CameraRequstCode = 0x00022;
    public static int SelectRequstCode = 0x00011;

    /**
     * 下午1:29:10 TODO 系统参数。
     */
    private Context context;

    private Button item_popupwindows_camera;

    private Button item_popupwindows_Photo;

    private Button item_popupwindows_cancel;

    private int size;
    private int totalSize;
    private String path;
    private boolean islogo;

    public OwnerPhotoPop(Context context) {
        super();
        this.context = context;
        init();
    }
    /**
     * 下午1:29:54
     *
     * @author Zhangyuhui  TODO 初始化控件集合。
     */
    private void init() {
        // TODO Auto-generated method stub

        View view = LayoutInflater.from(context).inflate(R.layout.popupwindows,
                null);
        item_popupwindows_camera = (Button) view
                .findViewById(R.id.item_popupwindows_camera);
        item_popupwindows_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 照相功能
                if (ImageUtils.isCameraUseable()) {
                    Intent intentCamera = new Intent(context, CameraActivity.class);
                    intentCamera.putExtra("size", size);
                    intentCamera.putExtra("totalSize", totalSize);
                    intentCamera.putExtra("file", path);
                    intentCamera.putExtra("LOGO", islogo);//不打印水印
                    ((Activity)OwnerPhotoPop.this.context).startActivityForResult(intentCamera, OwnerPhotoPop.CameraRequstCode);
                } else {
                    Toast.makeText(context,"需要调用摄像头权限，请在设置中打开摄像头权限",Toast.LENGTH_SHORT).show();
                }
                dismiss();
            }
        });
        item_popupwindows_Photo = (Button) view
                .findViewById(R.id.item_popupwindows_Photo);
        item_popupwindows_Photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 相册功能
                Intent intentAlbum = new Intent(context, PhotoSelectActivity.class);
                intentAlbum.putExtra("size", size);
                intentAlbum.putExtra("totalSize", totalSize);
                ((Activity)context).startActivityForResult(intentAlbum, SelectRequstCode);
                dismiss();
            }
        });
        item_popupwindows_cancel = (Button) view
                .findViewById(R.id.item_popupwindows_cancel);
        item_popupwindows_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setFocusable(true);
        setOutsideTouchable(true);
        setContentView(view);
    }

    public void setBackground(int resId){
        if (resId==0){
            return;
        }
        item_popupwindows_camera.setBackgroundResource(resId);
        item_popupwindows_Photo.setBackgroundResource(resId);
        item_popupwindows_cancel.setBackgroundResource(resId);
    }

    public void setItem_popupwindows_camera(int resId) {
        if (resId==0){
            return;
        }
        item_popupwindows_camera.setBackgroundResource(resId);
    }

    public void setItem_popupwindows_Photo(int resId) {
        if (resId==0){
            return;
        }
        item_popupwindows_Photo.setBackgroundResource(resId);
    }

    public void setItem_popupwindows_cancel(int resId) {
        if (resId==0){
            return;
        }
        item_popupwindows_cancel.setBackgroundResource(resId);
    }

    public void show(View v, int size, int totalSize, String path, boolean islogo) {
        this.size = size;
        this.totalSize = totalSize;
        this.path = path;
        this.islogo = islogo;
        this.showAtLocation(v, 17, 0, 0);
    }

}
