package com.example.servicemp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import java.nio.channels.Channel

class MyService : Service() {
    lateinit var player: MediaPlayer
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this,
            Settings.System.DEFAULT_RINGTONE_URI);
        player.start();
        val CHANNELID = "Foreground Service ID"
        val channel = NotificationChannel(
            CHANNELID,
            "MyChannel",
            NotificationManager.IMPORTANCE_LOW
        )
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        val notification: Notification.Builder = Notification.Builder(this, CHANNELID)
            .setContentText("Service is running")
            .setContentTitle("Service enabled")
            .setSmallIcon(com.google.android.material.R.drawable.ic_mtrl_chip_checked_black)
            .setColor(Color.RED)
        startForeground(1001,notification.build())
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
}