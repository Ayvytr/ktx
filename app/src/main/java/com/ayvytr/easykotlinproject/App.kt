package com.ayvytr.easykotlinproject

import android.app.Application
import android.content.res.Configuration
import com.ayvytr.ktx.context.isNightMode
import com.ayvytr.logger.L

/**
 * @author EDZ
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        L.e("app", isNightMode())
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }
}