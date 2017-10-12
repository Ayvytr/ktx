package com.ayvytr.easykotlin.context

import android.content.Context

/**
 * Created by Do on 2017/10/12.
 */

/**
 * 将px转换为dp
 *
 * @param px 像素值
 * @return dp值
 */
fun Context.px2dp(px: Int): Int
{
    return px2dp(px.toFloat()).toInt()
}

/**
 * 将px转换为dp，接收/返回float
 *
 * @param px 像素值
 * @return dp值
 */
fun Context.px2dp(px: Float): Float
{
    return px2dp(px.toDouble()).toFloat()
}

/**
 * 将px转换为dp，接收/返回double
 *
 * @param px 像素值
 * @return dp值
 */
fun Context.px2dp(px: Double): Double
{
    val scale = resources.displayMetrics.density
    return px / scale + 0.5F
}

/**
 * 将dp转换为px，接收/返回int
 *
 * @param dp dp值
 * @return 像素值
 */
fun Context.dp2px(dp: Int): Int
{
    return dp2px(dp.toFloat()).toInt()
}

/**
 * 将dp转换为px，接收/返回float
 *
 * @param dp dp值
 * @return 像素值
 */
fun Context.dp2px(dp: Float): Float
{
    return dp2px(dp.toDouble()).toFloat()
}

/**
 * 将dp转换为px，接收/返回double
 *
 * @param dp dp值
 * @return 像素值
 */
fun Context.dp2px(dp: Double): Double
{
    val scale = resources.displayMetrics.density
    return dp * scale + 0.5F
}

