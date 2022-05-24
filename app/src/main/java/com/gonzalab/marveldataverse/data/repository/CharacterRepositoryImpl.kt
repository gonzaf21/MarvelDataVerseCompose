package com.gonzalab.marveldataverse.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gonzalab.marveldataverse.data.remote.CharacterApi
import com.gonzalab.marveldataverse.data.remote.paging.CharacterSource
import com.gonzalab.marveldataverse.domain.model.Character
import com.gonzalab.marveldataverse.domain.repository.CharacterRepository
import com.gonzalab.marveldataverse.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi
): CharacterRepository {
    /**
     * Get paging data transformed to domain character models and in flow format.
     */
    override fun getCharactersList(): Flow<PagingData<Character>> {
        return Pager(PagingConfig(CharacterSource.PAGE_SIZE)) {
            CharacterSource(api)
        }.flow
    }

    override suspend fun getCharacterData(
        limit: Int,
        offset: Int
    ): Flow<Resource<List<Character>>> {
        TODO("Not yet implemented")
    }
}