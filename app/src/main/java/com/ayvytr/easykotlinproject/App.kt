package com.ayvytr.easykotlinproject

import android.app.Application
import android.content.res.Configuration
import com.ayvytr.ktx.app.ActivityStack

/**
 * @author EDZ
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        L.e("app", isNightMode())

        ActivityStack.registerCallback(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }
}