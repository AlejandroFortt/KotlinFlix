package com.fortatic.apps.kotlinflix.repository

import com.fortatic.apps.kotlinflix.database.AppDatabase
import com.fortatic.apps.kotlinflix.database.DatabaseMovie
import com.fortatic.apps.kotlinflix.database.asDomainModel
import com.fortatic.apps.kotlinflix.domain.Movie
import com.fortatic.apps.kotlinflix.network.Api
import com.fortatic.apps.kotlinflix.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

/**
 * Repositorio para recuperar la lista de "Movies" del servidor y almacenarlos en el disco.
 */
class MovieRepository @Inject constructor(
    private val appDatabase: AppDatabase
) {

    val movies: Flow<List<Movie>>
        get() = appDatabase.movieDao.getMovies().map {
            it.asDomainModel()
        }

    suspend fun getMoviesFromNetwork() {
        withContext(Dispatchers.IO) {
            val moviesFromNetwork = try {
                Api.retrofitService.getPlaylist()
            } catch (e: Exception) {
                Timber.e(e)
                null
            }
            moviesFromNetwork?.let {
                saveDataInDatabase(it.asDatabaseModel())
            }
        }
    }

    private fun saveDataInDatabase(data: List<DatabaseMovie>) {
        appDatabase.movieDao.saveMovies(data)
    }
}