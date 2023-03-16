package com.example.practical_6a_menu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId","RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var b1:Button = findViewById(R.id.share)
        b1.setOnClickListener{
            val p = PopupMenu(this, it)
            val inflater = menuInflater
            inflater.inflate(R.menu.popupmenudemo, p.menu)
            p.show()
            p.setOnMenuItemClickListener {
                Toast.makeText(this, it.title, Toast.LENGTH_SHORT).show()
                true
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.optionmenudemo,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var data = item.title
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }
}