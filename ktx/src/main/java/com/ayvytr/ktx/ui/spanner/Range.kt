package com.ayvytr.ktx.ui.spanner

import java.io.Serializable

class Range private constructor(var from: Int, var to: Int) : Serializable {

    override fun toString(): String {
        val sb = StringBuilder("Range{")
        sb.append("from=").append(from)
        sb.append(", to=").append(to)
        sb.append('}')
        return sb.toString()
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val range = o as Range?

        return if (from != range!!.from) false else to == range.to

    }

    override fun hashCode(): Int {
        var result = from
        result = 31 * result + to
        return result
    }

    companion object {

        fun create(from: Int, to: Int): Range {
            return Range(from, to)
        }
    }

}