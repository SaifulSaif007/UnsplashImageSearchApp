package com.saiful.unsplashimagesearchapp.view.ui.gallery

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.saiful.unsplashimagesearchapp.util.ItemDecorator
import com.saiful.unsplashimagesearchapp.R
import com.saiful.unsplashimagesearchapp.databinding.FragmentGalleryBinding
import com.saiful.unsplashimagesearchapp.util.DarkModeToggle.toggleDarkMode

import com.saiful.unsplashimagesearchapp.view.adapter.GalleryAdapter
import com.saiful.unsplashimagesearchapp.view.adapter.PhotoLoadStateAdapter
import com.saiful.unsplashimagesearchapp.view.ui.MainActivity
import com.saiful.unsplashimagesearchapp.view.viewModel.GalleryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private val viewModel: GalleryViewModel by viewModels()

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentGalleryBinding.bind(view)

        setHasOptionsMenu(true)

        val adapter = GalleryAdapter()

        val gridLayoutManager = GridLayoutManager(activity, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return adapter.getItemViewType(position)
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

        viewModel.photos.observe(viewLifecycleOwner) { data ->
            adapter.submitData(viewLifecycleOwner.lifecycle, data)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.gallery_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.dark_mode -> {
                toggleDarkMode()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}