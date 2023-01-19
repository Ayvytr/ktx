package com.ayvytr.ktx

import android.widget.EditText
import com.ayvytr.ktx.app.ActivityStack
import com.ayvytr.ktx.context.getClipboardManager
import com.ayvytr.ktx.context.setPlainText
import com.ayvytr.ktx.provider.ContextProvider
import com.ayvytr.ktx.ui.selectText
import junit.framework.Assert.assertEquals

/**
 * @author Do
 */
class ActivityStackTest {
    fun fun1() {
        ActivityStack.killApp()
    }

    fun fun2() {
        val context = ContextProvider.getContext()
        val clipboardManager = context.getClipboardManager()
        clipboardManager.setPlainText("text")
    }

    fun fun3() {
        val et = EditText(ContextProvider.getContext())
        val text = "default text"
//        et.setText2(text)
        assertEquals(text.length, et.length())
        assertEquals(text.length, et.text.length)

//        et.setTextWithSelection(text)
        et.selectText(text, true)
    }
}
