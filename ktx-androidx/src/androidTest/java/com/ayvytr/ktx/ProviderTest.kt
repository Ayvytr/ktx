package com.ayvytr.ktx

import com.ayvytr.ktx.provider.ContextProvider
import org.junit.Assert.assertNotNull
import org.junit.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
//@RunWith(AndroidJUnit4::class)
class ProviderTest {
    @Test
    fun testContext() {
        assertNotNull(ContextProvider.getContext())
    }
}
