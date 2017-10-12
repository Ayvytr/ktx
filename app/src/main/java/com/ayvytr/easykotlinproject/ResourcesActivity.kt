package com.ayvytr.easykotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import com.ayvytr.easykotlin.context.getDrawable2
import com.ayvytr.easykotlin.context.getDrawableArray
import com.ayvytr.easykotlin.context.getDrawableIdArray
import com.ayvytr.easykotlin.context.toast
import kotlinx.android.synthetic.main.activity_resources.*

class ResourcesActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resources)
        initView()
    }

    private fun initView()
    {
        btnGetAppName.setOnClickListener {
            btnGetAppName.text = getString(R.string.app_name)
        }

        ib1.setImageDrawable(getDrawable2(R.mipmap.ic_launcher))

        val drawableArray = getDrawableArray(R.array.drawableArray)
//        toast("drawable array size: ${drawableArray.size}")

        val drawableIdArray = getDrawableIdArray(R.array.drawableArray)
        var str = ""
        drawableIdArray.forEach {
            str += it.toString() + " "
        }
        toast(str)

        ib2.setImageDrawable(drawableArray[0])
        ib3.setImageDrawable(drawableArray[1])

        val m = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(m)
        toast("${m.widthPixels}, ${m.heightPixels}")
    }
}
