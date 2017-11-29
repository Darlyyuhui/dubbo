package com.darly.dubbo.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.darly.dubbo.R;


/**
 * @author zhangyh2 BaseActivity $ 下午2:33:01 TODO
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        initView(savedInstanceState);

        loadData();

        initListener();

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

    public void startActivityForResult(Intent intent, int requestCode, int defautl) {
        super.startActivityForResult(intent, requestCode);
    }


    public void int4Right() {
        getActivity().overridePendingTransition(R.anim.right_in, R.anim.activity_nothing);
    }

}
