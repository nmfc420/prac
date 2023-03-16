package com.example.musicplayer

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    private val PICK_AUDIO = 1
    var AudioUri: Uri? = null
    val audio = Intent()
    var f=0
    var pos:Int=0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playButton = findViewById<ImageButton>(R.id.play)
        val stopButton = findViewById<ImageButton>(R.id.stop)
        val pauseButton = findViewById<ImageButton>(R.id.pause)
        val iv1 = findViewById<ImageView>(R.id.imgv)
        stopButton.isEnabled = false
        pauseButton.isEnabled = false

        val  mp= registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == Activity.RESULT_OK){
                AudioUri = it.data?.data
                Toast.makeText(this,"Date Selected" + AudioUri, Toast.LENGTH_LONG).show()
            }
        }
        playButton.setOnClickListener {
            if (AudioUri==null)
                Toast.makeText(this, "Select Audio", Toast.LENGTH_SHORT).show()
            else if(f==0){
                mediaPlayer = MediaPlayer.create(this, AudioUri)
                mediaPlayer.start()
            }
            else if(f==1)
            {
                Toast.makeText(this, "Music Player Resumed", Toast.LENGTH_SHORT).show()
                mediaPlayer.seekTo(pos)
                mediaPlayer.start()
                f=0
            }
            playButton.isEnabled = false
            stopButton.isEnabled = true
            pauseButton.isEnabled = true
        }
        stopButton.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.prepare()
            playButton.isEnabled = true
            stopButton.isEnabled = false
            Toast.makeText(this, "Music Player Stopped", Toast.LENGTH_SHORT).show()
            f=0
        }
        pauseButton.setOnClickListener {
            mediaPlayer.pause()
            playButton.isEnabled = true
            stopButton.isEnabled = true
            pauseButton.isEnabled = false
            Toast.makeText(this, "Music Player Paused", Toast.LENGTH_SHORT).show()
            pos=mediaPlayer.currentPosition
            f=1
        }
        iv1.setOnClickListener{
            audio.type = "audio/*"
            audio.action = Intent.ACTION_OPEN_DOCUMENT
            audio.putExtra("Select audio",PICK_AUDIO)
            mp.launch(audio)
        }
    }
}