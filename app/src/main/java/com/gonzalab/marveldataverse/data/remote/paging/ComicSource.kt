package com.gonzalab.marveldataverse.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gonzalab.marveldataverse.data.mappers.toComic
import com.gonzalab.marveldataverse.data.remote.ComicApi
import com.gonzalab.marveldataverse.domain.model.Comic
import com.orhanobut.logger.Logger
import retrofit2.HttpException
import java.io.IOException

class ComicSource(
    private val comicApi: ComicApi
) : PagingSource<Int, Comic>() {
    override fun getRefreshKey(state: PagingState<Int, Comic>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comic> {
        return try {
            val currentOffSet = params.key ?: 0
            Logger.wtf("$TAG -> current offset = $currentOffSet")
            val comicsList = comicApi.getComics(offset = currentOffSet)
            LoadResult.Page(
                data = comicsList.data?.results?.map { it.toComic() } ?: listOf(),
                prevKey = null,
                nextKey = if (comicsList.data?.results.isNullOrEmpty()) null
                else currentOffSet.plus(PAGE_SIZE)
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    companion object {
        const val PAGE_SIZE = 20
        val TAG: String = ComicSource::class.java.simpleName
    }
}