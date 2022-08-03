package com.ayvytr.ktx.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import androidx.annotation.LayoutRes
import com.ayvytr.ktx.R

/**
 * 对话框基类，默认对MIUI等某些定制系统手机的Dialog宽度很窄的问题做了处理：[setFullWidth]
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 3.1.1
 */
abstract class BaseDialog(context: Context, themeResId: Int = R.style.TransparentDialog):
    Dialog(context, themeResId) {

    private var mGravity = Gravity.NO_GRAVITY

    @LayoutRes
    protected abstract fun getContentView(): Int

    protected abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentView())
        initView()
    }

    override fun show() {
        super.show()
        setFullWidth()

        if (mGravity != 0) {
            window.setGravity(mGravity)
        }
    }

    /**
     * 设置对话框宽度占满屏幕宽度，解决了MIUI等某些定制系统手机的Dialog宽度很窄的问题. 需要对话框左右有间距，
     * 直接给布局加margin.
     */
    fun setFullWidth(isFullWidth: Boolean = true) {
        val window = window
        window.decorView.setPadding(0, 0, 0, 0)
        val layoutParams = window.attributes
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.horizontalMargin = 0f
        window.attributes = layoutParams
        window.decorView.minimumWidth = context.resources.displayMetrics.widthPixels
    }

    /**
     * @see android.view.Gravity
     */
    fun setGravity(gravity: Int) {
        mGravity = gravity
    }
}