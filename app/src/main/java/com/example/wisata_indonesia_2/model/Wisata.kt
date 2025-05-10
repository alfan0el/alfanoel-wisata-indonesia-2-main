package com.example.wisata_indonesia_2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wisata(
    val name: String,
    val location: String,
    val description: String
) : Parcelable
