package com.fortatic.apps.kotlinflix.database

import androidx.room.TypeConverter

private const val DELIMITER = ","

/**
 * Esta clase convierte una lista a datos primitivos, esto debido a que Room no acepta objetos.
 * @see https://developer.android.com/training/data-storage/room/referencing-data#type-converters
 */
class Converters {

    @TypeConverter
    fun fromString(linearValue: String?): List<Int>? {
        return if (linearValue.isNullOrEmpty()) emptyList() else linearValue.split(DELIMITER).map {
            it.trim().toInt()
        }
    }

    @TypeConverter
    fun listToString(list: List<Int>?): String? {
        return list?.joinToString()
    }
}