package com.ayvytr.ktxapp

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.context.dp
import com.ayvytr.ktx.context.dp2px
import com.ayvytr.ktx.context.isNightMode
import com.ayvytr.ktx.ui.addFilters
import com.ayvytr.ktx.ui.edittext.ChineseFilter
import com.ayvytr.ktx.ui.edittext.EmojiFilter
import com.ayvytr.ktx.ui.getContext
import com.ayvytr.ktx.ui.isShow
import com.ayvytr.ktx.ui.onClick
import com.ayvytr.ktx.ui.show
import com.ayvytr.ktx.ui.startActivity
import com.ayvytr.ktx.ui.toNightMode
import com.ayvytr.ktxapp.activitystack.StackActivity
import com.ayvytr.ktxapp.et.EditTextActivity
import com.ayvytr.ktxapp.ext.FiltersActivity
import com.ayvytr.ktxapp.ext.StatusBarActivity
import com.ayvytr.ktxapp.rich.RichActivity
import com.ayvytr.ktxapp.util.DensityUtil
import com.ayvytr.logger.L
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: AppCompatActivity() {

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
        L.e()
    }

    private fun initView() {
        btn_et.onClick {
            startActivity<EditTextActivity>()
        }
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
        et.addFilters(EmojiFilter(), ChineseFilter())

        btn_to_night.text = if (isNightMode()) "切换到白天模式" else "切换到黑夜模式"
//        L.e(isNightMode(), delegate.localNightMode == AppCompatDelegate.MODE_NIGHT_YES)
        btn_to_night.setOnClickListener {
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
