package com.ayvytr.ktx.ui

import android.text.InputFilter
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.annotation.IntRange
import androidx.annotation.StringRes
import com.ayvytr.ktx.context.getInputMethodManager
import com.ayvytr.ktx.internal.Views

/**
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 2.4.0
 */

/**
 * 设置文本，并且当[selectAllText]=true时，选择所有文本([EditText.setSelection, EditText.text.length])；
 * 当[selectAllText]=false时，移动光标到文字末尾.
 * @since 3.0.1
 */
fun EditText.selectText(@StringRes stringId: Int, selectAllText: Boolean = false) {
    selectText(context.getString(stringId), selectAllText)
}

/**
 * @since 3.0.1
 */
fun EditText.selectText(text: CharSequence?, selectAllText: Boolean = false) {
    setText(text)
    if (selectAllText) {
        setSelection(0, length())
    } else {
        setSelection(length())
    }
}


/**
 * 增加[EditText] [filter]
 */
fun EditText.addFilters(vararg filter: InputFilter) {
    val list = filters.toMutableList()
    list.addAll(filter)
    filters = list.toTypedArray()
}

/**
 * 显示软键盘，[isShow]:显示，在[android.app.Activity.onCreate]中使用也可以弹出键盘.
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

/**
 * [EditText]文本变化监听器，文本变化后，以[timeout]为时间间隔触发[action]，[ignoreEmpty]=true: 输入文本为
 * 空时，不触发[action].
 * [timeout]默认300ms，默认[ignoreEmpty]=true，忽略空字符串.
 * @since 3.0.0
 * 灵感：RxBinding TextView.textChanges。这里直接以[EditText]实现，[android.widget.TextView]没有必要.
 */
fun EditText.textChange(@IntRange(from = 1L, to = Long.MAX_VALUE) timeout: Int = 300,
                        ignoreEmpty: Boolean = true,
                        action: (text: String) -> Unit) {
    Views.textChange(this, timeout, ignoreEmpty, action)
}