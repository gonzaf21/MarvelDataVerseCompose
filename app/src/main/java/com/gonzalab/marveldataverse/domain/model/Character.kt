package com.gonzalab.marveldataverse.domain.model

data class Character(
    val comics: Comic,
    val description: String,
    val events: Event,
    val id: Int,
    val modified: String,
    val name: String,
    val resourceURI: String,
    val series: Series,
    val stories: Story,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)

data class Comic(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicItem>,
    val returned: Int
)

data class Event(
    val available: Int,
    val collectionURI: String,
    val items: List<EventItem>,
    val returned: Int
)

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<SeriesItem>,
    val returned: Int
)

data class Story(
    val available: Int,
    val collectionURI: String,
    val items: List<StoryItem>,
    val returned: Int
)

data class Thumbnail(
    val extension: String,
    val path: String
)

data class Url(
    val type: String,
    val url: String
)

data class ComicItem(
    val name: String,
    val resourceURI: String
)

data class EventItem(
    val name: String,
    val resourceURI: String
)

data class SeriesItem(
    val name: String,
    val resourceURI: String
)

data class StoryItem(
    val name: String,
    val resourceURI: String,
    val type: String
)
