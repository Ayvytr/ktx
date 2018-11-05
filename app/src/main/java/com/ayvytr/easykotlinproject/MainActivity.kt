package com.ayvytr.easykotlinproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ayvytr.easykotlinproject.ext.StatusBarActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

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

//        L.settings.justShowMsg = true

//        btn1.setOnClickListener {
//            //            Toast.makeText(this, "Toast1", Toast.LENGTH_SHORT).show()
//            toast("这是我的Toast，哈哈！1")
//        }
//        btn2.setOnClickListener {
//            //            Toast.makeText(this, "Toast2", Toast.LENGTH_SHORT).show()
//            toast("这是我的Toast，哈哈！2")
//        }

//        getString(R.string.app_name)
//        getColor2(R.color.abc_background_cache_hint_selector_material_dark)
//        getDrawable2(R.drawable.abc_ab_share_pack_mtrl_alpha)
//
//        testLog()

//        tvStatusBarHeight.setText(getStatusBarHeight().toString())
        initView()
    }

    private fun initView()
    {
        btnStatusBar.onClick { startActivity<StatusBarActivity>() }
    }

}
