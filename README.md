[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.ayvytr/ktx-androidx/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.ayvytr/ktx-androidx)

[![License](https://img.shields.io/badge/License-Apache--2.0%20-blue.svg)](license)

# Ktx：简化Android开发的Kotlin库

## 使用

3.0.6+：

mavenCentral()

```
//androidx
implementation 'io.github.ayvytr:ktx-androidx:3.1.3'


//注意：android最后一个版本是3.0.6
implementation 'io.github.ayvytr:ktx:3.0.6'
```



## 说明

3.0.6之后，将只更新androidx库



## ChangeLog

### 3.1.3

1. 修改Spanner

### 3.1.2

1. 修复style报错问题

### ~~3.1.1 不要使用，style报错~~

1. 增加了**BaseDialog**，**.setFullWidth()**解决了MIUI等某些定制系统手机的Dialog宽度很窄的问题

### 3.1.0

1. 修复了ActivityStack.finishExceptTop()死循环问题
2. ActivityStack新增了通过类名/类简单名关闭Activity的方法，便于跨模块关闭Activity：finishByName(), finishBySimpleName(), finishAllExceptName(), finishAllExceptSimpleName()
3. ActivityStack废弃了~~forceClose()~~，并新增了finishAllAndKillApp()来做替代

### 3.0.7

1. 只支持androidx
2. 修改[EditText.textChange](https://github.com/Ayvytr/ktx/blob/master/ktx-androidx/src/main/java/com/ayvytr/ktx/ui/EditText.kt).handler空指针问题
3. 增加DecimalDigitsInputFilter，支持小数位数筛选

### 3.0.6

1. 方法弃用和改名：

   | 文件名        | 原方法         | 新方法            |
   | ------------- | -------------- | ----------------- |
   | Clipboard     | getText2()     | getPalinText()    |
   | Clipboard     | setText2()     | setPalinText()    |
   | Res           | getDrawable2() | getDrawableCompat |
   | Res           | getColor2()    | getColorCompat    |
   | Context       | inflate()      | -                 |
   | Context       | inflateRv()    | -                 |
   | ActivityStack | killSelf()     | killApp()         |
   | EditText      | setText2       | selectText        |

2. 代码分类和优化（部分方法移动了文件，需要重新导包）



### *跳过3.0.1-3.0.5（失误：版本号改错了）*

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

//@since 3.1.0
finishByName()
finishBySimpleName()
finishAllExceptName()
finishAllExceptSimpleName()
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
    clibboardManager.setPlainText()
    clibboardManager.getPlainText()
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
    context.getDrawableCompat()
    context.getColorCompat()
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




    // 设置EditText文本，并且移动光标到文本末尾，第二个参数默认为false
    editText.selectText(text, false)
    // 设置EditText文本，并且全选文字
    editText.selectText(text, true)
