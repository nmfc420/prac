package com.example.practical_2c

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var color: Int=Color.BLACK
        var rqd=findViewById<RadioGroup>(R.id.radioGroup)
        var btn=findViewById<Button>(R.id.btn)
        var txt=findViewById<TextView>(R.id.textView)
        rqd.setOnCheckedChangeListener{ group, checkedId ->
            color = when(checkedId){
                R.id.rb1 -> Color.RED
                R.id.rb2 -> Color.GREEN
                R.id.rb3 -> Color.BLUE
                else -> Color.BLACK
            }
        }
        btn.setOnClickListener {
            txt.setTextColor(color)
        }
    }
}