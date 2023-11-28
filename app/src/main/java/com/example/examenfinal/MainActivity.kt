package com.example.examenfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenfinal.Models.CustomerAdapterVideo
import com.example.examenfinal.Models.RetroFitHelper
import com.example.examenfinal.Models.videoA
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:CustomerAdapterVideo

    private fun openVideo(videoUrl: String) {
        val intent = Intent(this, video::class.java)
        intent.putExtra("Url", videoUrl)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.listadoVideo)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CustomerAdapterVideo(emptyList()){ videoUrl ->
            openVideo(videoUrl)
        }
        recyclerView.adapter = adapter
        val AVideo = RetroFitHelper.getRetroFitHelper().create(videoA::class.java);
        GlobalScope.launch {
            val response = AVideo.getVideo()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val categorias = body.categories
                    val videos = categorias.flatMap { it.videos}
                    runOnUiThread {
                        adapter.setData(videos)
                    }
                }
            }
        }

    }
}