package com.darly.video.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.darly.video.R;
import com.darly.video.base.OnDialogListener;
import com.darly.video.camera.MediaRecorderBase;
import com.darly.video.camera.MediaRecorderNative;
import com.darly.video.camera.VCamera;
import com.darly.video.camera.model.MediaObject;
import com.darly.video.camera.util.DeviceUtils;
import com.darly.video.camera.util.FileUtils;
import com.darly.video.camera.util.StringUtils;
import com.darly.video.common.CommonCons;
import com.darly.video.common.ConvertToUtils;
import com.darly.video.common.RecoderAttrs;
import com.darly.video.wedget.ProgressImage;
import com.darly.video.wedget.ShowLoading;
import com.darly.video.wedget.dialog.TourSelectDialog;
import com.darly.video.wedget.dialog.TourSelectDialog.onSelectItemClick;
import com.darly.video.wedget.dialog.TourSelectListener;
import com.yixia.videoeditor.adapter.UtilityAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author maimingliang@gmail.com
 * <p/>
 * Created by maimingliang on 2016/9/25.
 */
public class WechatRecoderActivity extends Activity implements MediaRecorderBase.OnErrorListener, MediaRecorderBase.OnEncodeListener, ProgressImage.OnFinishListener, OnPreparedListener, OnErrorListener, OnCompletionListener {

    /**
     * 录制最长时间
     */
    public static int RECORD_TIME_MAX = 10 * 1000;
    /**
     * 录制最小时间
     */
    public static int RECORD_TIME_MIN = 2 * 1000;

    /**
     * 按住拍偏移距离
     */
    private static float OFFSET_DRUTION = 25.0f;

    /**
     * titel_bar 取消颜色
     */
    private static int TITEL_BAR_CANCEL_TEXT_COLOR = 0xFF00FF00;


    /**
     * 按住拍 字体颜色
     */
    private static int PRESS_BTN_COLOR = 0xFF00FF00;

    /**
     * progress 小于录制最少时间的颜色
     */
    private static int LOW_MIN_TIME_PROGRESS_COLOR = 0xFFFC2828;
    /**
     * progress 颜色
     */
    private static int PROGRESS_COLOR = 0xFF00FF00;

    private static int PRESS_BTN_BG = 0xFF00FF00;

    /**
     * 对焦图片宽度
     */
    private int mFocusWidth;
    /**
     * 底部背景色
     */
    private int mBackgroundColorNormal, mBackgroundColorPress;
    /**
     * 屏幕宽度
     */
    private int mWindowWidth;

    /**
     * SDK视频录制对象
     */
    private MediaRecorderBase mMediaRecorder;
    /**
     * 视频信息
     */
    private MediaObject mMediaObject;

    /**
     * 对焦动画
     */
    private Animation mFocusAnimation;
    private boolean mCreated;

    private Handler mHandler = new Handler();

    /**
     * 是否自动录像.
     */
    private boolean isAuto;


    private static OnDialogListener mOnDialogListener;

    TextView mTvRecorderCancel;
    TextView mTvSelectVideo;
    RelativeLayout mLayoutHeader;
    SurfaceView mSurfaceView;
    MediaController mediaco;
    VideoView videoView;

    ImageView mImgRecordFocusing;
    RelativeLayout mRlRecoderSurfaceview;
    LinearLayout mRlRecorderBottom;
    //视频录制按钮
    ProgressImage mBtnPress;
    //录制完成后展示的按钮
    TableRow select;
    ImageView id_recorder_de;
    ImageView id_recorder_ch;
    ImageView id_recoder_ratio;
    ImageView id_recoder_time;
    ImageView id_recoder_switch;


    protected ShowLoading loading;

    public ShowLoading showProgress(String title, String message) {
        return showProgress(title, message, -1);
    }

    public ShowLoading showProgress(String title, String message, int theme) {
        if (loading == null) {
            if (theme > 0)
                loading = new ShowLoading(this, theme);
            else
                loading = new ShowLoading(this);
        }

        if (!StringUtils.isEmpty(title))
            loading.setTitle(title);
        loading.setMessage(message);
        loading.show();
        return loading;
    }

    public void hideProgress() {
        if (loading != null) {
            loading.dismiss();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        hideProgress();
        loading = null;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        mCreated = false;
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // 防止锁屏
        setContentView(R.layout.activity_wechat_recoder);
        initCustomerAttrs();
        initView();
        initData();
        mCreated = true;
    }

    private void initView() {
        mTvRecorderCancel = (TextView) findViewById(R.id.tv_recorder_cancel);
        mTvSelectVideo = (TextView) findViewById(R.id.tv_select_video);
        mLayoutHeader = (RelativeLayout) findViewById(R.id.layout_header);
        mSurfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        videoView = (VideoView) findViewById(R.id.videoview);
        mImgRecordFocusing = (ImageView) findViewById(R.id.img_record_focusing);
        mRlRecoderSurfaceview = (RelativeLayout) findViewById(R.id.rl_recoder_surfaceview);
        mBtnPress = (ProgressImage) findViewById(R.id.btn_press);
        mRlRecorderBottom = (LinearLayout) findViewById(R.id.rl_recorder_bottom);
        mBtnPress.setMax(RECORD_TIME_MAX);
        mBtnPress.setCricleProgressColor(R.color.blue);
        mBtnPress.setRoundWidth(20);
        mBtnPress.setVisibility(View.VISIBLE);
        select = (TableRow) findViewById(R.id.id_recorder_select);
        id_recorder_de = (ImageView) findViewById(R.id.id_recorder_de);
        id_recorder_ch = (ImageView) findViewById(R.id.id_recorder_ch);

        select.setVisibility(View.GONE);
        id_recoder_ratio = (ImageView) findViewById(R.id.id_recoder_ratio);
        id_recoder_time = (ImageView) findViewById(R.id.id_recoder_time);
        id_recoder_switch = (ImageView) findViewById(R.id.id_recoder_switch);

        id_recoder_ratio.setVisibility(View.GONE);
        id_recoder_time.setVisibility(View.GONE);
        id_recoder_switch.setVisibility(View.GONE);

        mediaco = new MediaController(this);
        mediaco.setVisibility(View.INVISIBLE);
        videoView.setMediaController(mediaco);
        videoView.setOnPreparedListener(this);
        videoView.setOnErrorListener(this);
        videoView.setOnCompletionListener(this);
        mediaco.setMediaPlayer(videoView);
    }


    private void initData() {
        mWindowWidth = DeviceUtils.getScreenWidth(this);
        mFocusWidth = ConvertToUtils.dipToPX(this, 64);
        try {
            mImgRecordFocusing.setImageResource(R.drawable.ms_video_focus_icon);
        } catch (OutOfMemoryError e) {
            Log.e("maiml", e.getMessage());
        }
        mTvRecorderCancel.setTextColor(TITEL_BAR_CANCEL_TEXT_COLOR);
        setListener();
    }

    private List<TourSelectListener> getScreem() {
        List<TourSelectListener> lists = new ArrayList<TourSelectListener>();
        lists.add(new TourSelectListener(240, 320));
        lists.add(new TourSelectListener(320, 480));
        lists.add(new TourSelectListener(480, 480));
        lists.add(new TourSelectListener(480, 640));
        return lists;
    }

    private List<TourSelectListener> getTimer() {
        List<TourSelectListener> lists = new ArrayList<TourSelectListener>();
        lists.add(new TourSelectListener(10 * 1000));
        lists.add(new TourSelectListener(60 * 1000));
        lists.add(new TourSelectListener(600 * 1000));
        lists.add(new TourSelectListener(3600 * 1000));
        return lists;
    }

    private List<TourSelectListener> getAuto() {
        List<TourSelectListener> lists = new ArrayList<TourSelectListener>();
        lists.add(new TourSelectListener(true));
        lists.add(new TourSelectListener(false));
        return lists;
    }

    private void setListener() {
        id_recoder_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new TourSelectDialog(WechatRecoderActivity.this, getAuto(), "选择模式", new onSelectItemClick() {
                    @Override
                    public void changeState(TourSelectListener type) {
                        isAuto = type.isAuto;
                        if (isAuto) {
                            isAuto = false;
                            mBtnPress.setOnClickListener(null);
                            mBtnPress.setOnTouchListener(onVideoRecoderTouchListener);
                        } else {
                            isAuto = true;
                            mBtnPress.setOnTouchListener(null);
                            mBtnPress.setOnClickListener(onclinckListener);
                        }
                    }
                }).show();

            }
        });
        id_recoder_ratio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TourSelectDialog(WechatRecoderActivity.this, getScreem(), "选择分辨率", new onSelectItemClick() {
                    @Override
                    public void changeState(TourSelectListener type) {
                        CommonCons.WIDTH_RATIO = type.width;
                        CommonCons.HEIGHT_RATIO = type.height;
                    }
                }).show();
            }
        });
        id_recoder_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TourSelectDialog(WechatRecoderActivity.this, getTimer(), "选择录像时长", new onSelectItemClick() {
                    @Override
                    public void changeState(TourSelectListener type) {
                        mBtnPress.setMax(type.time);
                    }
                }).show();
            }
        });
        if (DeviceUtils.hasICS()) {
            mSurfaceView.setOnTouchListener(onSurfaveViewTouchListener);
        }
        mBtnPress.setOnFinishListener(this);
        mBtnPress.setOnClickListener(null);
        mBtnPress.setOnTouchListener(onVideoRecoderTouchListener);

        mTvRecorderCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        id_recorder_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //选中视频，进行播放或者传递。
                String outputVideoPath = mMediaObject.getOutputVideoPath();
                //编码完成后，直接调用播放器，不用跳转回原始页面。
                Log.i(getClass().getSimpleName(), outputVideoPath);
//                Intent data = new Intent(WechatRecoderActivity.this, PlayActivity.class);
//                data.putExtra("path", outputVideoPath);
//                startActivity(data);
                Intent intent = new Intent();
                intent.putExtra("path", outputVideoPath);
                setResult(901, intent);
                onBackPressed();
            }
        });
        id_recorder_de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
            }
        });
        mTvSelectVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(WechatRecoderActivity.this, ShowRecoderActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        select.setVisibility(View.GONE);
        mBtnPress.setVisibility(View.VISIBLE);
        mSurfaceView.setVisibility(View.VISIBLE);
        videoView.setVisibility(View.GONE);
        videoView.stopPlayback();
        UtilityAdapter.freeFilterParser();
        UtilityAdapter.initFilterParser();
        if (mMediaRecorder == null) {
            initMediaRecorder();
        } else {
            mMediaRecorder.prepare();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        stopRecord();
        UtilityAdapter.freeFilterParser();
        if (mMediaRecorder != null)
            mMediaRecorder.release();
    }

    /**
     * 初始化拍摄SDK
     */
    private void initMediaRecorder() {
        mMediaRecorder = new MediaRecorderNative();

        mMediaRecorder.setOnErrorListener(this);
        mMediaRecorder.setOnEncodeListener(this);
        File f = new File(VCamera.getVideoCachePath());
        if (!FileUtils.checkFile(f)) {
            f.mkdirs();
        }
        mMediaRecorder.setSurfaceHolder(mSurfaceView.getHolder());
        mMediaRecorder.prepare();
    }

    private void initCustomerAttrs() {


        int maxTime = getIntent().getIntExtra(CommonCons.RECORD_TIME_MAX, 0);

        if (maxTime != 0) {
            RECORD_TIME_MAX = maxTime;
        }

        int minTime = getIntent().getIntExtra(CommonCons.RECORD_TIME_MIN, 0);

        if (minTime != 0) {
            RECORD_TIME_MIN = minTime;
        }

        int offset = getIntent().getIntExtra(CommonCons.OFFSET_DRUTION, 0);

        if (offset != 0) {
            OFFSET_DRUTION = offset;
        }

        int cancelColor = getIntent().getIntExtra(CommonCons.TITEL_BAR_CANCEL_TEXT_COLOR, 0);

        if (cancelColor != 0) {
            TITEL_BAR_CANCEL_TEXT_COLOR = cancelColor;
        }

        int btnColor = getIntent().getIntExtra(CommonCons.PRESS_BTN_COLOR, 0);

        if (btnColor != 0) {
            PRESS_BTN_COLOR = btnColor;
        }

        int minTimeProgressColor = getIntent().getIntExtra(CommonCons.LOW_MIN_TIME_PROGRESS_COLOR, 0);

        if (minTimeProgressColor != 0) {
            LOW_MIN_TIME_PROGRESS_COLOR = minTimeProgressColor;
        }
        int color = getIntent().getIntExtra(CommonCons.PROGRESS_COLOR, 0);


        if (color != 0) {
            PROGRESS_COLOR = color;
        }

        int pressbg = getIntent().getIntExtra(CommonCons.PRESS_BTN_BG, 0);

        if (pressbg != 0) {
            PRESS_BTN_BG = pressbg;
        }

    }


    private void startRecoder() {
        String key = String.valueOf(System.currentTimeMillis());
        mMediaObject = mMediaRecorder.setOutputDirectory(key,
                VCamera.getVideoCachePath() + key);
        if (!RecoderAttrs.isAvailableSpace(this)) {
            return;
        }
        select.setVisibility(View.GONE);
        mBtnPress.setVisibility(View.VISIBLE);
        if (mMediaRecorder == null) {
            return;
        }
        MediaObject.MediaPart part = mMediaRecorder.startRecord();
        if (part == null) {
            return;
        }
    }


    private void startEncoding() {
        mMediaRecorder.startEncoding();
    }


    private void stopAll() {
        stopRecord();
        //  isRecoder = false;


    }

    private void recoderShortTime() {
        // removeRecoderPart();
        select.setVisibility(View.GONE);
        mBtnPress.setVisibility(View.VISIBLE);
    }

    private void hideRecoderTxt() {
        select.setVisibility(View.VISIBLE);
        mBtnPress.setVisibility(View.GONE);
    }

    private void removeRecoderPart() {
        // 回删
        if (mMediaObject != null) {
            mMediaObject.removeAllPart();

        }
    }


    /**
     * 停止录制
     */
    private void stopRecord() {
        if (mMediaRecorder != null) {
            mMediaRecorder.stopRecord();
        }
    }

    private Runnable mRunable = new Runnable() {
        @Override
        public void run() {
            hideRecoderTxt();
        }
    };

    private boolean first;
    private View.OnClickListener onclinckListener = new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            if (mMediaRecorder == null) {
                return;
            }
            if (!first) {
                startTime = System.currentTimeMillis();
                mBtnPress.start();
                startRecoder();
                first = true;
            } else {
                first = false;
                stopAll();
                mBtnPress.stop();
                long duration = System.currentTimeMillis();
                if (duration - startTime < RECORD_TIME_MIN) {
                    recoderShortTime();
                    return;
                }
                //if (isCancelRecoder) {
                hideRecoderTxt();
                // }
                startEncoding();
            }
        }
    };

    long startTime = 0;
    /**
     * 点击屏幕录制
     */
    private View.OnTouchListener onVideoRecoderTouchListener = new View.OnTouchListener() {
        private float startY;
        private float moveY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (mMediaRecorder == null) {
                return false;
            }

            switch (event.getAction()) {
                default:
                    return true;
                case MotionEvent.ACTION_DOWN:
                    startTime = System.currentTimeMillis();
                    startY = event.getY();
                    mBtnPress.start();
                    startRecoder();
                    break;
                case MotionEvent.ACTION_MOVE:
                    //滑动取消视频录制。
//                    int durationMove = mMediaObject.getDuration();
//                    if (durationMove >= RECORD_TIME_MAX) {
//                        stopAll();
//                        mBtnPress.stop();
//                        return true;
//                    }
//                    moveY = event.getY();
//                    float drution = moveY - startY;
//
//                    if ((drution > 0.0f) && Math.abs(drution) > OFFSET_DRUTION) {
//                        slideCancelRecoder();
//
//                    }
//                    if ((drution < 0.0f) && (Math.abs(drution) > OFFSET_DRUTION)) {
//                        releaseCancelRecoder();
//                    }
                    //後續功能，滑動修改攝像頭焦距。
                    break;
                case MotionEvent.ACTION_UP:
                    stopAll();
                    mBtnPress.stop();
                    long duration = System.currentTimeMillis();
                    if (duration - startTime < RECORD_TIME_MIN) {
                        recoderShortTime();
                        return true;
                    }
                    //if (isCancelRecoder) {
                    hideRecoderTxt();
                    // }
                    startEncoding();
                    break;

            }

            return true;


        }

    };


    /**
     * 点击屏幕对焦
     */
    private View.OnTouchListener onSurfaveViewTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (mMediaRecorder == null || !mCreated) {
                return false;
            }

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    // 检测是否手动对焦
                    if (checkCameraFocus(event))
                        return true;
                    break;
            }
            return true;
        }

    };


    /**
     * 手动对焦
     */
    @SuppressLint("NewApi")
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private boolean checkCameraFocus(MotionEvent event) {
        mImgRecordFocusing.setVisibility(View.GONE);
        float x = event.getX();
        float y = event.getY();
        float touchMajor = event.getTouchMajor();
        float touchMinor = event.getTouchMinor();

        Rect touchRect = new Rect((int) (x - touchMajor / 2),
                (int) (y - touchMinor / 2), (int) (x + touchMajor / 2),
                (int) (y + touchMinor / 2));
        // The direction is relative to the sensor orientation, that is, what
        // the sensor sees. The direction is not affected by the rotation or
        // mirroring of setDisplayOrientation(int). Coordinates of the rectangle
        // range from -1000 to 1000. (-1000, -1000) is the upper left point.
        // (1000, 1000) is the lower right point. The width and height of focus
        // areas cannot be 0 or negative.
        // No matter what the zoom level is, (-1000,-1000) represents the top of
        // the currently visible camera frame
        if (touchRect.right > 1000)
            touchRect.right = 1000;
        if (touchRect.bottom > 1000)
            touchRect.bottom = 1000;
        if (touchRect.left < 0)
            touchRect.left = 0;
        if (touchRect.right < 0)
            touchRect.right = 0;

        if (touchRect.left >= touchRect.right
                || touchRect.top >= touchRect.bottom)
            return false;

        ArrayList<Camera.Area> focusAreas = new ArrayList<Camera.Area>();
        focusAreas.add(new Camera.Area(touchRect, 1000));
        if (!mMediaRecorder.manualFocus(new Camera.AutoFocusCallback() {

            @Override
            public void onAutoFocus(boolean success, Camera camera) {
                // if (success) {
                mImgRecordFocusing.setVisibility(View.GONE);
                // }
            }
        }, focusAreas)) {
            mImgRecordFocusing.setVisibility(View.GONE);
        }

        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mImgRecordFocusing
                .getLayoutParams();
        int left = touchRect.left - (mFocusWidth / 2);// (int) x -
        int top = touchRect.top - (mFocusWidth / 2);// (int) y -
        if (left < 0)
            left = 0;
        else if (left + mFocusWidth > mWindowWidth)
            left = mWindowWidth - mFocusWidth;
        if (top + mFocusWidth > mWindowWidth)
            top = mWindowWidth - mFocusWidth;

        lp.leftMargin = left;
        lp.topMargin = top;
        mImgRecordFocusing.setLayoutParams(lp);
        mImgRecordFocusing.setVisibility(View.VISIBLE);

        if (mFocusAnimation == null)
            mFocusAnimation = AnimationUtils.loadAnimation(this,
                    R.anim.record_focus);

        mImgRecordFocusing.startAnimation(mFocusAnimation);

        return true;
    }


    @Override
    public void progressDown() {
        if (isAuto) {
            first = false;
            stopAll();
            mBtnPress.stop();
            startEncoding();
        }
        hideRecoderTxt();
    }

    @Override
    public void onVideoError(int what, int extra) {

    }

    @Override
    public void onAudioError(int what, String message) {

    }

    @Override
    public void onEncodeStart() {

        if (mOnDialogListener != null) {
            mOnDialogListener.onShowDialog(this);
        } else {
            showProgress("", "正在处理中...");

        }
    }

    @Override
    public void onEncodeProgress(int progress) {

    }

    @Override
    public void onEncodeComplete() {
        if (mOnDialogListener != null) {
            mOnDialogListener.onHideDialog(this);
        } else {
            hideProgress();
        }
        //转码完成后，进行播放。
        mSurfaceView.setVisibility(View.GONE);
        videoView.setVisibility(View.VISIBLE);
        videoView.setVideoPath(mMediaObject.getOutputVideoPath());
        videoView.start();

        stopRecord();
        UtilityAdapter.freeFilterParser();
        if (mMediaRecorder != null)
            mMediaRecorder.release();
    }

    @Override
    public void onEncodeError() {
        if (mOnDialogListener != null) {
            mOnDialogListener.onHideDialog(this);
        } else {
            hideProgress();
        }
        Toast.makeText(this, "视频损坏,请重新拍摄",
                Toast.LENGTH_SHORT).show();
        removeRecoderPart();
        initMediaRecorder();
        select.setVisibility(View.GONE);
        mBtnPress.setVisibility(View.VISIBLE);
    }


    @Override
    public void onBackPressed() {
        if (mMediaObject != null)
            mMediaObject.delete();
        finish();
        overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
    }


    @Override
    public void finish() {
        MediaRecorderBase.RecursionDeleteFile(new File(VCamera.getVideoCachePath()));
        super.finish();
    }

    public static void launchActivity(Context context, RecoderAttrs attrs, int requestCode) {

        if (context instanceof OnDialogListener) {
            mOnDialogListener = (OnDialogListener) context;
        }

        Bundle bundle = new Bundle();
        Intent intent = new Intent(context, WechatRecoderActivity.class);


        if (attrs != null) {
            bundle.putInt(CommonCons.RECORD_TIME_MAX, attrs.getRecoderTimeMax());
            bundle.putInt(CommonCons.RECORD_TIME_MIN, attrs.getRecoderTimeMin());
            bundle.putInt(CommonCons.TITEL_BAR_CANCEL_TEXT_COLOR, attrs.getTitelBarCancelTextColor());
            bundle.putInt(CommonCons.PRESS_BTN_COLOR, attrs.getPressBtnColor());
            bundle.putInt(CommonCons.OFFSET_DRUTION, attrs.getOffsetDrution());
            bundle.putInt(CommonCons.LOW_MIN_TIME_PROGRESS_COLOR, attrs.getLowMinTimeProgressColor());
            bundle.putInt(CommonCons.PROGRESS_COLOR, attrs.getProgressColor());
            bundle.putInt(CommonCons.PRESS_BTN_BG, attrs.getPressBtnBg());
            intent.putExtras(bundle);
        }

        ((Activity) context).startActivityForResult(intent, requestCode);
    }

    public static void launchActivity(Context context, int requestCode) {
        launchActivity(context, null, requestCode);
    }


    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return true;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        mp.setLooping(true);
    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        videoView.setVideoPath(mMediaObject.getOutputVideoPath());
        videoView.start();
    }
}
