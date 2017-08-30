package com.ayvytr.easykotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ayvytr.easykotlin.view.hide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.hide()
    }
}
