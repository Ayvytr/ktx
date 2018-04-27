package com.ayvytr.easykotlin.log;

/**
 * @author wangdunwei
 * @date 2018/4/27
 */
public class Log
{
    private Log()
    {
        throw new IllegalStateException("No instance");
    }

    public static void v(Object... objects)
    {
        L.INSTANCE.v(objects);
    }

    public static void d(Object... objects)
    {
        L.INSTANCE.d(objects);
    }

    public static void i(Object... objects)
    {
        L.INSTANCE.i(objects);
    }

    public static void w(Object... objects)
    {
        L.INSTANCE.w(objects);
    }

    public static void e(Object... objects)
    {
        L.INSTANCE.e(objects);
    }

    public static void wtf(Object... objects)
    {
        L.INSTANCE.wtf(objects);
    }
}
