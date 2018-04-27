package com.ayvytr.easykotlin.log

class LogSetting
{
    var tag = "PrettyLogger"

    var hasLog: Boolean = true
    var justShowMsg: Boolean = false
    var isShowCalledInfo: Boolean = true
    var isShowBottomLogBorder: Boolean = false
    var isShowThreadInfo: Boolean = true
    var methodOffset: Int = 2

    var methodCount: Int = 2
}