package com.saiful.unsplashimagesearchapp.view.viewModel


import androidx.lifecycle.ViewModel
import com.saiful.unsplashimagesearchapp.data.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GalleryViewModel @Inject constructor(private val repository: UnsplashRepository) : ViewModel() {


}