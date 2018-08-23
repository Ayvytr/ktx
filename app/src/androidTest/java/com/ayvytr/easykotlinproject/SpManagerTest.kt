package com.ayvytr.easykotlinproject

import android.support.test.rule.ActivityTestRule
import com.ayvytr.easykotlin.android.sp.SpManager
import junit.framework.Assert
import org.junit.Rule
import org.junit.Test

/**
 * Created by Do on 2017/10/16.
 */
class SpManagerTest
{
    @get:Rule
    var rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testEasyAndSpManager()
    {
        val sp = SpManager.getDefault(rule.activity).getSp("aa")
        Assert.assertNotNull(sp)

        sp.putString("key", "value")
        val string = sp.getString("key")
        Assert.assertEquals("value", string)

        val sp1 = SpManager.getDefault(rule.activity).sp
        sp1.putInt("int", 111)
        val i = sp1.getInt("int")
        Assert.assertEquals(i, 111)

    }

}