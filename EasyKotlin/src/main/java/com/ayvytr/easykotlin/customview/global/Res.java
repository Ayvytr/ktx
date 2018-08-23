package com.ayvytr.easykotlin.customview.global;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ArrayRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;

/**
 * 这个类是专门用于自定义控件时，需要使用控件的 {@link Context} 时，专门提供的类，用来做控件相关操作.
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @since 2.0.0
 */

public class Res
{
    /**
     * 从资源中获取Drawable
     *
     * @param id Drawable资源id
     * @return Drawable
     */
    public static Drawable getDrawable(Context context, @DrawableRes int id)
    {
        return ContextCompat.getDrawable(context, id);
    }


    /**
     * 从资源中获取Dimension并返回
     *
     * @param id 尺寸资源id
     * @return 尺寸像素值
     */
    public static int getDimen(Context context, @DimenRes int id)
    {
        return (int) getDimenFloat(context, id);
    }

    /**
     * 从资源中获取Dimension并返回float类型
     *
     * @param id 尺寸资源id
     * @return 尺寸像素值
     */
    public static float getDimenFloat(Context context, @DimenRes int id)
    {
        return context.getResources().getDimension(id);
    }

    /**
     * 从资源中获取Dimension并返回
     *
     * @param id 像素资源id
     * @return 尺寸dp值
     */
    public static int getDimenToDp(Context context, @DimenRes int id)
    {
        return (int) getDimenFloatToDp(context, id);
    }

    /**
     * 从资源中获取Dimension并返回float类型
     *
     * @param id 像素资源id
     * @return 尺寸dp值
     */
    public static float getDimenFloatToDp(Context context, @DimenRes int id)
    {
        return Density.px2dp(context, getDimenFloat(context, id));
    }

    /**
     * 从资源中获取Color
     *
     * @param id 颜色资源id
     * @return 颜色值
     */
    public static int getColor(Context context, @ColorRes int id)
    {
        return ContextCompat.getColor(context, id);
    }

    /**
     * 获取返回String array.
     *
     * @param id resource id
     * @return String array
     */
    public static String[] getStringArray(Context context, @ArrayRes int id)
    {
        return context.getResources().getStringArray(id);
    }

    /**
     * 获取返回int array.
     *
     * @param id resource id
     * @return int array
     */
    public static int[] getIntArray(Context context, @ArrayRes int id)
    {
        return context.getResources().getIntArray(id);
    }

    /**
     * 获取返回text id.
     *
     * @param id resource id
     * @return text array
     */
    public static CharSequence[] getTextArray(Context context, @ArrayRes int id)
    {
        return context.getResources().getTextArray(id);
    }

}
