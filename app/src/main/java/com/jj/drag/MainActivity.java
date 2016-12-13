package com.jj.drag;

import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Gallery;
import android.widget.ImageSwitcher;

public class MainActivity extends Activity {
	private int window_width, window_height;// �ؼ����
	private Gallery dragImageView;// �Զ���ؼ�

	private ImageReader mReader;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		/** ��ȡ��Ҋ����߶� **/

		WindowManager manager = getWindowManager();
		window_width = manager.getDefaultDisplay().getWidth();
		window_height = manager.getDefaultDisplay().getHeight();
		Log.d("xx","width = " + window_width + " height = " + window_height);
		dragImageView = (Gallery) findViewById(R.id.div_main);
		Bitmap bmp = BitmapUtil.ReadBitmapById(this, R.drawable.huoying,
				window_width, window_height);
		// ����ͼƬ

		mReader = new ImageReader(this,dragImageView);
		mReader.addBitmap(bmp);

		/** ����״̬���߶� **/


	}

	/**
	 * ��ȡ������Դ��ͼƬ
	 * 
	 * @param context
	 * @param resId
	 * @return
	 */
	public static Bitmap ReadBitmapById(Context context, int resId) {
		BitmapFactory.Options opt = new BitmapFactory.Options();
		opt.inPreferredConfig = Bitmap.Config.RGB_565;
		opt.inPurgeable = true;
		opt.inInputShareable = true;
		// ��ȡ��ԴͼƬ
		InputStream is = context.getResources().openRawResource(resId);
		return BitmapFactory.decodeStream(is, null, opt);
	}

}