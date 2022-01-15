package com.farhandev.edtech.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.farhandev.edtech.R
import com.farhandev.edtech.adapter.VideoCourseAdapter
import com.farhandev.edtech.databinding.ActivityDetailCourseBinding
import com.farhandev.edtech.model.VideoCourseModel

class DetailCourseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailCourseBinding
    private lateinit var videoAdapter: VideoCourseAdapter
    private var listVideo:ArrayList<VideoCourseModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoAdapter = VideoCourseAdapter(arrayListOf(), object : VideoCourseAdapter.OnAdapterListener{
            override fun onClick(videoCourse: VideoCourseModel) {

            }

        })

        initDataVideo()

        with(binding){
            rvListVideo.adapter = videoAdapter
            rvListVideo.setHasFixedSize(true)
        }
    }

    private fun initDataVideo() {
        listVideo = ArrayList()
        listVideo.add(
            VideoCourseModel(1,"1","Visual Design Intro",
        "03:00","http://google.com")
        )
        listVideo.add(VideoCourseModel(2,"2","Introduction Tools",
            "13:00","http://google.com"))
        listVideo.add(VideoCourseModel(3,"3","Figma",
            "05:00","http://google.com"))

        videoAdapter.setVideoCourse(listVideo)
    }
}