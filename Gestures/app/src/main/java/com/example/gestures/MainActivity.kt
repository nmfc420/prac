package com.example.gestures

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.Math.abs

class MainActivity : AppCompatActivity(),GestureDetector.OnGestureListener {
    lateinit var gest:GestureDetector
    var x1=0.0f
    var x2=0.0f
    var y1=0.0f
    var y2=0.0f
    val MIN_DIST=150
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var layout = findViewById<ConstraintLayout>(R.id.cl)
        var btn: Button = findViewById(R.id.one)
        var tv = findViewById<TextView>(R.id.tv)
        btn.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN)
                tv.setText("Action Down")
            if (motionEvent.action == MotionEvent.ACTION_UP)
                tv.setText("Action UP")
            if (motionEvent.action == MotionEvent.ACTION_MOVE)
                tv.setText("Action Move")

            return@setOnTouchListener true
        }

        gest= GestureDetector(this,this)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gest.onTouchEvent(event)
        if(event?.action==0)
        {
            x1=event.x
            y1=event.y
        }
        if(event?.action==1)
        {
            x2=event.x
            y2=event.y
            val diffx=x2-x1
            val diffy=y2-y1

            if(abs(diffx)>MIN_DIST)
            {
                if(x2>x1)
                    Toast.makeText(this,"Right Swipe",Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this,"Left Swipe",Toast.LENGTH_LONG).show()

            }
            else if(abs(diffy)>MIN_DIST)
            {
                if(y2>y1)
                    Toast.makeText(this,"Bottom Swipe",Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(this,"Up Swipe",Toast.LENGTH_LONG).show()

            }
        }

        return super.onTouchEvent(event)
    }

    override fun onDown(p0: MotionEvent?): Boolean {
        // TODO("Not yet implemented")
        return false
    }

    override fun onShowPress(p0: MotionEvent?) {
        // TODO("Not yet implemented")
    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        Toast.makeText(this,"Sinle Tap", Toast.LENGTH_LONG).show()
        return true
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        // TODO("Not yet implemented")
        return false
    }

    override fun onLongPress(p0: MotionEvent?) {
        Toast.makeText(this,"On long press",Toast.LENGTH_LONG).show()
    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        return false
    }

}
