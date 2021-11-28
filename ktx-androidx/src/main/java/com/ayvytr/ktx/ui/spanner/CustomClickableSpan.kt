package com.ayvytr.ktx.ui.spanner

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

internal class CustomClickableSpan private constructor(private val text: CharSequence,
                                                       private val tag: Any? = null,
                                                       private val range: Range) : ClickableSpan() {
    var onTextClickListener: OnTextClickListener? = null
    var onTextLongClickListener: OnTextLongClickListener? = null

    constructor(text: CharSequence, tag: Any?, range: Range,
                onTextClickListener: OnTextClickListener) : this(text, tag, range) {
        this.onTextClickListener = onTextClickListener
    }

    constructor(text: CharSequence, tag: Any?, range: Range,
                onTextLongClickListener: OnTextLongClickListener) : this(text, tag, range) {
        this.onTextLongClickListener = onTextLongClickListener
    }

    override fun onClick(view: View) {
        if (onTextClickListener != null) {
            handleClickEvent(view, Runnable { onTextClickListener!!.onClicked(text, range, tag) })
        }
    }

    override fun updateDrawState(ds: TextPaint) {}

    fun onLongClick(view: View) {
        if (onTextLongClickListener != null) {
            handleClickEvent(view, Runnable { onTextLongClickListener!!.onLongClicked(text, range, tag) })
        }
    }

    private fun handleClickEvent(view: View, runnable: Runnable) {
        // prevent calling view's onClick listener after
        view.isEnabled = false
        runnable.run()
        view.isEnabled = true
    }
}
