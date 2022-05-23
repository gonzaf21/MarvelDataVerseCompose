package com.gonzalab.marveldataverse.domain.repository

import com.gonzalab.marveldataverse.domain.model.Character
import com.gonzalab.marveldataverse.util.Resource
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getCharactersList(
        limit: Int,
        offset: Int
    ): Flow<Resource<List<Character>>>
}