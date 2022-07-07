package com.gonzalab.marveldataverse.data.remote.dto

import com.gonzalab.marveldataverse.data.remote.dto.common.*

data class CharacterDto(
    val comics: DataCollectionDto,
    val description: String,
    val events: DataCollectionDto,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: DataCollectionDto,
    val stories: DataCollectionDto,
    val thumbnail: ThumbnailDto,
    val urls: List<UrlDto>
)