package com.gonzalab.marveldataverse.data.remote.dto.common

data class DataCollectionDto(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemDto>,
    val returned: Int
)
