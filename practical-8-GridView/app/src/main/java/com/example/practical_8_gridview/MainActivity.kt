package com.example.practical_8_gridview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var gridview: GridView
    var str = arrayOf<String>("Android", "Java", "C++", "DS", "PYTHON")
    var images = arrayOf<Int>(
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img3,
        R.drawable.img4,
        R.drawable.img5
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gridview = findViewById(R.id.gridview)
        var ca = CustomAdapter(str, images, this)
        gridview.adapter = ca
        gridview.setOnItemClickListener { adapterView, view2, i, l ->
            var selectedname = str[i]
            var selectedimage = images[i]
            intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name", selectedname).putExtra("image", selectedimage)
            startActivity(intent)

        }
    }

    class CustomAdapter(
        var imageNames: Array<String>,
        var imagePhoto: Array<Int>,
        var context: Context
    ) : BaseAdapter() {
        var layoutInflater: LayoutInflater =
            context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater

        override fun getCount(): Int {
            return imagePhoto.size
        }

        override fun getItem(p0: Int): Any? {
            return null
        }

        override fun getItemId(p0: Int): Long {
            return 0
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var myview = p1
            // if(myview==null)
            // {
            myview = layoutInflater.inflate(R.layout.row_item, p2, false)
            // }
            var tvName: TextView = myview.findViewById(R.id.tvname)
            var imagev: ImageView = myview.findViewById(R.id.imageview)
            tvName.setText(imageNames[p0])
            imagev.setImageResource(imagePhoto[p0])
            return myview
        }
    }
}