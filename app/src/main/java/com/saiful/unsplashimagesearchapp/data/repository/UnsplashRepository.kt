package com.saiful.unsplashimagesearchapp.data.repository

import com.saiful.unsplashimagesearchapp.api.UnsplashApi
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UnsplashRepository
    @Inject constructor
        (private val unsplashApi: UnsplashApi) {

}