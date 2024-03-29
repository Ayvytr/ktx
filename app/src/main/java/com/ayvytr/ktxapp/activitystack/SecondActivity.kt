package com.ayvytr.ktxapp.activitystack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.app.ActivityStack
import com.ayvytr.ktxapp.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        setTitle("SecondActivity")
        btn_close_all_background_kill.setOnClickListener {
            ActivityStack.finishAllAndKillApp()
        }
        btn_kill.setOnClickListener {
            ActivityStack.killApp()
        }

    }
}
