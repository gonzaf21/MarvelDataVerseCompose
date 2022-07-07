package com.gonzalab.marveldataverse.data.mappers

import com.gonzalab.marveldataverse.data.remote.dto.CharacterDto
import com.gonzalab.marveldataverse.data.remote.dto.common.*
import com.gonzalab.marveldataverse.domain.model.Character
import com.gonzalab.marveldataverse.domain.model.common.*

// Character.
fun CharacterDto.toCharacter(): Character {
    return Character(
        comics = comics.toDataCollection(),
        description = description,
        events = events.toDataCollection(),
        id = id,
        modified = modified,
        name = name,
        resourceURI = resourceURI,
        series = series.toDataCollection(),
        stories = stories.toDataCollection(),
        thumbnail = thumbnail.toThumbnail(),
        urls = urls.map { it.toUrl() }
    )
}

// Generic data collection.
fun DataCollectionDto.toDataCollection(): DataCollection {
    return DataCollection(
        available = available,
        collectionURI = collectionURI,
        items = items.map { it.toItem() },
        returned = returned
    )
}

// Generic item data.
fun ItemDto.toItem(): Item {
    return Item(
        name = name,
        resourceURI = resourceURI,
        type = type
    )
}

// Thumbnail.
fun ThumbnailDto.toThumbnail(): Thumbnail {
    return Thumbnail(
        extension = extension,
        path = path
    )
}

// Url.
fun UrlDto.toUrl(): Url {
    return Url(
        type = type,
        url = url
    )
}