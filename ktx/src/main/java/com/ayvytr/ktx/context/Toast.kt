package com.ayvytr.ktx.context

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.widget.Toast

/**
 * Context 的扩展显示Toast方法，一个方法创建并显示Toast（原想采用扩展属性，但是无法实现共享 [Toast] 实例的问题，所以采用全局 gToast.
 * <p>
 *
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 0.2.0
 */


private var gToast: Toast? = null

/**
 * 创建并显示Toast，显示长度为 [Toast.LENGTH_SHORT]
 * @param text 要显示的文本
 */
fun Context.toast(text: String)
{
    if (gToast == null)
    {
        gToast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
    }
    else
    {
        gToast?.setText(text)
        gToast?.duration = Toast.LENGTH_SHORT
    }

    gToast?.show()
}

/**
 * 创建并显示Toast，显示长度为 [Toast.LENGTH_SHORT]
 * @param textId 要显示的字符串资源id
 */
fun Context.toast(@StringRes textId: Int)
{
    if (gToast == null)
    {
        gToast = Toast.makeText(this, textId, Toast.LENGTH_SHORT)
    }
    else
    {
        gToast?.setText(textId)
        gToast?.duration = Toast.LENGTH_SHORT
    }

    gToast?.show()
}

/**
 * 创建并显示Toast，显示长度为 [Toast.LENGTH_LONG]
 * @param text 要显示的文本
 */
fun Context.toastLong(text: String)
{
    if (gToast == null)
    {
        gToast = Toast.makeText(this, text, Toast.LENGTH_LONG)
    }
    else
    {
        gToast?.setText(text)
        gToast?.duration = Toast.LENGTH_SHORT
    }

    gToast?.show()
}

/**
 * 创建并显示Toast，显示长度为 [Toast.LENGTH_LONG]
 * @param textId 要显示的字符串资源id
 */
fun Context.toastLong(@StringRes textId: Int)
{
    if (gToast == null)
    {
        gToast = Toast.makeText(this, textId, Toast.LENGTH_LONG)
    }
    else
    {
        gToast?.setText(textId)
        gToast?.duration = Toast.LENGTH_SHORT
    }

    gToast?.show()
}


/**
 * 创建并显示Toast，显示长度为 [Toast.LENGTH_SHORT]
 * @param text 要显示的文本
 */
fun Fragment.toast(text: String)
{
    if (gToast == null)
    {
        gToast = Toast.makeText(context, text, Toast.LENGTH_SHORT)
    }
    else
    {
        gToast?.setText(text)
        gToast?.duration = Toast.LENGTH_SHORT
    }

    gToast?.show()
}

/**
 * 创建并显示Toast，显示长度为 [Toast.LENGTH_SHORT]
 * @param textId 要显示的字符串资源id
 */
fun Fragment.toast(@StringRes textId: Int)
{
    if (gToast == null)
    {
        gToast = Toast.makeText(context, textId, Toast.LENGTH_SHORT)
    }
    else
    {
        gToast?.setText(textId)
        gToast?.duration = Toast.LENGTH_SHORT
    }

    gToast?.show()
}

/**
 * 创建并显示Toast，显示长度为 [Toast.LENGTH_LONG]
 * @param text 要显示的文本
 */
fun Fragment.toastLong(text: String)
{
    if (gToast == null)
    {
        gToast = Toast.makeText(context, text, Toast.LENGTH_LONG)
    }
    else
    {
        gToast?.setText(text)
        gToast?.duration = Toast.LENGTH_SHORT
    }

    gToast?.show()
}

/**
 * 创建并显示Toast，显示长度为 [Toast.LENGTH_LONG]
 * @param textId 要显示的字符串资源id
 */
fun Fragment.toastLong(@StringRes textId: Int)
{
    if (gToast == null)
    {
        gToast = Toast.makeText(context, textId, Toast.LENGTH_LONG)
    }
    else
    {
        gToast?.setText(textId)
        gToast?.duration = Toast.LENGTH_SHORT
    }

    gToast?.show()
}
