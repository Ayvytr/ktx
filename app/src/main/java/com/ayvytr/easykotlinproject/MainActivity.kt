package com.ayvytr.easykotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ayvytr.easykotlin.context.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        toast("这是我的Toast，哈哈！")
//        toast("这是我的Toast，哈哈！1")
//        toast("这是我的Toast，哈哈！2")
//        Toast.makeText(this, "Toast1", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, "Toast2", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, "Toast3", Toast.LENGTH_SHORT).show()

        btn1.setOnClickListener {
            //            Toast.makeText(this, "Toast1", Toast.LENGTH_SHORT).show()
            toast("这是我的Toast，哈哈！1")
        }
        btn2.setOnClickListener {
            //            Toast.makeText(this, "Toast2", Toast.LENGTH_SHORT).show()
            toast("这是我的Toast，哈哈！2")
        }
    }
}
