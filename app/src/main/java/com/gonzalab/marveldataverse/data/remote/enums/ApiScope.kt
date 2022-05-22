package com.gonzalab.marveldataverse.data.remote.enums

enum class ApiScope(val url: String) {
    PRODUCTION("https://gateway.marvel.com/v1/public"),
    DEVELOP("https://gateway.marvel.com/v1/public"),
    LOCAL("https://gateway.marvel.com/v1/public")
}