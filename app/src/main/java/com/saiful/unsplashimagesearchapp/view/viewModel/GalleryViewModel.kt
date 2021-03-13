package com.saiful.unsplashimagesearchapp.view.viewModel


import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.saiful.unsplashimagesearchapp.data.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.switchMap
import javax.inject.Inject


@ExperimentalCoroutinesApi
@HiltViewModel
class GalleryViewModel
@Inject constructor(private val repository: UnsplashRepository) : ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos (query : String){
        currentQuery.value = query
    }




    companion object {
        private const val DEFAULT_QUERY = "random"
    }

}