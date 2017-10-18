package com.ayvytr.easykotlin.context

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ArrayRes
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat

/**
 * 这个类是专门用于自定义控件时，需要使用控件的 [Context] 时，专门提供的类，用来做控件的 Context 相关操作
 *
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

object ResCompat
{
    /**
     * 从资源中获取Drawable
     *
     * @param id Drawable资源id
     * @return Drawable
     */
    fun getDrawable(context: Context, @DrawableRes id: Int): Drawable
    {
        return ContextCompat.getDrawable(context, id)
    }


    /**
     * 从资源中获取Dimension并返回
     *
     * @param id 尺寸资源id
     * @return 尺寸像素值
     */
    fun getDimen(context: Context, @DimenRes id: Int): Int
    {
        return getDimenFloat(context, id).toInt()
    }

    /**
     * 从资源中获取Dimension并返回float类型
     *
     * @param id 尺寸资源id
     * @return 尺寸像素值
     */
    fun getDimenFloat(context: Context, @DimenRes id: Int): Float
    {
        return context.resources.getDimension(id)
    }


    /**
     * 从资源中获取Color
     *
     * @param id 颜色资源id
     * @return 颜色值
     */
    fun getColor(context: Context, @ColorRes id: Int): Int
    {
        return ContextCompat.getColor(context, id)
    }

    /**
     * 获取返回String array.
     *
     * @param id resource id
     * @return String array
     */
    fun getStringArray(context: Context, @ArrayRes id: Int): Array<String>
    {
        return context.resources.getStringArray(id)
    }

    /**
     * 获取返回int array.
     *
     * @param id resource id
     * @return int array
     */
    fun getIntArray(context: Context, @ArrayRes id: Int): IntArray
    {
        return context.resources.getIntArray(id)
    }

    /**
     * 获取返回text id.
     *
     * @param id resource id
     * @return text array
     */
    fun getTextArray(context: Context, @ArrayRes id: Int): Array<CharSequence>
    {
        return context.resources.getTextArray(id)
    }

}
