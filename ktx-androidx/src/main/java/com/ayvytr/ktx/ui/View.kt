package com.ayvytr.ktx.ui

import android.view.View
import android.view.View.*

/**
 * View 相关的Kotlin扩展方法
 * <p>
 *
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 0.1.0
 */


/**
 * 隐藏 View
 */
fun View.hide(isTrue: Boolean = true) {
    if (isTrue) visibility = GONE else VISIBLE
}


/**
 * 显示/隐藏 View
 * @param isTrue {@code true } 显示<br>{@code false} 隐藏
 */
fun View.show(isTrue: Boolean = true) {
    if (isTrue) visibility = VISIBLE else GONE
}

/**
 * invisible/显示 View
 * @param `true` INVISIBLE, `false` VISIBLE
 */
fun View.invisible(isTrue: Boolean = true) {
    if (isTrue) visibility = INVISIBLE else VISIBLE
}


/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] == [View.VISIBLE])
 */
fun View.isVisible(): Boolean {
    return visibility == VISIBLE
}

/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] == [View.VISIBLE])
 */
fun View.isShow(): Boolean {
    return isVisible()
}

/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] == [View.VISIBLE])
 */
fun View.isNotShow(): Boolean {
    return !isVisible()
}

/**
 * 判断View是不是可见
 *
 * @return `true` 不可见([View.getVisibility] != [View.VISIBLE])
 */
fun View.isNotVisible(): Boolean {
    return !isVisible()
}

/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] == [View.INVISIBLE])
 */
fun View.isInvisible(): Boolean
{
    return visibility == INVISIBLE
}

/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] != [View.INVISIBLE])
 */
fun View.isNotInvisible(): Boolean
{
    return !isInvisible()
}

/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] == [View.GONE])
 */
fun View.isGone(): Boolean {
    return visibility == GONE
}


/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] == [View.GONE])
 */
fun View.isHide(): Boolean {
    return isGone()
}

/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] != [View.GONE])
 */
fun View.isNotHide(): Boolean {
    return !isGone()
}


/**
 * 将px转换为dp
 *
 * @param px 像素值
 * @return dp值
 */
fun View.px2dp(px: Int): Int
{
    return px2dp(px.toFloat()).toInt()
}

/**
 * 将px转换为dp，接收/返回float
 *
 * @param px 像素值
 * @return dp值
 */
fun View.px2dp(px: Float): Float
{
    return px2dp(px.toDouble()).toFloat()
}

/**
 * 将px转换为dp，接收/返回double
 *
 * @param px 像素值
 * @return dp值
 */
fun View.px2dp(px: Double): Double
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
fun View.dp2px(dp: Int): Int
{
    return dp2px(dp.toFloat()).toInt()
}

/**
 * 将dp转换为px，接收/返回float
 *
 * @param dp dp值
 * @return 像素值
 */
fun View.dp2px(dp: Float): Float
{
    return dp2px(dp.toDouble()).toFloat()
}

/**
 * 将dp转换为px，接收/返回double
 *
 * @param dp dp值
 * @return 像素值
 */
fun View.dp2px(dp: Double): Double
{
    val scale = resources.displayMetrics.density
    return dp * scale + 0.5F
}



