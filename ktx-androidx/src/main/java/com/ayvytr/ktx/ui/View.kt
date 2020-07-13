package com.ayvytr.ktx.ui

import android.os.Build
import android.view.View
import android.view.View.*
import com.ayvytr.ktx.internal.Views

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



/**
 * [View]点击事件，点击[doActionAfterTimes]次后执行[action]，如果[doActionAfterTimes]==1,
 * [millisecondInterval]是防止重复点击的间隔；如果[doActionAfterTimes]>1，相当于双击，多次点击，以
 * [millisecondInterval]内点击记录点击次数，点击次数到[doActionAfterTimes]，触发[action].
 */
fun View.onClick(doActionAfterTimes: Int = 1, millisecondInterval: Int = 500, action: () -> Unit) {
    Views.onClick(this, doActionAfterTimes, millisecondInterval, action)
}

/**
 * 获取[View] id，如果没有id：如果SDK>17, 使用[View.generateViewId]；否则使用[View.hashCode]
 */
fun View.getViewId(): Int {
    var id = id
    if (id == NO_ID) {
        id = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            generateViewId()
        } else {
            this.hashCode()
        }
    }

    return id
}


