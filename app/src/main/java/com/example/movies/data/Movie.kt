package com.example.movies.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val poster_path: String,
    val title: String,
    val Type: String,
    val release_date: String,
    val id: String,

    val vote_average: String,





):Parcelable