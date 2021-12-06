package com.ayvytr.ktx.ui.edittext

/**
 * 中文筛选器.
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 2.4.1
 */
class ChineseFilter: EmojiFilter() {
    init {
        BASE_REGEX = "^[\\u4E00-\\u9FA5]+$"
    }
}
