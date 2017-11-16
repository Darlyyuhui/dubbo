package com.darly.dubbo.base;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


import com.darly.dubbo.R;
import com.darly.dubbo.binder.InitBinder;
import com.darly.dubbo.common.DLog;



/**
 * @author zhangyh2 BaseActivity $ 下午2:33:01 TODO
 */
public abstract class BaseActivity extends FragmentActivity {
    public int REQUEST_CODE = 0; // 请求码

    /*
     * (non-Javadoc)
     *
     * @see android.support.v4.app.FragmentActivity#onCreate(android.os.Bundle)
     */
    @TargetApi(19)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = getWindow();
        ViewGroup mContentView = (ViewGroup) findViewById(Window.ID_ANDROID_CONTENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //版本21(5.0)以上（包括5.0）
            //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.setStatusBarColor(getResources().getColor(R.color.titlebar));
            View mChildView = mContentView.getChildAt(0);
            if (mChildView != null) {
                //注意不是设置 ContentView 的 FitsSystemWindows, 而是设置 ContentView 的第一个子 View . 预留出系统 View 的空间.
                ViewCompat.setFitsSystemWindows(mChildView, true);
            }
        }else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int resourceId = getResources().getIdentifier("status_bar_height", "dimen","android");
            int statusBarHeight = getResources().getDimensionPixelSize(resourceId);
            DLog.i(getClass().getSimpleName(),"statusBarHeight--->"+statusBarHeight);
            View mTopView = mContentView.getChildAt(0);
            if (mTopView != null && mTopView.getLayoutParams() != null && mTopView.getLayoutParams().height == statusBarHeight) {
                //避免重复添加 View
                mTopView.setBackgroundColor(getResources().getColor(R.color.titlebar));
                return;
            }
            //使 ChildView 预留空间
            if (mTopView != null) {
                ViewCompat.setFitsSystemWindows(mTopView, true);
            }
            //添加假 View
            mTopView = new View(this);
            mTopView.setBackgroundColor(getResources().getColor(R.color.titlebar));
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, statusBarHeight);
            mContentView.addView(mTopView, 0, lp);
        }
        initGlobalVariable();
        initView(savedInstanceState);
        loadData();
        initListener();
    }


    /**
     * 下午2:36:27
     *
     * @author zhangyh2 BaseActivity.java TODO
     * 初始化全局的一些变量。而且做好的静态变量。每个Activity里面的变量由自己来进行定义。
     */
    private void initGlobalVariable() {
        // TODO Auto-generated method stub
        InitBinder.InitAll(this);
    }

    /**
     * @param savedInstanceState 下午2:34:08
     * @author zhangyh2 BaseActivity.java TODO 初始化控件
     */

    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 下午2:34:10
     *
     * @author zhangyh2 BaseActivity.java TODO 加载数据
     */
    protected abstract void loadData();

    /**
     * 下午2:42:02
     *
     * @author zhangyh2 BaseFragment.java TODO 初始化坚挺事件
     */
    protected abstract void initListener();


    protected void initFragments(Class<?> cls, int resId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        try {
            fragment = (Fragment) cls.newInstance();
            transaction.add(resId, fragment);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        transaction.commit();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        int4Right();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        int4Right();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        out2Left();
    }

    public void out2Left() {
        overridePendingTransition(R.anim.activity_nothing, R.anim.activity_out_to_buttom);
    }

    public void int4Right() {
        overridePendingTransition(R.anim.right_in, R.anim.activity_nothing);
    }
}
