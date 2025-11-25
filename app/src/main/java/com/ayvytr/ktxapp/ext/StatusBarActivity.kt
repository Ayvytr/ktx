package com.ayvytr.ktxapp.ext

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.context.hideStatusBar
import com.ayvytr.ktx.context.isStatusBarShowing
import com.ayvytr.ktx.context.showStatusBar
import com.ayvytr.ktx.ui.onClick
import com.ayvytr.ktx.ui.setLightStatusBar
import com.ayvytr.ktxapp.R
import com.ayvytr.ktxapp.databinding.ActivityStatusBarBinding
import com.ayvytr.ktxapp.util.viewBinding

class StatusBarActivity: AppCompatActivity() {
    private val binding by viewBinding<ActivityStatusBarBinding>()

    private var isLight = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_bar)
        initView()
    }

    private fun initView() {
        binding.apply {

            btnShowOrHideStatusBar.setOnClickListener {
                if (isStatusBarShowing()) {
                    hideStatusBar()
                } else {
                    showStatusBar()
                }
            }

            btnLightOrDark.onClick {
                isLight = !isLight
                setLightStatusBar(isLight)
                btnLightOrDark.text = "切换到" + if (isLight) "Dark" else "Light"
                btnLightOrDark.append("模式")
            }
        }
    }
}
