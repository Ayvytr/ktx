package com.ayvytr.ktx.ui.spanner.span

import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.annotation.ColorInt
import com.ayvytr.ktx.ui.spanner.Spanner

/**
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 3.1.3
 */
internal class TextColorSpan(@ColorInt textColor: Int, @ColorInt val pressedTextColor: Int):
    ForegroundColorSpan(textColor) {
    private val pressedTextSpan by lazy {
        TextColorSpan(pressedTextColor, 0)
    }

    fun actionDown(tv: TextView, ss: SpannableString, start: Int, end: Int) {
        ss.setSpan(pressedTextSpan, start, end, Spanner.SPAN_MODE)
        tv.text = ss
    }

    fun actionUp(tv: TextView, ss: SpannableString) {
        ss.removeSpan(pressedTextSpan)
        tv.text = ss
    }
}