package com.ayvytr.easykotlin.customview.global;

import android.content.Context;

/**
 * Dp - Px 相互转化类，提供了int，float，double 3种类型的重载方法，尽可能减少外部强制类型转换，
 * 并添加了Context参数，直接通过Context进行转换.
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @since 2.0.0
 */

public class Density
{
    private Density()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * 将px转换为dp
     *
     * @param context Context
     * @param px      像素值
     * @return dp值
     */
    public static int px2dp(Context context, int px)
    {
        return (int) px2dp(context, (float) px);
    }

    /**
     * 将px转换为dp，接收/返回float
     *
     * @param context Context
     * @param px      像素值
     * @return dp值
     */
    public static float px2dp(Context context, float px)
    {
        return (float) px2dp(context, (double) px);
    }

    /**
     * 将px转换为dp，接收/返回double
     *
     * @param context Context
     * @param px      像素值
     * @return dp值
     */
    public static double px2dp(Context context, double px)
    {
        float scale = context.getResources().getDisplayMetrics().density;
        return px / scale + 0.5;
    }

    /**
     * 将dp转换为px，接收/返回int
     *
     * @param context Context
     * @param dp      dp值
     * @return 像素值
     */
    public static int dp2px(Context context, int dp)
    {
        return (int) dp2px(context, (float) dp);
    }

    /**
     * 将dp转换为px，接收/返回float
     *
     * @param context Context
     * @param dp      dp值
     * @return 像素值
     */
    public static float dp2px(Context context, float dp)
    {
        return (float) dp2px(context, (double) dp);
    }

    /**
     * 将dp转换为px，接收/返回double
     *
     * @param context Context
     * @param dp      dp值
     * @return 像素值
     */
    public static double dp2px(Context context, double dp)
    {
        float scale = context.getResources().getDisplayMetrics().density;
        return dp * scale + 0.5f;
    }
}
