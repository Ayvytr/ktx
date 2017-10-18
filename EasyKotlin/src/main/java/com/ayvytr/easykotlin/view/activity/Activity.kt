package com.ayvytr.easykotlin.view.activity

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager

/**
 * Activity 相关的Kotlin扩展方法
 * <p>
 *
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 0.1.0
 */

/**
 * 获取 AppCompatActivity 的 Context（实际获取的是Activity自身）
 */
fun AppCompatActivity.getContext(): Context
{
    return this
}

/**
 * 获取 AppCompatActivity 自身
 */
fun AppCompatActivity.getActivity(): AppCompatActivity
{
    return this
}

/**
 * 获取 Activity 的 Context（实际获取的是Activity自身）
 */
fun Activity.getContext(): Context
{
    return this
}

/**
 * 获取 Activity 自身
 */
fun Activity.getActivity(): Activity
{
    return this
}

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
