package com.ayvytr.ktx.ui.spanner

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.text.TextPaint
import android.text.style.ReplacementSpan

import androidx.annotation.ColorInt

internal class RoundedBackgroundSpan : ReplacementSpan {

    private var radius = 0
    private var backgroundColor: Int = 0
    private var textColor: Int = 0

    constructor(@ColorInt textColor: Int,
                @ColorInt backgroundColor: Int,
                radius: Int) {
        this.backgroundColor = backgroundColor
        this.textColor = textColor
        this.radius = radius
    }

    constructor(@ColorInt backgroundColor: Int,
                radius: Int) {
        this.backgroundColor = backgroundColor
        this.radius = radius
    }

    override fun getSize(paint: Paint, text: CharSequence, start: Int, end: Int,
                         fm: Paint.FontMetricsInt?): Int {
        return paint.measureText(text.subSequence(start, end).toString()).toInt()
    }

    override fun draw(canvas: Canvas, text: CharSequence,
                      start: Int, end: Int, x: Float, top: Int, y: Int, bottom: Int,
                      paint: Paint) {
        val isLeftEdge = x == 0.0f

        if (backgroundColor != 0) {
            val extra1Dp = ((paint as TextPaint).density * 1 + 0.5f).toInt()
            val width = paint.measureText(text.subSequence(start, end).toString())
            val newTop = (bottom.toFloat() - paint.getFontSpacing() - paint.descent()).toInt() + 2 * extra1Dp
            val newBottom = bottom - extra1Dp
            val newLeft = (if (isLeftEdge) x else x - radius).toInt()
            val newRight = (if (isLeftEdge) x + width + (2 * radius).toFloat() else x + width + radius.toFloat()).toInt()
            val rect = RectF(newLeft.toFloat(), newTop.toFloat(), newRight.toFloat(), newBottom.toFloat())
            paint.setColor(backgroundColor)
            canvas.drawRoundRect(rect, radius.toFloat(), radius.toFloat(), paint)
        }

        if (textColor != 0) {
            val textX = if (isLeftEdge) x + radius else x
            paint.color = textColor
            canvas.drawText(text, start, end, textX, y.toFloat(), paint)
        }
    }

}