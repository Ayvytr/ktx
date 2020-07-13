package com.ayvytr.easykotlinproject

import android.os.Bundle
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ayvytr.ktx.ui.getViewId
import com.ayvytr.ktx.ui.onClick
import kotlinx.android.synthetic.main.activity_test_repeat_click.*
import org.jetbrains.anko.toast

class TestRepeatClickActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_repeat_click)
        initView()
    }

    private fun initView() {
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