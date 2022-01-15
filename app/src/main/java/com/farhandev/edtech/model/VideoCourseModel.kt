package com.farhandev.edtech.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class VideoCourseModel(
    val id: Int? = 0,
    val numberVideo: String? = null,
    val titleVideo: String? = null,
    val timeVideo: String? = null,
    val urlVideo: String? = null
):Parcelable