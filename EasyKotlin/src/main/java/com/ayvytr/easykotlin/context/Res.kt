package com.ayvytr.easykotlin.context

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ArrayRes
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import com.ayvytr.easykotlin.EasyKotlin

/**
 * 这个类是专门用于自定义控件时，需要使用控件的 [Context] 时，专门提供的类，用来做控件的 Context 相关操作
 *
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.1
 */

object Res
{
    /**
     * 从资源中获取Drawable
     *
     * @param id Drawable资源id
     * @return Drawable
     */
    fun getDrawable(@DrawableRes id: Int): Drawable?
    {
        return ContextCompat.getDrawable(EasyKotlin.getContext(), id)
    }


    /**
     * 从资源中获取Dimension并返回
     *
     * @param id 尺寸资源id
     * @return 尺寸像素值
     */
    fun getDimen(@DimenRes id: Int): Int
    {
        return getDimenFloat(id).toInt()
    }

    /**
     * 从资源中获取Dimension并返回float类型
     *
     * @param id 尺寸资源id
     * @return 尺寸像素值
     */
    fun getDimenFloat(@DimenRes id: Int): Float
    {
        return EasyKotlin.getContext().resources.getDimension(id)
    }


    /**
     * 从资源中获取Color
     *
     * @param id 颜色资源id
     * @return 颜色值
     */
    fun getColor(@ColorRes id: Int): Int
    {
        return ContextCompat.getColor(EasyKotlin.getContext(), id)
    }

    /**
     * 获取返回String array.
     *
     * @param id resource id
     * @return String array
     */
    fun getStringArray(@ArrayRes id: Int): Array<String>
    {
        return EasyKotlin.getContext().resources.getStringArray(id)
    }

    /**
     * 获取返回int array.
     *
     * @param id resource id
     * @return int array
     */
    fun getIntArray(@ArrayRes id: Int): IntArray
    {
        return EasyKotlin.getContext().resources.getIntArray(id)
    }

    /**
     * 获取返回text id.
     *
     * @param id resource id
     * @return text array
     */
    fun getTextArray(@ArrayRes id: Int): Array<CharSequence>
    {
        return EasyKotlin.getContext().resources.getTextArray(id)
    }
}