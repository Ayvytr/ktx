package com.ayvytr.ktx.ui

import android.text.InputFilter
import android.widget.EditText

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

/**
 * 设置 [EditText] filters, 先获取原有filters，和[filters]一并设置到[EditText]
 */
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