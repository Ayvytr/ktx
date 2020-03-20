package com.ayvytr.ktx.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

/**
 * 切换到黑夜模式.
 * @param isNight `true`: 黑夜模式
 */
fun AppCompatActivity.toNightMode(isNight: Boolean = true) {
    delegate.localNightMode =
            if (isNight) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
}