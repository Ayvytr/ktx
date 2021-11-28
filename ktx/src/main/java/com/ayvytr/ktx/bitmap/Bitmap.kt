package com.ayvytr.ktx.bitmap

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PixelFormat
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import java.io.ByteArrayOutputStream

/**
 * 为 Bitmap 和 Drawable 类提供的互相转换的方法.
 *
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

/**
 * Drawable -> Bitmap
 */
fun Drawable.toBitmap(): Bitmap
{
    if (this is BitmapDrawable)
    {
        return this.bitmap
    }

    val bitmap: Bitmap
    val w = intrinsicWidth
    val h = intrinsicHeight
    val config = if (opacity != PixelFormat.OPAQUE)
        Bitmap.Config.ARGB_8888
    else
        Bitmap.Config.RGB_565
    bitmap = Bitmap.createBitmap(w, h, config)
    //注意，下面三行代码要用到，否在在View或者surfaceview里的canvas.drawBitmap会看不到图
    val canvas = Canvas(bitmap)
    setBounds(0, 0, w, h)
    draw(canvas)
    return bitmap
}

/**
 * Bitmap -> Drawable.
 */
fun Bitmap.toDrawable(context: Context): Drawable
{
    return BitmapDrawable(context.resources, this)
}

/**
 * Bitmap -> ByteArray
 */
fun Bitmap.toByteArray(): ByteArray
{
    val b = ByteArrayOutputStream()
    compress(Bitmap.CompressFormat.PNG, 100, b)
    val bytes = b.toByteArray()
    b.close()

    return bytes
}

