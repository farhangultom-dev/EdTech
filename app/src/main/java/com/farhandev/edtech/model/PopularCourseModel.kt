package com.farhandev.edtech.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PopularCourseModel(
    val id: Int? = null,
    val picCourse: String? = null,
    val price: Int? = 0,
    val titleCourse: String? = null,
    val rating: Float? = 0f,
    val totalReviews: String? = null
):Parcelable