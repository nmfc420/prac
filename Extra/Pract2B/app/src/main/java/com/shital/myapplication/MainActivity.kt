package com.shital.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var color: Int=Color.BLACK
        var rgd=findViewById<RadioGroup>(R.id.radioGroup)
        var btn=findViewById<Button>(R.id.btn)
        var txt=findViewById<TextView>(R.id.textView)
        rgd.setOnCheckedChangeListener { group, checkedId ->
            color = when(checkedId){
                R.id.rb1 -> Color.RED
                R.id.rb2-> Color.GREEN
                R.id.rb3-> Color.BLUE
                else -> Color.BLACK
            }
        }
        //on button click
        btn.setOnClickListener{
            txt.setTextColor(color)
        }
    }
}