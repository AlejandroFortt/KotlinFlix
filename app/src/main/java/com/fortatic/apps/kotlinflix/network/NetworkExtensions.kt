package com.fortatic.apps.kotlinflix.network

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

fun httpTimberInterceptor(): HttpLoggingInterceptor {
    val customLogger = object : HttpLoggingInterceptor.Logger {
        override fun log(message: String) {
            Timber.tag("OkHttp").v(message)
        }
    }
    return HttpLoggingInterceptor(customLogger)
}

fun HttpLoggingInterceptor.bodyLevel(): HttpLoggingInterceptor {
    level = HttpLoggingInterceptor.Level.BODY
    return this
}
