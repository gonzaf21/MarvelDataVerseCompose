package com.gonzalab.marveldataverse.domain.repository

import androidx.paging.PagingData
import com.gonzalab.marveldataverse.domain.model.Comic
import kotlinx.coroutines.flow.Flow

interface ComicRepository {
    fun getComicsList(): Flow<PagingData<Comic>>
}