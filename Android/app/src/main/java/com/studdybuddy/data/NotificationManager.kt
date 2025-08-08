package com.studdybuddy.data

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.google.firebase.messaging.FirebaseMessaging

class AppNotificationManager(private val context: Context) {
    fun registerChannel(id: String, name: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT)
            val manager = context.getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    fun registerFcmToken(onToken: (String) -> Unit) {
        FirebaseMessaging.getInstance().token.addOnSuccessListener { onToken(it) }
    }
}
