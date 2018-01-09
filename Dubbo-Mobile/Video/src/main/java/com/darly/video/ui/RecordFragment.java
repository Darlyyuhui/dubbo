package com.darly.video.ui;

import android.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.darly.video.R;

/**
 * Created by Zhangyuhui/Darly on 2017/6/19.
 * Copyright by [Zhangyuhui/Darly]
 * ©2017 XunXiang.Company. All rights reserved.
 *
 * @TODO:
 */
public class RecordFragment extends Fragment implements OnClickListener, OnPreparedListener, OnErrorListener, OnCompletionListener {

    public interface OnResultBackListener {
        void resultBack(String path);
    }

    private View root;

    private VideoView videoView;

    private MediaController mediaco;

    private String videoPath;

    private OnResultBackListener listener;

    private RelativeLayout reltivie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_recorder, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        listener();
    }


    private void initView() {
        videoView = (VideoView) root.findViewById(R.id.id_fragment_recorder_video);
        reltivie = (RelativeLayout) root.findViewById(R.id.id_fragment_recorder_relative);
        mediaco = new MediaController(getActivity());
        mediaco.setVisibility(View.INVISIBLE);
    }

    private void listener() {
        reltivie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivityForResult(new Intent(getActivity(), WechatRecoderActivity.class), 900);
    }


    public void setOnResultBackListener(OnResultBackListener listener) {
        this.listener = listener;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 901 && requestCode == 900) {
            videoPath = data.getStringExtra("path");
            listener.resultBack(videoPath);
            videoView.setVideoPath(videoPath);
            videoView.setMediaController(mediaco);
            videoView.setOnPreparedListener(this);
            videoView.setOnErrorListener(this);
            videoView.setOnCompletionListener(this);
            mediaco.setMediaPlayer(videoView);
            //让VideiView获取焦点
            videoView.requestFocus();
            videoView.start();
        }
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
        videoView.setVideoPath(videoPath);
        videoView.start();
    }

}
