package com.ayvytr.ktx.ui

import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate


/**
 * 切换到黑夜模式.
 * @param isNight `true`: 黑夜模式
 */
fun AppCompatActivity.toNightMode(isNight: Boolean = true) {
    delegate.setLocalNightMode(
        if (isNight) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO)
}