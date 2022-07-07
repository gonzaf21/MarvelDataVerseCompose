package com.gonzalab.marveldataverse.data.mappers

import com.gonzalab.marveldataverse.data.remote.dto.ComicDto
import com.gonzalab.marveldataverse.data.remote.dto.common.DateDto
import com.gonzalab.marveldataverse.data.remote.dto.common.PriceDto
import com.gonzalab.marveldataverse.domain.model.Comic
import com.gonzalab.marveldataverse.domain.model.common.*
import com.gonzalab.marveldataverse.domain.model.common.Date
import com.orhanobut.logger.Logger
import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

// Comic.
fun ComicDto.toComic(): Comic {
    return Comic(
        characters = characters.toDataCollection(),
        collectedIssues = collectedIssues,
        collections = collections,
        creators = creators.toDataCollection(),
        dates = dates.map { it.toDate() },
        description = description,
        diamondCode = diamondCode,
        digitalId = digitalId,
        ean = ean,
        events = events.toDataCollection(),
        format = format,
        id = id,
        images = images.map { it.toThumbnail() },
        isbn = isbn,
        issn = issn,
        issueNumber = issueNumber,
        modified = modified,
        pageCount = pageCount,
        prices = prices.map { it.toPrice() },
        resourceURI = resourceURI,
        series = series.toItem(),
        stories = stories.toDataCollection(),
        textObjects = textObjects,
        thumbnail = thumbnail.toThumbnail(),
        title = title,
        upc = upc,
        urls = urls.map { it.toUrl() },
        variantDescription = variantDescription,
        variants = variants.map { it.toItem() }
    )
}

// Date.
fun DateDto.toDate(): Date {
    return try {
        val pattern = "yyyy-MM-dd HH:mm:ss"
        val formatter = DateTimeFormatter.ofPattern(pattern, Locale.getDefault())
        val localDateTime = LocalDateTime.parse(this.date, formatter)
        Date(localDateTime, this.type)
    } catch (e: Exception) {
        e.printStackTrace()
        Logger.e("ComicMapper -> ${e.message}")
        Date(LocalDateTime.MIN, this.type)
    }
}

// Price.
fun PriceDto.toPrice(): Price {
    return Price(this.price, this.type)
}