package com.example.movies.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.movies.MovieViewModel
import com.example.movies.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

import com.example.movies.utils.Result
import com.example.movies.utils.Status


@AndroidEntryPoint
class DetailsFragment : Fragment() {


    lateinit var binding: FragmentDetailsBinding

    val args: DetailsFragmentArgs by navArgs()

    val viewModel: MovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.backPress.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.movieDetails = args.movies


       // viewModel.getMovieDetails(args.movies!!)


    }

}