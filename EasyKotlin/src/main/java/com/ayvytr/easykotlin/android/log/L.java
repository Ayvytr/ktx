package com.ayvytr.easykotlin.android.log;

/**
 * EasyKotlin库的Log类，是整个Log模块的使用入口，Log输出在这里完成.
 * 这个类写成Java类而不写成Kotlin类的原因主要是使用Kotlin的object类或者使用静态方法编写，在Java代码中调用会多出额外代码，
 * 类似 L.Compain().v()，所以经过考虑还是写成Java类.如果有更好方法避免这个现象，可以联系我
 * 请注意，在这种情况下，如果Log的Tag未显示出来，请在GitHub上联系我.
 * 2018/04/28完成第一版编写和测试.
 * <p>
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @since 1.1.0
 * @date 2018/04/28
 */
public class L
{
    private static LogSettings settings;
    private static Printer printer;

    private L()
    {
        throw new IllegalStateException("No Instance.");
    }

    static
    {
        settings = new LogSettings();
        printer = new Printer(settings);
    }

    public static LogSettings getSettings()
    {
        return settings;
    }

    public static void v(Object... args)
    {
        printer.v(args);
    }

    public static void d(Object... args)
    {
        printer.d(args);
    }

    public static void i(Object... args)
    {
        printer.i(args);
    }

    public static void w(Object... args)
    {
        printer.w(args);
    }

    public static void e(Object... args)
    {
        printer.e(args);
    }

    public static void wtf(Object... args)
    {
        printer.wtf(args);
    }
}
