package com.example.movies

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.movies.data.movieDetials.MovieDetails
import com.example.movies.remote.MovieInterface
import com.example.movies.ui.details.MovieDetailsRepository
import com.example.movies.ui.movie.MoviePaging
import com.example.movies.utils.Events
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.movies.utils.Status
import com.example.movies.utils.Result

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieInterface: MovieInterface,
    private val repository: MovieDetailsRepository
) : ViewModel() {


    private val query = MutableLiveData<String>()


    val list = query.switchMap { query ->
        Pager(PagingConfig(pageSize = 10)) {
            MoviePaging(query, movieInterface)
        }.liveData.cachedIn(viewModelScope)
    }

    fun setQuery(s: String) {
        query.postValue(s)
    }

    private val _movieDetails = MutableLiveData<Events<Result<MovieDetails>>>()
    val movieDetails: LiveData<Events<Result<MovieDetails>>> = _movieDetails


    fun getMovieDetails(imdbId: String) = viewModelScope.launch {
        _movieDetails.postValue(Events(Result(Status.LOADING, null, null)))
        _movieDetails.postValue(Events(repository.getMovieDetails(imdbId)))

    }


}