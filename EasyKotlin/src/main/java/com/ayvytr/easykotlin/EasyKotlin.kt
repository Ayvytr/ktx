package com.ayvytr.easykotlin

import android.content.Context
import android.widget.Toast


/**
 * 这个库的单例入口类, 使用有关Context的类之前，需要初始化这个类.
 *
 *
 * 提供了获取Context，常用SystemService等方法，在使用 ClipboardTool, DensityTool 等类之前，
 * 需要调用'EasyKotlin.getDefault().initTag(context);' 初始化。
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

class EasyKotlin private constructor()
{
    private var context: Context? = null

    /**
     * 初始化Context
     *
     * @param c context
     */
    fun init(c: Context)
    {
        context = c.applicationContext
    }

    fun getContext(): Context
    {
        return context!!
    }

    /**
     * 释放资源（可能用不到，但还是提供吧)
     */
    fun release()
    {
        context = null
    }

    companion object
    {
        /**
         * 单例初始化 [EasyKotlin] 方法，并返回 [EasyKotlin] 对象
         *
         * @return [EasyKotlin] 对象
         */
        var default = EasyKotlin()
            private set

        var gToast: Toast? = null
    }

}
