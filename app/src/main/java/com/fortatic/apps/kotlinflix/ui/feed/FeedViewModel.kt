package com.fortatic.apps.kotlinflix.ui.feed

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.fortatic.apps.kotlinflix.repository.MovieRepository
import kotlinx.coroutines.launch

class FeedViewModel @ViewModelInject constructor(
    movieRepository: MovieRepository
) : ViewModel() {

    val movies = movieRepository.movies.asLiveData()

    init {
        viewModelScope.launch {
            movieRepository.getMoviesFromNetwork()
        }
    }
}