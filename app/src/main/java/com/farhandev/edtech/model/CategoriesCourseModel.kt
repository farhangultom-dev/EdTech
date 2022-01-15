package com.farhandev.edtech.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CategoriesCourseModel(
    val id: Int? = null,
    val icon: String? = null,
    val categoriesName: String? = null,
    val totalCourse: Int? = 0
):Parcelable