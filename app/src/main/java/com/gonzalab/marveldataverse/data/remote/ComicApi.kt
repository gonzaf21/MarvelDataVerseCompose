package com.gonzalab.marveldataverse.data.remote

import com.gonzalab.marveldataverse.data.remote.dto.common.BaseResponseDto
import com.gonzalab.marveldataverse.data.remote.dto.ComicDto
import com.gonzalab.marveldataverse.data.remote.paging.ComicSource
import retrofit2.http.GET
import retrofit2.http.Query

interface ComicApi {
    @GET("comics")
    suspend fun getComics(
        @Query("limit") limit: Int = ComicSource.PAGE_SIZE,
        @Query("offset") offset: Int
    ): BaseResponseDto<ComicDto>
}