package com.ayvytr.ktxapp.ext

import android.os.Bundle
import android.text.InputType
import com.ayvytr.flow.BaseActivity
import com.ayvytr.flow.base.IView
import com.ayvytr.flow.vm.BaseViewModel
import com.ayvytr.ktx.ui.edittext.DecimalDigitsInputFilter
import com.ayvytr.ktx.ui.addFilters
import com.ayvytr.ktx.ui.edittext.ChineseFilter
import com.ayvytr.ktx.ui.edittext.EmailFilter
import com.ayvytr.ktx.ui.edittext.EmojiFilter
import com.ayvytr.ktx.ui.edittext.PasswordFilter
import com.ayvytr.ktxapp.R
import kotlinx.android.synthetic.main.activity_filters.*

class FiltersActivity : BaseActivity<BaseViewModel<IView>>() {

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
        et_2_digits.setRawInputType(InputType.TYPE_CLASS_NUMBER)
    }
}
