package com.ayvytr.ktx.context

import com.ayvytr.ktx.provider.ContextProvider


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


