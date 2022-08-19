package com.ayvytr.ktxapp.activitystack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.app.ActivityStack
import com.ayvytr.ktxapp.R
import kotlinx.android.synthetic.main.activity_stack.*

class StackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack)
        setTitle("StackActivity 是否在前台：${ActivityStack.isForeground()}")
//        L.e(ActivityStack.getRunningActivityCount())
        btn_goto_first_activity.setOnClickListener {
//            ActivityStack.start(FirstActivity::class.java)
            ActivityStack.start(Intent(this, FirstActivity::class.java))
        }
        btn_close_top_activity.setOnClickListener {
            ActivityStack.finishCurrent()
        }
    }
}
