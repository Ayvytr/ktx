[![Build Status](https://travis-ci.org/Ayvytr/ktx.svg?branch=master)](https://travis-ci.org/Ayvytr/ktx)

[![jCenter](https://img.shields.io/badge/jCenter-2.5.1-red.svg)](https://bintray.com/ayvytr/maven/ktx/_latestVersion)
[![License](https://img.shields.io/badge/License-Apache--2.0%20-blue.svg)](license)

Ktx：简化Android开发的Kotlin库

## JCenter

android

```
	implementation 'com.ayvytr:ktx:2.5.1'
```

androidx

```
    implementation 'com.ayvytr:ktx-androidx:2.5.1'
```



## ChangeLog

### 2.5.1

增加ActivityStack，可以实现打开和关闭指定Activity，关闭所有Activity，关闭除指定Activity外所有Activity，终止进程等功能.

### 2.5.0
增加Spanner工具类，为TextView提供简单易用的SpannableString

### 2.4.3
精简工具类
增加Fragment getStringArray等方法

### 2.4.1

1. BaseTextWatcher
2. ChineseFilter
3. EmailFilter
4. EmojiFilter
5. PasswordFilter



## 包含内容以及用法

### ActivityStack

```kotlin
registerCallback()
unregisterCallback()
getRunningActivityCount()
isForeground()
getCurrentActivity()
finish()
finishCurrent()
finishAll()
finishAllExcept()
start()
startAndFinishOthers()
forceClose()
```





### Clipboard.kt 剪贴板操作常用方法
    val clipboardManager = getClipboardManager()
    clibboardManager.getText2()
    clibboardManager.setText2()
    clibboardManager.getUri()
    clibboardManager.setUri()
    clibboardManager.getIntent()
    clibboardManager.setIntent()

### Context.kt 最少代码搞定加载布局，各种便利方法都有提供

    Context.getStatusBarHeight()
    
    Context.inflate(...)
    
    //RecyclerView 子 item加载的方法
    Context.inflateRv(...)

### Density.kt  dp,sp相互转化，在Context子类中调用最方便
    context.dp2px(...)
    context.px2dp(...)

### Managers.kt Android常用管理类一个方法直接获取，免去类型转换的累赘
    context.getAccountManager()
    ...

### Res.kt, Resources.kt:获取android字符串等资源，两个文件功能相近，都可使用

    context.getStringArray(...)
    //方法名称最后包含数字2的是和原生SDK中弃用的或者有版本限制的方法区分开来
    context.getDrawable2()
    context.getColor2()
    ...

### Screen.kt 获取屏幕尺寸，判断横竖屏，切换横竖屏等方法
    context.getDisplayMetrics()
    context.isLandscape()
    context.setLandscape()
    context.getScreenWidth()
    context.getScreenHeight()

### Toast.kt 最简单的toast使用扩展方法，共享一个Toast实例
    context.toast(...)
    context.toastLong(...)

### Activity.kt Activity扩展方法    
    activity.showActionBar
    activity.hideActionBar
    activity.getContext
    activity.fullscreen(boolean)
    ...

### Bitmap.kt   提供了Bitmap和Drawable相互转化的方法

### Colors      提供了近1000种颜色，可自由选用

### View.kt     View扩展方法
    view.show()
    view.hide()
    view.invisible()
    view.isShow()
    
    // 设置EditText文本，并且移动光标到文本末尾
    editText.setText2(...)
    
    // 设置EditText文本，并且全选文字
    editText.setTextWithSelection(...)
