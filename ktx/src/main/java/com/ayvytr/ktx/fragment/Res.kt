@file:JvmName("ResKt")
@file:JvmMultifileClass

package com.ayvytr.ktx.fragment

import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.support.annotation.ArrayRes
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat

/**
 * @author admin
 */

/**
 * @see android.content.res.Resources.getStringArray
 */
fun Fragment.getStringArray(@ArrayRes id: Int): Array<String>
{
    return resources.getStringArray(id)
}

/**
 * @see android.content.res.Resources.getIntArray
 */
fun Fragment.getIntArray(@ArrayRes id: Int): IntArray
{
    return resources.getIntArray(id)
}

/**
 * @see android.content.res.Resources.getTextArray
 */
fun Fragment.getTextArray(@ArrayRes id: Int): Array<CharSequence>
{
    return resources.getTextArray(id)
}

/**
 * @see android.content.res.Resources.obtainTypedArray
 */
fun Fragment.getTypedArray(@ArrayRes id: Int): TypedArray
{
    return resources.obtainTypedArray(id)
}

/**
 * @see ContextCompat.getDrawable
 */
fun Fragment.getDrawable2(@DrawableRes id: Int): Drawable?
{
    return ContextCompat.getDrawable(context!!, id)
}

/**
 * @see ContextCompat.getColor
 */
fun Fragment.getColor2(@ColorRes id: Int): Int
{
    return ContextCompat.getColor(context!!, id)
}

/**
 * @See android.content.res.Resources.getConfiguration
 */
fun Fragment.getConfiguration() = resources.configuration

/**
 * @see android.content.res.Resources.getDimension
 */
fun Fragment.getDimen(@DimenRes id: Int) = resources.getDimension(id)

/**
 * 获取返回 Drawable array
 * @see getTypedArray
 */
fun Fragment.getDrawableArray(@ArrayRes id: Int): Array<Drawable?>
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
fun Fragment.getDrawableIdArray(@ArrayRes id: Int): IntArray
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