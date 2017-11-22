/**
 *
 */
package com.darly.dview.widget.camera;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Images.ImageColumns;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.darly.dview.R;
import com.darly.dview.common.SCfg;
import com.darly.dview.widget.camera.util.ImageUtils;
import com.darly.dview.widget.camera.util.MDate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sunhaifeng
 */
public class CameraActivity extends Activity {
    private SharedPreferences mysp = null;
    private Button btnexit;
    private ImageView btntack;
    private Button btnok;
    private CameraView cv = null;
    private Camera camera;
    private LinearLayout linearLayout;
    private LinearLayout linearLayoutCamera;
    private boolean bIfPreview = false;
    private ToneGenerator tone;
    private List<String> listPath = new ArrayList<String>();
    @SuppressLint("UseSparseArrays")
    private Map<Integer, Bitmap> imap = new HashMap<Integer, Bitmap>();
    private int i = 0;
    private SurfaceHolder mSurfaceHolder;
    private SensorEventListener mListener = null;
    private SensorManager mManager = null;
    private Sensor mSensor = null;
    private int direction = 0;
    private int mSize;
    private String filePaths;
    private int callbackTimes;
    private String currentTime;
    private ImageUtils iu;

    private ScrollView scrollView;
    private int zoo;
    private int mode = 0;
    private float oldDist;

    private boolean logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.camera_activity);
        initView();
        initData();
        initListener();
    }

    public void initView() {
        btnexit = (Button) this.findViewById(R.id.tvcamexit);
        btntack = (ImageView) this.findViewById(R.id.tvcamtakepic);
        btnok = (Button) this.findViewById(R.id.tvcamok);
        linearLayout = (LinearLayout) this.findViewById(R.id.tvcamlinearlayout_images);
        linearLayoutCamera = (LinearLayout) this.findViewById(R.id.tvcampreciew);
        scrollView = (ScrollView) this.findViewById(R.id.tvcamgallery_images);
    }

    public void initListener() {
        btnexit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                onBackPressed();
            }
        });
        btntack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getIntent().getAction() != null && getIntent().getAction().equals("publishFourPhotosAccident")) {
                    if (mSize + listPath.size() >= 10) {
                        Toast.makeText(CameraActivity.this,"最多拍摄10张照片",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else if (getIntent().getAction() != null && getIntent().getAction().equals("publishFourPhotos")) {
                    if (mSize + listPath.size() >= 4) {
                        Toast.makeText(CameraActivity.this,"最多可拍摄4张照片",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else if (getIntent().getAction() != null && getIntent().getAction().equals("Sence")) {
                    if (mSize + listPath.size() >= 4) {
                        Toast.makeText(CameraActivity.this,"最多可拍摄3张照片",Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else if (getIntent().getAction() != null && getIntent().getAction().equals("publishThreePhotos")) {
                    if (mSize + listPath.size() >= 3) {
                        Toast.makeText(CameraActivity.this,"最多可拍摄3张照片",Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                try {
                    callbackTimes = 0;
                    if (SCfg.isDebug()) {
                        camera.takePicture(new shutterCallback(), null, picture);//使用电脑虚拟机进行拍照
                    } else {
                        camera.autoFocus(new TPcallback());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnok.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int t = 0;
                int b = 0;
                for (; ; ) {
                    if (b == imap.size())
                        break;
                    if (imap.get(t) != null) {
                        if (!imap.get(t).isRecycled()) {
                            imap.get(t).recycle();
                        }
                        b++;
                    }
                    t++;
                }
                imap.clear();

                int pcount = listPath.size();
                if (pcount <= 0) {
                    return;
                }

                Intent intent = new Intent();

                int k = 0;
                for (int j = 0; j < pcount; j++) {
                    String path = listPath.get(j);
                    if (!path.equals("NOIMAGE")) {
                        intent.putExtra("img" + k, path);
                        k++;
                    }
                }
                intent.putExtra("camera_picture", (Serializable) listPath);
/*			ImageUtils iu = new ImageUtils(this);
            for (int i = 0; i < listPath.size(); i++) {
				File f = new File(listPath.get(i));
				if (f != null && f.exists() && f.isFile()) {
					iu.pressText(listPath.get(i), getResources().getString(R.string.textviewtime) + ":" + MDate.getDate(),"","");
				}
			}*/
                intent.putExtra("imgcount", k);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
        cv.setOnClickListener(new cvOnClice());
        mListener = new SensorEventListener() {
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }

            @SuppressWarnings("deprecation")
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[SensorManager.DATA_X];
                float y = event.values[SensorManager.DATA_Y];
                direction = getDiection((int) x, (int) y);
            }
        };
        mManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mManager.registerListener(mListener, mSensor, SensorManager.SENSOR_DELAY_GAME);
        //添加双指滑动切换焦距
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        mode = 1;
                        break;
                    case MotionEvent.ACTION_UP:
                        mode = 0;
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        mode -= 1;
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        oldDist = spacing(event);
                        mode += 1;
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if (mode >= 2) {
                            float newDist = spacing(event);
                            if (newDist > oldDist + 10) {
                                if (zoo >= camera.getParameters().getMaxZoom()) {
                                    zoo = camera.getParameters().getMaxZoom();
                                } else {
                                    zoo++;
                                }
                                setZoom(zoo);
                                oldDist = newDist;
                            }
                            if (newDist < oldDist - 1) {
                                if (zoo <= 1) {
                                    zoo = 1;
                                } else {
                                    zoo--;
                                }
                                setZoom(zoo);
                                oldDist = newDist;
                            }
                        }
                        break;
                }

                return true;
            }
        });
    }

    public int getDiection(int x, int y) {
        int tempDirection = -100;
        if (Math.abs(x) < 1) {
            if (y > 8) {
                tempDirection = 0;
            } else if (y < -8) {
                tempDirection = 2;
            }
        } else if (Math.abs(y) < 1) {
            if (x > 8) {
                tempDirection = 3;
            } else if (x < -8) {
                tempDirection = 1;
            }
        }
        return tempDirection;
    }

    public void initData() {
        iu = new ImageUtils(this);
        mSize = getIntent().getIntExtra("size", 0);
        filePaths = getIntent().getStringExtra("file");
        logo = getIntent().getBooleanExtra("LOGO", false);
        mysp = getSharedPreferences("xxsyscfg", Context.MODE_PRIVATE);
        openCamera();
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        super.onBackPressed();
    }

    private class shutterCallback implements ShutterCallback {

        @Override
        public void onShutter() {
            if (tone == null) {
                tone = new ToneGenerator(1, ToneGenerator.MIN_VOLUME);
                tone.startTone(ToneGenerator.TONE_PROP_BEEP);
            }
        }
    }

    private class TakePic implements Runnable {
        private byte[] data;

        public TakePic(byte[] data) {
            this.data = data;
        }

        @Override
        public void run() {
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                String picpath = filePaths + "/vio" + MDate.getDateAsFileName() + "-" + Math.round(Math.random() * 8999 + 1000) + ".jpg";

                File picture = new File(filePaths);
                if (!picture.exists())
                    picture.mkdirs();

                try {
                    FileOutputStream fos = new FileOutputStream(picpath);// ����ļ������
                    fos.write(data);// MyUtils.rotataData(data, direction));//
                    // д���ļ�
                    fos.close();// �ر��ļ���
                    ExifInterface exifInterface = new ExifInterface(picpath);
                    exifInterface.setAttribute(ExifInterface.TAG_DATETIME, MDate.getDate());
                    exifInterface.saveAttributes();
                    exifInterface = null;
                    getImageView(picpath);// ��ȡ��Ƭ

                    File file = new File(picpath);
                    if (file.exists()) {

                        File f = new File(picpath);
                        //在这里判断是否需要添加水印效果
                        if (f != null && f.exists() && f.isFile() && logo) {
                            iu.pressText(picpath, getResources().getString(R.string.textviewtime) + ":" + MDate.getDate(), "", "");
                        }

                        ContentResolver resolver = CameraActivity.this.getContentResolver();
                        ContentValues cv = new ContentValues();
                        cv.put(ImageColumns.TITLE, file.getName());
                        cv.put(ImageColumns.DISPLAY_NAME, file.getName());
                        cv.put(ImageColumns.ORIENTATION, 0);
                        cv.put(ImageColumns.DATA, picpath);
                        resolver.insert(Images.Media.EXTERNAL_CONTENT_URI, cv);
                        resolver.notifyChange(Images.Media.EXTERNAL_CONTENT_URI, null);


                    }
                } catch (Exception e) {
                    Toast.makeText(CameraActivity.this, R.string.fileWriteError, Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(CameraActivity.this, R.string.sdCardOut, Toast.LENGTH_LONG).show();
            }
        }

    }

    private class cvOnClice implements OnClickListener {

        @Override
        public void onClick(View v) {
            camera.autoFocus(new AFcallback());
        }

    }

    private class AFcallback implements AutoFocusCallback {

        @Override
        public void onAutoFocus(boolean success, Camera camera) {
        }

    }

    private class TPcallback implements AutoFocusCallback {
        public void onAutoFocus(boolean success, Camera camera) {
            if (success) {
                callbackTimes++;
                if (callbackTimes > 1) {
                    return;
                }
                camera.takePicture(new shutterCallback(), null, picture);
            } else {
                Toast.makeText(CameraActivity.this, R.string.focusFailed, Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class CameraView extends SurfaceView {
        private SurfaceHolder holder = null;

        public CameraView(Context context) {
            super(context);
            this.setKeepScreenOn(true);
            holder = this.getHolder();
            holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
            holder.addCallback(new SurfaceHolder.Callback() {
                @Override
                public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                    if (bIfPreview) {
                        camera.startPreview();
                    }
                    if (null != camera) {
                        try {
                            Camera.Parameters parameters = camera.getParameters();

                            int w;
                            int h;
                            List<Size> list = parameters.getSupportedPictureSizes();
                            parameters.setPictureFormat(ImageFormat.JPEG);
                            parameters.setPreviewFormat(ImageFormat.NV21);
                            if (!mysp.contains("viopicwidth")) {
                                for (Size l : list) {
                                    if (l.height <= 2048 && l.width <= 1536) {
                                        if (l.height > 640 && l.width > 480) {
                                            w = l.width;
                                            h = l.height;
                                            parameters.setPictureSize(w, h);
                                            SCfg.setVioPicHight(h);
                                            SCfg.setVioPicWidth(w);
                                            break;
                                        }
                                    }
                                }
                            } else {
                                w = SCfg.getVioPicWidth();
                                h = SCfg.getVioPicHight();
                                parameters.setPictureSize(w, h);
                            }

                            parameters.setFlashMode(SCfg.getFlashModes());
                            list = parameters.getSupportedPreviewSizes();
                            if (list.get(0).width > list.get(list.size() - 1).width) {
                                parameters.setPreviewSize(list.get(0).width, list.get(0).height);
                            } else {
                                parameters.setPreviewSize(list.get(list.size() - 1).width, list.get(list.size() - 1).height);
                            }
                            parameters.setWhiteBalance(SCfg.getWhiteBalance());
                            parameters.setSceneMode(SCfg.getSceneModes());
                            if (SCfg.getExposureCompensation() != 10)
                                parameters.setExposureCompensation(SCfg.getExposureCompensation());
                            parameters.setJpegQuality(70); // ͼƬ����

                            if (CameraActivity.this.getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
                                camera.setDisplayOrientation(90);
                            } else {
                                camera.setDisplayOrientation(0);
                            }
                            camera.setParameters(parameters);

                            camera.startPreview();
                            bIfPreview = true;

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void surfaceCreated(SurfaceHolder holder) {
                    camera = Camera.open();
                    try {
                        camera.setPreviewDisplay(mSurfaceHolder);
                        camera.setDisplayOrientation(getPreviewDegree(CameraActivity.this));
                    } catch (IOException e) {
                        camera.release();
                        camera = null;
                        e.printStackTrace();
                    }
                }

                @Override
                public void surfaceDestroyed(SurfaceHolder holder) {
                    camera.stopPreview();
                    camera.setPreviewCallback(null);
                    camera.release();
                    camera = null;
                }
            });
        }
    }

    private int getPreviewDegree(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int res = 0;
        switch (rotation) {
            case Surface.ROTATION_0:
                res = 90;
                break;
            case Surface.ROTATION_90:
                res = 0;
                break;
            case Surface.ROTATION_180:
                res = 270;
                break;
            case Surface.ROTATION_270:
                res = 180;
                break;
            default:
                break;
        }
        return res;
    }

    private void openCamera() {
        linearLayoutCamera.removeAllViews();
        cv = new CameraView(CameraActivity.this);
        mSurfaceHolder = cv.getHolder();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        linearLayoutCamera.addView(cv, params);
    }

    @Override
    protected void onDestroy() {
        listPath.clear();
        for (int c = 0; c < imap.size(); c++) {
            if (imap.get(c) != null && !imap.get(c).isRecycled()) {
                imap.get(c).recycle();
            }
        }
        imap.clear();
        mManager.unregisterListener(mListener);
        super.onDestroy();
    }

    private Bitmap getImageBitmap(String path) throws FileNotFoundException, IOException {
        Bitmap bmp = null;
        BitmapDrawable bd = new BitmapDrawable(path);
        bmp = bd.getBitmap();
        bmp = ThumbnailUtils.extractThumbnail(bmp, 150, 150);
        Matrix matrix = new Matrix();
        matrix.setRotate(getPreviewDegree(CameraActivity.this));
        bmp = Bitmap.createBitmap(bmp, 0, 0, 150, 150, matrix, true);
        return bmp;
    }

    private void getImageView(final String path) {
        int j = i++;
        final View view = getLayoutInflater().inflate(R.layout.camera_item, null);
        final ImageView imageView = (ImageView) view.findViewById(R.id.photoshare_item_image);
        imageView.setScaleType(ScaleType.FIT_XY);
        final ImageButton button = (ImageButton) view.findViewById(R.id.photoshare_item_delete);
        try {
            imageView.setImageBitmap(getImageBitmap(path));
            imap.put(j, getImageBitmap(path));
            button.setTag(j);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                linearLayout.removeView(view);
                int k = Integer.parseInt(button.getTag().toString());
                imap.get(k).recycle();
                imap.remove(k);
                File f = new File(path);
                if (f.exists()) {
                    f.delete();
                    listPath.remove(path);
                }
            }
        });

        linearLayout.addView(view);
        listPath.add(path);
    }

    private Camera.PictureCallback picture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            Handler handler = new Handler();
            handler.post(new TakePic(data));
            camera.startPreview(); // ���´�Ԥ��
        }
    };

    /**
     * 设置相机焦距
     **/
    private void setZoom(int mValue) {
        Camera.Parameters mParams = camera.getParameters();
        mParams.setZoom(mValue);
        camera.setParameters(mParams);
    }

    /**
     * 计算两点之间的距离
     *
     * @param event
     */
    private float spacing(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }
}
