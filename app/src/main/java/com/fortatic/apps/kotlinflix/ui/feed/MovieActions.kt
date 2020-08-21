package com.fortatic.apps.kotlinflix.ui.feed

import com.fortatic.apps.kotlinflix.domain.Movie

/**
 * OnClickListener para cada "Movie".
 */
class MovieActions(val block: (Movie) -> Unit) {
    fun onClick(video: Movie) = block(video)
}