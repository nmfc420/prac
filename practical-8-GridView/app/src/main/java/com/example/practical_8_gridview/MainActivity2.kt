package com.example.practical_8_gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var imageview: ImageView
    lateinit var tetxview: TextView
    lateinit var animation1: Animation
    lateinit var animation2: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        imageview=findViewById(R.id.imageview)
        tetxview=findViewById(R.id.tvname)
        val intent=intent
        tetxview.setText(intent.getStringExtra("name"))
        imageview.setImageResource(intent.getIntExtra("image",0))
        animation1=AnimationUtils.loadAnimation(this,R.anim.blink)
        imageview.startAnimation(animation1)
        animation2= AnimationUtils.loadAnimation(this,R.anim.zoomin)
        tetxview.startAnimation(animation2)

    }
}