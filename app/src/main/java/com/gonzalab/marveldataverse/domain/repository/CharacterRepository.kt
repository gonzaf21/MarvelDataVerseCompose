package com.gonzalab.marveldataverse.domain.repository

import androidx.paging.PagingData
import com.gonzalab.marveldataverse.domain.model.Character
import com.gonzalab.marveldataverse.util.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getCharactersList(): Flow<PagingData<Character>>

    suspend fun getCharacterData(
        limit: Int,
        offset: Int
    ): Flow<Resource<List<Character>>>
}