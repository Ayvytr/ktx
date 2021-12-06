package com.ayvytr.ktx.context

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.widget.Toast
import com.ayvytr.ktx.provider.ContextProvider

/**
 * Context 的扩展显示Toast方法，一个方法创建并显示Toast，内部采用一个全局Toast实例.
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 0.2.0
 */

private val gToast by lazy {
    Toast.makeText(ContextProvider.getContext(), "", Toast.LENGTH_SHORT)
}

/**
 * 显示Toast，时长[Toast.LENGTH_SHORT]
 * @param text 要显示的文本
 */
fun Context.toast(text: String) {
    gToast.setText(text)
    gToast.duration = Toast.LENGTH_SHORT
    gToast.show()
}

/**
 * 显示Toast，时长[Toast.LENGTH_SHORT]
 * @param textId 要显示的字符串资源id
 */
fun Context.toast(@StringRes textId: Int) {
    gToast.setText(textId)
    gToast.duration = Toast.LENGTH_SHORT
    gToast.show()
}

/**
 * 显示Toast，时长[Toast.LENGTH_LONG]
 * @param text 要显示的文本
 */
fun Context.toastLong(text: String) {
    gToast.setText(text)
    gToast.duration = Toast.LENGTH_LONG
    gToast.show()
}

/**
 * 显示Toast，时长[Toast.LENGTH_LONG]
 * @param textId 要显示的字符串资源id
 */
fun Context.toastLong(@StringRes textId: Int) {
    gToast.setText(textId)
    gToast.duration = Toast.LENGTH_LONG
    gToast.show()
}


fun Fragment.toast(text: String) {
    context?.toast(text)
}

fun Fragment.toast(@StringRes textId: Int) {
    context?.toast(textId)
}

fun Fragment.toastLong(text: String) {
    context?.toastLong(text)
}

fun Fragment.toastLong(@StringRes textId: Int) {
    context?.toastLong(textId)
}
