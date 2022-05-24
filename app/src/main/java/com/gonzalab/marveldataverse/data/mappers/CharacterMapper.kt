package com.gonzalab.marveldataverse.data.mappers

import com.gonzalab.marveldataverse.data.remote.dto.*
import com.gonzalab.marveldataverse.domain.model.*

fun CharacterDto.toCharacter(): Character {
    return Character(
        comics = comics.toComic(),
        description = description,
        events = events.toEvent(),
        id = id,
        modified = modified,
        name = name,
        resourceURI = resourceURI,
        series = series.toSeries(),
        stories = stories.toStory(),
        thumbnail = thumbnail.toThumbnail(),
        urls = urls.map { it.toUrl() }
    )
}

// Comic.
fun ComicDto.toComic(): Comic {
    return Comic(
        available = available,
        collectionURI = collectionURI,
        items = items.map { it.toComicItem() },
        returned = returned
    )
}

fun ComicItemDto.toComicItem(): ComicItem {
    return ComicItem(
        name = name,
        resourceURI = resourceURI
    )
}

// Event.
fun EventDto.toEvent(): Event {
    return Event(
        available = available,
        collectionURI = collectionURI,
        items = items.map { it.toEventItem() },
        returned = returned
    )
}

fun EventItemDto.toEventItem(): EventItem {
    return EventItem(
        name = name,
        resourceURI = resourceURI
    )
}

// Series.
fun SeriesDto.toSeries(): Series {
    return Series(
        available = available,
        collectionURI = collectionURI,
        items = items.map { it.toSeriesItem() },
        returned = returned
    )
}

fun SeriesItemDto.toSeriesItem(): SeriesItem {
    return SeriesItem(
        name = name,
        resourceURI = resourceURI
    )
}

// Story.
fun StoryDto.toStory(): Story {
    return Story(
        available = available,
        collectionURI = collectionURI,
        items = items.map { it.toStoryItem() },
        returned = returned
    )
}

fun StoryItemDto.toStoryItem(): StoryItem {
    return StoryItem(
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