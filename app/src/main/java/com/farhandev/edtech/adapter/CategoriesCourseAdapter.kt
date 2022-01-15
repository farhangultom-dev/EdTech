package com.farhandev.edtech.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farhandev.edtech.databinding.ItemTypeCourseHorizontalBinding
import com.farhandev.edtech.model.CategoriesCourseModel

class CategoriesCourseAdapter(val listCategoriesCourses: ArrayList<CategoriesCourseModel>,
                              val listenerCategoriesCourse: OnAdapterListener)
    : RecyclerView.Adapter<CategoriesCourseAdapter.ViewHolder>(){

    fun setCategoriesCourse(categoriesCourses: List<CategoriesCourseModel>){
        listCategoriesCourses.clear()
        listCategoriesCourses.addAll(categoriesCourses)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesCourseAdapter.ViewHolder {
        val binding = ItemTypeCourseHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesCourseAdapter.ViewHolder, position: Int) {
        holder.bind(listCategoriesCourses[position])
    }

    override fun getItemCount(): Int = listCategoriesCourses.size

    inner class ViewHolder(val binding: ItemTypeCourseHorizontalBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(categoriesCourses: CategoriesCourseModel){
            with(binding){
                tvItem.text = categoriesCourses.categoriesName
                tvSubItem.text = "${ categoriesCourses.totalCourse.toString() } Course"

                Glide.with(itemView.context)
                    .load(categoriesCourses.icon)
                    .into(ivItem)
            }

            itemView.setOnClickListener {
                listenerCategoriesCourse.onClick(categoriesCourses)
            }
        }
    }

    interface OnAdapterListener{
        fun onClick(categoriesCourses: CategoriesCourseModel)
    }
}