package com.ayvytr.easykotlin.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

import com.ayvytr.easykotlin.R;
import com.ayvytr.easykotlin.customview.util.DensityUtil;
import com.ayvytr.easykotlin.customview.util.ResUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字母索引控件，和微信联系人右侧字母索引效果相似，可以在屏幕中心显示Toast，以及字母索引顶部和底部的图片
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @since 1.2.0
 */

public class QuickIndexView extends View
{
    /**
     * 默认字母索引宽高
     */
    private static final int DEFAULT_WIDTH_DP = 50;

    /**
     * 绘制字母索引的paint
     */
    private Paint paint;

    @ColorInt
    private int textColor;

    /**
     * 索引文字尺寸
     */
    private int textSize;

    /**
     * 字母索引List
     */
    private List<String> indexList;

    /**
     * 字母变化监听器
     * {@link OnLetterChangeListener}
     */
    private OnLetterChangeListener onLetterChangeListener;

    //索引文字重心，只有Top，Center，Center_Vertical有效
    private int gravity;

    private int bottomTextY;
    private int topTextY;

    public QuickIndexView(Context context)
    {
        this(context, null);
    }

    public QuickIndexView(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public QuickIndexView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    /**
     * 初始化，包括必要的 {@link #paint} 等变量初始化，xml属性获取等.
     *
     * @param attrs {@link AttributeSet}
     */
    private void init(AttributeSet attrs)
    {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.QuickIndexView);

        textColor = typedArray.getColor(R.styleable.QuickIndexView_android_textColor, 0x8A000000);
        textSize = typedArray.getDimensionPixelSize(R.styleable.QuickIndexView_android_textSize, -1);
        setBackgroundDrawable(typedArray.getDrawable(R.styleable.QuickIndexView_android_background));
        gravity = typedArray.getInt(R.styleable.QuickIndexView_android_gravity, Gravity.CENTER);

        CharSequence[] textArray = typedArray.getTextArray(R.styleable.QuickIndexView_indexArray);
        if(textArray != null)
        {
            indexList = new ArrayList<>();
            for(CharSequence charSequence : textArray)
            {
                indexList.add(charSequence.toString());
            }
        } else
        {
            setLetterArray(ResUtil.getStringArray(getContext(), R.array.defaultQuickIndexViewLetters));
        }

        typedArray.recycle();
    }

    public int getTextSize()
    {
        return textSize;
    }

    public void setTextSize(int textSize)
    {
        if(this.textSize == textSize)
        {
            return;
        }

        if(textSize > calcMaxTextSize())
        {
            return;
        }

        this.textSize = textSize;
    }

    public int getGravity()
    {
        return gravity;
    }

    public void setGravity(int gravity)
    {
        if(gravity != this.gravity)
        {
            if(gravity == Gravity.TOP || gravity == Gravity.CENTER || gravity == Gravity.CENTER_VERTICAL)
            {
                this.gravity = gravity;
            }
        }
    }

    /**
     * 获取 {@link #indexList}
     */
    public List<String> getIndexList()
    {
        return indexList;
    }

    /**
     * 设置 {@link #indexList}
     *
     * @param indexList 要设置的字母索引列表
     */
    public void setIndexList(List<String> indexList)
    {
        this.indexList = indexList;
        invalidate();
    }

    /**
     * 设置 {@link #indexList}
     *
     * @param letterArray 要设置的字母索引数组
     */
    public void setLetterArray(String[] letterArray)
    {
        this.indexList = Arrays.asList(letterArray);
        invalidate();
    }

    /**
     * 获取字体颜色 {@link #textColor}
     */
    public int getTextColor()
    {
        return textColor;
    }

    /**
     * 设置字体颜色 {@link #textColor}
     */
    public void setTextColor(@ColorInt int textColor)
    {
        this.textColor = textColor;
        invalidate();
    }

    /**
     * 只对宽度进行限制，尺寸默认为 {@link android.view.ViewGroup.LayoutParams#MATCH_PARENT}
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        if(widthMode == MeasureSpec.AT_MOST)
        {
            width = DensityUtil.dp2px(getContext(), DEFAULT_WIDTH_DP);
        }

        int height = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        int maxTextSize = calcMaxTextSize();
        if(textSize == -1)
        {
            this.textSize = maxTextSize;
        }

        paint.setColor(textColor);
        paint.setTextSize(textSize);

        int y = getPaddingTop();

        int x = getWidth() >> 1;
        int halfLetterLength = textSize >> 1;

        if(gravity == Gravity.CENTER || gravity == Gravity.CENTER_VERTICAL)
        {
            if(textSize < calcMaxTextSize())
            {
                int size = getIndexList().size();
                y = (getHeight() - size * textSize) / 2;
            }
        }

        this.topTextY = y;

        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int fontY = (int) (halfLetterLength - fontMetrics.top / 2 - fontMetrics.bottom / 2);
        int size = indexList.size();
        for(int i = 0; i < size; i++)
        {
            canvas.drawText(indexList.get(i), x, y + fontY, paint);
            y += textSize;
        }

        this.bottomTextY = y;
    }

    /**
     * 返回的每个Letter的支持的最大文字尺寸，因为动态设置时，如果设置的文字尺寸太大，超出最大文字尺寸，绘制出来没有意义，
     * 这时限制文字尺寸为支持的最大文字尺寸.
     * <p>
     * 计算方法：以控件宽度减去padding，而后计算
     *
     * @return 支持的最大文字尺寸
     */
    private int calcMaxTextSize()
    {
        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int letterCount = getIndexList().size();
        if(letterCount == 0)
        {
            return 0;
        }

        return Math.min(width, (getHeight() - getPaddingTop() - getPaddingBottom()) / letterCount);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getY() < topTextY || event.getY() > bottomTextY)
        {
            return true;
        }

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            {
                int index = (int) ((event.getY() - topTextY) / textSize);

                if(onLetterChangeListener != null)
                {
                    onLetterChangeListener.onLetterChange(index, indexList.get(index), this);
                }
            }
            break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    protected void onDetachedFromWindow()
    {
        paint = null;
        super.onDetachedFromWindow();
    }

    /**
     * 设置字母索引变化监听器
     *
     * @param onLetterChangeListener {@link OnLetterChangeListener}
     */
    public void setOnLetterChangeListener(OnLetterChangeListener onLetterChangeListener)
    {
        this.onLetterChangeListener = onLetterChangeListener;
    }

    /**
     * 字母索引变化监听器
     */
    public interface OnLetterChangeListener
    {
        /**
         * {@link #onTouchEvent(MotionEvent)} 触发时，调用此字母索引变化方法
         *
         * @param position       当前指向的position
         * @param text           当前指向的文本
         * @param quickIndexView {@link QuickIndexView}
         */
        void onLetterChange(int position, String text, QuickIndexView quickIndexView);
    }
}
