package com.example.latihan_navigation_component.util

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.latihan_navigation_component.R

object Notifier {

    private const val channelId = "Default"

    fun init(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                activity.getSystemService(AppCompatActivity.NOTIFICATION_SERVICE) as NotificationManager
            val existingChannel = notificationManager.getNotificationChannel(channelId)
            if (existingChannel == null) {
                val name = "NavComponent default channel"
                val importance = NotificationManager.IMPORTANCE_DEFAULT
                val mChannel = NotificationChannel(channelId, name, importance)
                mChannel.description = "Notification from NavComponent"
                notificationManager.createNotificationChannel(mChannel)
            }
        }
    }

    fun postNotification(id: Int, context: Context, intent: PendingIntent) {
        val builder = NotificationCompat.Builder(context, channelId)
        builder.setContentTitle("Deep Link")
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
        val text = "Go to Home Fragment with deep link"
        val notification = builder.setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(intent)
            .setAutoCancel(true)
            .build()
        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.cancelAll()
        notificationManager.notify(id , notification)
    }
}