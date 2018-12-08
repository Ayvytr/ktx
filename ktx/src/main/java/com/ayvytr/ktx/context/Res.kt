package com.ayvytr.ktx.context

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.support.annotation.ArrayRes
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat

/**
 * 专门为方便 [Context] 类获取字符串等资源提供的方法，部分方法因为和系统弃用方法名相同，所以在类名后跟了数字2，比如 getDrawable2.
 *
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

/**
 * @see android.content.res.Resources.getStringArray
 */
fun Context.getStringArray(@ArrayRes id: Int): Array<String>
{
    return resources.getStringArray(id)
}

/**
 * @see android.content.res.Resources.getIntArray
 */
fun Context.getIntArray(@ArrayRes id: Int): IntArray
{
    return resources.getIntArray(id)
}

/**
 * @see android.content.res.Resources.getTextArray
 */
fun Context.getTextArray(@ArrayRes id: Int): Array<CharSequence>
{
    return resources.getTextArray(id)
}

/**
 * @see android.content.res.Resources.obtainTypedArray
 */
fun Context.getTypedArray(@ArrayRes id: Int): TypedArray
{
    return resources.obtainTypedArray(id)
}

/**
 * @see ContextCompat.getDrawable
 */
fun Context.getDrawable2(@DrawableRes id: Int): Drawable?
{
    return ContextCompat.getDrawable(this, id)
}

/**
 * @see ContextCompat.getColor
 */
fun Context.getColor2(@ColorRes id: Int): Int
{
    return ContextCompat.getColor(this, id)
}

/**
 * @See android.content.res.Resources.getConfiguration
 */
fun Context.getConfiguration() = resources.configuration

/**
 * @see android.content.res.Resources.getDimension
 */
fun Context.getDimen(@DimenRes id: Int) = resources.getDimension(id)

/**
 * 获取返回 Drawable array
 * @see getTypedArray
 */
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

/**
 * 获取返回 Drawable id array
 * @see getTypedArray
 */
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