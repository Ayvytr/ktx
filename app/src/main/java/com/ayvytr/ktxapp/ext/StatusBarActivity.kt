package com.ayvytr.ktxapp.ext

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.context.hideStatusBar
import com.ayvytr.ktx.context.isStatusBarShowing
import com.ayvytr.ktx.context.showStatusBar
import com.ayvytr.ktxapp.R
import kotlinx.android.synthetic.main.activity_status_bar.*

class StatusBarActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_bar)
        initView()
    }

    private fun initView()
    {
        btnShowOrHideStatusBar.setOnClickListener {
            if (isStatusBarShowing())
            {
                hideStatusBar()
            }
            else
            {
                showStatusBar()
            }
        }
    }
}
