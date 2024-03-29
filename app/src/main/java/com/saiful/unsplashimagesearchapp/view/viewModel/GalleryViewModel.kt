package com.saiful.unsplashimagesearchapp.view.viewModel

import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.saiful.unsplashimagesearchapp.data.repository.DataStoreRepository
import com.saiful.unsplashimagesearchapp.data.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class GalleryViewModel
@Inject constructor(
    private val repository: UnsplashRepository,
    private val dataStoreRepository: DataStoreRepository
    ) : ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos (query : String){
        currentQuery.value = query
    }

    val readDarkModeStatus = dataStoreRepository.readDarkModeStatus.asLiveData()

     fun saveDarkModeStatus(status:Boolean) = viewModelScope.launch {
        dataStoreRepository.saveDarkMode(status = status)
    }

    companion object {
        private const val DEFAULT_QUERY = "random"
    }
}