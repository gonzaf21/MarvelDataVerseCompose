package com.gonzalab.marveldataverse.data.remote

import com.gonzalab.marveldataverse.data.remote.dto.BaseResponseDto
import com.gonzalab.marveldataverse.data.remote.dto.CharacterDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {
    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): BaseResponseDto<CharacterDto>
}