package com.ayvytr.ktx.context

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment


/**
 * Context 加载布局方法，包括 [RecyclerView] item 的加载方法 [inflateRv(Int, ViewGroup)]
 * <p>
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

/**
 * 使用Context初始化布局
 */
fun Context.inflate(@LayoutRes id: Int, parent: ViewGroup? = null,
                    attachToParent: Boolean = parent != null): View {
    return LayoutInflater.from(this).inflate(id, parent, attachToParent)
}


/**
 * 使用Fragment初始化布局
 */
fun Fragment.inflate(@LayoutRes id: Int, parent: ViewGroup? = null,
                     attachToParent: Boolean = parent != null): View {
    return LayoutInflater.from(context).inflate(id, parent, attachToParent)
}


