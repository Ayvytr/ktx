package com.ayvytr.ktx.ui

import android.app.Activity
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity 相关的Kotlin扩展方法
 * <p>
 *
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 0.1.0
 */


/**
 * 获取 Activity 的 Context（实际获取的是Activity自身）
 */
fun Activity.getContext(): Activity {
    return this
}

/**
 * 获取 Activity 自身
 */
@Deprecated("废弃，使用getContext代替返回Activity，推荐使用Activity.applicationContext获取Context实例",
            ReplaceWith("getContext()", "com.ayvytr.ktx.ui"))
fun Activity.getActivity(): Activity {
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
