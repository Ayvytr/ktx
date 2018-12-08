package com.ayvytr.ktx.context

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Point
import android.util.DisplayMetrics

/**
 * 为 [Context] 类提供的获取屏幕尺寸，判断横竖屏，设置横竖屏提供的方法.
 *
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

/**
 * @see [android.view.Display.getMetrics]
 */
fun Context.getDisplayMetrics(): DisplayMetrics
{
    val dm = DisplayMetrics()
    getWindowManager().defaultDisplay.getMetrics(dm)
    return dm
}

/**
 * @see [android.view.Display.getSize]
 */
fun Context.getDisplaySize(): Point
{
    val point = Point()
    getWindowManager().defaultDisplay.getSize(point)
    return point
}

fun Context.isLandscape(): Boolean
{
    return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}

fun Context.isPortrait(): Boolean
{
    return resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
}

fun Activity.setLandscape()
{
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
}

fun Activity.setPortrait()
{
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}

fun Context.getScreenWidth(): Int
{
    return getDisplaySize().x
}

fun Context.getScreenHeight(): Int
{
    return getDisplaySize().y
}
