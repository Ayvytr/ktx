package com.ayvytr.easykotlinproject;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * 小数位数筛选器，支持大于0的自然数，默认2位小数，小于等于0的数忽略，注意要配合 {@link android.widget.EditText#setInputType(int)}
 * 使用，限制只能输入数字.
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @since 1.0.1
 */
public class DecimalDigitsInputFilter implements InputFilter {
    /**
     * 小数位数
     */
    private int decimalDigits;

    public static final int DEFAULT_DECIMAL_DIGITS = 2;

    public DecimalDigitsInputFilter() {
        this(DEFAULT_DECIMAL_DIGITS);
    }

    public DecimalDigitsInputFilter(int decimalDigits) {
        setDecimalDigits(decimalDigits);
    }

    public void setDecimalDigits(int decimalDigits) {
        if(decimalDigits > 0) {
            this.decimalDigits = decimalDigits;
        } else {
            this.decimalDigits = DEFAULT_DECIMAL_DIGITS;
        }
    }


    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dstart, int dend) {
        // 删除等特殊字符，直接返回
        if("".equals(source.toString())) {
            return null;
        }
        String dValue = dest.toString();
        String[] splitArray = dValue.split("\\.");
        if(splitArray.length > 1) {
            String dotValue = splitArray[1];
            int diff = dotValue.length() + 1 - decimalDigits;
            if(diff > 0) {
                return source.subSequence(start, end - diff);
            }
        }
        return null;
    }

}
