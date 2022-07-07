package com.gonzalab.marveldataverse.domain.model.common

data class Thumbnail(
    val extension: String,
    val path: String
) {
    fun url(): String {
        return "${
            path.replace(
                "http",
                "https"
            )
        }.$extension" // Coil just does not work with http normal requests.
    }
}