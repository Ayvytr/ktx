package com.ayvytr.ktx.context

import android.content.Context
import android.content.res.Configuration
import android.graphics.Point
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

/**
 * 为 [Context] 类提供的获取屏幕尺寸，判断横竖屏，设置横竖屏提供的方法.
 *
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */


/**
 * 判断是不是黑夜模式
 * @return `true`: 黑夜模式
 */
fun Context.isNightMode(): Boolean {
    if (this is AppCompatActivity) {
        return delegate.localNightMode == AppCompatDelegate.MODE_NIGHT_YES
    }

    return resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK) ==
            Configuration.UI_MODE_NIGHT_YES
}


/**
 * @see [android.view.Display.getMetrics]
 */
fun Context.getDisplayMetrics(): DisplayMetrics {
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

fun Context.getScreenWidth(): Int
{
    return getDisplaySize().x
}

fun Context.getScreenHeight(): Int
{
    return getDisplaySize().y
}
