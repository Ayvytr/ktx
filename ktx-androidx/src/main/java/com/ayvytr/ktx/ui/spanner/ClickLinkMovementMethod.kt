package com.ayvytr.ktx.ui.spanner

import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.MotionEvent
import android.widget.TextView
import com.ayvytr.ktx.ui.spanner.span.BgColorSpan
import com.ayvytr.ktx.ui.spanner.span.TextColorSpan

/**
 * @author Administrator
 */
class ClickLinkMovementMethod: LinkMovementMethod() {
    override fun onTouchEvent(widget: TextView?, buffer: Spannable?, event: MotionEvent?): Boolean {
        if (widget == null || buffer == null || event == null) {
            return super.onTouchEvent(widget, buffer, event)
        }

        var x = event.x.toInt()
        var y = event.y.toInt()

        x -= widget.totalPaddingLeft
        y -= widget.totalPaddingTop

        x += widget.scrollX
        y += widget.scrollY

        val layout = widget.layout
        val line = layout.getLineForVertical(y)
        val off = layout.getOffsetForHorizontal(line, x.toFloat())

        val clicks = buffer.getSpans(off, off, ClickableSpan::class.java)
        if (clicks.isEmpty()) {
            return super.onTouchEvent(widget, buffer, event)
        }

        val texts = buffer.getSpans(off, off, TextColorSpan::class.java)
        val bgs = buffer.getSpans(off, off, BgColorSpan::class.java)

        if (widget.text is SpannableString) {
            val ss = widget.text as SpannableString
            val start = ss.getSpanStart(clicks[0])
            val end = ss.getSpanEnd(clicks[0])

//            L.e(event.action)
            when (event.action) {
                MotionEvent.ACTION_DOWN                          -> {
                    if (texts.isNotEmpty()) {
                        texts[0].actionDown(widget, ss, start, end)
                    }
                    if (bgs.isNotEmpty()) {
                        bgs[0].actionDown(widget, ss, start, end)
                    }
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_MOVE -> {
                    if (texts.isNotEmpty()) {
                        texts[0].actionUp(widget, ss)
                    }
                    if (bgs.isNotEmpty()) {
                        bgs[0].actionUp(widget, ss)
                    }
                }
            }

        }

        return super.onTouchEvent(widget, buffer, event)
    }

    companion object {
        @JvmStatic
        val INSTANCE by lazy {
            ClickLinkMovementMethod()
        }
    }
}