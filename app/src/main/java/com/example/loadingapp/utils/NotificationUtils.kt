package com.example.loadingapp.utils


import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.example.loadingapp.DetailActivity
import com.example.loadingapp.R

// Notification ID.
private val NOTIFICATION_ID = 0
private val REQUEST_CODE = 0
private val FLAGS = 0


/**
 * Builds and delivers the notification.
 *
 * @param context, activity context.
 */
fun NotificationManager.sendNotification(messageBody: String, applicationContext: Context) {
    // Create the content intent for the notification, which launches this activity
   // val contentIntent = Intent(applicationContext, DetailActivity::class.java)

    // Create PendingIntent
    /*val contentPendingIntent = PendingIntent.getActivity(
        applicationContext,
        NOTIFICATION_ID,
        contentIntent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )
*/

    // Build the notification, get an instance of NotificationCompat.Builder
    val builder = NotificationCompat.Builder(
        applicationContext,
        applicationContext.getString(R.string.load_notification_channel_id)
    )
        // Set title, text to builder
        .setContentTitle(applicationContext
            .getString(R.string.notification_title))
        .setContentText(messageBody)

        .setSmallIcon(R.drawable.ic_launcher_background)
        // Set content intent
       // .setContentIntent(contentPendingIntent)
        //.setAutoCancel(true)

        // Set priority
        //.setPriority(NotificationCompat.PRIORITY_HIGH)

    // Call notify
    notify(NOTIFICATION_ID, builder.build())
}


/**
 * Cancels all notifications.
 */
fun NotificationManager.cancelNotifications() {
    cancelAll()
}
