package com.example.xiejingwen.m2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by xiejingwen on 2017/11/8.
 */

public class CircleImageView extends View {
    private int resId;
    private Bitmap bitmap;
    private Paint paint;
    private int bitmapWidth,bitmapHeight;
    private int size;
    private PorterDuffXfermode xfermode;

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setDither(true);//设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        paint.setFilterBitmap(true);//加快显示速度，本设置项依赖于dither和xfermode的设置
        bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.pic_shuoming_pic02);
        bitmapWidth=bitmap.getWidth();
        bitmapHeight=bitmap.getHeight();
        xfermode=new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        size=Math.min(bitmapWidth,bitmapHeight);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(size,size);
    }

    /**
     * 生成圆形Bitmap
     * @return
     */
    private Bitmap makeCircle(){
        Bitmap bitmap=Bitmap.createBitmap(size,size, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        int radius=size/2;
        canvas.drawCircle(size/2,size/2,radius,paint);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int sc=canvas.saveLayer(0,0,size,size,paint,Canvas.ALL_SAVE_FLAG);
        Bitmap dst=makeCircle();
        canvas.drawBitmap(dst,0,0,new Paint());
        paint.setXfermode(xfermode);
        canvas.drawBitmap(bitmap,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(sc);
    }
}
