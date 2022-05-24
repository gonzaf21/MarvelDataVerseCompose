package com.gonzalab.marveldataverse.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.gonzalab.marveldataverse.data.mappers.toCharacter
import com.gonzalab.marveldataverse.data.remote.CharacterApi
import com.gonzalab.marveldataverse.domain.model.Character
import com.orhanobut.logger.Logger
import retrofit2.HttpException
import java.io.IOException

class CharacterSource(
    private val characterApi: CharacterApi
) : PagingSource<Int, Character>() {
    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val currentOffSet = params.key ?: 0
            Logger.wtf("$TAG -> current offset = $currentOffSet")
            val characterList = characterApi.getCharacters(offset = currentOffSet)
            LoadResult.Page(
                data = characterList.data?.results?.map { it.toCharacter() } ?: listOf(),
                prevKey = null,
                nextKey = if (characterList.data?.results.isNullOrEmpty()) null
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
        val TAG: String = CharacterSource::class.java.simpleName
    }
}