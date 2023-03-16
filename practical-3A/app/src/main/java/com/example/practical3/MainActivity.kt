package com.example.practical3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var next=findViewById<Button>(R.id.btnnext)
        next.setOnClickListener{
            var myintent= Intent(this,second_activity::class.java)
            startActivity(myintent)
        }
    }
}