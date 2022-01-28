package com.example.movies.data.movieDetials

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieDetails(
    val Actors: String,
    val Awards: String,
    val BoxOffice: String,
    val Country: String,
    val DVD: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Metascore: String,
    val Plot: String,
    val poster_path: String,
    val Production: String,
    val Released: String,
    val Response: String,
    val Runtime: String,
    val title: String,
    val Type: String,
    val Website: String,
    val Writer: String,
    val release_date: String,
    val id: String,
    val imdbRating: String,
    val imdbVotes: String,
    val image_url: String = "https://image.tmdb.org/t/p/original" +poster_path

) :Parcelable