package com.fortatic.apps.kotlinflix.ui.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fortatic.apps.kotlinflix.databinding.ItemMoviesBinding
import com.fortatic.apps.kotlinflix.domain.Movie
import com.fortatic.apps.kotlinflix.ui.feed.MovieAdapter.MovieHolder

class MovieDiffUtil : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}

class MovieAdapter : ListAdapter<Movie, MovieHolder>(MovieDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    class MovieHolder private constructor(private val binding: ItemMoviesBinding) :
        ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): MovieHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemMoviesBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
                return MovieHolder(binding)
            }
        }

        fun bind(movie: Movie) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }
}