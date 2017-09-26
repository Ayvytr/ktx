package com.ayvytr.easykotlin.view.activity

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity

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
