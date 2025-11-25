package com.ayvytr.ktxapp

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.context.*
import com.ayvytr.ktx.ui.*
import com.ayvytr.ktxapp.databinding.ActivityResourcesBinding
import com.ayvytr.ktxapp.util.viewBinding

class ResourcesActivity: AppCompatActivity() {
    private val binding: ActivityResourcesBinding by viewBinding()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {

            btnGetAppName.setOnClickListener {
                btnGetAppName.text = getString(R.string.app_name)
            }

            ib1.setImageDrawable(getDrawableCompat(R.mipmap.ic_launcher))

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

            val color = getColorCompat(R.color.colorAccent)
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
    }

    override fun onBackPressed() {
        if (isLandscape()) {
            setPortrait()
            return
        }

        super.onBackPressed()
    }
}
