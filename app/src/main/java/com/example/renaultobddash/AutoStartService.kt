
package com.example.renaultobddash

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import kotlinx.coroutines.*

class AutoStartService: Service() {
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var obd: ObdManager? = null

    override fun onCreate() {
        super.onCreate()
        createChannel()
        startForeground(9001, NotificationCompat.Builder(this, "obd")
            .setContentTitle("Renault OBD Dash")
            .setContentText("Service running")
            .setSmallIcon(android.R.drawable.ic_menu_compass)
            .build())

        obd = ObdManager(this)
        // auto-connect would be performed here using stored last dongle address
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = getSystemService(NotificationManager::class.java)
            nm.createNotificationChannel(NotificationChannel("obd","OBD Service", NotificationManager.IMPORTANCE_LOW))
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
        obd?.close()
    }
}
