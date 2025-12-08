package com.ayvytr.ktx.app

import android.app.Activity
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.os.Process
import androidx.lifecycle.Transformations.map
import com.ayvytr.ktx.provider.ContextProvider
import java.io.Serializable
import kotlin.system.exitProcess

/**
 * Activity管理任务栈，内部通过[Application.registerActivityLifecycleCallbacks]实现，可以打开和关闭指定
 * Activity，关闭所有Activity，关闭除指定Activity外所有Activity，终止进程等功能.
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 3.1.6
 * 1. 修改[isForeground]，适配Android12最后关闭的Activity默认不会onDestroy()的问题
 * 2. [registerCallback]增加第二个参数observer，回调判断Activity是否前台可见
 * 3. 适配：不停的按返回很快关闭多个Activity时，Activity关闭/销毁顺序和正常顺序相反的问题
 *
 * @since 2.5.1
 */
object ActivityStack {
    /**
     * 应用是否运行在前台的监听器，注意：只关注Activity是否在前台可见.
     */
    @JvmStatic
    private lateinit var foregroundObserver: (Boolean) -> Unit

    @JvmStatic
    private var isForceClose: Boolean = false

    /**
     * 已创建，但是没销毁的Activity map.
     *
     * 注意：
     * 1. android12变更：关闭最后一个Activity后，默认不会调用onDestroy()
     * 2. 不停的按返回很快关闭多个Activity时，它们结束的顺序正好反了，最先打开的Activity走了onStop，但是
     * 没走onDestroy, 后面的Activity是从前往后依次销毁的
     *
     * Boolean: Activity是不是on stopped
     */
    @JvmStatic
    val activityMap by lazy {
        LinkedHashMap<Activity, Boolean>()
    }

    @JvmStatic
    private val callback by lazy {
        object: Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
            }

            override fun onActivityStarted(activity: Activity) {
                if (activityMap.isEmpty() && !activityMap.contains(activity)) {
                    activityMap.put(activity, false)
                    foregroundObserver.invoke(true)
                }
            }

            override fun onActivityDestroyed(activity: Activity) {
                activityMap.remove(activity)
                if (activityMap.isEmpty()) {
                    foregroundObserver.invoke(isForeground())
                } else if (activityMap.size == 1) {
                    /**
                     * @see activityMap
                     */
                    val value = activityMap.get(activityMap.keys.first())
                    if (value != null && value == true) {
                        activityMap.clear()
                    }
                    foregroundObserver.invoke(isForeground())
                }

                if (activityMap.isEmpty() && isForceClose) {
                    isForceClose = false
                    killApp()
                }
            }

            override fun onActivityStopped(activity: Activity) {
                activityMap.put(activity, true)
                if (activityMap.size == 1) {
                    activityMap.remove(activity)
                    foregroundObserver.invoke(isForeground())
                }
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activityMap.put(activity, false)
                if (activityMap.size == 1) {
                    foregroundObserver.invoke(true)
                }
            }
        }
    }

    /**
     * 注册Activity Lifecycle callback.
     * @param observer 是否在前台的监听器，注意：只判断Activity是不是前台可见的.
     */
    @JvmStatic
    fun registerCallback(app: Application, observer: (Boolean) -> Unit = { isForeground -> }) {
        this.foregroundObserver = observer
        app.registerActivityLifecycleCallbacks(callback)
    }

    /**
     * 取消注册Activity Lifecycle callback.
     */
    @JvmStatic
    fun unregisterCallback(app: Application) {
        activityMap.clear()
        app.unregisterActivityLifecycleCallbacks(callback)
    }

    /**
     * 返回已启动的Activity数量.
     */
    @JvmStatic
    fun getRunningActivityCount(): Int {
        return activityMap.size
    }

    /**
     * 判断Activity是否在前台
     */
    @JvmStatic
    fun isForeground(): Boolean {
        return activityMap.isNotEmpty()
    }

    /**
     * 获取当前Activity.
     */
    @JvmStatic
    fun getCurrentActivity(): Activity? {
        if (activityMap.isEmpty()) {
            return null
        }

        return activityMap.keys.last()
    }

    /**
     * 关闭[clazz] Activity.
     */
    @JvmStatic
    fun finish(clazz: Class<out Activity>) {
        activityMap.keys.reversed().forEach {
            if (it.javaClass == clazz) {
                it.finish()
                return
            }
        }
    }

    /**
     * 关闭类名为[name]的Activity.
     */
    @JvmStatic
    fun finishByName(name: String) {
        for (activity in activityMap.keys.reversed()) {
            if (activity.javaClass.name == name) {
                activity.finish()
            }
        }
    }

    /**
     * 关闭简单类名为[name]的Activity.
     */
    @JvmStatic
    fun finishBySimpleName(name: String) {
        for (activity in activityMap.keys.reversed()) {
            if (activity.javaClass.simpleName == name) {
                activity.finish()
            }
        }
    }

    /**
     * 关闭当前Activity.
     */
    @JvmStatic
    fun finishCurrent() {
        if (activityMap.size > 0) {
            activityMap.keys.last().finish()
        }
    }

    /**
     * 关闭所有Activity.
     */
    @JvmStatic
    fun finishAll() {
        activityMap.keys.reversed().forEach {
            it.finish()
        }
    }

    /**
     * 关闭除[clazz]外的所有Activity.
     */
    @JvmStatic
    fun finishAllExcept(clazz: Class<out Activity>) {
        activityMap.keys.reversed().forEach {
            if (it.javaClass.name != clazz.name) {
                it.finish()
            }
        }
    }

    /**
     * 关闭除类名为[name]外的所有Activity.
     */
    @JvmStatic
    fun finishAllExceptName(name: String) {
        activityMap.keys.reversed().forEach {
            if (it.javaClass.name != name) {
                it.finish()
            }
        }
    }

    /**
     * 关闭除简单类名为[name]外的所有Activity.
     * @see [Class.getSimpleName]
     */
    @JvmStatic
    fun finishAllExceptSimpleName(name: String) {
        activityMap.keys.reversed().forEach {
            if (it.javaClass.simpleName != name) {
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
        val intent = makeIntent(clazz, map)

        if (currentActivity == null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } else {
            currentActivity.startActivity(intent)
        }
    }


    @JvmStatic
    fun makeIntent(clazz: Class<out Activity>, map: Map<String, Serializable>?): Intent {
        val context = ContextProvider.getContext()
        val intent = Intent(context, clazz)
        map?.map {
            intent.putExtra(it.key, it.value)
        }
        return intent
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
     * @since 3.1.0 修复了死循环问题
     */
    @JvmStatic
    fun finishExceptTop() {
        if (activityMap.isNotEmpty()) {
            activityMap.keys.toList().subList(0, activityMap.size - 1).forEach {
                it.finish()
            }
        }
    }


    /**
     * 关闭所有页面后，终止进程。推荐使用这个方法终止进程.
     */
    @JvmStatic
    fun finishAllAndKillApp() {
        isForceClose = true
        finishAll()
    }

    /**
     * 强杀进程. 慎重使用：直接调用这个方法可能有app自动重新打开的问题.
     * @since 3.0.1
     */
    @JvmStatic
    fun killApp() {
        Process.killProcess(Process.myPid())
        exitProcess(0)
    }

    @JvmStatic
    fun contains(clazz: Class<out Activity>): Boolean {
        return activityMap.filter { it.key.javaClass.name == clazz.name }.isNotEmpty()
    }

    @JvmStatic
    fun contains(activityName: String): Boolean {
        return activityMap.filter { it.key.javaClass.name == activityName }.isNotEmpty()
    }
}
