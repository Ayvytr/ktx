package com.ayvytr.easykotlinproject

import android.support.test.rule.ActivityTestRule
import com.ayvytr.easykotlin.context.getClipboardManager
import com.ayvytr.easykotlin.context.getText2
import com.ayvytr.easykotlin.context.setText2
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test

/**
 * Created by Do on 2017/10/16.
 */

class ClipboardTest
{
    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testClipboard()
    {
        val activity = rule.activity
        activity.runOnUiThread {
            val cm = activity.getClipboardManager()
            cm.setText2("clipboard text")
            Assert.assertEquals("clipboard text", cm.getText2(activity))
        }
    }
}
