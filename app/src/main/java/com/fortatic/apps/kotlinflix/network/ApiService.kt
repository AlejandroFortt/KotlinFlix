package com.fortatic.apps.kotlinflix.network

import com.fortatic.apps.kotlinflix.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val FEED_PATH = "now_playing"

interface ApiService {
    @GET(FEED_PATH)
    suspend fun getPlaylist(): NetworkMovieContainer
}

/**
 * Punto de entrada principal para el acceso a la red.
 */
object Api {

    private const val url = BuildConfig.BASE_URL

    private val httpClient = OkHttpClient.Builder()
        .addInterceptor(httpTimberInterceptor().bodyLevel())
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
            val httpBuilder = chain.request().url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.API_KEY)
            request.url(httpBuilder.build())
            chain.proceed(request.build())
        }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(url)
        .client(httpClient.build())
        .build()

    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
