package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

public class CustomReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val intentAction = intent.action
        var str = "Unknown Action Performed"
        when(intentAction){
            Intent.ACTION_POWER_CONNECTED -> str = "Power connected!"
            Intent.ACTION_POWER_DISCONNECTED -> str = "Power disconnected!"
        }
        Toast.makeText(context,str,Toast.LENGTH_SHORT).show()
    }
}