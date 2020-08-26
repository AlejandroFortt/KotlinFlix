package com.fortatic.apps.kotlinflix.domain

/**
 * Los objetos de dominio son data class de Kotlin que representan las cosas
 * en nuestra aplicación.
 * Estos son los objetos que deben mostrarse en la pantalla o manipularse por la aplicación.
 *
 * @see database para los objetos usados en Room.
 * @see network para objetos que analizan o preparan llamadas de red.
 */
data class Movie(
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
) {
    /**
     * Url completas, usadas por Glide para cargar los recursos mostrados en la UI.
     */
    val posterUrl: String
        get() = posterPath.toUrl()
    val backdropUrl: String
        get() = backdropPath.toUrl()

    val rate = voteAverage.toString()
    val idmb = voteAverage.fakeIdmb()
    val votes = voteCount.toString()
}