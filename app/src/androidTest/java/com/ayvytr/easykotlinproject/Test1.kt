package com.ayvytr.easykotlinproject

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Do on 2017/9/20.
 */

@RunWith(AndroidJUnit4::class)
class Test1
{
    @Test
    fun test11()
    {
        onView(withId(R.id.all)).check(matches(withText("Hello, World!")))
    }
}
