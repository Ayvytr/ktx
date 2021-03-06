package com.ayvytr.easykotlinproject

import android.os.Bundle
import android.text.InputFilter
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.easykotlinproject.activitystack.StackActivity
import com.ayvytr.easykotlinproject.ext.FiltersActivity
import com.ayvytr.easykotlinproject.ext.StatusBarActivity
import com.ayvytr.easykotlinproject.rich.RichActivity
import com.ayvytr.ktx.context.*
import com.ayvytr.ktx.ui.*
import com.ayvytr.ktx.ui.edittext.ChineseFilter
import com.ayvytr.ktx.ui.edittext.EmojiFilter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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

    private fun initView() {
        btnStatusBar.setOnClickListener { startActivity<StatusBarActivity>() }
        btn_filters.setOnClickListener {
            startActivity<FiltersActivity>()
        }
        btn_rich.setOnClickListener {
            startActivity<RichActivity>()
        }

        getContext()

//        L.e(ContextProvider.getContext())

        val et = EditText(this)
        et.addFilters(arrayOf<InputFilter>(EmojiFilter(), ChineseFilter()).toList())

        btn_to_night.text = if(isNightMode()) "切换到白天模式" else "切换到黑夜模式"
//        L.e(isNightMode(), delegate.localNightMode == AppCompatDelegate.MODE_NIGHT_YES)
        btn_to_night.setOnClickListener{
            toNightMode(!isNightMode())
        }
        btn_activity_stack.setOnClickListener {
            startActivity<StackActivity>()
        }

        val i = 10
        val f = 50.5f
//        println("densityutil: dp2px:${DensityUtil.dip2px(this, i.toFloat())}")
//        println("me: dp=${i.dp} dp2px=${i.dp2px}")

        println("densityutil: dp2px:${DensityUtil.dip2px(this, f)}")
        println("me: dp=${f.dp} dp2px=${f.dp2px}")

        btn_show.setOnClickListener {
            btnStatusBar.show(btnStatusBar.isShow().not())
        }

        btn_test_click.setOnClickListener {
            startActivity<TestRepeatClickActivity>()
        }

        btn_test_text_change.setOnClickListener {
            startActivity<TextChangeActivity>()
        }
    }

}
