package com.ayvytr.ktx.ui.edittext

import android.text.InputFilter
import android.text.Spanned

/**
 * Emoji表情筛选器.
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 2.4.1
 */
open class EmojiFilter(val isMultiLine: Boolean = false) : InputFilter {
    /**
     * \u3002一直到\uffe5：匹配这些中文标点符号 。？！，、；：“”‘'（）《》〈〉【】『』「」﹃﹄〔〕…—～﹏￥
     */
    var BASE_REGEX = "^[ 0-9a-zA-Z!#$%&'\"()*+,\\-.:;=?@\\[\\\\\\]^_`{|}~\\u4E00-\\u9FA5\\u3002\\uff1f\\uff01\\uff0c\\u3001\\uff1b\\uff1a\\u201c\\u201d\\u2018\\u2019\\uff08\\uff09\\u300a\\u300b\\u3008\\u3009\\u3010\\u3011\\u300e\\u300f\\u300c\\u300d\\ufe43\\ufe44\\u3014\\u3015\\u2026\\u2014\\uff5e\\ufe4f\\uffe5]+$"

    init {
        if (isMultiLine) {
            BASE_REGEX = StringBuffer(BASE_REGEX).insert(BASE_REGEX.lastIndexOf("]"), '\n').toString()
        }
    }

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