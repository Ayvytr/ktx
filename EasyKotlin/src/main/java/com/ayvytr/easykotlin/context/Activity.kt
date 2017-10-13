package com.ayvytr.easykotlin.context

import android.app.Activity
import android.content.pm.ActivityInfo

/**
 * Created by Do on 2017/10/13.
 */

fun Activity.setLandscape()
{
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
}

fun Activity.setPortrait()
{
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}

