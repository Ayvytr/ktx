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
    visibility = if (isTrue) GONE else VISIBLE
}


/**
 * 显示/隐藏 View
 * @param isTrue {@code true } 显示<br>{@code false} 隐藏
 */
fun View.show(isTrue: Boolean = true) {
    visibility = if (isTrue) VISIBLE else GONE
}

/**
 * invisible/显示 View
 * @param `true` INVISIBLE, `false` VISIBLE
 */
fun View.invisible(isTrue: Boolean = true) {
    visibility = if (isTrue) INVISIBLE else VISIBLE
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
 * @return `true` 可见([View.getVisibility] == [View.INVISIBLE])
 */
fun View.isInvisible(): Boolean {
    return visibility == INVISIBLE
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





