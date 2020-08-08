package com.fortatic.apps.kotlinflix.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Interfaz que nos permite acceder a métodos que desencadenarán acciones
 * en la base de datos.
 */

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies_table")
    fun getMovies(): Flow<List<DatabaseMovie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movies: List<DatabaseMovie>)
}