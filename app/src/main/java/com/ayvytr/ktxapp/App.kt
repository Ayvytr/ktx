package com.ayvytr.ktxapp

import android.app.Application
import android.content.res.Configuration
import com.ayvytr.ktx.app.ActivityStack
import com.tencent.bugly.crashreport.CrashReport

/**
 * @author EDZ
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        L.e("app", isNightMode())

        CrashReport.initCrashReport(getApplicationContext(), "844a494050", true);

        ActivityStack.registerCallback(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }
}