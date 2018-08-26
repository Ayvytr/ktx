package com.ayvytr.easykotlinproject

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ayvytr.easykotlin.android.context.dp2px
import com.ayvytr.easykotlin.android.context.getDrawable2
import com.ayvytr.easykotlin.android.context.toast
import com.ayvytr.easykotlin.android.ui.getContext
import kotlinx.android.synthetic.main.activity_quick_index_view.*
import java.util.*

class QuickIndexViewActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quick_index_view)
        initView()
    }

    private val random = Random()

    private val drawables = intArrayOf(0, android.R.drawable.ic_menu_search, android.R.drawable.ic_menu_add, android.R.drawable.ic_menu_call, android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_day)

    val randomDrawable: Drawable?
        get()
        {
            val i = random.nextInt(drawables.size)
            if (i == 0)
            {
                return null
            }

            return getContext().getDrawable2(drawables[i])
        }


    fun initView()
    {
        quickIndexView?.setOnLetterChangeListener { position, text, quickIndexView ->
            toast(text)
        }
        btnTextColor?.setOnClickListener {
            val rgb = randomColor
            quickIndexView?.textColor = rgb
        }
//        btnTopDrawable.setOnClickListener {
//            quickIndexView?.topDrawable = randomDrawable
//        }
//        btnBottomDrawable.setOnClickListener {
//            quickIndexView?.bottomDrawable = randomDrawable
//        }
        btnBackground.setOnClickListener {
            quickIndexView.setBackgroundColor(randomColor)
        }
//        btnShowToast.setOnClickListener {
//            quickIndexView.isShowToast = !quickIndexView.isShowToast
//            //这里有问题，不能在屏幕上同时显示多个Toast
//            toast("已经更改了，触摸字母索引试试吧!")
//        }
//        btnToastTextColor.setOnClickListener {
//            quickIndexView.toastTextColor = randomColor
//        }
//        btnToastBackground.setOnClickListener {
//            quickIndexView.toastBackground = ColorDrawable(randomColor)
//        }
//        btnToastWidth.setOnClickListener {
//            quickIndexView.toastWidth = randomToastPx
//        }
//        btnToastHeight.setOnClickListener {
//            quickIndexView.toastHeight = randomToastPx
//        }
//        btnNullData.setOnClickListener {
//            quickIndexView.bottomDrawable = null
//            quickIndexView.topDrawable = null
//            quickIndexView.indexList = null
//        }
//        btnRestoreData.setOnClickListener {
//            quickIndexView.setTopDrawable(android.R.drawable.ic_menu_search)
//            quickIndexView.setBottomDrawable(android.R.drawable.dark_header)
//            quickIndexView.indexList = arrayListOf("a", "B", "c")
//        }
    }

    private val randomColor: Int
        get() = Color.rgb(random.nextInt(0xff), random.nextInt(0xff), random.nextInt(0xff))

    private val randomToastPx: Int
        get()
        {
            var i = random.nextInt(1000)
            while (i < dp2px(50))
            {
                i = random.nextInt(1000)
            }

            return i
        }
}
