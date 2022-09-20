package com.kenbu.marssale.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RealEstateModel(
    val price: Int,
    val id: String,
    val type: String,
    val img_src: String
) : Parcelable