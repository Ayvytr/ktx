package com.ayvytr.ktx.ui.edittext

/**
 * 密码筛选器.
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 2.4.1
 */
class PasswordFilter: EmojiFilter(){
    init {
        BASE_REGEX = "^[0-9a-zA-Z!#$%&'()*+,\\-.:;=?@\\[\\\\\\]^_`{|}~]+$"
    }
}