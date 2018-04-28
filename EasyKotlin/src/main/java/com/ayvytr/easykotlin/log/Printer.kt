package com.ayvytr.easykotlin.log

import android.os.SystemClock
import android.util.Log
import android.util.Log.*
import java.util.*


/**
 * Log处理和输出类.
 * <p>
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @version v1.1.0
 */
class Printer(private val settings: LogSettings)
{
    /**
     * Android's max limit for a log entry is ~4076 bytes,
     * so 4000 bytes is used as chunk size since default charset
     * is UTF-8
     */
    private val CHUNK_SIZE = 4000

    /**
     * Drawing toolbox
     */
    private val TOP_LEFT_CORNER = '╔'
    private val TOP_LEFT_CONNECT_CORNER = '╠'
    private val BOTTOM_LEFT_CORNER = '╚'
    private val MIDDLE_CORNER = '╟'
    private val HORIZONTAL_DOUBLE_LINE = '║'
    private val DOUBLE_DIVIDER = "════════════════════════════════════════════════════════"
    private val SINGLE_DIVIDER = "────────────────────────────────────────────────────────"
    private val TOP_BORDER = TOP_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER
    private val TOP_CONNECT_BORDER = TOP_LEFT_CONNECT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER
    private val BOTTOM_BORDER = BOTTOM_LEFT_CORNER + DOUBLE_DIVIDER + DOUBLE_DIVIDER
    private val MIDDLE_BORDER = MIDDLE_CORNER + SINGLE_DIVIDER + SINGLE_DIVIDER

    private val CONNECT_BORDER_INTERVAL = 10

    private var lastTimeMillis: Long = 0

    /**
     * 这里参数不写成可变参数是因为参数通过可变参数传递两次，丢失了类型
     *  可以尝试，int通过可变参数传递第二次时，使用 is int判断时，结果为false
     */
    fun v(args: Array<out Any?>?)
    {
        buildLog(Log.VERBOSE, args)
    }

    fun d(args: Array<out Any?>?)
    {
        buildLog(Log.DEBUG, args)
    }

    fun i(args: Array<out Any?>?)
    {
        buildLog(Log.INFO, args)
    }

    fun w(args: Array<out Any?>?)
    {
        buildLog(Log.WARN, args)
    }

    fun e(args: Array<out Any?>?)
    {
        buildLog(Log.ERROR, args)
    }

    fun wtf(args: Array<out Any?>?)
    {
        buildLog(Log.ASSERT, args)
    }

    @Synchronized
    private fun buildLog(level: Int, msg: Array<out Any?>?)
    {
        if (!settings.hasLog)
        {
            return
        }

        val message = buildMessage(msg)
        if (settings.justShowMsg)
        {
            logMessage(level, message)
        }
        else
        {
            logTopBorder(level)
            logMessage(level, message)
            logMethodInfo(level)
            logBottomBorder(level)
        }
    }

    private fun logMessage(priority: Int, message: String)
    {
        //get bytes of message with system's default charset (which is UTF-8 for Android)
        val bytes = message.toByteArray()
        val length = bytes.size
        if (length <= CHUNK_SIZE)
        {
            logContent(priority, message)
            return
        }

        var i = 0
        while (i < length)
        {
            val count = Math.min(length - i, CHUNK_SIZE)
            //create a new String with system's default charset (which is UTF-8 for Android)
            logContent(priority, String(bytes, i, count))
            i += CHUNK_SIZE
        }
    }

    private fun logTopBorder(level: Int)
    {
        performLog(level,
                   when
                   {
                       settings.isShowBottomBorder -> TOP_BORDER
                       needConnectBorder()         -> TOP_CONNECT_BORDER
                       else                        -> TOP_BORDER
                   })
    }

    private fun logMethodInfo(priority: Int)
    {
        if (settings.methodCount <= 0)
        {
            return
        }

        logDivider(priority)

        var spaces = ""
        val trace = Thread.currentThread().stackTrace
        val stackOffset = getStackOffset(trace) + 1
        for (i in settings.methodCount - 1 downTo 0)
        {
            val stackIndex = i + stackOffset
            if (stackIndex >= trace.size)
            {
                continue
            }

            val fileName = trace[stackIndex].fileName
            val builder = StringBuilder()
            builder.append("║ ")
                    .append(spaces)
                    .append(getSimpleClassName(trace[stackIndex].className))
                    .append(".")
                    .append(trace[stackIndex].methodName)
                    .append(" ")
                    .append(" (")
                    .append(fileName)
                    .append(":")
                    .append(trace[stackIndex].lineNumber)
                    .append(")")
            performLog(priority, builder.toString())
            spaces += "  "
        }
    }

    private fun getThreadInfo(): String
    {
        return if (settings.isShowThreadInfo && !settings.justShowMsg)
        {
            "[\"${Thread.currentThread().name}\" Thread]"
        }
        else
        {
            ""
        }
    }

    private fun logBottomBorder(logType: Int)
    {
        if (settings.isShowBottomBorder)
        {
            performLog(logType, BOTTOM_BORDER)
        }
    }

    private fun logDivider(logType: Int)
    {
        performLog(logType, MIDDLE_BORDER)
    }

    private fun logContent(logType: Int, chunk: String)
    {
        val lines = chunk.split(System.getProperty("line.separator").toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (line in lines)
        {
            performLog(logType, "${if (settings.justShowMsg) "" else HORIZONTAL_DOUBLE_LINE} $line")
        }
    }

    private fun needConnectBorder(): Boolean
    {
        val timeMillis = System.currentTimeMillis()
        val need = System.currentTimeMillis() - lastTimeMillis < CONNECT_BORDER_INTERVAL
        lastTimeMillis = timeMillis
        return need
    }

    /**
     * 最终的Log输出方法
     */
    @Synchronized
    private fun performLog(level: Int, msg: String)
    {
        val tag = settings.tag
        if (System.currentTimeMillis() - lastTimeMillis < 3)
        {
            SystemClock.sleep(3)
        }

        when (level)
        {
            VERBOSE -> Log.v(tag, msg)
            INFO    -> Log.i(tag, msg)
            DEBUG   -> Log.d(tag, msg)
            WARN    -> Log.w(tag, msg)
            ERROR   -> Log.e(tag, msg)
            ASSERT  -> Log.wtf(tag, msg)
            else    -> Log.d(tag, msg)
        }

        lastTimeMillis = System.currentTimeMillis()
    }

    @Synchronized
    private fun buildMessage(msg: Array<out Any?>?): String
    {
        val buffer = StringBuilder()
        buffer.append(getThreadInfo())
        buffer.append(getCalledMethodInfo())

        if (buffer.isNotEmpty())
        {
            buffer.append(" ")
        }

        if (msg == null)
        {
            return buffer.toString()
        }

        for (any in msg)
        {
            when
            {
                any == null           -> buffer.append("null")
            //如果是数组，需要通过专门的数组转字符串方法进行转换
                any.javaClass.isArray -> buffer.append(Arrays.toString(any as Array<*>))
                else                  -> buffer.append(any)
            }
            buffer.append(" ")
        }

        return buffer.toString()
    }

    private fun getCalledMethodInfo(): String
    {
        if (settings.justShowMsg || !settings.isShowCalledInfo)
        {
            return ""
        }

        val trace = Thread.currentThread().stackTrace
        val element = trace[getStackOffset(trace) + 1]
        return "[${getSimpleClassName(element.className)}.${element.methodName}()]"
    }

    private fun getSimpleClassName(name: String): String
    {
        val lastIndex = name.lastIndexOf(".")
        return name.substring(lastIndex + 1)
    }

    private fun getStackOffset(trace: Array<StackTraceElement>): Int
    {
        var i = 3
        while (i < trace.size)
        {
            val e = trace[i]
            val name = e.className
            if (name != Printer::class.java.name && name != L::class.java.name)
            {
                --i
                return i
            }
            ++i
        }

        return -1
    }
}