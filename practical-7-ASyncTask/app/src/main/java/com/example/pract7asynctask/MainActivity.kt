package com.example.pract7asynctask

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.app.DownloadManager.Request.NETWORK_MOBILE
import android.app.DownloadManager.Request.NETWORK_WIFI
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.StrictMode
import android.widget.*

lateinit var url:String
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var et:EditText=findViewById(R.id.edittxt)
        var vi:VideoView=findViewById(R.id.vv)
        var but: Button =findViewById(R.id.button)

        val policy= StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        but.setOnClickListener{
            url=et.text.toString()
            Thread{
                var manager=getSystemService(DOWNLOAD_SERVICE) as DownloadManager
                val uri= Uri.parse(url)
                val request=DownloadManager.Request(uri)
                request.setDescription("Selected Video is being download")
                request.setTitle("downloading")
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION)
                request.setAllowedNetworkTypes(NETWORK_WIFI+NETWORK_MOBILE)
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS.toString(),"abc"+".mp4")
                manager.enqueue(request)

                runOnUiThread{
                    Toast.makeText(this,"Started", Toast.LENGTH_SHORT).show()
                    val uri:Uri=Uri.parse(url)
                    vi.setVideoURI(uri)
                    val mediaController= MediaController(this)
                    mediaController.setAnchorView(vi);
                    mediaController.setMediaPlayer(vi);
                    vi.setMediaController(mediaController);
                    vi.start()
                }
            }.start()

        }
    }
}