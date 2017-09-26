package com.ayvytr.easykotlinproject


import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.widget.TextView
import com.ayvytr.easykotlin.view.ex.*
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
    @get:Rule
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
            tv.show()
            assertEquals(tv.isVisible(), true)
            assertEquals(tv.isInvisible(), false)
            assertEquals(tv.isGone(), false)
            assertEquals(tv.isNotVisible(), false)
            assertEquals(tv.isNotInvisible(), true)
            assertEquals(tv.isNotGone(), true)
            tv.invisible()
            assertEquals(tv.isInvisible(), true)
            assertEquals(tv.isVisible(), false)
            assertEquals(tv.isGone(), false)
            assertEquals(tv.isNotVisible(), true)
            assertEquals(tv.isNotInvisible(), false)
            assertEquals(tv.isNotGone(), true)
            tv.hide()
            assertEquals(tv.isGone(), true)
            assertEquals(tv.isShow(), false)
            assertEquals(tv.isInvisible(), false)
            assertEquals(tv.isNotVisible(), true)
            assertEquals(tv.isNotInvisible(), true)
            assertEquals(tv.isNotGone(), false)
        }
    }
}