package com.ayvytr.ktx.ui.spanner

import android.os.Handler
import android.text.Selection
import android.text.Spannable
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.view.MotionEvent
import android.widget.TextView

internal class LinkTouchMovementMethod(pressedTextColor: Int,
                                       pressedBackgroundColor: Int,
                                       backgroundRadius: Int) : LinkMovementMethod() {
    private var isLongClicked: Boolean = false
    private val longClickHandler: Handler?
    private var customClickSpan: CustomClickableSpan? = null
    private val backgroundSpan: RoundedBackgroundSpan = RoundedBackgroundSpan(pressedTextColor, pressedBackgroundColor,
                                                                          backgroundRadius)

    init {
        longClickHandler = Handler()
    }

    override fun onTouchEvent(textView: TextView, spannable: Spannable,
                              event: MotionEvent): Boolean {
        val action = event.action

        if (action == MotionEvent.ACTION_CANCEL && longClickHandler != null) {
            longClickHandler.removeCallbacksAndMessages(null)
        }

        if (action == MotionEvent.ACTION_DOWN) {
            customClickSpan = getPressedSpan(textView, spannable, event)

            longClickHandler!!.postDelayed({
                                               if (customClickSpan != null) {
                                                   customClickSpan!!.onLongClick(textView)
                                                   isLongClicked = true
                                                   removeBackground(spannable)
                                               }
                                           }, LONG_CLICK_THRESHOLD.toLong())

            if (customClickSpan != null) {
                setBackground(spannable)
            }
        } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
            isLongClicked = false

            longClickHandler?.removeCallbacksAndMessages(null)

            if (!isLongClicked && customClickSpan != null && action == MotionEvent.ACTION_UP) {
                customClickSpan!!.onClick(textView)
            }

            if (customClickSpan != null) {
                removeBackground(spannable)
            }
        }

        return true
    }

    private fun getPressedSpan(textView: TextView, spannable: Spannable,
                               event: MotionEvent): CustomClickableSpan? {
        var x = event.x.toInt()
        var y = event.y.toInt()

        x -= textView.totalPaddingLeft
        y -= textView.totalPaddingTop

        x += textView.scrollX
        y += textView.scrollY

        val layout = textView.layout
        val line = layout.getLineForVertical(y)
        val off = layout.getOffsetForHorizontal(line, x.toFloat())

        val link = spannable.getSpans(off, off, CustomClickableSpan::class.java)
        var touchedSpan: CustomClickableSpan? = null
        if (link.size == 2) {
            touchedSpan = link[0]
            val tempSpan = link[1]
            touchedSpan!!.onTextClickListener = if (touchedSpan.onTextClickListener != null)
                touchedSpan
                    .onTextClickListener
            else
                tempSpan.onTextClickListener
            touchedSpan.onTextLongClickListener = if (touchedSpan.onTextLongClickListener != null)
                touchedSpan
                    .onTextLongClickListener
            else
                tempSpan.onTextLongClickListener
        } else if (link.size == 1) {
            touchedSpan = link[0]
        }

        return touchedSpan
    }

    private fun setBackground(spannable: Spannable) {
        spannable.setSpan(backgroundSpan, spannable.getSpanStart(customClickSpan),
                          spannable.getSpanEnd(customClickSpan), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        Selection.setSelection(spannable, spannable.getSpanStart(customClickSpan),
                               spannable.getSpanEnd(customClickSpan))
    }

    private fun removeBackground(spannable: Spannable) {
        spannable.removeSpan(backgroundSpan)
        Selection.removeSelection(spannable)
        customClickSpan = null
    }

    companion object {

        private val LONG_CLICK_THRESHOLD = 1000
    }

}