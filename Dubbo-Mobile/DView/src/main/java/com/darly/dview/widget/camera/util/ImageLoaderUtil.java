package com.darly.dview.widget.camera.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.darly.dview.R;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

/**
 * @author zhangyh2 ImageLoaderUtil 下午2:50:09 TODO
 *         呼出Imageloader图片加载类，防止耦合过多。替换不方便。 单例一个图片加载类 多线程安全单例模式实例三(使用双重同步锁)
 *         图片工具
 */
public class ImageLoaderUtil{

    private static ImageLoaderUtil instance = null;

    private Context context;

    /**
     * 下午2:51:19
     *
     * @author zhangyh2
     */
    private ImageLoaderUtil(Context context) {
        // TODO Auto-generated constructor stub
        this.context = context;
        initImageLoader();
    }

    private ImageLoaderUtil() {
    }

    public static void init(Context context) {
        if (instance == null) {
            synchronized (ImageLoaderUtil.class) {
                if (instance == null) {
                    instance = new ImageLoaderUtil(context);
                }
            }
        }
    }


    /**
     * @return the instance
     */
    public static ImageLoaderUtil getInstance() {
        if (instance == null) {
            Log.i("", "[工具类没有进行初始化使用，会出现异常]");
            synchronized (ImageLoaderUtil.class) {
                if (instance == null) {
                    instance = new ImageLoaderUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 上午10:44:40
     *
     * @author Zhangyuhui AppStack.java TODO初始化单例模式下的ImageLoader
     */
    private void initImageLoader() {
        // TODO Auto-generated method stub
        @SuppressWarnings("deprecation")
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context)
                .memoryCacheExtraOptions(480, 800)
                // maxwidth, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3)
                // 线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)

                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                // You can pass your own memory cache
                // implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(2 * 1024 * 1024)
                .discCacheSize(50 * 1024 * 1024)
                // 将保存的时候的URI名称用MD5 加密
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .discCacheFileCount(100)
                // 自定义缓存路径
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                .imageDownloader(
                        new BaseImageDownloader(context, 5 * 1000,
                                30 * 1000)).writeDebugLogs() // Remove for
                // releaseapp
                .build();// 开始构建
        ImageLoader.getInstance().init(config);
    }

    /**
     * 下午2:50:09
     *
     * @author zhangyh2 TODO 圆角加载
     */
    @SuppressWarnings("deprecation")
    private DisplayImageOptions getOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.empty_photo) // 设置图片在下载期间显示的图片
                .showImageForEmptyUri(R.mipmap.empty_photo)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.mipmap.empty_photo) // 设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)// 设置下载的图片是否缓存在SD卡中
                .considerExifParams(true) // 是否考虑JPEG图像EXIF参数（旋转，翻转）
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)// 设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型//
                .displayer(new CircleBitmapDisplayer())// 是否设置为圆角，弧度为多少
                .build();// 构建完成
        return options;
    }

    /**
     * 下午2:50:57
     *
     * @author zhangyh2 TODO正常加载
     */
    @SuppressWarnings("deprecation")
    private DisplayImageOptions getOptions(int r) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(r) // 设置图片在下载期间显示的图片
                .showImageForEmptyUri(r)// 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(r) // 设置图片加载/解码过程中错误时候显示的图片
                .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                .cacheOnDisc(true)// 设置下载的图片是否缓存在SD卡中
                .considerExifParams(true) // 是否考虑JPEG图像EXIF参数（旋转，翻转）
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)// 设置图片以如何的编码方式显示
                .bitmapConfig(Bitmap.Config.RGB_565)// 设置图片的解码类型//
                .build();// 构建完成
        return options;
    }

    /**
     * 下午3:02:41
     *
     * @author zhangyh2 TODO 图片圆角进行加载，调用此方法直接传入图片控件和图片地址，直接将图片放入对应位置
     */
    public void loadImage(String url, ImageView iv) {
        ImageLoader.getInstance().displayImage(url, iv, getOptions());
    }

    public void loadImageNor(String url, ImageView iv) {
        ImageLoader.getInstance().displayImage(url, iv,
                getOptions(R.mipmap.empty_photo));
    }

    public interface Loading {
        void onStarted(String arg0, View arg1);

        void onFailed(String arg0, View arg1, FailReason arg2);

        void onComplete(String arg0, View arg1, Bitmap arg2);

        void onCancelled(String arg0, View arg1);
    }

    private Loading loadinglistener;

    public void load(String url, Loading loading) {
        loadinglistener = loading;
        ImageLoader.getInstance().loadImage(url,
                getOptions(R.mipmap.empty_photo), new ImageLoadingListener() {

                    @Override
                    public void onLoadingStarted(String arg0, View arg1) {
                        // TODO Auto-generated method stub
                        loadinglistener.onStarted(arg0, arg1);
                    }

                    @Override
                    public void onLoadingFailed(String arg0, View arg1,
                                                FailReason arg2) {
                        // TODO Auto-generated method stub
                        loadinglistener.onFailed(arg0, arg1, arg2);
                    }

                    @Override
                    public void onLoadingComplete(String arg0, View arg1,
                                                  Bitmap arg2) {
                        // TODO Auto-generated method stub
                        loadinglistener.onComplete(arg0, arg1, arg2);
                    }

                    @Override
                    public void onLoadingCancelled(String arg0, View arg1) {
                        // TODO Auto-generated method stub
                        loadinglistener.onCancelled(arg0, arg1);
                    }
                });
    }


    public static boolean isCameraUseable() {
        boolean canUse = true;
        Camera mCamera = null;
        try {
            mCamera = Camera.open();
            // setParameters 是针对魅族MX5。MX5通过Camera.open()拿到的Camera对象不为null
            Camera.Parameters mParameters = mCamera.getParameters();
            mCamera.setParameters(mParameters);
        } catch (Exception e) {
            canUse = false;
        }
        if (mCamera != null) {
            mCamera.release();
        }
        return canUse;
    }

}
