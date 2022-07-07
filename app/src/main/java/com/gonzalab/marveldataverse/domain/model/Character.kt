package com.gonzalab.marveldataverse.domain.model

import com.gonzalab.marveldataverse.domain.model.common.DataCollection
import com.gonzalab.marveldataverse.domain.model.common.Thumbnail
import com.gonzalab.marveldataverse.domain.model.common.Url

data class Character(
    val comics: DataCollection,
    val description: String,
    val events: DataCollection,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: DataCollection,
    val stories: DataCollection,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)