package com.ayvytr.ktx.context

import android.content.Context
import com.ayvytr.ktx.provider.ContextProvider

/**
 * 将px转换为dp
 *
 * @param px 像素值
 * @return dp值
 * @since 2.5.3
 */
@Deprecated("推荐使用Int或Float扩展属性", replaceWith = ReplaceWith("px.px2dp"))
fun Context.px2dp(px: Int): Int {
    return px2dp(px.toFloat())
}

/**
 * 将px转换为dp，接收/返回float
 *
 * @param px 像素值
 * @return dp值
 */
@Deprecated("推荐使用Int或Float扩展属性", replaceWith = ReplaceWith("px.px2dp"))
fun Context.px2dp(px: Float): Int {
    val scale = resources.displayMetrics.density
    return (px / scale + 0.5F).toInt()
}

/**
 * 将px转换为dp，接收/返回double
 *
 * @param px 像素值
 * @return dp值
 */
@Deprecated("弃用Double转换")
fun Context.px2dp(px: Double): Double {
    val scale = resources.displayMetrics.density
    return px / scale + 0.5F
}

/**
 * 将dp转换为px，接收/返回int
 *
 * @param dp dp值
 * @return 像素值
 */
@Deprecated("推荐使用Int或Float扩展属性", replaceWith = ReplaceWith("dp.dp2px"))
fun Context.dp2px(dp: Int): Int {
    return dp2px(dp.toFloat())
}

/**
 * 将dp转换为px，接收/返回float
 *
 * @param dp dp值
 * @return 像素值
 */
@Deprecated("推荐使用Int或Float扩展属性", replaceWith = ReplaceWith("px.dp2px"))
fun Context.dp2px(dp: Float): Int {
    val scale = resources.displayMetrics.density
    return (dp * scale + 0.5F).toInt()
}

/**
 * 将dp转换为px，接收/返回double
 *
 * @param dp dp值
 * @return 像素值
 */
@Deprecated("弃用Double转换")
fun Context.dp2px(dp: Double): Double {
    val scale = resources.displayMetrics.density
    return dp * scale + 0.5F
}

/**
 * dp转px
 */
val Float.dp
    get() = dp2px

/**
 * sp转px
 */
val Float.sp
    get() = sp2px

/**
 * dp转px
 */
val Int.dp
    get() = toFloat().dp

/**
 * sp转px
 */
val Int.sp
    get() = toFloat().sp

/**
 * dp转px
 */
val Float.dp2px
    get() = run {
        val scale = ContextProvider.getContext().resources.displayMetrics.density
        this * scale + 0.5F
    }.toInt()

/**
 * dp转px
 */
val Int.dp2px
    get() = toFloat().dp2px

/**
 * sp转px
 */
val Float.sp2px
    get() = run {
        val fontScale = ContextProvider.getContext().resources.displayMetrics.scaledDensity
        this * fontScale + 0.5F
    }.toInt()

/**
 * sp转px
 */
val Int.sp2px
    get() = toFloat().sp2px

/**
 * px转dp
 */
val Float.px2dp
    get() = run {
        val scale = ContextProvider.getContext().resources.displayMetrics.scaledDensity
        this / scale + 0.5F
    }.toInt()

/**
 * px转dp
 */
val Int.px2dp
    get() = toFloat().px2dp

/**
 * px转sp
 */
val Float.px2sp
    get() = run {
        val fontScale = ContextProvider.getContext().resources.displayMetrics.scaledDensity
        this / fontScale + 0.5f
    }.toInt()

/**
 * px转sp
 */
val Int.px2sp
    get() = toFloat().px2sp


