package com.ayvytr.ktx.internal

import android.text.Editable
import android.view.View
import android.widget.EditText
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.ayvytr.ktx.ui.edittext.BaseTextWatcher
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

    private val textChangeMap
            by lazy { hashMapOf<EditText, Pair<BaseTextWatcher, Runnable>>() }

    private val textChangeObserver by lazy {
        object: LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroyed() {
                textChangeMap.forEach {
                    val et = it.key
                    val triple = textChangeMap[et]
                    et.removeCallbacks(triple?.second)
                    et.removeTextChangedListener(triple?.first)
                }
                if (textChangeMap.isNotEmpty()) {
                    val et = textChangeMap.keys.first()
                    (et.context as? FragmentActivity)?.lifecycle?.removeObserver(this)
                    textChangeMap.clear()
                }
            }
        }
    }

    fun textChange(et: EditText,
                   timeout: Int,
                   action: (text: String) -> Unit) {
        if (!textChangeMap.containsKey(et)) {
            (et.context as? FragmentActivity)?.lifecycle?.addObserver(textChangeObserver)

            val textWatcher = object: BaseTextWatcher() {
                override fun afterTextChanged(s: Editable) {
                    val runnable =
                            if (!textChangeMap.containsKey(et))
                                Runnable { action.invoke(s.toString()) }
                            else textChangeMap[et]!!.second

                    if (!textChangeMap.containsKey(et)) {
                        textChangeMap[et] = Pair(this, runnable)
                    }

                    et.handler.removeCallbacks(runnable)
                    et.handler.postDelayed(runnable, timeout.toLong())
                }
            }
            et.addTextChangedListener(textWatcher)
        }
    }
}

