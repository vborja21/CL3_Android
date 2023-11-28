package com.example.examenfinal

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class video : AppCompatActivity() {

    lateinit var video: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        video = findViewById(R.id.videos)
        val url = intent.getStringExtra("Url")
        if (!url.isNullOrEmpty()){
            var uri : Uri = Uri.parse(url)
            video.setVideoURI(uri)
            val mC = MediaController(this)
            video.setMediaController(mC)
            video.setOnErrorListener { mp, what, extra ->
                Toast.makeText(this, "Error, video no cargado", Toast.LENGTH_SHORT).show()
                false
            }
        } else {
            Toast.makeText(this, "URL no validado", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}