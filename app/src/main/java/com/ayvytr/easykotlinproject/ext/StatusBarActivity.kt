package com.ayvytr.easykotlinproject.ext

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ayvytr.easykotlin.context.hideStatusBar
import com.ayvytr.easykotlin.context.isStatusBarShowing
import com.ayvytr.easykotlin.context.showStatusBar
import com.ayvytr.easykotlinproject.R
import kotlinx.android.synthetic.main.activity_status_bar.*
import org.jetbrains.anko.sdk27.coroutines.onClick

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
        btnShowOrHideStatusBar.onClick {
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
