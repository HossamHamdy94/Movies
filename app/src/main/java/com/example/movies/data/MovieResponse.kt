package com.example.movies.data


data class MovieResponse(
    val Response: String,
    val page : Int,

    val results: List<Movie>,
    val totalResults: String
)