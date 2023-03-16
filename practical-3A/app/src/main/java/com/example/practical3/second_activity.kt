package com.example.practical3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton

class second_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var myurl=findViewById<EditText>(R.id.url)
        var btnshow=findViewById<ImageButton>(R.id.btnshow)

        btnshow.setOnClickListener{
            var myurl1=myurl.text.toString()
            intent= Intent(Intent.ACTION_VIEW, Uri.parse(myurl1))
            startActivity(intent)
        }
    }
}