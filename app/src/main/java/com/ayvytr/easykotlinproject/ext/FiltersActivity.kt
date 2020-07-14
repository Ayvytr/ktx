package com.ayvytr.easykotlinproject.ext

import android.os.Bundle
import com.ayvytr.coroutine.BaseCoroutineActivity
import com.ayvytr.easykotlinproject.DecimalDigitsInputFilter
import com.ayvytr.easykotlinproject.R
import com.ayvytr.ktx.ui.addFilters
import com.ayvytr.ktx.ui.edittext.ChineseFilter
import com.ayvytr.ktx.ui.edittext.EmailFilter
import com.ayvytr.ktx.ui.edittext.EmojiFilter
import com.ayvytr.ktx.ui.edittext.PasswordFilter
import kotlinx.android.synthetic.main.activity_filters.*

class FiltersActivity : BaseCoroutineActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filters)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        et_emoji_filter.addFilters(EmojiFilter(true))
        et_password_filter.addFilters(PasswordFilter())
        et_email_filter.addFilters(EmailFilter())
        et_chinese_filter.addFilters(ChineseFilter())
        et_2_digits.addFilters(DecimalDigitsInputFilter())
    }
}
