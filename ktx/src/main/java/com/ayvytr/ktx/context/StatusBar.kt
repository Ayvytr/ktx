package com.ayvytr.ktx.context

import android.app.Activity
import android.view.WindowManager

/**
 * @author Ayvytr
 */

/**
 * 隐藏状态栏
 */
fun Activity.hideStatusBar()
{
    window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

/**
 * 显示状态栏
 */
fun Activity.showStatusBar()
{
    window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

/**
 * 状态栏是否显示
 * @return true: 显示
 */
fun Activity.isStatusBarShowing(): Boolean
{
    return window.attributes.flags.and(WindowManager.LayoutParams.FLAG_FULLSCREEN) == 0
}
