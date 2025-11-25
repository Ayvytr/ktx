package com.ayvytr.ktxapp.et

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.ui.onClick
import com.ayvytr.ktx.ui.selectText
import com.ayvytr.ktxapp.databinding.ActivityEditTextBinding
import com.ayvytr.ktxapp.util.viewBinding

class EditTextActivity: AppCompatActivity() {
    private val binding by viewBinding<ActivityEditTextBinding>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {

            btnClearText.onClick {
                et.setText(null)
            }
            btnSelectText1.onClick {
                et.selectText("select text")
//            et.selectText(null)
            }
            btnSelectText2.onClick {
                et.selectText("select text for all", true)
            }
        }
    }
}