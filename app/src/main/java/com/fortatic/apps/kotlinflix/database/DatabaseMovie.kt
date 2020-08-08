package com.fortatic.apps.kotlinflix.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fortatic.apps.kotlinflix.domain.Movie

/**
 * Las entidades de la base de datos son responsables de leer y escribir desde
 * la base de datos.
 *
 * DatabaseMovie representa a una entidad en la base de datos.
 */
@Entity(tableName = "movies_table")
data class DatabaseMovie(
    @PrimaryKey
    val id: Int,
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean,
    val posterPath: String,
    val adult: Boolean,
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<Int>,
    val title: String,
    val voteAverage: Double,
    val overview: String,
    val releaseDate: String
)

/**
 * Asignamos DatabaseMovie(entidad de Room) a Movie (entidad de dominio)
 */
fun List<DatabaseMovie>.asDomainModel(): List<Movie> {
    return map {
        Movie(
            id = it.id,
            popularity = it.popularity,
            voteCount = it.voteCount,
            video = it.video,
            posterPath = it.posterPath,
            adult = it.adult,
            backdropPath = it.backdropPath,
            originalLanguage = it.originalLanguage,
            originalTitle = it.originalTitle,
            genreIds = it.genreIds,
            title = it.title,
            voteAverage = it.voteAverage,
            overview = it.overview,
            releaseDate = it.releaseDate
        )
    }
}