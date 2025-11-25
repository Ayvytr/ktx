package com.ayvytr.ktxapp.activitystack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.app.ActivityStack
import com.ayvytr.ktxapp.R
import com.ayvytr.ktxapp.databinding.ActivityFirstBinding
import com.ayvytr.ktxapp.util.viewBinding

class FirstActivity: AppCompatActivity() {
    private val binding by viewBinding<ActivityFirstBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        setTitle("First Activity")
        binding.apply {

            btnCloseMe.setOnClickListener {
                ActivityStack.finish(FirstActivity::class.java)
            }
//        startActivity(Intent())
            btnCloseOthers.setOnClickListener {
                ActivityStack.finishAllExcept(FirstActivity::class.java)
            }

            btnCloseAll.setOnClickListener {
                ActivityStack.finishAll()
            }

            btnCloseTopActivity.setOnClickListener {
                ActivityStack.finishCurrent()
            }

            btnStartAndCloseOthers.setOnClickListener {
                ActivityStack.start(SecondActivity::class.java)
            }

            btnFinishExceptTop.setOnClickListener {
                ActivityStack.finishExceptTop()
            }

            btnFinishByName.setOnClickListener {
                ActivityStack.finishByName(FirstActivity::class.java.name)
            }

            btnFinishBySimpleName.setOnClickListener {
                ActivityStack.finishBySimpleName(FirstActivity::class.java.simpleName)
            }

            btnFinishExceptName.setOnClickListener {
                ActivityStack.finishAllExceptName(FirstActivity::class.java.name)
            }
            btnFinishExceptSimpleName.setOnClickListener {
                ActivityStack.finishAllExceptSimpleName(FirstActivity::class.java.simpleName)
            }
        }
    }
}
