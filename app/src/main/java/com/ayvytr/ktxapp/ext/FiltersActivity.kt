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
import com.ayvytr.ktxapp.databinding.ActivityFiltersBinding
import com.ayvytr.ktxapp.util.viewBinding

class FiltersActivity : BaseActivity<BaseViewModel<IView>>() {
    private val binding by viewBinding<ActivityFiltersBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)

        binding.apply {
            etEmojiFilter.addFilters(EmojiFilter(true))
            etPasswordFilter.addFilters(PasswordFilter())
            etEmailFilter.addFilters(EmailFilter())
            etChineseFilter.addFilters(ChineseFilter())
            et2Digits.addFilters(DecimalDigitsInputFilter())
            et2Digits.setRawInputType(InputType.TYPE_CLASS_NUMBER)
        }
    }
}
