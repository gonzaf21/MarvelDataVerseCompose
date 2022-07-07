package com.gonzalab.marveldataverse.domain.model.common

data class DataCollection(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)
