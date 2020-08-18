package com.fortatic.apps.kotlinflix

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Evitamos mostrar mensajes en la consola cuando estamos en modo "release"
        if (BuildConfig.DEBUG){
            Timber.plant(Tree())
        }
    }
}

/**
 * Creamos la clase Tree para poder personalizar el tag por defecto que nos
 * proporciona Timber.
 */
class Tree : Timber.DebugTree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        super.log(priority, "$tag FATAL", message, t)
    }
}