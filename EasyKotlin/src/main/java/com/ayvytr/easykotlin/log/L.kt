
package com.ayvytr.easykotlin.log

/**
 * Log日志工具类.
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.1.0
 * @date 2018/04/28
 */
object L
{
    var settings: LogSettings = LogSettings()
        private set
    private var printer: Printer = Printer(settings)

    @JvmStatic
    fun v(vararg args: Any)
    {
        printer.v(args)
    }

    @JvmStatic
    fun d(vararg args: Any)
    {
        printer.d(args)
    }

    @JvmStatic
    fun i(vararg args: Any)
    {
        printer.i(args)
    }

    @JvmStatic
    fun w(vararg args: Any)
    {
        printer.w(args)
    }

    @JvmStatic
    fun e(vararg args: Any)
    {
        printer.e(args)
    }

    @JvmStatic
    fun wtf(vararg args: Any)
    {
        printer.wtf(args)
    }
}
