package com.ayvytr.easykotlin.context

import android.app.Activity
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.graphics.Point
import android.util.DisplayMetrics

/**
 * Created by Do on 2017/10/13.
 */

fun Context.getDisplayMetrics(): DisplayMetrics
{
    val dm = DisplayMetrics()
    getWindowManager().defaultDisplay.getMetrics(dm)
    return dm
}

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
