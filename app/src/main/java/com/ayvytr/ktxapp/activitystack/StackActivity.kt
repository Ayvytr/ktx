package com.ayvytr.ktxapp.activitystack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.app.ActivityStack
import com.ayvytr.ktxapp.R
import com.ayvytr.ktxapp.databinding.ActivityStackBinding
import com.ayvytr.ktxapp.util.viewBinding

class StackActivity: AppCompatActivity() {
    private val binding by viewBinding<ActivityStackBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("StackActivity 是否在前台：${ActivityStack.isForeground()}")
//        L.e(ActivityStack.getRunningActivityCount())

        binding.apply {

            btnGotoFirstActivity.setOnClickListener {
//            ActivityStack.start(FirstActivity::class.java)
                ActivityStack.start(FirstActivity::class.java)
            }
            btnCloseTopActivity.setOnClickListener {
                ActivityStack.finishCurrent()
            }
        }
    }
}
