package com.ayvytr.ktxapp.dialog

import android.content.Context
import android.view.Gravity
import com.ayvytr.ktx.ui.dialog.BaseDialog
import com.ayvytr.ktxapp.R

/**
 * @author Administrator
 */
class TestDialog(context: Context) : BaseDialog(context) {
    override fun getContentView(): Int {
        return R.layout.dialog_test
    }

    override fun initView() {
        setGravity(Gravity.CENTER)
        isFullWidth = false
    }

    override fun show() {
        super.show()
    }
}