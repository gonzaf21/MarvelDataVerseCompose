package com.gonzalab.marveldataverse.data.remote.dto

data class CharacterDto(
    val comics: ComicDto,
    val description: String,
    val events: EventDto,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: SeriesDto,
    val stories: StoryDto,
    val thumbnail: ThumbnailDto,
    val urls: List<UrlDto>
)

data class ComicDto(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicItemDto>,
    val returned: Int
)

data class EventDto(
    val available: Int,
    val collectionURI: String,
    val items: List<EventItemDto>,
    val returned: Int
)

data class SeriesDto(
    val available: Int,
    val collectionURI: String,
    val items: List<SeriesItemDto>,
    val returned: Int
)

data class StoryDto(
    val available: Int,
    val collectionURI: String,
    val items: List<StoryItemDto>,
    val returned: Int
)

data class ThumbnailDto(
    val extension: String,
    val path: String
)

data class UrlDto(
    val type: String,
    val url: String
)

data class ComicItemDto(
    val name: String,
    val resourceURI: String
)

data class EventItemDto(
    val name: String,
    val resourceURI: String
)

data class SeriesItemDto(
    val name: String,
    val resourceURI: String
)

data class StoryItemDto(
    val name: String,
    val resourceURI: String,
    val type: String
)