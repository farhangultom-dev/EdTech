package com.farhandev.edtech.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farhandev.edtech.databinding.ItemPopularCourseBinding
import com.farhandev.edtech.databinding.ItemVideosCourseBinding
import com.farhandev.edtech.model.PopularCourseModel
import com.farhandev.edtech.model.VideoCourseModel

class VideoCourseAdapter(val listVideoCourse: ArrayList<VideoCourseModel>,
                         val listenerVideoCourse: OnAdapterListener)
    : RecyclerView.Adapter<VideoCourseAdapter.ViewHolder>(){

    fun setVideoCourse(videoCourse: List<VideoCourseModel>){
        listVideoCourse.clear()
        listVideoCourse.addAll(videoCourse)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VideoCourseAdapter.ViewHolder {
        val binding = ItemVideosCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoCourseAdapter.ViewHolder, position: Int) {
        holder.bind(listVideoCourse[position])
    }

    override fun getItemCount(): Int = listVideoCourse.size

    inner class ViewHolder(val binding: ItemVideosCourseBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(videoCourse: VideoCourseModel){
            with(binding){
                tvVideoNumber.text = videoCourse.numberVideo
                tvVideoTime.text = videoCourse.timeVideo
                tvVideoTitle.text = videoCourse.titleVideo
            }

            itemView.setOnClickListener {
                listenerVideoCourse.onClick(videoCourse)
            }
        }
    }

    interface OnAdapterListener{
        fun onClick(videoCourse: VideoCourseModel)
    }
}