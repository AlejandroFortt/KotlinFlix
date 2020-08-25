package com.fortatic.apps.kotlinflix.ui.moviedetail

import androidx.lifecycle.*
import com.fortatic.apps.kotlinflix.repository.MovieRepository
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class DetailViewModel @AssistedInject constructor(
    @Assisted private val movieId: Int,
    movieRepository: MovieRepository
) : ViewModel() {

    val movie = Transformations.map(movieRepository.movies.asLiveData()) {
        it.firstOrNull { movie -> movie.id == movieId }
    }

    @AssistedInject.Factory
    interface AssistedFactory {
        fun create(movieId: Int): DetailViewModel
    }

    companion object {
        fun provideFactory(
            assistedFactory: AssistedFactory,
            movieId: Int
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return assistedFactory.create(movieId) as T
            }
        }
    }
}