package com.ayvytr.ktxapp

import android.os.Bundle
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.context.toast
import com.ayvytr.ktx.ui.getViewId
import com.ayvytr.ktx.ui.onClick
import com.ayvytr.ktxapp.databinding.ActivityTestRepeatClickBinding
import com.ayvytr.ktxapp.util.viewBinding

class TestRepeatClickActivity: AppCompatActivity() {
    private val binding by viewBinding<ActivityTestRepeatClickBinding>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.apply {
            btn1.onClick {
                tv.append("${System.currentTimeMillis()} $ 点击了 viewId:${btn1.getViewId()}\n")
                scrollView.fullScroll(ScrollView.FOCUS_DOWN)
                toast("我要跳转了")
            }
            btn2.onClick {
                tv.append("${System.currentTimeMillis()} $ 点击了 viewId:${btn2.getViewId()}\n")
                scrollView.fullScroll(ScrollView.FOCUS_DOWN)
                toast("我要跳转了2")
            }

            btn3.onClick(2) {
                tv.append("${System.currentTimeMillis()} $ 两次点击 viewId:${btn3.getViewId()}\n")
                scrollView.fullScroll(ScrollView.FOCUS_DOWN)
                toast("两次点击触发了")
            }
            btn4.onClick(3) {
                tv.append("${System.currentTimeMillis()} $ 三次点击 viewId:${btn3.getViewId()}\n")
                scrollView.fullScroll(ScrollView.FOCUS_DOWN)
                toast("三次点击触发了")
            }
        }
    }
}