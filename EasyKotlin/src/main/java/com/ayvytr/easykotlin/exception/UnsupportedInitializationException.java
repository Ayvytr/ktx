package com.ayvytr.easykotlin.exception;

/**
 * 不支持构造函数初始化操作异常类, 在不需要创建类实例的类的私有无参构造中使用.
 *
 * @author Ayvytr <a href="https://github.com/Ayvytr" target="_blank">'s GitHub</a>
 * @since 1.0.0
 */

public class UnsupportedInitializationException extends RuntimeException
{
    public UnsupportedInitializationException()
    {
        super(UnsupportedInitializationException.class.getSimpleName() +
                ".You can't initialize this class. 你不能初始化这个类");
    }
}
