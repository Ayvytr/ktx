package com.ayvytr.ktx.ui.edittext

import android.text.TextWatcher

/**
 * Base text watcher.
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 2.4.1
 */
abstract class BaseTextWatcher : TextWatcher {

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
    }
}
