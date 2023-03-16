package com.example.practical6c_contextdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.graphics.toColorInt

class MainActivity : AppCompatActivity() {
    lateinit var cl:ConstraintLayout
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cl = findViewById(R.id.cl)
        val btn:Button=findViewById(R.id.btn)
        registerForContextMenu(btn)
    }
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menu.setHeaderTitle("Select Color")
        menu.add(0,v.id,0,"Red")
        menu.add(1,v.id,0,"Green")
        menu.add(1,v.id,0,"Black")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        var s1: Int = item.title.toString().toColorInt()
      cl.setBackgroundColor(s1)
        return true
    } }