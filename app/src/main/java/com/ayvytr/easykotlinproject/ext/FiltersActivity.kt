package com.ayvytr.easykotlinproject.ext

import android.os.Bundle
import com.ayvytr.coroutine.BaseCoroutineActivity
import com.ayvytr.easykotlinproject.DecimalDigitsInputFilter
import com.ayvytr.easykotlinproject.R
import com.ayvytr.ktx.ui.edittext.ChineseFilter
import com.ayvytr.ktx.ui.edittext.EmailFilter
import com.ayvytr.ktx.ui.edittext.EmojiFilter
import com.ayvytr.ktx.ui.edittext.PasswordFilter
import com.ayvytr.ktx.ui.setFilters
import kotlinx.android.synthetic.main.activity_filters.*

class FiltersActivity : BaseCoroutineActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filters)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        et_emoji_filter.setFilters(EmojiFilter(true))
        et_password_filter.setFilters(PasswordFilter())
        et_email_filter.setFilters(EmailFilter())
        et_chinese_filter.setFilters(ChineseFilter())
        et_2_digits.setFilters(DecimalDigitsInputFilter())
    }
}
