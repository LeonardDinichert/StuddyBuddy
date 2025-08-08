package com.studdybuddy.util

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

class TextManager(private val context: Context) {
    fun copy(text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("text", text))
    }
}
