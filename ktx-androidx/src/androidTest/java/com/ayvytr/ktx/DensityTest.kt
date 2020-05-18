package com.ayvytr.ktx

import androidx.test.runner.AndroidJUnit4
import com.ayvytr.ktx.context.*
import com.ayvytr.ktx.provider.ContextProvider
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Administrator
 */
@RunWith(AndroidJUnit4::class)
class DensityTest {
    @Test
    fun test() {
        val context = ContextProvider.getContext()
        val i = 10
        val f = 50.5f

        println("densityutil: dp2px:${DensityUtil.dip2px(context, i.toFloat())}")
        println("me: dp=${i.dp} dp2px=${i.dp2px}")
        Assert.assertEquals(DensityUtil.dip2px(context, i.toFloat()), i.dp)
        Assert.assertEquals(DensityUtil.dip2px(context, i.toFloat()), i.dp2px)

        Assert.assertEquals(DensityUtil.sp2px(context, i.toFloat()), i.sp)
        Assert.assertEquals(DensityUtil.sp2px(context, i.toFloat()), i.sp2px)

        Assert.assertEquals(DensityUtil.dip2px(context, f), f.dp)
        Assert.assertEquals(DensityUtil.dip2px(context, f), f.dp2px)

        Assert.assertEquals(DensityUtil.sp2px(context, f), f.sp)
        Assert.assertEquals(DensityUtil.sp2px(context, f), f.sp2px)

        val px = 1000
        val pxf = 855.8f

        Assert.assertEquals(DensityUtil.px2dip(context, px.toFloat()), px.px2dp)
        Assert.assertEquals(DensityUtil.px2sp(context, px.toFloat()), px.px2sp)
        Assert.assertEquals(DensityUtil.px2dip(context, pxf), pxf.px2dp)
        Assert.assertEquals(DensityUtil.px2sp(context, pxf), pxf.px2sp)
    }
}