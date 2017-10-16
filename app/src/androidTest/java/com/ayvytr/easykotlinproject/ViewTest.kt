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
class ViewTest
{
    @get:Rule
    var rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testView()
    {
        val tv:TextView = rule.activity.findViewById(R.id.tv)
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

    @Test
    fun testContext()
    {
        var context = rule.activity
        context.getString(R.string.abc_action_bar_home_description)
        context.getColor(R.color.abc_background_cache_hint_selector_material_dark)
    }
}