package com.shital.pract2a

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class  MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var res: String="Hobbies are:"
        val cb1: CheckBox = findViewById<CheckBox>(R.id.cb1)
        val cb2: CheckBox = findViewById<CheckBox>(R.id.cb2)
        val cb3: CheckBox = findViewById<CheckBox>(R.id.cb3)
        val btn1: Button = findViewById<Button>(R.id.btn1)
        val btn2: Button = findViewById<Button>(R.id.btn2)
        btn1.setOnClickListener {
            if(cb1.isChecked==true)
               res=res + (cb1.text).toString()
            if(cb2.isChecked==true)
                res=res + (cb2.text).toString()
            if(cb3.isChecked==true)
                res=res + (cb3.text).toString()
            Toast.makeText(this,res,Toast.LENGTH_LONG).show()
    }
        btn2.setOnClickListener{
            res="Hobbies are:"
            cb1.isChecked=false
            cb2.isChecked=false
            cb3.isChecked=false
        }

    }
}