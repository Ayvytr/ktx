package com.ayvytr.easykotlinproject

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ayvytr.easykotlin.context.getColor2
import com.ayvytr.easykotlin.context.getDrawable2
import com.ayvytr.easykotlin.context.toast
import com.ayvytr.easykotlin.log.L
import com.ayvytr.easykotlin.view.activity.getContext
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

        getString(R.string.app_name)
        getColor2(R.color.abc_background_cache_hint_selector_material_dark)
        getDrawable2(R.drawable.abc_ab_share_pack_mtrl_alpha)

        btnLogTestActivity.setOnClickListener {
            startActivity(Intent(getContext(), LogTestActivity::class.java))
        }
        testLog()
    }

    private fun testLog()
    {
//        L.i()
//        L.d()
//        L.e()
//        L.v()
//        L.w()
//        L.wtf()

//        L.i(1)
//        L.d(1)
//        L.e(1)
//        L.v(1)
//        L.w(1)
//        L.wtf(1)

//        L.i("String")
//        L.d("String")
//        L.e("String")
//        L.v("String")
//        L.w("String")
//        L.wtf("String")


//        val l = listOf("aa", "bb", "cc")
//        L.i(l)
//        L.d(l)
//        L.e(l)
//        L.v(l)
//        L.w(l)
//        L.wtf(l)
//
//        val map = mapOf("ka" to 10, "kb" to 20, "kc" to 30)
//        L.i(map)
//        L.d(map)
//        L.e(map)
//        L.v(map)
//        L.w(map)
//        L.wtf(map)

//        L.getSettings().hasLog = false
//        L.getSettings().tag = "Different Tag"
//        L.getSettings().methodCount = 10
//        L.getSettings().isShowThreadInfo = true
//        L.getSettings().methodCount = 1
//        L.getSettings().isShowCalledInfo = false
//        L.getSettings().justShowMsg = true
        L.getSettings().isShowBottomBorder = true

        val ints = arrayOf(1, 2, 3, 4, 5)
        L.i(ints)
        L.d(ints)
        L.e(ints)
        L.v(ints)
        L.w(ints)
        L.wtf(ints)

        val strs = arrayOf("aa", "bb", "cc", "dd", "ee")
        L.i(strs)
        L.d(strs)
        L.e(strs)
        L.v(strs)
        L.w(strs)
        L.wtf(strs)
    }
}
