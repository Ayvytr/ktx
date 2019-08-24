package com.ayvytr.ktx.ui.edittext

import android.text.InputFilter
import android.text.Spanned

/**
 * Emoji表情筛选器.
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 2.4.1
 */
open class EmojiFilter : InputFilter {
    var BASE_REGEX = "^[ 0-9a-zA-Z!#$%&'()*+,\\-.:;=?@\\[\\\\\\]^_`{|}~\\u4E00-\\u9FA5]+$"

    override fun filter(source: CharSequence, start: Int, end: Int, dest: Spanned, dstart: Int,
                        dend: Int): CharSequence? {
        if ("" == source.toString()) {
            return null
        }

        return if (!source.toString().matches(BASE_REGEX.toRegex())) {
            ""
        } else source

    }

}