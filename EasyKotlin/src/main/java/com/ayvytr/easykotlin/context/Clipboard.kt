package com.ayvytr.easykotlin.context

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Created by Do on 2017/10/12.
 */

val PLAIN_TEXT_LABEL = "PLAIN_TEXT_LABEL"
val URI_LABEL = "URI_LABEL"
val INTENT_LABEL = "INTENT_LABEL"

fun ClipboardManager.setText(text: CharSequence)
{
    primaryClip = ClipData.newPlainText(PLAIN_TEXT_LABEL, text)
}

fun ClipboardManager.getText(context: Context): String
{
    if (primaryClip.itemCount > 0)
    {
        return primaryClip.getItemAt(0).coerceToText(context).toString()
    }

    return ""
}

fun ClipboardManager.setUri(context: Context, uri: Uri)
{
    primaryClip = ClipData.newUri(context.contentResolver, URI_LABEL, uri)
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
    primaryClip = ClipData.newIntent(INTENT_LABEL, intent)
}

fun ClipboardManager.getIntent(): Intent?
{
    if(primaryClip.itemCount > 0)
    {
        return primaryClip.getItemAt(0).intent
    }

    return null
}