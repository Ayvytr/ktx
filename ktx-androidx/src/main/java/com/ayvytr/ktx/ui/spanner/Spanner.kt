package com.ayvytr.ktx.ui.spanner

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.TextUtils
import android.text.style.*
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.collection.ArrayMap
import androidx.core.content.ContextCompat
import com.ayvytr.ktx.provider.ContextProvider
import com.ayvytr.ktx.ui.spanner.span.BgColorSpan
import com.ayvytr.ktx.ui.spanner.span.ClickSpan
import com.ayvytr.ktx.ui.spanner.span.TextColorSpan
import java.util.*
import java.util.regex.Pattern

/**
 * 简化富文本上色，点击，加粗等功能的SpannableString.
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 3.1.3
 * 1. 取消长按点击事件
 * 2. 修改点击时的字体自动换行问题
 * 3. 取消点击时的背景色圆角
 * 4. 修改点击时的字体颜色和背景色为[TextColorSpan]，[BgColorSpan]保存
 * @since 0.1.0
 */
class Spanner(text: CharSequence):
    SpannableString(text) {
    private val rangeList = ArrayList<Range>()
    private val tagsMap = ArrayMap<Range, Any?>()

    fun first(target: String): Spanner {
        rangeList.clear()
        val index = toString().indexOf(target)
        val range = Range.create(index, index + target.length)
        rangeList.add(range)
        return this
    }

    fun last(target: String): Spanner {
        rangeList.clear()
        val index = toString().lastIndexOf(target)
        val range = Range.create(index, index + target.length)
        rangeList.add(range)
        return this
    }

    fun all(vararg targets: String): Spanner {
        rangeList.clear()

        for (target in targets) {
            if (TextUtils.isEmpty(target)) {
                continue
            }
            val indexes = SpannerUtils.indexesOf(toString(), target)
            for (index in indexes) {
                val range = Range.create(index, index + target.length)
                rangeList.add(range)
            }
        }
        return this
    }

    fun all(): Spanner {
        rangeList.clear()
        val range = Range.create(0, toString().length)
        rangeList.add(range)
        return this
    }

    fun allStartWith(vararg prefixs: String): Spanner {
        rangeList.clear()
        for (prefix in prefixs) {
            if (TextUtils.isEmpty(prefix)) {
                continue
            }
            val ranges = SpannerUtils.ranges(toString(), Pattern.quote(prefix) + "\\w+")
            rangeList.addAll(ranges)
        }
        return this
    }

    fun range(from: Int, to: Int): Spanner {
        rangeList.clear()
        val range = Range.create(from, to + 1)
        rangeList.add(range)
        return this
    }

    fun ranges(ranges: List<Range>): Spanner {
        rangeList.clear()
        rangeList.addAll(ranges)
        return this
    }

    fun between(startText: String, endText: String): Spanner {
        rangeList.clear()
        val startIndex = toString().indexOf(startText) + startText.length + 1
        val endIndex = toString().lastIndexOf(endText) - 1
        val range = Range.create(startIndex, endIndex)
        rangeList.add(range)
        return this
    }

    fun size(dp: Int): Spanner {
        for (range in rangeList) {
            setSpan(AbsoluteSizeSpan(dp, true), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun scaleSize(proportion: Int): Spanner {
        for (range in rangeList) {
            setSpan(RelativeSizeSpan(proportion.toFloat()), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun bold(): Spanner {
        for (range in rangeList) {
            setSpan(StyleSpan(Typeface.BOLD), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun italic(): Spanner {
        for (range in rangeList) {
            setSpan(StyleSpan(Typeface.ITALIC), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun normal(): Spanner {
        for (range in rangeList) {
            setSpan(StyleSpan(Typeface.NORMAL), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun boldItalic(): Spanner {
        for (range in rangeList) {
            setSpan(StyleSpan(Typeface.BOLD_ITALIC), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun font(font: String): Spanner {
        for (range in rangeList) {
            setSpan(TypefaceSpan(font), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun strikethrough(): Spanner {
        for (range in rangeList) {
            setSpan(StrikethroughSpan(), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun underline(): Spanner {
        for (range in rangeList) {
            setSpan(UnderlineSpan(), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    /**
     * 设置字体背景色和点击时的背景色
     * @see [BgColorSpan]
     * @see [ClickLinkMovementMethod]
     */
    @JvmOverloads
    fun backgroundColor(@ColorInt bgColor: Int, @ColorInt pressedBgColor: Int = bgColor): Spanner {
        for (range in rangeList) {
            setSpan(BgColorSpan(bgColor, pressedBgColor), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    /**
     * @see [backgroundColor]
     */
    @JvmOverloads
    fun backgroundColorRes(
        @ColorRes bgColorRes: Int,
        @ColorRes pressedBgColorRes: Int = bgColorRes
    ): Spanner {
        val context = ContextProvider.getContext()
        val color = ContextCompat.getColor(context, bgColorRes)
        val pressedBackgroundColor = ContextCompat.getColor(context, pressedBgColorRes)
        return backgroundColor(color, pressedBackgroundColor)
    }


    /**
     * 设置字体颜色和点击时的字体颜色
     * @see [TextColorSpan]
     * @see [ClickLinkMovementMethod]
     */
    @JvmOverloads
    fun textColor(@ColorInt textColor: Int, @ColorInt pressedTextColor: Int = textColor): Spanner {
        for (range in rangeList) {
            setSpan(TextColorSpan(textColor, pressedTextColor), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    /**
     * @see [textColor]
     */
    @JvmOverloads
    fun textColorRes(
        @ColorRes textColorRes: Int,
        @ColorRes pressedTextColorRes: Int = textColorRes
    ): Spanner {
        val context = ContextProvider.getContext()
        return textColor(
            ContextCompat.getColor(context, textColorRes),
            ContextCompat.getColor(context, pressedTextColorRes)
        )
    }

    fun subscript(): Spanner {
        for (range in rangeList) {
            setSpan(SubscriptSpan(), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun superscript(): Spanner {
        for (range in rangeList) {
            setSpan(SuperscriptSpan(), range.from, range.to, SPAN_MODE)
        }
        return this
    }

    fun onClick(textView: TextView, action: (CharSequence, Range) -> Unit): Spanner {
        for (range in rangeList) {
            val span = ClickSpan(
                subSequence(range.from, range.to),
                range,
                action
            )
            setSpan(span, range.from, range.to, SPAN_MODE)
        }
        linkify(textView)
        return this
    }

//    fun onLongClick(textView: TextView,
//                    onTextLongClickListener: OnTextLongClickListener): Spanner {
//        for (range in rangeList) {
//            val span = CustomClickableSpan(
//                textView,
//                subSequence(range.from, range.to),
//                range,
//                tagsMap[range],
//                onTextLongClickListener
//            )
//            setSpan(span, range.from, range.to, SPAN_MODE)
//        }
//        linkify(textView)
//        return this
//    }

    fun tag(tag: Any): Spanner {
        val lastRange = rangeList[rangeList.size - 1]
        tagsMap[lastRange] = tag
        return this
    }

    fun tags(vararg tags: Any): Spanner {
        return tags(Arrays.asList(*tags))
    }

    fun tags(tags: List<Any>): Spanner {
        var i = 0
        for (tag in tags) {
            tagsMap[rangeList[i++]] = tag
        }
        return this
    }

    fun tagOf(range: Range): Any? {
        return tagsMap[range]
    }

    private fun linkify(textView: TextView) {
        textView.movementMethod = ClickLinkMovementMethod.INSTANCE
    }

    companion object {
        internal val SPAN_MODE = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE

        /**
         * [Spanner]入口.
         */
        @JvmStatic
        fun from(text: CharSequence): Spanner {
            return Spanner(text)
        }
    }

}
