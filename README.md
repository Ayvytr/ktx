[![Build Status](https://travis-ci.org/Ayvytr/ktx.svg?branch=master)](https://travis-ci.org/Ayvytr/ktx)

[![jCenter](https://img.shields.io/badge/jCenter-3.0.0-red.svg)](https://bintray.com/ayvytr/maven/ktx/_latestVersion)
[![License](https://img.shields.io/badge/License-Apache--2.0%20-blue.svg)](license)

Ktx：简化Android开发的Kotlin库

## JCenter

android

```
implementation 'com.ayvytr:ktx:3.0.0'
```

androidx

```
implementation 'com.ayvytr:ktx-androidx:3.0.0'
```



## ChangeLog

### 3.0.0

1. 增加View.onClick扩展方法：防止重复点击，或者响应多次点击事件
2. 增加EditText.textChange扩展方法，afterTextChange后间隔一段时间后执行action，可设置text为空时是否触发action，延迟搜索的场景特别有用。相当于RxBinding中TextView.textChanges()
3. 增加ActivityStack.finishExceptTop()
4. 增加Context.getConnectivityManager，network判断网络是否连接等方法
5. 其他代码优化，注释修改

### 2.5.4

1. 修改InputMethodManager以application context获取实例
2. 增加Fragment和Activity setActivityTitle() 以解决直接调用Activity.setTitle()无效的问题（比如使用了Navigation时)

### 2.5.3
修改dp，sp，px转换功能，摆脱依赖Context调用，提供Int，Float扩展属性进行dp，sp，px转换，且统一返回Int类型的扩展属性：.dp, .sp, .dp2px, sp2px, px2dp, px2sp

### 2.5.1

增加ActivityStack，可以实现打开和关闭指定Activity，关闭所有Activity，关闭除指定Activity外所有Activity，终止进程等功能.

### 2.5.0
增加Spanner工具类，为TextView提供简单易用的SpannableString相关操作

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

### View最新新增方法

```kotlin
//点击监听：默认是单击事件，防止重复点击时长间隔：millisecondInterval，默认500ms。可修改doActionAfterTimes的值响应多击事件
view.onClick(doActionAfterTimes=1, millisecondInterval=500){
	//点击action
}

//文本变化监听：延迟timeout毫秒触发action，默认timeout=300ms，默认ignoreEmpty=true，空字符串不触发action
editText.textChange(timeout=300, ignoreEmpty = true){
	//搜索action
}
```





### network.kt

```kotlin
getConnectivityManager
isNetworkConnected
isWifiConnected
isMobileDataConnected
```



### dp.kt Float，Int的dp，sp相关扩展方法

```kotlin
Int.dp
Int.sp
Float.dp
Float.sp
Int.dp2px
Float.dp2px
Int.sp2px
Float.sp2px
Int.px2dp
Float.px2dp
Int.px2sp
Float.px2sp

```



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
finishExceptTop()
forceClose()
```

### Spanner SpannableString操作工具类

```kotlin
bold
italic
normal
boldItalic
font
strikethrough
underline
backgroundColor
backgroundColorRes
textColorRes
textColor
pressedBackgroundColor
pressedBackgroundRes
onClick
onLongClick
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

### Managers.kt Android常用管理类一个方法直接获取，免去类型转换的累赘
    context.getAccountManager()
    context.getInputMethodManager()
    context.getConnectivityManager
    ...

### Res.kt 获取android字符串，drawable等资源

    context.getStringArray()
    //方法名称最后包含数字2的是和原生SDK中弃用的或者有版本限制的方法区分开来
    context.getDrawable2()
    context.getColor2()
    context.getDrawableArray()
    context.getDrawableIdArray()
    ...

### Screen.kt 获取屏幕尺寸，判断横竖屏，切换横竖屏等方法
    context.getDisplayMetrics()
    context.isLandscape()
    context.setLandscape()
    context.getScreenWidth()
    context.getScreenHeight()

### Toast.kt 最简单的toast使用扩展方法，内部共享一个Toast实例
    context.toast(...)
    context.toastLong(...)

### Activity.kt Activity扩展方法    
    activity.showActionBar
    activity.hideActionBar
    activity.getContext
    activity.fullscreen(boolean)
    ...

### Bitmap.kt  提供了Bitmap和Drawable相互转化的方法

### View.kt     View扩展方法
    view.show()
    view.hide()
    view.invisible()
    view.isShow()
    
    
    // 设置EditText文本，并且移动光标到文本末尾
    editText.setText2(...)
    
    // 设置EditText文本，并且全选文字
    editText.setTextWithSelection(...)
