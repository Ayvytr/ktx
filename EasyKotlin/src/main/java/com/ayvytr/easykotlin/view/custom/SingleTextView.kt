package com.ayvytr.easykotlin.view.custom

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.text.TextUtils
import android.util.AttributeSet
import android.view.Gravity

/**
 * SingleTextView，默认文字居中，单行，超出一行以结尾为省略号显示，默认padding为10px.
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 0.2.0
 */

class SingleTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = android.R.attr.textViewStyle) : AppCompatTextView(context, attrs, defStyleAttr)
{
    init
    {
        gravity = Gravity.CENTER
        setSingleLine()
        ellipsize = TextUtils.TruncateAt.END
        //去掉padding属性，因为设置居中后，再设置padding没有意义，并且TextView尺寸特别小的时候，字会被裁切
//        setPadding(10, 10, 10, 10)
    }
}
