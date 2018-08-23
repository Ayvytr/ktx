package com.ayvytr.easykotlin.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * TextView，文字居中，单行，末尾省略.
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @since 2.0.0
 */
public class SingleTextView extends AppCompatTextView {
    public SingleTextView(Context context) {
        this(context, null);
    }

    public SingleTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public SingleTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setGravity(Gravity.CENTER);
        setEllipsize(TextUtils.TruncateAt.END);
        setSingleLine(true);
    }
}
