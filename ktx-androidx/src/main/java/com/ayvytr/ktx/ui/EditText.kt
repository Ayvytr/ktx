package com.ayvytr.ktx.ui

import android.text.InputFilter
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.ayvytr.ktx.context.getInputMethodManager
import com.ayvytr.ktx.internal.Views

/**
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 2.4.0
 */

/**
 * 设置 [EditText] 文本，并且把光标定位到末尾
 */
fun EditText.setText2(text: CharSequence) {
    setText(text)
    setSelection(getText().length)
}

/**
 * 设置 [EditText] 文本，并且全选文本
 */
fun EditText.setTextWithSelection(text: CharSequence) {
    setText(text)
    setSelection(0, getText().length)
}

@Deprecated("弃用", ReplaceWith("addFilters(filters.toList())", "com.ayvytr.ktx.ui"))
fun EditText.setFilters(vararg filters: InputFilter) {
    val list = mutableListOf<InputFilter>()
    getFilters().forEach {
        list.add(it)
    }
    filters.forEach {
        list.add(it)
    }
    setFilters(list.toTypedArray())
}

fun EditText.addFilters(filter: InputFilter) {
    addFilters(listOf(filter))
}

/**
 * 设置 [EditText] filters, 先获取原有filters，和[filters]一并设置到[EditText]
 */
fun EditText.addFilters(filters: List<InputFilter>) {
    val list = filters.toMutableList()
    list.addAll(getFilters())
    setFilters(list.toTypedArray())
}

/**
 * 显示软键盘，[isShow]:显示
 */
fun EditText.showInputMethod(isShow: Boolean = true) {
    if (isShow) {
        postDelayed({
                        isFocusable = true
                        requestFocus()
                        val imm = context.getInputMethodManager()
                        imm.showSoftInput(this, InputMethodManager.SHOW_FORCED)
                    }, 100)
    } else {
        hideInputMethod()
    }
}

/**
 * 隐藏软键盘
 */
fun EditText.hideInputMethod() {
    val imm = context.getInputMethodManager()
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun EditText.textChange(timeout: Int,
                        action: (text: String) -> Unit) {
    Views.textChange(this, timeout, action)
}