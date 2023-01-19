package com.ayvytr.ktxapp

import android.app.Application
import android.content.res.Configuration
import com.ayvytr.ktx.app.ActivityStack
import com.ayvytr.logger.L
import com.tencent.bugly.crashreport.CrashReport

/**
 * @author EDZ
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        L.e("app", isNightMode())

        CrashReport.initCrashReport(getApplicationContext(), "844a494050", true);

        ActivityStack.registerCallback(this, { isForeground->
            L.e(isForeground)
        })
    }

}