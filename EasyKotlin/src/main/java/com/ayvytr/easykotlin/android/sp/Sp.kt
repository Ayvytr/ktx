package com.ayvytr.easykotlin.android.sp

import android.content.SharedPreferences
import android.os.Build

/**
 * [Sp], 是 [SharedPreferences] 的操作类，通过构造函数接受了 [SharedPreferences] 实例，获取值和设置值的步骤
 * 进行了简化和缩短，能够较为简便地使用。这个类可以单独使用，不过还是建议使用 [SpManager] 获得 [Sp] 实例，便于统一管
 * 理，以及统一释放 [SpManager.close].
 *
 *
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

@Deprecated("not suggested")
class Sp(val sp: SharedPreferences)
{
    /**
     * @return value
     * @see SharedPreferences.getAll
     */
    val all: Map<String, *>
        get() = sp.all

    /**
     * @param key key
     * @return value
     * @see .getString
     */
    fun getString(key: String): String?
    {
        return getString(key, "")
    }

    /**
     * @param key key
     * @return value
     * @see SharedPreferences.getString
     */
    fun getString(key: String, defStr: String?): String?
    {
        return sp.getString(key, defStr)
    }

    /**
     * @param key key
     * @return value
     * @see SharedPreferences.getInt
     */
    @JvmOverloads
    fun getInt(key: String, defInt: Int = 0): Int
    {
        return sp.getInt(key, defInt)
    }

    /**
     * @param key key
     * @return value
     * @see SharedPreferences.getBoolean
     */
    @JvmOverloads
    fun getBool(key: String, defBool: Boolean = false): Boolean
    {
        return sp.getBoolean(key, defBool)
    }

    /**
     * @param key key
     * @return value
     * @see SharedPreferences.getFloat
     */
    @JvmOverloads
    fun getFloat(key: String, defFloat: Float = 0f): Float
    {
        return sp.getFloat(key, defFloat)
    }

    /**
     * @param key key
     * @return value
     * @see SharedPreferences.getLong
     */
    @JvmOverloads
    fun getLong(key: String, defLong: Long = 0): Long
    {
        return sp.getLong(key, defLong)
    }

    /**
     * @param key key
     * @return value
     * @see SharedPreferences.getStringSet
     */
    @JvmOverloads
    fun getStringSet(key: String, defStringSet: Set<String>? = null): Set<String>?
    {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            sp.getStringSet(key, defStringSet)
        }
        else null

    }

    /**
     * @param key key
     * @return `true ` 存在键名为key的值
     * @see SharedPreferences.contains
     */
    operator fun contains(key: String): Boolean
    {
        return sp.contains(key)
    }

    /**
     * @param key key
     * @param value value
     * @return [Sp]
     * @see SharedPreferences.Editor.putString
     */
    fun putString(key: String, value: String): Sp
    {
        sp.edit().putString(key, value).apply()
        return this
    }

    /**
     * @param key key
     * @param value value
     * @return [Sp]
     * @see SharedPreferences.Editor.putInt
     */
    fun putInt(key: String, value: Int): Sp
    {
        sp.edit().putInt(key, value).apply()
        return this
    }

    /**
     * @param key key
     * @param value value
     * @return [Sp]
     * @see SharedPreferences.Editor.putLong
     */
    fun putLong(key: String, value: Long): Sp
    {
        sp.edit().putLong(key, value).apply()
        return this
    }

    /**
     * @param key key
     * @param value value
     * @return [Sp]
     * @see SharedPreferences.Editor.putBoolean
     */
    fun putBool(key: String, value: Boolean): Sp
    {
        sp.edit().putBoolean(key, value).apply()
        return this
    }

    /**
     * @param key key
     * @param value value
     * @return [Sp]
     * @see SharedPreferences.Editor.putFloat
     */
    fun putFloat(key: String, value: Float): Sp
    {
        sp.edit().putFloat(key, value).apply()
        return this
    }

    /**
     * @param key key
     * @param value value
     * @return [Sp]
     * @see SharedPreferences.Editor.putStringSet
     */
    fun putStringSet(key: String, value: Set<String>): Sp
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
        {
            sp.edit().putStringSet(key, value).apply()
        }
        return this
    }

    /**
     * @param key key
     * @see SharedPreferences.Editor.remove
     */
    fun remove(key: String)
    {
        sp.edit().remove(key).apply()
    }

    /**
     * @see SharedPreferences.Editor.clear
     */
    fun clear()
    {
        sp.edit().clear().apply()
    }
}


