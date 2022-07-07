package com.gonzalab.marveldataverse.data.remote

import com.gonzalab.marveldataverse.data.remote.dto.CharacterDto
import com.gonzalab.marveldataverse.data.remote.dto.common.BaseResponseDto
import com.gonzalab.marveldataverse.data.remote.paging.CharacterSource
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {
    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int = CharacterSource.PAGE_SIZE,
        @Query("offset") offset: Int
    ): BaseResponseDto<CharacterDto>
}