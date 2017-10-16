package com.ayvytr.easykotlin.context

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager

/**
 * Created by Do on 2017/10/13.
 */


fun Activity.showActionBar()
{
    if (this is AppCompatActivity)
    {
        supportActionBar?.show()
    }
    else
    {
        actionBar?.show()
    }
}

fun Activity.hideActionBar()
{
    if (this is AppCompatActivity) supportActionBar?.hide() else actionBar?.hide()
}

fun Activity.fullscreen(isFullScreen: Boolean)
{
    val attrs = window.attributes
    if (isFullScreen)
    {
        attrs.flags = attrs.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
    }
    else
    {
        attrs.flags = attrs.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
    }
    window.attributes = attrs
}

fun Activity.isFullscreen(): Boolean
{
    return window.attributes.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN == WindowManager.LayoutParams.FLAG_FULLSCREEN
}