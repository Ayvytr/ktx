package com.ayvytr.easykotlinproject

import android.app.Activity
import android.app.Application
import android.content.res.Configuration
import android.os.Bundle
import com.ayvytr.ktx.app.ActivityStack
import com.ayvytr.ktx.context.isNightMode
import com.ayvytr.logger.L

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