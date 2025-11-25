package com.ayvytr.ktxapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.context.toast
import com.ayvytr.ktx.ui.textChange
import com.ayvytr.ktxapp.databinding.ActivityTextChangeBinding
import com.ayvytr.ktxapp.util.viewBinding

class TextChangeActivity: AppCompatActivity() {
    private val binding by viewBinding<ActivityTextChangeBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {

            et.textChange(ignoreEmpty = false) {
                toast("我：默认延迟，触发空格：$it")
            }

            et2.textChange(3000) {
                toast("我：3s延迟，不触发空格：$it")
            }
        }
    }
}