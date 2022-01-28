package com.example.movies.hilt

import com.example.movies.remote.MovieInterface
import com.example.movies.ui.details.MovieDetailsRepository
import com.example.movies.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

    @Singleton
    @Provides
    fun provideRetrofitInterface(): MovieInterface {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(MovieInterface::class.java)
    }


    @Provides
    fun provideRepository(movieInterface: MovieInterface): MovieDetailsRepository {
        return MovieDetailsRepository(movieInterface)
    }

}