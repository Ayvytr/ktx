package com.ayvytr.ktx.internal

import android.view.View
import com.ayvytr.ktx.ui.getViewId

/**
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 3.0.0
 */

internal object Views {
    private val clickMap = hashMapOf<Int, Triple<Int, Int, Long>>()

    fun onClick(view: View,
                doActionAfterTimes: Int = 1,
                millisecondInterval: Int = 300,
                action: () -> Unit) {
        view.setOnClickListener {
            val viewId = view.getViewId()
            val t = clickMap[viewId]
            var times = doActionAfterTimes
            if (times < 1) {
                times = 1
            }

            val third = System.currentTimeMillis()
            if (times == 1) {
                if (t == null || (third - t.third >= millisecondInterval)) {
                    action.invoke()
                    clickMap[viewId] = Triple(1, 1, third)
                }
            } else {
                if (t == null) {
                    clickMap[viewId] = Triple(times, 1, third)
                } else {
                    if (third - t.third >= millisecondInterval) {
                        clickMap[viewId] = Triple(times, 1, third)
                    } else {
                        val newT = t.copy(second = t.second + 1, third = third)
                        clickMap[viewId] = newT
                        if (newT.second != newT.first) {
                            //不做任何操作
                        } else {
                            action.invoke()
                            clickMap.remove(viewId)
                        }
                    }
                }
            }
        }
    }
}

