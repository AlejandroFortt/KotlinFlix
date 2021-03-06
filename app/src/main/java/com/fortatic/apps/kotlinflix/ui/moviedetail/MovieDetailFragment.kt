package com.fortatic.apps.kotlinflix.ui.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.fortatic.apps.kotlinflix.databinding.FragmentMovieDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {
    private val args: MovieDetailFragmentArgs by navArgs()

    @Inject lateinit var viewModelAssistedFactory: DetailViewModel.AssistedFactory
    private val detailViewModel: DetailViewModel by viewModels {
        DetailViewModel.provideFactory(viewModelAssistedFactory, args.movieId)
    }

    private lateinit var binding: FragmentMovieDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(
            inflater, container, false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        detailViewModel.movie.observe(viewLifecycleOwner, { movie->
            binding.movie = movie
        })

        return binding.root
    }
}