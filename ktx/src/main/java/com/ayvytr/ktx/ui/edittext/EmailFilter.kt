package com.ayvytr.ktx.ui.edittext

/**
 * Email筛选器.
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 2.4.1
 */
open class EmailFilter : EmojiFilter() {
    init {
        BASE_REGEX = "^[0-9a-zA-Z@._]+$"
    }
}

