package com.saiful.unsplashimagesearchapp.view.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.saiful.unsplashimagesearchapp.util.ItemDecorator
import com.saiful.unsplashimagesearchapp.R
import com.saiful.unsplashimagesearchapp.databinding.FragmentGalleryBinding

import com.saiful.unsplashimagesearchapp.view.adapter.GalleryAdapter
import com.saiful.unsplashimagesearchapp.view.adapter.PhotoLoadStateAdapter
import com.saiful.unsplashimagesearchapp.view.viewModel.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

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

        val gridLayoutManager = GridLayoutManager(activity, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val viewType = adapter.getItemViewType(position)
                return if (viewType == 1) 1
                else 2
            }

        }

        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = gridLayoutManager
            recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
                header = PhotoLoadStateAdapter { adapter.retry() },
                footer = PhotoLoadStateAdapter { adapter.retry() },
            )
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