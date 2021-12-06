package com.ayvytr.ktx.context

import android.app.Activity
import android.content.Context
import android.view.WindowManager

/**
 * @author Ayvytr
 */


/**
 * 获取状态栏高度
 *
 * @return 状态栏高度px
 */
fun Context.getStatusBarHeight(): Int {
    var result = 0
    val resourceId = this.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = this.resources.getDimensionPixelSize(resourceId)
    }

    return result
}

/**
 * 隐藏状态栏
 */
fun Activity.hideStatusBar() {
    window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

/**
 * 显示状态栏
 */
fun Activity.showStatusBar(isShow: Boolean = true) {
    if(isShow) window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    else window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

/**
 * 状态栏是否显示
 * @return true: 显示
 */
fun Activity.isStatusBarShowing(): Boolean
{
    return window.attributes.flags.and(WindowManager.LayoutParams.FLAG_FULLSCREEN) == 0
}
