package com.saiful.unsplashimagesearchapp.data.paging

import androidx.paging.PagingSource
import com.saiful.unsplashimagesearchapp.data.api.UnsplashApi
import com.saiful.unsplashimagesearchapp.data.model.UnsplashPhoto
import retrofit2.HttpException

private const val START_PAGE_INDEX = 1

class UnsplashPagingSource(
    private val unsplashApi: UnsplashApi,
    private val query: String
) : PagingSource<Int, UnsplashPhoto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashPhoto> {
       val position = params.key ?: START_PAGE_INDEX

        return try {

            val response = unsplashApi.searchPhotos(query, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if(position == START_PAGE_INDEX) null else position - 1,
                nextKey =  if(photos.isEmpty()) null else position + 1
            )
        } catch (exception : Exception ){
            LoadResult.Error(exception)
        }catch (exception : HttpException){
            LoadResult.Error(exception)
        }
    }



}