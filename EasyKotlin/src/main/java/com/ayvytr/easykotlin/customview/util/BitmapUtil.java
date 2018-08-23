package com.ayvytr.easykotlin.customview.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 提供Bitmap，Drawable，byte[]的相互转换等图片转换功能.
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @since 2.0.0
 */

public class BitmapUtil
{

    /**
     * drawable 转换为 Bitmap.
     *
     * @param drawable Drawable
     * @return Bitmap
     */
    private static Bitmap toBitmap1(Drawable drawable)
    {
        BitmapDrawable bd = (BitmapDrawable) drawable;
        return bd.getBitmap();
    }

    /**
     * drawable 转换为 Bitmap.
     *
     * @param drawable Drawable
     * @return Bitmap
     */
    private static Bitmap toBitmap2(Drawable drawable)
    {
        Bitmap bitmap;
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap.Config config =
                drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                        : Bitmap.Config.RGB_565;
        bitmap = Bitmap.createBitmap(w, h, config);
        //注意，下面三行代码要用到，否在在View或者surfaceview里的canvas.drawBitmap会看不到图
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * Drawable 转换返回 Bitmap.
     *
     * @param drawable Drawable
     * @return Bitmap
     */
    public static Bitmap toBitmap(Drawable drawable)
    {
        try
        {
            /*
             直接强转BitmapDrawable有时报错：
             java.lang.ClassCastException: android.graphics.drawable.VectorDrawable
             cannot be cast to android.graphics.drawable.BitmapDrawable
             */
            return toBitmap1(drawable);
        } catch(Exception e)
        {
            e.printStackTrace();
            return toBitmap2(drawable);
        }
    }


    /**
     * byte[] 转换为 Bitmap.
     *
     * @param bytes byte[]
     * @return Bitmap
     */
    public static Bitmap toBitmap(byte[] bytes)
    {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }


    /**
     * Drawable 转换为 byte[].
     *
     * @param drawable Drawable
     * @return byte[]
     */
    public static byte[] toByteArray(Drawable drawable)
    {
        return toByteArray(toBitmap(drawable));
    }

    /**
     * Bitmap 转换为 byte[].
     *
     * @param bitmap Bitmap
     * @return byte[]
     */
    public static byte[] toByteArray(Bitmap bitmap)
    {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, b);
        byte[] bytes = b.toByteArray();
        try
        {
            b.close();
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        return bytes;
    }
}
