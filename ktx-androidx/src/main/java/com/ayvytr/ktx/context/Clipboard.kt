package com.ayvytr.ktx.context

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.net.Uri
import com.ayvytr.ktx.provider.ContextProvider

/**
 * ClipboardManager 相关的Kotlin扩展方法，包含设置/获取剪贴板文本/Uri/Intent.
 * <p>
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 1.0.0
 */

const val PLAIN_TEXT_LABEL = "PLAIN_TEXT_LABEL"
const val URI_LABEL = "URI_LABEL"
const val INTENT_LABEL = "INTENT_LABEL"

/**
 * @since 3.0.1
 */
fun ClipboardManager.setPlainText(text: CharSequence, label: CharSequence = PLAIN_TEXT_LABEL) {
    setPrimaryClip(ClipData.newPlainText(label, text))
}

/**
 * @since 3.0.1
 */
fun ClipboardManager.getPlainText(): String? {
    primaryClip?.apply {
        if (itemCount > 0) {
            getItemAt(0).coerceToText(ContextProvider.getContext()).toString()
        }
    }
    return null
}

fun ClipboardManager.setUri(uri: Uri, label: CharSequence = URI_LABEL) {
    setPrimaryClip(ClipData.newUri(ContextProvider.getContext().contentResolver, label, uri))
}

fun ClipboardManager.getUri(): Uri? {
    primaryClip?.apply {
        if(itemCount > 0) {
            return getItemAt(0).uri
        }
    }

    return null
}

fun ClipboardManager.setIntent(intent: Intent, label: CharSequence = INTENT_LABEL) {
    setPrimaryClip(ClipData.newIntent(label, intent))
}

fun ClipboardManager.getIntent(): Intent? {
    primaryClip?.apply {
        if (itemCount > 0) {
            return getItemAt(0).intent
        }
    }

    return null
}