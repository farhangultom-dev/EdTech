package com.farhandev.edtech.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.farhandev.edtech.R
import com.farhandev.edtech.adapter.ArticlesCourseAdapter
import com.farhandev.edtech.adapter.CategoriesCourseAdapter
import com.farhandev.edtech.adapter.PopularCourseAdapter
import com.farhandev.edtech.databinding.FragmentHomeBinding
import com.farhandev.edtech.model.ArticlesCourseModel
import com.farhandev.edtech.model.CategoriesCourseModel
import com.farhandev.edtech.model.PopularCourseModel
import com.farhandev.edtech.ui.detail.DetailCourseActivity

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var listItem: ArrayList<PopularCourseModel> = ArrayList()
    private var listItemCategories: ArrayList<CategoriesCourseModel> = ArrayList()
    private var listItemArticles: ArrayList<ArticlesCourseModel> = ArrayList()
    private lateinit var popularCourseAdapter: PopularCourseAdapter
    private lateinit var categoriesCourseAdapter: CategoriesCourseAdapter
    private lateinit var articlesCourseAdapter: ArticlesCourseAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularCourseAdapter = PopularCourseAdapter(arrayListOf(),object : PopularCourseAdapter.OnAdapterListener{
            override fun onClick(popularCourse: PopularCourseModel) {
                startActivity(Intent(requireActivity(), DetailCourseActivity::class.java)
                    .putExtra("itemCourse", popularCourse))
            }

        })

        categoriesCourseAdapter = CategoriesCourseAdapter(arrayListOf(), object : CategoriesCourseAdapter.OnAdapterListener{
            override fun onClick(categoriesCourses: CategoriesCourseModel) {

            }

        })

        articlesCourseAdapter = ArticlesCourseAdapter(arrayListOf(), object : ArticlesCourseAdapter.OnAdapterListener{
            override fun onClick(article: ArticlesCourseModel) {

            }

        })

        initDataPopular()
        initDataCategories()
        initDataArticles()

        with(binding){
            rvPopular.setHasFixedSize(true)
            rvPopular.adapter = popularCourseAdapter

            rvCategory.setHasFixedSize(true)
            rvCategory.adapter = categoriesCourseAdapter

            rvArticles.setHasFixedSize(true)
            rvArticles.adapter = articlesCourseAdapter
        }
    }

    private fun initDataArticles() {
        listItemArticles = ArrayList()
        listItemArticles.add(
            ArticlesCourseModel(1,"Tips Design Mobile App",
        "https://cdn.dribbble.com/users/1615584/screenshots/14282211/media/715273fd7f22b5834da83dac3fd2a346.jpg?compress=1&resize=400x300",
            "UI Design")
        )
        listItemArticles.add(
            ArticlesCourseModel(2,"viewBinding for beginner",
                "https://raw.githubusercontent.com/yogacp/android-viewbinding/master/assets/android_viewbinding_kotlin.png",
                "Programming")
        )
        listItemArticles.add(
            ArticlesCourseModel(3,"Don't use syntethic view!",
                "https://i.ytimg.com/vi/MXZz438aCDM/maxresdefault.jpg",
                "Programming")
        )
        articlesCourseAdapter.setArticlesCourse(listItemArticles)
    }

    private fun initDataCategories() {
        listItemCategories = ArrayList()
        listItemCategories.add(CategoriesCourseModel(1,
            "https://cdn-icons-png.flaticon.com/512/3159/3159310.png",
            "Design",23))
        listItemCategories.add(CategoriesCourseModel(2,
            "https://cdn-icons-png.flaticon.com/512/2640/2640598.png",
            "Soft Skill",15))
        listItemCategories.add(CategoriesCourseModel(3,
            "https://cdn-icons-png.flaticon.com/512/751/751429.png",
            "Art",12))

        categoriesCourseAdapter.setCategoriesCourse(listItemCategories)
    }

    private fun initDataPopular() {
        listItem = ArrayList()
        listItem.add(PopularCourseModel(1,
        "https://www.pointstar.co.id/wp-content/uploads/2019/05/Online-courses.jpg",
        150000,"Belajar Dasar Algoritma",4f,"123,608"))
        listItem.add(PopularCourseModel(2,
            "https://colorlib.com/wp/wp-content/uploads/sites/2/creative-css3-tutorials.jpg",
            250000,"Belajar Dasar CSS",5f,"12,971"))
        listItem.add(PopularCourseModel(3,
            "https://www.techfor.id/wp-content/uploads/2019/12/html.png",
            250000,"Belajar Dasar HTML",4.5f,"13,518"))

        popularCourseAdapter.setPopularCourse(listItem)
    }
}