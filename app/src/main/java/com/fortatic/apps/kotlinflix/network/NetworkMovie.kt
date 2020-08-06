package com.fortatic.apps.kotlinflix.network

import com.google.gson.annotations.SerializedName

/**
 * NetworkMovie es un DataTransferObject(DTO), los DTO's son responsables de analizar
 * las respuestas del servidor o de formatear los objetos para enviarlos al servidor.
 * Debe convertirlos en objetos de dominio/database antes de usarlos.
 *
 * @see https://martinfowler.com/eaaCatalog/dataTransferObject.html
 */
data class NetworkMovieContainer(
    val results: List<NetworkMovie>,
    val page: Int,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int
)

data class NetworkMovie(
    val popularity: Double,
    @SerializedName("vote_count") val voteCount: Int,
    val video: Boolean,
    @SerializedName("poster_path") val posterPath: String,
    val id: Int,
    val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    val title: String,
    @SerializedName("vote_average") val voteAverage: Double,
    val overview: String,
    @SerializedName("release_date") val releaseDate: String
)