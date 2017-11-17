package com.darly.dubbo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.darly.dubbo.base.AppConst;
import com.darly.dubbo.base.BaseActivity;
import com.darly.dubbo.binder.ContentBinder;
import com.darly.dubbo.binder.ViewsBinder;
import com.darly.dubbo.common.DLog;
import com.darly.dview.widget.camera.OwnerPhotoPop;
import com.darly.dview.widget.header.TitleView;

@ContentBinder(R.layout.activity_main)
public class MainActivity extends BaseActivity implements OnClickListener{

    @ViewsBinder(R.id.id_title)
    TitleView title;

    @ViewsBinder(R.id.id_forword_html)
    Button btn;

    private OwnerPhotoPop pop;

    @Override
    protected void initView(Bundle savedInstanceState) {
        title.setRightViewRightOneListener(this);
        pop = new OwnerPhotoPop(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.id_forword_html:
                startActivity(new Intent(this,HtmlWebView.class));
                break;
            case com.darly.dview.R.id.title_view_operation_imageview_right:
                pop.show(view, 3, AppConst.getVido().concat("tour"));
                break;
            default:
                break;
        }

    }
}
