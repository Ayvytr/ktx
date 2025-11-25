package com.ayvytr.ktx.context

import android.content.Context
import android.content.res.Configuration
import android.graphics.Point
import android.util.DisplayMetrics
import android.view.WindowMetrics
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
@Deprecated("Deprecated, use getDisplaySize()", replaceWith = ReplaceWith("getDisplaySize()"))
fun Context.getDisplayMetrics(): DisplayMetrics {
    val dm = DisplayMetrics()
    getWindowManager().defaultDisplay.getMetrics(dm)
    return dm
}

/**
 * @see [android.view.Display.getSize]
 * @since 4.0.3 适配Android新版本
 */
fun Context.getDisplaySize(): Point
{
    val screenSize = Point()
    val windowManager: android.view.WindowManager = getSystemService(
        Context.WINDOW_SERVICE) as android.view.WindowManager

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) {
        // 适用于 Android 11 (API 30) 及更高版本
        val maximumWindowMetrics: WindowMetrics = windowManager.maximumWindowMetrics
        screenSize.x = maximumWindowMetrics.bounds.width()
        screenSize.y = maximumWindowMetrics.bounds.height()
    } else if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
        // 适用于 Android 4.2 (API 17) 至 Android 10 (API 29)
        val display: android.view.Display = windowManager.defaultDisplay
        display.getRealSize(screenSize)
    } else {
        // 适用于更早的版本（现已较少见，但为保证兼容性）
        val display: android.view.Display = windowManager.defaultDisplay
        display.getSize(screenSize)
        // 注意：在较早版本且带有永久性菜单键的设备上，此方法获取的高度可能不包含导航栏
        // 但对于现代设备开发，通常可忽略此分支
    }
    return screenSize
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
