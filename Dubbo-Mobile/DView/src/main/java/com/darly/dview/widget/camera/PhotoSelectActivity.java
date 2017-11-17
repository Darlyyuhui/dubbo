package com.darly.dview.widget.camera;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


import com.darly.dview.R;
import com.darly.dview.widget.header.TitleView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @package: com.xiangxun.activity
 * @ClassName: PhotoSelectActivity.java
 * @Description: 图片选择器
 * @author: HanGJ
 * @date: 2015-8-24 下午2:53:41
 */
public class PhotoSelectActivity extends Activity{
    private TitleView titleView;
    private GridView mGvPhotos = null;
    private MyGridAdapter mMyGridAdapter = null;
    private Button mBtnFinish = null;

    private ArrayList<String> mAllLocalPhotos = new ArrayList<String>();
    private List<String> mSelectedPhotos = new ArrayList<String>();
    private int mCount = 0;
    private int mSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_select_activity);
        titleView = (TitleView) findViewById(R.id.tv_comm_title);
        titleView.setLeftBackOneListener(R.mipmap.ic_title_back, new OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        titleView.setTitle(R.string.publish_my_album);
        mGvPhotos = (GridView) findViewById(R.id.gv_photos);
        mBtnFinish = (Button) findViewById(R.id.btn_finish);
        loadData();
        initListener();
    }


    public void initListener() {
        mBtnFinish.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("album_picture", (Serializable) mSelectedPhotos);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
        mGvPhotos.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView ivSelectChecked = (ImageView) view.findViewById(R.id.iv_photo_select);
                if (ivSelectChecked.getVisibility() == View.GONE) {
                    if (getIntent().getAction() != null && getIntent().getAction().equals("publishFourPhotos")) {
                        if (mSize + mCount >= 4) {
                            Toast.makeText(PhotoSelectActivity.this,"已经选取3张照片~",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } else if (getIntent().getAction() != null && getIntent().getAction().equals("publishThreePhotos")) {
                        if (mSize + mCount >= 4) {
                            Toast.makeText(PhotoSelectActivity.this,"已经选取3张照片~",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    ivSelectChecked.setVisibility(View.VISIBLE);
                    mSelectedPhotos.add(mAllLocalPhotos.get(position));
                    mCount++;
                } else {
                    ivSelectChecked.setVisibility(View.GONE);
                    mSelectedPhotos.remove(mAllLocalPhotos.get(position));
                    mCount--;
                }
                mBtnFinish.setText("完成(" + mCount + ")");
            }
        });
    }

    public void loadData() {
        mSize = getIntent().getIntExtra("size", 0);
        mMyGridAdapter = new MyGridAdapter();
        //query(new File(AppEnum.IMAGE));
        getImages();
    }

    /**
     * @throws
     * @Title:
     * @Description: 查询vio文件夹下的所有照片
     * @param:
     * @return: void
     */
    public void query(File file) {
        if (file.exists()) {
            File[] fils = file.listFiles();
            for (int i = 0; i < fils.length; i++) {
                if (fils[i].isDirectory()) {
                    query(fils[i]);
                } else {
                    mAllLocalPhotos.add(fils[i].getAbsolutePath());
                }
            }
        } else
            return;

        // String[] filePathColumn = { MediaStore.Images.Media.DATA };
        // Cursor cursor =
        // getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        // filePathColumn, null, null,
        // MediaStore.Images.Media.DATE_ADDED.concat(" desc"));
        // for (cursor.moveToFirst(); !cursor.isAfterLast();
        // cursor.moveToNext()) {
        // String filepath =
        // cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
        // mAllLocalPhotos.add(filepath);
        // }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mProgressDialog.dismiss();
            mGvPhotos.setAdapter(mMyGridAdapter);
        }
    };
    private ProgressDialog mProgressDialog;

    /**
     * 利用ContentProvider扫描手机中的图片，此方法在运行在子线程中 完成图片的扫描，最终获得jpg最多的那个文件夹
     */
    private void getImages() {
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this,"暂无外部存储",Toast.LENGTH_SHORT).show();
            return;
        }
        // 显示进度条
        mProgressDialog = ProgressDialog.show(this, null, "正在加载...");
        new Thread(new Runnable() {
            @Override
            public void run() {
                String firstImage = null;
                Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                ContentResolver mContentResolver = PhotoSelectActivity.this
                        .getContentResolver();
                // 只查询jpeg和png的图片
                Cursor mCursor = mContentResolver.query(mImageUri, null,
                        MediaStore.Images.Media.MIME_TYPE + "=? or "
                                + MediaStore.Images.Media.MIME_TYPE + "=?",
                        new String[]{"image/jpeg", "image/png"},
                        MediaStore.Images.Media.DATE_MODIFIED);
                while (mCursor.moveToNext()) {
                    // 获取图片的路径
                    String path = mCursor.getString(mCursor
                            .getColumnIndex(MediaStore.Images.Media.DATA));
                    File file = new File(path);
                    if (file.exists()) {
                        mAllLocalPhotos.add(path);
                    }
                    file = null;
                }
                mCursor.close();
                // 扫描完成，辅助的HashSet也就可以释放内存了
                // 通知Handler扫描图片完成
                handler.sendEmptyMessage(1);
            }
        }).start();
    }



    private class MyGridAdapter extends BaseAdapter {
        private LayoutInflater mInflater = null;

        public MyGridAdapter() {
            mInflater = LayoutInflater.from(PhotoSelectActivity.this);
        }

        @Override
        public int getCount() {
            return mAllLocalPhotos.size();
        }

        @Override
        public Object getItem(int arg0) {
            return mAllLocalPhotos.get(arg0);
        }

        @Override
        public long getItemId(int arg0) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup arg2) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.photo_select_item, null);
                holder.ivPhoto = (LocalNetWorkView) convertView.findViewById(R.id.iv_photo);
                holder.ivSelectedLogo = (ImageView) convertView.findViewById(R.id.iv_photo_select);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            ImageLoader.getInstance().displayImage(
                    "file://" + mAllLocalPhotos.get(position), holder.ivPhoto);
            holder.ivSelectedLogo.setVisibility(mSelectedPhotos.contains(mAllLocalPhotos.get(position)) ? View.VISIBLE : View.GONE);
            return convertView;
        }
    }

    private class ViewHolder {
        LocalNetWorkView ivPhoto = null;
        ImageView ivSelectedLogo = null;
    }

}
