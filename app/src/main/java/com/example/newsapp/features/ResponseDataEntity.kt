package com.example.newsapp.features

import com.example.newsapp.core.extension.empty
import com.squareup.moshi.Json

data class ResponseDataEntity(
        @Json(name = "status") val status: String,
        @Json(name = "totalResults") val totalResults: Int?,
        @Json(name = "articles") val articles: List<ArticleEntity>?,
        @Json(name = "code") val code: String?,
        @Json(name = "message") val message: String?
) {

    companion object {
        fun empty() = ResponseDataEntity(
                String.empty(),
                0,
                emptyList(),
                String.empty(),
                String.empty()
        )
    }

    fun toResponseData() = ResponseData(status, totalResults, articles, code, message)
}