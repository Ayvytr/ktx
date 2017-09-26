package com.ayvytr.easykotlin.view.ex

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
 * 显示 View
 */
fun View.show()
{
    visibility = View.VISIBLE
}

/**
 * 隐藏 View
 */
fun View.hide()
{
    visibility = View.GONE
}

/**
 * 设置View为 View.INVISIBLE
 */
fun View.invisible()
{
    visibility = View.INVISIBLE
}

/**
 * 显示/隐藏 View
 * @param isShow {@code true } 显示<br>{@code false} 隐藏
 */
fun View.show(isShow: Boolean)
{
    if (isShow) show() else hide()
}

/**
 * 显示/隐藏 View（注意：是 View.INVISIBLE 这个隐藏）
 * @param isShow {@code true} 显示<br>{@code false} 隐藏
 */
fun View.showOrInvisible(isShow: Boolean)
{
    if (isShow) show() else invisible()
}

/**
 * 设置View 可用/不可用
 * @param enable {@code true} 可用<br>{@code false} 不可用
 */
fun View.enable(enable: Boolean)
{
    isEnabled = enable
}

/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] == [View.VISIBLE])
 */
fun View.isVisible(): Boolean
{
    return visibility == VISIBLE
}

/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] == [View.VISIBLE])
 */
fun View.isShow(): Boolean
{
    return isVisible()
}

/**
 * 判断View是不是可见
 *
 * @return `true` 不可见([View.getVisibility] != [View.VISIBLE])
 */
fun View.isNotVisible(): Boolean
{
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
fun View.isGone(): Boolean
{
    return visibility == GONE
}

/**
 * 判断View是不是可见
 *
 * @return `true` 可见([View.getVisibility] != [View.GONE])
 */
fun View.isNotGone(): Boolean
{
    return !isGone()
}
