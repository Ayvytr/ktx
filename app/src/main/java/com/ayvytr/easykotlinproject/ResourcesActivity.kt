package com.ayvytr.easykotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import com.ayvytr.ktx.context.*
import com.ayvytr.ktx.ui.fullscreen
import com.ayvytr.ktx.ui.hideActionBar
import com.ayvytr.ktx.ui.isFullscreen
import com.ayvytr.ktx.ui.showActionBar
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

        val color = getColor2(R.color.abc_background_cache_hint_selector_material_dark)
        btnGetAppName.setBackgroundColor(color)

//        setLandscape()

        tv.text = "${getScreenWidth()} ${getScreenHeight()}"
        val dm = getDisplayMetrics()
        tv2.text = "${dm.widthPixels} ${dm.heightPixels}"

        btnHideActionBar.setOnClickListener {
            if (supportActionBar!!.isShowing) hideActionBar() else showActionBar()
        }

        btnFullScreen.setOnClickListener {
            fullscreen(!isFullscreen())
        }

        btnFullScreenWithoutActionBar.setOnClickListener {
            fullscreen(!isFullscreen(), false)
        }
    }

    override fun onBackPressed()
    {
        if (isLandscape())
        {
            setPortrait()
            return
        }

        super.onBackPressed()
    }
}
