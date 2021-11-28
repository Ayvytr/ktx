package com.ayvytr.ktx.ui.spanner

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri
import java.util.*
import java.util.regex.Pattern

internal object SpannerUtils {

    fun dp2px(context: Context, dp: Int): Int {
        val density = context.applicationContext.resources.displayMetrics.density
        return (dp * density + 0.5f).toInt()
    }

    fun openURL(context: Context, url: String) {
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.flags = FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    fun indexesOf(src: String, target: String): List<Int> {
        val positions = ArrayList<Int>()
        var index = src.indexOf(target)
        while (index >= 0) {
            positions.add(index)
            index = src.indexOf(target, index + 1)
        }
        return positions
    }

    fun ranges(src: String, pattern: String): List<Range> {
        val ranges = ArrayList<Range>()
        val matcher = Pattern.compile(pattern).matcher(src)
        while (matcher.find()) {
            val range = Range.create(matcher.start(), matcher.end())
            ranges.add(range)
        }
        return ranges
    }

}
