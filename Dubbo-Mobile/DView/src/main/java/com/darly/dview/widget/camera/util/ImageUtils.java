package com.darly.dview.widget.camera.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.hardware.Camera;


import com.darly.dview.R;
import com.darly.dview.observer.SystemCfg;

import java.io.File;
import java.io.FileOutputStream;

public class ImageUtils {

	private Context mContext;

	public ImageUtils(Context mContext) {
		this.mContext = mContext;
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

	public void pressText(String targetImg, String time, String road, String code) {

		Bitmap bm = BitmapFactory.decodeFile(targetImg);

		int w = bm.getWidth();
		int h = bm.getHeight();

		Bitmap newmap = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		Canvas mcanvas = new Canvas(newmap);

		Paint textpaint = new Paint();
		textpaint.setColor(Color.RED);
		textpaint.setTextSize(SystemCfg.getTextSize());
		String texttype = mContext.getResources().getString(R.string.font);
		Typeface typeface = Typeface.create(texttype, Typeface.BOLD_ITALIC);

		textpaint.setTypeface(typeface);
		textpaint.setTextAlign(Align.LEFT);

		mcanvas.drawBitmap(bm, 0, 0, null);

		mcanvas.drawText(time, 10, SystemCfg.getTextSize() + 40, textpaint);
		mcanvas.drawText(road, 10, SystemCfg.getTextSize() + 80, textpaint);
		mcanvas.drawText(code, 10, SystemCfg.getTextSize() + 120, textpaint);
		mcanvas.drawText(mContext.getResources().getString(R.string.deviceType) + SystemCfg.getAccount(), 10, SystemCfg.getTextSize() + 200, textpaint);
		mcanvas.save(Canvas.ALL_SAVE_FLAG);
		mcanvas.restore();

		saveFile(newmap, targetImg);

	}

	public void pressText(String targetImg, String time, String yjxh, String hphm, String bllx) {

		Bitmap bm = BitmapFactory.decodeFile(targetImg);

		int w = bm.getWidth();
		int h = bm.getHeight();

		Bitmap newmap = Bitmap.createBitmap(w, h, Config.ARGB_8888);
		Canvas mcanvas = new Canvas(newmap);

		Paint textpaint = new Paint();
		textpaint.setColor(Color.RED);
		textpaint.setTextSize(SystemCfg.getTextSize());
		String texttype = mContext.getResources().getString(R.string.font);
		Typeface typeface = Typeface.create(texttype, Typeface.BOLD_ITALIC);

		textpaint.setTypeface(typeface);
		textpaint.setTextAlign(Align.LEFT);

		mcanvas.drawBitmap(bm, 0, 0, null);

		mcanvas.drawText(time, 10, SystemCfg.getTextSize() + 40, textpaint);
		mcanvas.drawText(yjxh, 10, SystemCfg.getTextSize() + 80, textpaint);
		mcanvas.drawText(hphm, 10, SystemCfg.getTextSize() + 120, textpaint);
		mcanvas.drawText(bllx, 10, SystemCfg.getTextSize() + 160, textpaint);
//		mcanvas.drawText(mContext.getResources().getString(R.string.deviceType) + SystemCfg.getAccount(mContext), 10, SystemCfg.getTextSize(mContext) + 200, textpaint);
		mcanvas.save(Canvas.ALL_SAVE_FLAG);
		mcanvas.restore();

		saveFile(newmap, targetImg);

	}

	public void saveFile(Bitmap pBitmap, String fileName) {
		File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}

		// String filePathName = file.getAbsolutePath() + "/" + fileName;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(fileName);
			pBitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos);
			fos.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	public int getLength(String text) {
		int textLength = text.length();
		int length = textLength;
		for (int i = 0; i < textLength; i++) {
			if (String.valueOf(text.charAt(i)).getBytes().length > 1) {
				length++;
			}
		}
		return (length % 2 == 0) ? length / 2 : length / 2 + 1;
	}
	/*
	 * public void resize(String filePath, int height, int width, boolean bb) {
	 * try { double ratio = 0; File f = new File(filePath); BufferedImage bi; bi
	 * = ImageIO.read(f); Image itemp = bi.getScaledInstance(width, height,
	 * BufferedImage.SCALE_SMOOTH); if((bi.getHeight() > height) ||
	 * (bi.getWidth() > width)) { if(bi.getHeight() > bi.getWidth()) { ratio =
	 * (new Integer(height).doubleValue() / bi.getHeight()); } else { ratio =
	 * (new Integer(width).doubleValue() / bi.getWidth()); } AffineTransformOp
	 * op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio,
	 * ratio), null); itemp = op.filter(bi, null); } if(bb) { BufferedImage
	 * image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	 * Graphics2D g = image.createGraphics(); g.setColor(Color.WHITE);
	 * g.fillRect(0, 0, width, height); if(width == itemp.getWidth(null))
	 * g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
	 * itemp.getWidth(null), itemp.getHeight(null), Color.white, null); else
	 * g.drawImage(itemp, (width - itemp.getWidth(null) / 2), 0,
	 * itemp.getWidth(null), itemp.getHeight(null), Color.white, null);
	 * 
	 * g.dispose(); itemp = image;
	 * 
	 * 
	 * } ImageIO.write((BufferedImage)itemp, "jpg", f); } catch (IOException e)
	 * { // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */
}
