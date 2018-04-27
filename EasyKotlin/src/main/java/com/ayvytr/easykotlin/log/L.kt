package com.ayvytr.easykotlin.log

/**
 * @author wangdunwei
 * @date 2018/4/26
 */
object L
{
    val settings = LogSetting()
    val printer = Printer(settings)

    fun v(vararg args: Any?)
    {
        printer.v(args)
    }

    fun d(vararg args: Any?)
    {
        printer.d(args)
    }

    fun i(vararg args: Any?)
    {
        printer.i(args)
    }

    fun w(vararg args: Any?)
    {
        printer.w(args)
    }

    fun e(vararg args: Any?)
    {
        printer.e(args)
    }

    fun wtf(vararg args: Any?)
    {
        printer.wtf(args)
    }
}