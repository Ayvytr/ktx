package com.ayvytr.ktxapp.activitystack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.app.ActivityStack
import com.ayvytr.ktxapp.R
import com.ayvytr.ktxapp.databinding.ActivitySecondBinding
import com.ayvytr.ktxapp.util.viewBinding

class SecondActivity: AppCompatActivity() {
    private val binding by viewBinding<ActivitySecondBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setTitle("SecondActivity")

        binding.apply {

            btnCloseAllBackgroundKill.setOnClickListener {
                ActivityStack.finishAllAndKillApp()
            }
            btnKill.setOnClickListener {
                ActivityStack.killApp()
            }

        }
    }
}
