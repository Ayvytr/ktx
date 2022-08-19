package com.ayvytr.ktxapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.ui.textChange
import kotlinx.android.synthetic.main.activity_text_change.*
import org.jetbrains.anko.toast

class TextChangeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_change)
        initView()
    }

    private fun initView() {
        et.textChange(ignoreEmpty = false) {
            toast("我：默认延迟，触发空格：$it")
        }

        et2.textChange(3000) {
            toast("我：3s延迟，不触发空格：$it")
        }
    }
}