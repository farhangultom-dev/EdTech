package com.farhandev.edtech.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArticlesCourseModel(
    val id: Int? = null,
    val titleArticle: String? = null,
    val picsArticles: String? = null,
    val categoriesArticles: String? = null,
):Parcelable