package com.ayvytr.easykotlinproject.activitystack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.easykotlinproject.R
import com.ayvytr.ktx.app.ActivityStack
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initView()
    }

    private fun initView() {
        setTitle("First Activity")
        btn_close_me.setOnClickListener {
            ActivityStack.finish(FirstActivity::class.java)
        }
//        startActivity(Intent())
        btn_close_others.setOnClickListener {
            ActivityStack.finishAllExcept(FirstActivity::class.java)
        }

        btn_close_all.setOnClickListener {
            ActivityStack.finishAll()
        }

        btn_close_top_activity.setOnClickListener {
            ActivityStack.finishCurrent()
        }
        btn_start_and_close_others.setOnClickListener {
//            ActivityStack.startAndFinishOthers(SecondActivity::class.java)
            ActivityStack.startAndFinishOthers(Intent(this, SecondActivity::class.java))
        }
    }
}
