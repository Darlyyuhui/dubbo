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
 * Created by Darly on 2017/9/13.
 */
public class OwnerPhotoPop extends PopupWindow {

    /**
     * 下午1:29:10 TODO 系统参数。
     */
    private Context context;

    private Button item_popupwindows_camera;

    private Button item_popupwindows_Photo;

    private Button item_popupwindows_cancel;

    private int size;
    private String path;

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
                    intentCamera.putExtra("file", path);
                    intentCamera.setAction("Sence");
                    intentCamera.putExtra("LOGO", false);//不打印水印
                    ((Activity)context).startActivityForResult(intentCamera, 1);
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
                Intent intentAlbum = new Intent();
                intentAlbum.putExtra("size", size);
                intentAlbum.setAction("publishFourPhotos");
                intentAlbum.setClass(context, PhotoSelectActivity.class);
                ((Activity)context).startActivityForResult(intentAlbum, 99);
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
    /**
     * @param v 下午3:15:27
     * @author Zhangyuhui TODO 展示POP
     */
    public void show(View v, int size, String path) {
        this.size = size;
        this.path = path;
        showAtLocation(v, Gravity.CENTER, 0, 0);
    }

}
