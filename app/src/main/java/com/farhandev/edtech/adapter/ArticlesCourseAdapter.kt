package com.farhandev.edtech.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.farhandev.edtech.databinding.ItemArticlesBinding
import com.farhandev.edtech.databinding.ItemTypeCourseHorizontalBinding
import com.farhandev.edtech.model.ArticlesCourseModel
import com.farhandev.edtech.model.CategoriesCourseModel

class ArticlesCourseAdapter(val listArticles: ArrayList<ArticlesCourseModel>,
                            val listenerArticlesCourse: OnAdapterListener)
    : RecyclerView.Adapter<ArticlesCourseAdapter.ViewHolder>(){

    fun setArticlesCourse(articlesCourses: List<ArticlesCourseModel>){
        listArticles.clear()
        listArticles.addAll(articlesCourses)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticlesCourseAdapter.ViewHolder {
        val binding = ItemArticlesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticlesCourseAdapter.ViewHolder, position: Int) {
        holder.bind(listArticles[position])
    }

    override fun getItemCount(): Int = listArticles.size

    inner class ViewHolder(val binding: ItemArticlesBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(articles: ArticlesCourseModel){
            with(binding){
                tvTitle.text = articles.titleArticle
                tvCategory.text = articles.categoriesArticles

                Glide.with(itemView.context)
                    .load(articles.picsArticles)
                    .into(ivArticles)
            }

            itemView.setOnClickListener {
                listenerArticlesCourse.onClick(articles)
            }
        }
    }

    interface OnAdapterListener{
        fun onClick(article: ArticlesCourseModel)
    }
}