package com.fortatic.apps.kotlinflix.di

import android.content.Context
import com.fortatic.apps.kotlinflix.database.AppDatabase
import com.fortatic.apps.kotlinflix.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Definimos todas las clases/objetos que deben proporcionarse en el "scope" de la aplicación,
 * si algunos de esas clases/objetos son singleton, deben anotarse con "@Singleton".
 */
@InstallIn(ApplicationComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) =
        AppDatabase.buildDatabase(context)

    @Singleton
    @Provides
    fun provideMovieRepository(appDatabase: AppDatabase) =
        MovieRepository(appDatabase)
}