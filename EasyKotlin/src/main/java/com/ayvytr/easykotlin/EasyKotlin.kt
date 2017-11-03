package com.ayvytr.easykotlin

import android.annotation.SuppressLint
import android.content.Context
import org.jetbrains.annotations.NotNull


@SuppressLint("StaticFieldLeak")
/**
 * 这个库的单例入口类, 使用有关Context的类之前，需要初始化这个类.
 *
 *
 * 提供了获取Context，常用SystemService等方法，在使用 ClipboardTool, DensityTool 等类之前，
 * 需要调用'Easy.getDefault().initTag(context);' 初始化。
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.2
 */

object EasyKotlin
{
    private var context: Context? = null

    /**
     * 初始化，使用 [context] 之前需要先调用这个方法
     */
    fun init(@NotNull c: Context)
    {
        context = c.applicationContext
    }

    @NotNull
    fun getContext(): Context
    {
        return context!!
    }

    /**
     * 释放
     */
    fun release()
    {
        context = null
    }
}
