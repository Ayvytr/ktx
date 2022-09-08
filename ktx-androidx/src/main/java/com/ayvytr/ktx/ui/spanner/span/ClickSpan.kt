package com.ayvytr.ktx.ui.spanner.span

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View
import com.ayvytr.ktx.ui.spanner.Range

/**
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 3.1.3
 */
internal class ClickSpan(
    private val text: CharSequence,
    private val range: Range,
    private val action: (CharSequence, Range) -> Unit = { _, _ -> }
): ClickableSpan() {

    override fun onClick(view: View) {
        handleClickEvent(view)
    }

    override fun updateDrawState(ds: TextPaint) {

    }

//    fun onLongClick(view: View) {
//        if (onTextLongClickListener != null) {
//            handleClickEvent(
//                view,
//                Runnable { onTextLongClickListener!!.onLongClicked(text, range, tag) })
//        }
//    }

    private fun handleClickEvent(view: View) {
        // prevent calling view's onClick listener after
        view.isEnabled = false
        action.invoke(text, range)
        view.isEnabled = true
    }
}
