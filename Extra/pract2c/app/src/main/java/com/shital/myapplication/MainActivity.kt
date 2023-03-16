package com.shital.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var b1=findViewById<Button>(R.id.add);
        var b2=findViewById<Button>(R.id.subst);
        var b3=findViewById<Button>(R.id.mult);
        var b4=findViewById<Button>(R.id.div);
        var t1=findViewById<EditText>(R.id.num1);
        var t2=findViewById<EditText>(R.id.num2);
        var res=findViewById<TextView>(R.id.ans);
        b1.setOnClickListener {
            val n1 = t1.text.toString().toInt()
            val n2 = t2.text.toString().toInt()
          res.setText((n1 + n2).toString())
        }
        b2.setOnClickListener {
            val n1 = t1.text.toString().toInt()
            val n2 = t2.text.toString().toInt()
            res.setText((n1 - n2).toString())
        }
        b3.setOnClickListener {
            val n1 = t1.text.toString().toInt()
            val n2 = t2.text.toString().toInt()
            res.setText((n1 * n2).toString())
        }
        b4.setOnClickListener {
            val n1 = t1.text.toString().toInt()
            val n2 = t2.text.toString().toInt()
            res.setText((n1 / n2).toString())
        }

    }
}