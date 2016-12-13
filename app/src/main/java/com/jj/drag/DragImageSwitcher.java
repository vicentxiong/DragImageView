package com.jj.drag;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

/**
 * Created by xiongxin on 16-9-8.
 */
public class DragImageSwitcher extends ImageSwitcher{
    public DragImageSwitcher(Context context) {
        this(context,null);
    }

    public DragImageSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * add bitmap
     * @param bitmap
     */
    public void setImageBitmap(Bitmap bitmap){
        ImageView image = (ImageView) this.getNextView();
        image.setImageBitmap(bitmap);
        showNext();
    }
}
