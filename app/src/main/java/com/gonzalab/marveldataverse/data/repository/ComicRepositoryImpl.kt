package com.gonzalab.marveldataverse.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gonzalab.marveldataverse.data.remote.ComicApi
import com.gonzalab.marveldataverse.data.remote.paging.ComicSource
import com.gonzalab.marveldataverse.domain.model.Comic
import com.gonzalab.marveldataverse.domain.repository.ComicRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComicRepositoryImpl @Inject constructor(
    private val api: ComicApi
): ComicRepository {
    /**
     * Get paging data transformed to domain comic models and in flow format.
     */
    override fun getComicsList(): Flow<PagingData<Comic>> {
        return Pager(PagingConfig(ComicSource.PAGE_SIZE)) {
            ComicSource(api)
        }.flow
    }
}