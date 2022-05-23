package com.gonzalab.marveldataverse.data.repository

import com.gonzalab.marveldataverse.data.remote.CharacterApi
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
    override suspend fun getCharactersList(
        limit: Int,
        offset: Int
    ): Flow<Resource<List<Character>>> {
        TODO("Not yet implemented")
    }
}