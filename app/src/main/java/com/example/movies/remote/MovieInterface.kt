package com.example.movies.remote

import com.example.movies.data.MovieResponse
import com.example.movies.data.movieDetials.MovieDetails

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {


    @GET("top_rated")
    suspend fun getAllMovies(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>


    @GET("/")
    suspend fun getMovieDetails(
        @Query("i") imdbId: String,
        @Query("apiKey") apiKey: String
    ): Response<MovieDetails>

}