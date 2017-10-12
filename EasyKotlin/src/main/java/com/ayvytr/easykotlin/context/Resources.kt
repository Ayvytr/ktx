package com.ayvytr.easykotlin.context

import android.content.Context
import android.content.res.Configuration
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.support.annotation.ArrayRes
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat

/**
 * Created by Do on 2017/10/11.
 */

fun Context.getStringArray(@ArrayRes id:Int): Array<String>
{
    return resources.getStringArray(id)
}

fun Context.getIntArray(@ArrayRes id:Int): IntArray
{
    return resources.getIntArray(id)
}

fun Context.getTextArray(@ArrayRes id:Int): Array<CharSequence>
{
    return resources.getTextArray(id)
}

fun Context.getTypedArray(@ArrayRes id: Int): TypedArray
{
    return resources.obtainTypedArray(id)
}

fun Context.getDrawable2(@DrawableRes id: Int): Drawable
{
    return ContextCompat.getDrawable(this, id)
}

fun Context.getColor2(@ColorRes id: Int): Int
{
    return ContextCompat.getColor(this, id)
}

fun Context.getConfiguration(): Configuration
{
    return resources.configuration
}

fun Context.getDimen(@DimenRes id: Int): Float
{
    return resources.getDimension(id)
}

fun Context.getDrawableArray(@ArrayRes id: Int): Array<Drawable?>
{
    val typedArray = getTypedArray(id)
    //获取数量需要用这样的方法, TypedArray.getIndexCount() 获取的一直是0.
    val count = getTextArray(id).size
    val drawables = arrayOfNulls<Drawable>(count)
    for (i in drawables.indices)
    {
        drawables[i] = typedArray.getDrawable(i)
    }
    typedArray.recycle()

    return drawables
}


fun Context.getDrawableIdArray(@ArrayRes id: Int): IntArray
{
    val typedArray = getTypedArray(id)
    val length = getTextArray(id).size
    val ids = IntArray(length)
    for (i in ids.indices)
    {
        ids[i] = typedArray.getResourceId(i, 0)
    }
    typedArray.recycle()

    return ids
}