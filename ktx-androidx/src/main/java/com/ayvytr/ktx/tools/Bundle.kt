package com.ayvytr.ktx.tools

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.ArrayMap
import java.io.Serializable

/**
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 3.1.7
 */
fun bundleOf(vararg params: Pair<String, Any?>): Bundle {
    val bundle = Bundle()
    params.forEach {
        val key = it.first
        val value = it.second
        when (value) {
            null -> bundle.putSerializable(key, null as Serializable?)
            is Int -> bundle.putInt(key, value)
            is Long -> bundle.putLong(key, value)
            is String -> bundle.putString(key, value)
            is CharSequence -> bundle.putCharSequence(key, value)
            is Float -> bundle.putFloat(key, value)
            is Double -> bundle.putDouble(key, value)
            is Char -> bundle.putChar(key, value)
            is Short -> bundle.putShort(key, value)
            is Boolean -> bundle.putBoolean(key, value)

            is ByteArray -> bundle.putByteArray(key, value)
            is CharArray -> bundle.putCharArray(key, value)
            is ShortArray -> bundle.putShortArray(key, value)
            is IntArray -> bundle.putIntArray(key, value)
            is LongArray -> bundle.putLongArray(key, value)
            is FloatArray -> bundle.putFloatArray(key, value)
            is DoubleArray -> bundle.putDoubleArray(key, value)
            is BooleanArray -> bundle.putBooleanArray(key, value)
            is Array<*> -> when {
                value.isArrayOf<CharSequence>() -> bundle.putCharSequenceArray(
                    key, value as Array<out CharSequence>?
                )
                value.isArrayOf<String>() -> bundle.putStringArray(key, value as Array<out String>?)
                value.isArrayOf<Parcelable>() -> bundle.putParcelableArray(
                    it.first, value as Array<out Parcelable>?
                )
            }

            is ArrayList<*> -> bundle.putSerializable(key, value)

            is Serializable -> bundle.putSerializable(key, value)
            is Bundle -> bundle.putBundle(key, value)
            is Parcelable -> bundle.putParcelable(key, value)

            //除了基本类型，数组，ArrayList，其他类型反射获取BaseBundle.mMap直接存储
            else -> {
                /**
                 * 触发Bundle.unparcel()初始化，防止mMap为空
                 */
                bundle.putString(null, null)

                //需要sdk>=19
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    try {
                        val field = bundle::class.java.superclass.getDeclaredField("mMap")
                        field.isAccessible = true
                        val map = field.get(bundle) as ArrayMap<String, Any>
                        map.put(key, value)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
        }
        return@forEach
    }
    return bundle
}