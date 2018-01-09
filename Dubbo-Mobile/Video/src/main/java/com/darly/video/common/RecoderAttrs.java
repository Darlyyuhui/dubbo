package com.darly.video.common;

import android.content.Context;
import android.widget.Toast;

import com.darly.video.R;
import com.darly.video.camera.util.FileUtils;

/**
 * Created by maimingliang on 2016/9/25.
 * 设置录制参数
 */

public class RecoderAttrs {


    /**
     * 录制最长时间
     */
    private int recoderTimeMax;
    /**
     * 录制最小时间
     */

    private int recoderTimeMin;

    /**
     * 按住拍偏移距离
     */

    private int offsetDrution;

    /**
     * titel_bar 取消颜色
     * 值为 十六进制 如：0xFFFC2828
     */
    private int titelBarCancelTextColor;

    /**
     * 按住拍 字体颜色
     * 值为 十六进制 如：0xFFFC2828
     */

    private int pressBtnColor;


    /**
     * progress 小于录制最少时间的颜色
     * 值为 十六进制 如：0xFFFC2828
     */
    private int lowMinTimeProgressColor;
    /**
     * progress 颜色
     * 值为 十六进制 如：0xFFFC2828
     */
    private int progressColor;


    private int pressBtnBg;


    private RecoderAttrs(int recoderTimeMax, int recoderTimeMin, int offsetDrution, int titelBarCancelTextColor, int pressBtnColor, int lowMinTimeProgressColor, int progressColor, int pressBtnBg) {
        this.recoderTimeMax = recoderTimeMax;
        this.recoderTimeMin = recoderTimeMin;
        this.offsetDrution = offsetDrution;
        this.titelBarCancelTextColor = titelBarCancelTextColor;
        this.pressBtnColor = pressBtnColor;
        this.lowMinTimeProgressColor = lowMinTimeProgressColor;
        this.progressColor = progressColor;
        this.pressBtnBg = pressBtnBg;
    }


    public int getRecoderTimeMax() {
        return recoderTimeMax;
    }

    public int getRecoderTimeMin() {
        return recoderTimeMin;
    }

    public int getOffsetDrution() {
        return offsetDrution;
    }

    public int getTitelBarCancelTextColor() {
        return titelBarCancelTextColor;
    }

    public int getPressBtnColor() {
        return pressBtnColor;
    }

    public int getLowMinTimeProgressColor() {
        return lowMinTimeProgressColor;
    }

    public int getProgressColor() {
        return progressColor;
    }

    public int getPressBtnBg() {
        return pressBtnBg;
    }

    public static class Builder {

        private int recoderTimeMax;
        private int recoderTimeMin;
        private int offsetDrution;
        private int titleBarCancelTextColor;
        private int pressBtnColor;
        private int lowMinTimeProgressColor;
        private int progressColor;
        private int pressBtnBg;

        public Builder recoderTimeMax(int recoderTimeMax) {
            this.recoderTimeMax = recoderTimeMax;
            return this;
        }

        public Builder recoderTimeMin(int recoderTimeMin) {
            this.recoderTimeMin = recoderTimeMin;
            return this;
        }

        public Builder offsetDrution(int offsetDrution) {
            this.offsetDrution = offsetDrution;
            return this;
        }

        public Builder titleBarCancelTextColor(int titleBarCancelTextColor) {
            this.titleBarCancelTextColor = titleBarCancelTextColor;
            return this;
        }

        public Builder pressBtnTextColor(int pressBtnColor) {
            this.pressBtnColor = pressBtnColor;
            return this;
        }

        public Builder lowMinTimeProgressColor(int lowMinTimeProgressColor) {
            this.lowMinTimeProgressColor = lowMinTimeProgressColor;
            return this;
        }

        public Builder progressColor(int progressColor) {
            this.progressColor = progressColor;
            return this;
        }


        public Builder pressBtnColorBg(int pressBtnBg) {
            this.pressBtnBg = pressBtnBg;
            return this;
        }

        public RecoderAttrs build() {
            return new RecoderAttrs(
                    recoderTimeMax,
                    recoderTimeMin,
                    offsetDrution,
                    titleBarCancelTextColor,
                    pressBtnColor,
                    lowMinTimeProgressColor,
                    progressColor,
                    pressBtnBg);
        }

    }

    public final static int AVAILABLE_SPACE = 500;//M

    /**
     * 检测用户手机是否剩余可用空间200M以上
     *
     * @return
     */
    public static boolean isAvailableSpace(Context context) {
        if (context == null) {
            return false;
        }
        //检测磁盘空间
        if (FileUtils.showFileAvailable() < AVAILABLE_SPACE) {
            Toast.makeText(context,context.getString(R.string.record_check_available_faild, AVAILABLE_SPACE),Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
