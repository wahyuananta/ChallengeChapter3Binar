package com.coder.challengechapter3binar

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BiayaListrik(
    val peralatanElektronik: String,
    val watt: Double,
    val jam: Double,
    val biaya: Double) : Parcelable
