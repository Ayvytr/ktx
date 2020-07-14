package com.ayvytr.ktx.ui

import android.app.Activity
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
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
 * 获取Activity本身，因为Dialog等都要用Activity实例，需要的话可以使用[Activity.getApplicationContext].
 */
fun Activity.getContext(): Activity {
    return this
}

fun Activity.showActionBar() {
    if (this is AppCompatActivity) {
        supportActionBar?.show()
    } else {
        actionBar?.show()
    }
}

fun Activity.hideActionBar() {
    if (this is AppCompatActivity) supportActionBar?.hide() else actionBar?.hide()
}

/**
 * Activity切换为全屏/非全屏
 *
 * 2018-1-5 09:30 修改为2个参数，因为一般情况下，全屏和非全屏，ActionBar同时也有必要进行相应的隐藏/显示操作，所以进行了专门的修改
 * @param isFullScreen true 是全屏; false 不是全屏
 * @param withActionBar true 伴随全屏和非全屏，ActionBar分别进行隐藏和显示; false ActionBar不进行任何操作
 */
fun Activity.fullscreen(isFullScreen: Boolean, withActionBar: Boolean = true) {
    val attrs = window.attributes
    if (isFullScreen) {
        attrs.flags = attrs.flags or WindowManager.LayoutParams.FLAG_FULLSCREEN
        if (withActionBar) hideActionBar()
    } else {
        attrs.flags = attrs.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN.inv()
        if (withActionBar) showActionBar()
    }
    window.attributes = attrs
}

/**
 * 判断Activity是不是全屏
 * @return `true`： 全屏
 */
fun Activity.isFullscreen(): Boolean {
    return window.attributes.flags and WindowManager.LayoutParams.FLAG_FULLSCREEN == WindowManager.LayoutParams.FLAG_FULLSCREEN
}

fun Fragment.setActivityTitle(@StringRes resId: Int) {
    setActivityTitle(getString(resId))
}

/**
 * 设置Activity标题，直接调用[Fragment.requireActivity.setTitle]，不起作用（使用了Navigation）.
 */
fun Fragment.setActivityTitle(title: String) {
    val activity = requireActivity()
    when (activity) {
        is AppCompatActivity -> {
            activity.supportActionBar?.setTitle(title)
        }
        else -> activity.actionBar?.title = title
    }
}

fun Activity.setActivityTitle(@StringRes resId: Int) {
    setActivityTitle(getString(resId))
}

/**
 * 设置Activity标题，直接调用[Activity.setTitle]，不起作用（使用了Navigation）.
 */
fun Activity.setActivityTitle(title: String) {
    when (this) {
        is AppCompatActivity -> {
            supportActionBar?.setTitle(title)
        }
        else -> actionBar?.title = title
    }
}
