package com.ayvytr.ktxapp.et

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.ui.onClick
import com.ayvytr.ktx.ui.selectText
import com.ayvytr.ktxapp.R
import kotlinx.android.synthetic.main.activity_edit_text.*

class EditTextActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)
        initView()
    }

    private fun initView() {
        btn_clear_text.onClick {
            et.setText(null)
        }
        btn_select_text1.onClick {
            et.selectText("select text")
        }
        btn_select_text2.onClick {
            et.selectText("select text for all", true)
        }
    }
}