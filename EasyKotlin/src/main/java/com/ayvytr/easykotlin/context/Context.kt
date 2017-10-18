package com.ayvytr.easykotlin.context

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Context 加载布局方法，包括 [RecyclerView] item 的加载方法 [inflateRv(Int, ViewGroup)]
 * <p>
 *
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

/**
 * 使用Context初始化布局
 */
fun Context.inflate(@LayoutRes id: Int): View
{
    return inflate(id, null)
}

/**
 * 使用Context初始化布局
 */
fun Context.inflate(@LayoutRes id: Int, parent: ViewGroup?): View
{
    return inflate(id, parent, parent != null)
}

/**
 * 使用Context初始化布局
 */
fun Context.inflate(@LayoutRes id: Int, parent: ViewGroup?, attachToParent: Boolean = false): View
{
    return LayoutInflater.from(this).inflate(id, parent, attachToParent)
}

/**
 * 使用Context初始化布局，专为RecyclerView提供
 */
fun Context.inflateRv(@LayoutRes id: Int, parent: ViewGroup?): View
{
    return LayoutInflater.from(this).inflate(id, parent, false)
}

/**
 * 使用Fragment初始化布局
 */
fun Fragment.inflate(@LayoutRes id: Int): View
{
    return inflate(id, null)
}

/**
 * 使用Fragment初始化布局
 */
fun Fragment.inflate(@LayoutRes id: Int, parent: ViewGroup?): View
{
    return inflate(id, parent, parent != null)
}

/**
 * 使用Fragment初始化布局
 */
fun Fragment.inflate(@LayoutRes id: Int, parent: ViewGroup?, attachToParent: Boolean = false): View
{
    return LayoutInflater.from(context).inflate(id, parent, attachToParent)
}

/**
 * 使用Fragment初始化布局，专为RecyclerView提供
 */
fun Fragment.inflateRv(@LayoutRes id: Int, parent: ViewGroup?): View
{
    return LayoutInflater.from(context).inflate(id, parent, false)
}
