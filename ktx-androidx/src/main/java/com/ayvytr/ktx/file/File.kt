package com.ayvytr.ktx.file

import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import com.ayvytr.ktx.provider.ContextProvider
import java.io.File

/**
 * File相关的Kotlin扩展方法
 * <p>
 *
 * @author Ayvytr ['s GitHub](https://github.com/Ayvytr)
 * @since 4.0.0
 */

var uriAuthority: String = ContextProvider.getContext().packageName + ".fileProvider"

/**
 * [File]转[Uri]，适配android7的 [FileProvider.getUriForFile].
 * 默认[authority]为[uriAuthority]，是packageName+".fileProvider"，如果和你声明的provider
 * 名称不一致，请直接传参更改，或者直接更改[uriAuthority].
 * @since 4.0.0
 */
fun File.toUriCompat(authority: String = uriAuthority): Uri {
    val fileUri =
        if (Build.VERSION.SDK_INT >= 24) {
            FileProvider.getUriForFile(ContextProvider.getContext(), authority, this)
        } else {
            Uri.fromFile(this)
        }
    return fileUri
}
