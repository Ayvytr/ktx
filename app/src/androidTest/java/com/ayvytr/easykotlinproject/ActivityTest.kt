package com.ayvytr.easykotlinproject


import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.widget.TextView
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Do on 2017/9/20.
 */

@RunWith(AndroidJUnit4::class)
class ActivityTest
{
    @Rule
    var rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testView()
    {

    }

    @Test
    fun test1()
    {
        val tv = rule.activity.findViewById(R.id.tv) as TextView
        rule.activity.runOnUiThread {
            tv.visibility = View.VISIBLE
            assertEquals(tv.visibility, View.VISIBLE)
            tv.visibility = View.INVISIBLE
            assertEquals(tv.visibility, View.INVISIBLE)
            tv.visibility = View.GONE
            assertEquals(tv.visibility, View.GONE)
        }
    }
}