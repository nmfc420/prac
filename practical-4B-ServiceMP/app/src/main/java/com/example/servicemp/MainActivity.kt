package com.example.servicemp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var start:Button= findViewById(R.id.button)
        var stop: Button = findViewById(R.id.button2)
        start.setOnClickListener {
            startService(Intent(this, MyService::class.java))
            Toast.makeText(this, "Service Started",Toast.LENGTH_LONG).show()
        }
        stop.setOnClickListener {
            stopService(Intent(baseContext, MyService::class.java))
            Toast.makeText(this, "Service stopped", Toast.LENGTH_LONG).show()
        }
    }
}