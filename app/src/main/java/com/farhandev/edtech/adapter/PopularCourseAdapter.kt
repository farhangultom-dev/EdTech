package com.farhandev.edtech.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farhandev.edtech.databinding.ItemPopularCourseBinding
import com.farhandev.edtech.model.PopularCourseModel

class PopularCourseAdapter(val listPopularCourse: ArrayList<PopularCourseModel>,
                           val listenerPopularCourse: OnAdapterListener)
    : RecyclerView.Adapter<PopularCourseAdapter.ViewHolder>(){

    fun setPopularCourse(popularCourse: List<PopularCourseModel>){
        listPopularCourse.clear()
        listPopularCourse.addAll(popularCourse)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularCourseAdapter.ViewHolder {
        val binding = ItemPopularCourseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularCourseAdapter.ViewHolder, position: Int) {
        holder.bind(listPopularCourse[position])
    }

    override fun getItemCount(): Int = listPopularCourse.size

    inner class ViewHolder(val binding: ItemPopularCourseBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(popularCourse: PopularCourseModel){
            with(binding){
                tvPrice.text = "Rp.${popularCourse.price.toString()}"
                tvTitle.text = popularCourse.titleCourse
                tvTotalReviews.text = "(${popularCourse.totalReviews})"
                ratingBar.rating = popularCourse.rating!!

                Glide.with(itemView.context)
                    .load(popularCourse.picCourse)
                    .into(ivItem)
            }

            itemView.setOnClickListener {
                listenerPopularCourse.onClick(popularCourse)
            }
        }
    }

    interface OnAdapterListener{
        fun onClick(popularCourse: PopularCourseModel)
    }
}