package com.ayvytr.ktx.ui.edittext

import kotlin.jvm.JvmOverloads
import com.ayvytr.ktx.ui.edittext.DecimalDigitsInputFilter
import android.text.InputFilter
import android.text.Spanned

/**
 * 小数位数筛选器，支持大于0的自然数，默认2位小数.
 *
 * <p>
 * 注意：
 * setInputType(InputType.TYPE_CLASS_NUMBER)之后，只能输入数字；
 * setInputType(InputType.TYPE_NUMBER_FLAG_DECIMAL)之后，只能输入数字，点；
 * 需要支持负号的方案：
 * setRawInputTYpe(InputType.TYPE_CLASS_NUMBER)，并且调用[android.widget.TextView.setKeyListener]或者
 * digits限制可输入字符中加入负号、数字、点，支持负数和小数输入
 * </p>
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 3.0.7
 */
class DecimalDigitsInputFilter @JvmOverloads constructor(decimalDigits: Int = DEFAULT_DECIMAL_DIGITS):
    InputFilter {

    init {
        setDecimalDigits(decimalDigits)
    }

    /**
     * 小数位数
     */
    private var decimalDigits = 0

    fun setDecimalDigits(decimalDigits: Int) {
        if (decimalDigits > 0) {
            this.decimalDigits = decimalDigits
        } else {
            this.decimalDigits = DEFAULT_DECIMAL_DIGITS
        }
    }

    override fun filter(
        source: CharSequence, start: Int, end: Int,
        dest: Spanned, dstart: Int, dend: Int
    ): CharSequence? {
        // 删除等特殊字符，直接返回
        if ("" == source.toString()) {
            return null
        }

        //防止允许负号时多次输入或者中间输入
        val dValue = dest.toString()
        if(source == "-") {
            if(dValue == "-") {
                return ""
            }

            if(dValue.isNotEmpty()) {
                return ""
            }
        }

        val splitArray = dValue.split(".").toTypedArray()
        if (splitArray.size > 1) {
            val dotValue = splitArray[1]
            val diff = dotValue.length + 1 - decimalDigits
            if (diff > 0) {
                return source.subSequence(start, end - diff)
            }
        }
        return null
    }

    companion object {
        const val DEFAULT_DECIMAL_DIGITS = 2
    }

}