package com.ayvytr.ktx.ui.spanner.span

import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import android.widget.TextView
import androidx.annotation.ColorInt
import com.ayvytr.ktx.ui.spanner.Spanner

/**
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 3.1.3
 */
internal class BgColorSpan(@ColorInt bgColor: Int, @ColorInt val pressedBgColor: Int):
    BackgroundColorSpan(bgColor) {
    private val pressedBgSpan by lazy {
        BgColorSpan(pressedBgColor, 0)
    }

    fun actionDown(tv: TextView, ss: SpannableString, start: Int, end: Int) {
        ss.setSpan(pressedBgSpan, start, end, Spanner.SPAN_MODE)
        tv.text = ss
    }

    fun actionUp(tv: TextView, ss: SpannableString) {
        ss.removeSpan(pressedBgSpan)
        tv.text = ss
    }
}