package com.gonzalab.marveldataverse.domain.model

import com.gonzalab.marveldataverse.domain.model.common.*

data class Comic(
    val characters: DataCollection,
    val collectedIssues: List<Any>,
    val collections: List<Any>,
    val creators: DataCollection,
    val dates: List<Date>,
    val description: Any,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: DataCollection,
    val format: String,
    val id: Int,
    val images: List<Thumbnail>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val resourceURI: String,
    val series: Item,
    val stories: DataCollection,
    val textObjects: List<Any>,
    val thumbnail: Thumbnail,
    val title: String,
    val upc: String,
    val urls: List<Url>,
    val variantDescription: String,
    val variants: List<Item>
)
