package com.ayvytr.easykotlin.android.log

/**
 * Log设置类.
 * 这个设置类外部不可初始化.
 * <p>
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @version v1.1.0
 */
class LogSettings internal constructor()
{
    var tag = "PrettyLogger"

    //Log总开关，关闭后，所有Log都不显示
    var hasLog: Boolean = true
    //打开后，只显示你自己的Log，所有附加信息都不显示
    var justShowMsg: Boolean = false
    var isShowCalledInfo: Boolean = false
    var isShowThreadInfo: Boolean = false

    //是否显示Log底部横线
    var isShowBottomBorder: Boolean = false

    //默认显示方法数量，这个默认显示1条。方法显示时，log中会有方法，文件名等，并且有超链接快速定位到调用的位置
    var methodCount: Int = 1
}