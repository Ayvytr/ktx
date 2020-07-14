package com.ayvytr.easykotlinproject

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
        et.textChange(3000) {
            toast("即将搜索：$it")
        }

        et2.textChange(3000) {
            toast("测试文本变化2：$it")
        }
    }
}