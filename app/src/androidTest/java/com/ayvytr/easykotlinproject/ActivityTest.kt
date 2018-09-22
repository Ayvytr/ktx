package com.ayvytr.easykotlinproject

import android.support.test.rule.ActivityTestRule
import android.support.v7.app.AppCompatActivity
import com.ayvytr.easykotlin.ui.fullscreen
import com.ayvytr.easykotlin.ui.hideActionBar
import com.ayvytr.easykotlin.ui.isFullscreen
import com.ayvytr.easykotlin.ui.showActionBar
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test

/**
 * Created by Do on 2017/10/16.
 */

class ActivityTest
{
    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testOrientation()
    {
        val activity = rule.activity
        activity.runOnUiThread {
            if (activity is AppCompatActivity)
            {
                activity.showActionBar()
                Assert.assertEquals(true, activity.supportActionBar?.isShowing)
                activity.hideActionBar()
                Assert.assertEquals(false, activity.supportActionBar?.isShowing)
            }
            else
            {
                activity.showActionBar()
                Assert.assertEquals(true, activity.actionBar?.isShowing)
                activity.hideActionBar()
                Assert.assertEquals(false, activity.actionBar?.isShowing)
            }

            activity.fullscreen(true)
            Assert.assertEquals(true, activity.isFullscreen())
            activity.fullscreen(false)
            Assert.assertEquals(false, activity.isFullscreen())
        }
    }
}
