package com.example.movies.ui.details

import com.example.movies.data.movieDetials.MovieDetails
import com.example.movies.remote.MovieInterface
import com.example.movies.utils.Constants
import com.example.movies.utils.Status

import com.example.movies.utils.Result

class MovieDetailsRepository(private val movieInterface: MovieInterface) {


    suspend fun getMovieDetails(imdbId: String): Result<MovieDetails> {


        return try {

            val response = movieInterface.getMovieDetails(imdbId, Constants.API_KEY)
            if (response.isSuccessful) {

                Result(Status.SUCCESS, response.body(), null)

            } else {
                Result(Status.ERROR, null, null)
            }


        } catch (e: Exception) {
            Result(Status.ERROR, null, null)
        }


    }


}