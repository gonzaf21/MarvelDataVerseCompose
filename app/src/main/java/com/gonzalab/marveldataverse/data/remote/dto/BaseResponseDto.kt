package com.gonzalab.marveldataverse.data.remote.dto

data class BaseResponseDto<T>(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val data: DataDto<T>?,
    val etag: String,
    val status: String
)

data class DataDto<T>(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<T>?,
    val total: Int
)