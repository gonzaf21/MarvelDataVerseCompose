package com.gonzalab.marveldataverse.data.remote.dto

import com.gonzalab.marveldataverse.data.remote.dto.common.*

data class ComicDto(
    val characters: DataCollectionDto,
    val collectedIssues: List<Any>,
    val collections: List<Any>,
    val creators: DataCollectionDto,
    val dates: List<DateDto>,
    val description: Any,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: DataCollectionDto,
    val format: String,
    val id: Int,
    val images: List<ThumbnailDto>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<PriceDto>,
    val resourceURI: String,
    val series: ItemDto,
    val stories: DataCollectionDto,
    val textObjects: List<Any>,
    val thumbnail: ThumbnailDto,
    val title: String,
    val upc: String,
    val urls: List<UrlDto>,
    val variantDescription: String,
    val variants: List<ItemDto>
)