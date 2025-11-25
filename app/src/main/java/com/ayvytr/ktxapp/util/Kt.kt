package com.ayvytr.ktxapp.util

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * @author Do
 */
inline fun <reified T: ViewBinding> Activity.viewBinding(): ReadOnlyProperty<Activity, T> {
    return object: ReadOnlyProperty<Activity, T> {
        private var binding: T? = null

        override fun getValue(thisRef: Activity, property: KProperty<*>): T {
            return binding ?: let {
                val inflateMethod = T::class.java.getMethod("inflate", LayoutInflater::class.java)
                val newBinding = inflateMethod.invoke(null, thisRef.layoutInflater) as T
                // 可在此处自动调用 setContentView (取决于具体库的实现思路)
                binding = newBinding
                newBinding
            }
        }
    }
}

inline fun <reified T : ViewBinding> Fragment.viewBinding(): ReadOnlyProperty<Fragment, T> {
    return object : ReadOnlyProperty<Fragment, T> {
        private var binding: T? = null

        override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
            return binding ?: let {
                // 方式1：使用 bind 方法 (适用于通过布局资源ID构造Fragment的情况)
//                val bindMethod = T::class.java.getMethod("bind", View::class.java)
//                val newBinding = bindMethod.invoke(null, thisRef.requireView()) as T

                // 方式2：使用 inflate 方法 (更通用)
                 val inflateMethod = T::class.java.getMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java)
                 val newBinding = inflateMethod.invoke(null, thisRef.layoutInflater, null, false) as T

                // 监听视图生命周期，在 onDestroyView 时清理 binding
                thisRef.viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    fun onDestroyView() {
                        binding = null
                    }
                })
                binding = newBinding
                newBinding
            }
        }
    }
}