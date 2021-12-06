package com.ayvytr.ktx.app

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.Process
import com.ayvytr.ktx.provider.ContextProvider
import java.io.Serializable
import java.util.*
import kotlin.system.exitProcess

/**
 * Activity管理任务栈，内部通过[Application.registerActivityLifecycleCallbacks]实现，可以打开和关闭指定
 * Activity，关闭所有Activity，关闭除指定Activity外所有Activity，终止进程等功能.
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 2.5.1
 */
object ActivityStack {
    @JvmStatic
    private var isForceClose: Boolean = false

    @JvmStatic
    private val list by lazy { LinkedList<Activity>() }

    @JvmStatic
    private var foregroundActivityCount = 0

    @JvmStatic
    private val callback by lazy {
        object: Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityStarted(activity: Activity) {
                foregroundActivityCount++
            }

            override fun onActivityDestroyed(activity: Activity) {
                list.remove(activity)
                if (list.isEmpty() && isForceClose) {
                    isForceClose = false
                    killSelf()
                }
            }

            override fun onActivityStopped(activity: Activity) {
                foregroundActivityCount--
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                list.add(activity)
            }
        }
    }

    /**
     * 注册Activity Lifecycle callback.
     */
    @JvmStatic
    fun registerCallback(app: Application) {
        app.registerActivityLifecycleCallbacks(callback)
    }

    /**
     * 取消注册Activity Lifecycle callback.
     */
    @JvmStatic
    fun unregisterCallback(app: Application) {
        list.clear()
        app.unregisterActivityLifecycleCallbacks(callback)
    }

    /**
     * 返回已启动的Activity数量.
     */
    @JvmStatic
    fun getRunningActivityCount(): Int {
        return list.size
    }

    /**
     * 判断Activity是否在前台
     */
    @JvmStatic
    fun isForeground(): Boolean {
        return foregroundActivityCount != 0
    }

    /**
     * 获取当前Activity.
     */
    @JvmStatic
    fun getCurrentActivity(): Activity? {
        if (list.isEmpty()) {
            return null
        }

        return list.last
    }

    /**
     * 关闭[clazz] Activity.
     */
    @JvmStatic
    fun finish(clazz: Class<out Activity>) {
        list.reversed().forEach {
            if (it.javaClass == clazz) {
                it.finish()
                return
            }
        }
    }

    /**
     * 关闭当前Activity.
     */
    @JvmStatic
    fun finishCurrent() {
        if (list.size > 0) {
            list.last.finish()
        }
    }

    /**
     * 关闭所有Activity.
     */
    @JvmStatic
    fun finishAll() {
        list.reversed().forEach {
            it.finish()
        }
    }

    /**
     * 关闭除[clazz]外的所有Activity.
     */
    @JvmStatic
    fun finishAllExcept(clazz: Class<out Activity>) {
        var find = false
        list.reversed().forEach {
            if (it.javaClass == clazz && !find) {
                find = true
            } else {
                it.finish()
            }
        }
    }

    /**
     * 启动[clazz],[map]是附带参数.
     */
    @JvmStatic
    fun start(clazz: Class<out Activity>, map: Map<String, Serializable>? = null) {
        val currentActivity = getCurrentActivity()
        val context = ContextProvider.getContext()
        val intent = Intent(context, clazz)
        map?.forEach {
            intent.putExtra(it.key, it.value)
        }

        if (currentActivity == null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } else {
            currentActivity.startActivity(intent)
        }
    }

    /**
     * 通过[intent]启动Activity.
     */
    @JvmStatic
    fun start(intent: Intent) {
        intent.component?.let {
            val currentActivity = getCurrentActivity()
            if (currentActivity == null) {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                ContextProvider.getContext().startActivity(intent)
            } else {
                currentActivity.startActivity(intent)
            }
        }
    }

    /**
     * 启动[clazz], [map]是附带参数，并且关闭其他所有Activity.
     */
    @JvmStatic
    fun startAndFinishOthers(clazz: Class<out Activity>, map: Map<String, Serializable>? = null) {
        start(clazz, map)
        finishAllExcept(clazz)
    }

    /**
     * [intent]方式启动Activity，并且关闭其他所有Activity.
     */
    @JvmStatic
    fun startAndFinishOthers(intent: Intent) {
        intent.component?.let {
            start(intent)
            finishAllExcept(Class.forName(it.className) as Class<out Activity>)
        }
    }

    /**
     * 关闭除顶部Activity外的其他所有activity.
     */
    @JvmStatic
    fun finishExceptTop() {
        val last = list.last
        while (list[0] != last) {
            list[0].finish()
        }
    }

    /**
     * 强制关闭Activity.
     * @param closeImmediately true:直接调用[Process.killProcess]和[exitProcess]终止进程; false:关闭
     * 已打开的Activity, 在后台终止进程.
     */
    @JvmStatic
    fun forceClose(closeImmediately: Boolean = false) {
        if (closeImmediately) {
            killSelf()
        } else {
            isForceClose = true
            finishAll()
        }
    }

    @Deprecated("Replace with killApp.",
                replaceWith = ReplaceWith("killApp()"))
    @JvmStatic
    fun killSelf() {
        killApp()
    }

    /**
     * @since 3.0.1
     */
    @JvmStatic
    fun killApp() {
        Process.killProcess(Process.myPid())
        exitProcess(0)
    }
}
