package com.example.sqllite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var sname:EditText
    lateinit var spass: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var data: Button =findViewById(R.id.save)
        var show: Button =findViewById(R.id.show)
        var del:Button =findViewById(R.id.delete)
        var upade:Button =findViewById(R.id.update)
        var tv: TextView =findViewById(R.id.tv)

        sname =findViewById(R.id.name)
        spass =findViewById(R.id.password)

        val db =DBHelper(this)
        data.setOnClickListener {
            db.insertData(sname.text.toString(), spass.text.toString())
            Toast.makeText(this, " data added to database", Toast.LENGTH_LONG).show()
            sname.text.clear()
            spass.text.clear()
        }
        show.setOnClickListener {
            var data=db.readdata()
            tv.setText(data)
        }
        del.setOnClickListener {
            db.deletedata(4)
        }
        upade.setOnClickListener {
            db.update(sname.text.toString() ,spass.text.toString())
        }
    }
}