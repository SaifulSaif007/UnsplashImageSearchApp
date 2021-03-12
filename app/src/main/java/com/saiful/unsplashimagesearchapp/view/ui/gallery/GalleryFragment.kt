package com.saiful.unsplashimagesearchapp.view.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.saiful.moviestvseries.util.ItemDecorator
import com.saiful.unsplashimagesearchapp.R
import com.saiful.unsplashimagesearchapp.databinding.FragmentGalleryBinding

import com.saiful.unsplashimagesearchapp.view.adapter.GalleryAdapter
import com.saiful.unsplashimagesearchapp.view.viewModel.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOn

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery){

    private val viewModel : GalleryViewModel by viewModels()

    private var _binding : FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGalleryBinding.bind(view)

        val adapter = GalleryAdapter()

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
            recyclerView.addItemDecoration(ItemDecorator())
        }

        viewModel.photos.observe(viewLifecycleOwner){  data ->
            adapter.submitData(viewLifecycleOwner.lifecycle, data )
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}