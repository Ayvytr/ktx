package com.ayvytr.ktx.context

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * ClipboardManager 相关的Kotlin扩展方法，包含设置/获取剪贴板文本/Uri/Intent.
 * <p>
 *
 * @author ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */


fun ClipboardManager.setText2(text: CharSequence)
{
    primaryClip = ClipData.newPlainText(null, text)
}

fun ClipboardManager.getText2(context: Context): String
{
    if (primaryClip.itemCount > 0)
    {
        return primaryClip.getItemAt(0).coerceToText(context).toString()
    }

    return ""
}

fun ClipboardManager.setUri(context: Context, uri: Uri)
{
    primaryClip = ClipData.newUri(context.contentResolver, null, uri)
}

fun ClipboardManager.getUri(): Uri?
{
    if(primaryClip.itemCount > 0)
    {
        return primaryClip.getItemAt(0).uri
    }

    return null
}

fun ClipboardManager.setIntent(intent: Intent)
{
    primaryClip = ClipData.newIntent(null, intent)
}

fun ClipboardManager.getIntent(): Intent?
{
    if(primaryClip.itemCount > 0)
    {
        return primaryClip.getItemAt(0).intent
    }

    return null
}