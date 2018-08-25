package com.ayvytr.easykotlin.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ayvytr.easykotlin.R;
import com.ayvytr.easykotlin.customview.util.DensityUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 可点击清除按钮清除文本的EditText
 * 修改字体Padding，请使用textPadding，textPaddingLeft, textPaddingRight, textPaddingTop, textPaddingBottom.
 *
 * @author wangdunwei
 * @date 2018/5/7
 */
public class SuperEditText extends LinearLayout
{
    private EditText etInput;
    private ImageView ivClear;
    private ImageButton ibEye;

    private TextWatcher textWatcher;
    private TextWatcher inputNameTextWatcher;
    private View underLine;

    private OnFocusChangeCustomListener mFocusChangeListener;

    public SuperEditText(Context context)
    {
        this(context, null);
    }

    public SuperEditText(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public SuperEditText(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public interface OnFocusChangeCustomListener
    {
        void focusChange(boolean hasFocus);
    }

    public void setOnFocusChangeCustomListener(OnFocusChangeCustomListener focusChangeListener)
    {
        this.mFocusChangeListener = focusChangeListener;
    }

    private void init(AttributeSet attrs)
    {
        View.inflate(getContext(), R.layout.layout_clearable_edittext, this);
        etInput = findViewById(R.id.et_input);
        ivClear = findViewById(R.id.iv_clear);
        ibEye = findViewById(R.id.ib_eye_pwd);
        underLine = findViewById(R.id.line);

        textWatcher = new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                ivClear.setVisibility(s.toString().isEmpty() ? View.GONE : View.VISIBLE);
            }
        };
        ivClear.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                etInput.setText(null);
            }
        });

        if(attrs != null)
        {
            TypedArray ta = getContext().obtainStyledAttributes(attrs, R.styleable.SuperEditText);
            setEnabled(ta.getBoolean(R.styleable.SuperEditText_android_enabled, true));
            etInput.setText(ta.getString(R.styleable.SuperEditText_android_text));

            final int inputType = ta.getInt(R.styleable.SuperEditText_android_inputType, InputType.TYPE_CLASS_TEXT);
            etInput.setInputType(inputType);

            boolean eyePwd = ta.getBoolean(R.styleable.SuperEditText_eye_pwd, false);
            if(eyePwd)
            {
                ibEye.setVisibility(VISIBLE);
                ibEye.setOnClickListener(new OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        ibEye.setSelected(!ibEye.isSelected());
                        etInput.setTransformationMethod(
                                ibEye.isSelected() ? HideReturnsTransformationMethod.getInstance() :
                                        PasswordTransformationMethod.getInstance());
                        etInput.setSelection(etInput.getText().length());
                    }
                });
            } else
            {
                ibEye.setVisibility(GONE);
                etInput.addTextChangedListener(textWatcher);
            }

            etInput.setHint(ta.getString(R.styleable.SuperEditText_android_hint));
            int color = ta.getColor(R.styleable.SuperEditText_android_textColor, -1);
            if(color != -1)
            {
                etInput.setTextColor(color);
            }
            color = ta.getColor(R.styleable.SuperEditText_android_textColorHint, -1);
            if(color != -1)
            {
                etInput.setHintTextColor(color);
            }

            etInput.setBackgroundDrawable(ta.getDrawable(R.styleable.SuperEditText_android_background));
            //输入长度限制
            int maxLength = ta.getInt(R.styleable.SuperEditText_android_maxLength, -1);
            if(maxLength >= 0)
            {
                etInput.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
            } else
            {
                etInput.setFilters(new InputFilter[0]);
            }

            int paddingTop, paddingRight, paddingLeft = 0, paddingBottom;
            int tempPadding = ta.getDimensionPixelSize(R.styleable.SuperEditText_textPadding,
                    DensityUtil.dp2px(getContext(), -1));
            if(tempPadding != -1)
            {
                paddingBottom = paddingLeft = paddingRight = paddingTop = tempPadding;
            }

            tempPadding = ta.getDimensionPixelSize(R.styleable.SuperEditText_textPaddingLeft, -1);
            if(tempPadding != -1)
            {
                paddingLeft = tempPadding;
            }
            paddingRight = ta.getDimensionPixelSize(R.styleable.SuperEditText_textPaddingRight, -1);
            if(tempPadding != -1)
            {
                paddingRight = tempPadding;
            }
            paddingTop = ta.getDimensionPixelSize(R.styleable.SuperEditText_textPaddingTop, -1);
            if(tempPadding != -1)
            {
                paddingTop = tempPadding;
            }
            paddingBottom = ta.getDimensionPixelSize(R.styleable.SuperEditText_textPaddingBottom, -1);
            if(tempPadding != -1)
            {
                paddingBottom = tempPadding;
            }
            etInput.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);

            //输入内容限制
            final String digits = ta.getString(R.styleable.SuperEditText_android_digits);
            if(digits != null)
            {
                etInput.setKeyListener(new NumberKeyListener()
                {
                    @NonNull
                    @Override
                    protected char[] getAcceptedChars()
                    {
                        return digits.toCharArray();
                    }

                    @Override
                    public int getInputType()
                    {
                        return InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
                    }
                });
            }

            boolean inputName = ta.getBoolean(R.styleable.SuperEditText_inputName, false);
            if(inputName)
            {
                addInputNameTextWatcher();
            }

            Drawable drawable = ta.getDrawable(R.styleable.SuperEditText_android_drawableRight);
            if(drawable != null)
            {
                ivClear.setImageDrawable(drawable);
            }

            boolean underlineVisible = ta.getBoolean(R.styleable.SuperEditText_showUnderLine, true);
            underLine.setVisibility(underlineVisible ? VISIBLE : GONE);

            int underlineResId = ta.getResourceId(R.styleable.SuperEditText_underlineBg, 0);
            if(underlineResId != 0)
            {
                underLine.setBackgroundResource(underlineResId);
            }

            ta.recycle();

            etInput.setEnabled(isEnabled());
            ivClear.setEnabled(isEnabled());
        }

        etInput.setOnFocusChangeListener(new OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View v, boolean hasFocus)
            {
                if(underLine.getVisibility() == VISIBLE)
                {
                    underLine.setSelected(hasFocus);
                }
                if(mFocusChangeListener != null)
                {
                    mFocusChangeListener.focusChange(hasFocus);
                }
            }
        });
    }

    private void addInputNameTextWatcher()
    {
        if(inputNameTextWatcher == null)
        {
            inputNameTextWatcher = new TextWatcher()
            {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after)
                {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count)
                {
                    String editable = etInput.getText().toString();
                    String str = chineseFilter(editable);
                    if(!editable.equals(str))
                    {
                        etInput.setText(str);
                        //设置新的光标所在位置
                        etInput.setSelection(str.length());
                    }
                }

                @Override
                public void afterTextChanged(Editable s)
                {
                    ivClear.setVisibility(s.toString().isEmpty() ? View.GONE : View.VISIBLE);
                }

            };
            etInput.addTextChangedListener(inputNameTextWatcher);
        }
    }


    @Override
    public void setEnabled(boolean enabled)
    {
        super.setEnabled(enabled);
        etInput.setEnabled(isEnabled());
        ivClear.setEnabled(isEnabled());
    }

    public String getText()
    {
        return etInput.getText().toString();
    }

    public void setText(String text)
    {
        etInput.setText(text);
    }

    public void setText(@StringRes int id)
    {
        etInput.setText(id);
    }

    public void setHint(String hint)
    {
        etInput.setHint(hint);
    }

    public void setHint(@StringRes int id)
    {
        etInput.setHint(id);
    }

    public void setDrawableRight(Drawable drawable)
    {
        ivClear.setImageDrawable(drawable);
    }

    public void setDrawableRight(@DrawableRes int id)
    {
        ivClear.setImageResource(id);
    }

    public void addTextChangedListener(TextWatcher watcher)
    {
        etInput.addTextChangedListener(watcher);
    }

    public void setSelection(int index)
    {
        etInput.setSelection(index);
    }

    public void setKeyListener(KeyListener input)
    {
        etInput.setKeyListener(input);
    }

    public void setUnderLineVisible(boolean visible)
    {
        underLine.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    public static String chineseFilter(String str)
    {
        try
        {
            String regEx = "[^\u4E00-\u9FA5]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            return m.replaceAll("").trim();
        } catch(Exception e)
        {
            return str;
        }

    }
}
