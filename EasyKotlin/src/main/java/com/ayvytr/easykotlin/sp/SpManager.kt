package com.ayvytr.easykotlin.sp

import android.content.Context
import android.os.Build
import java.util.*
import kotlin.collections.LinkedHashMap

/**
 * [SpManager], 是 [Sp] 的管理类，同时也是 [android.content.SharedPreferences] 的操作类，以单例模式统一管理
 * 了 [Sp] 实例，便于统一维护管理和释放.
 *
 *
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

@Deprecated("not suggested")
class SpManager private constructor(private var context: Context)
{

    /**
     * 获取默认的 [Sp]，默认名称为当前app的包名 [Context.getPackageName]
     *
     * @return [Sp]
     */
    val sp: Sp
        get()
        {
            var sp: Sp? = map!![context.packageName]
            if (sp == null)
            {
                sp = Sp(context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE))
                map!!.put(context.packageName, sp)
            }

            return sp
        }

    /**
     * 获取 [Sp] 实例
     *
     * @param name [android.content.SharedPreferences] 名称
     * @return [Sp]
     */
    fun getSp(name: String): Sp
    {
        var sp: Sp? = map!![name]
        if (sp == null)
        {
            sp = Sp(context.getSharedPreferences(name, Context.MODE_PRIVATE))
            map!!.put(name, sp)
        }

        return sp
    }

    /**
     * 关闭 [SpManager]
     */
    fun close()
    {
        map?.clear()

        map = null
        spManager = null
    }

    /**
     * 删除默认的 [android.content.SharedPreferences] 文件，默认文件名称为当前app包名 [Context.getPackageName]
     */
    fun deleteSp()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        {
            context.deleteSharedPreferences(context.packageName)
        }
    }

    /**
     * 删除名称为name的 [android.content.SharedPreferences] 文件
     *
     * @param name [android.content.SharedPreferences] 文件名
     */
    fun deleteSp(name: String)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        {
            context.deleteSharedPreferences(name)
        }
    }

    /**
     * 把指定位置和名称的 [android.content.SharedPreferences] 文件移动到当前app环境
     *
     * @param sourceContext 原位置
     * @param name          [android.content.SharedPreferences] 文件名
     */
    fun moveSpFrom(sourceContext: Context, name: String)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        {
            context.moveSharedPreferencesFrom(sourceContext, name)
        }
    }

    companion object
    {
        private var spManager: SpManager? = null

        /**
         * [Sp] 集合
         */
        private var map: HashMap<String, Sp>? = null

        fun getDefault(context: Context): SpManager
        {
            if (spManager == null)
            {
                synchronized(SpManager::class.java) {
                    if (spManager == null)
                    {
                        spManager = SpManager(context.applicationContext)
                        map = LinkedHashMap()
                    }
                }
            }

            return spManager!!
        }
    }
}
