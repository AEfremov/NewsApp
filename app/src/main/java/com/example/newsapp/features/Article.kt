package com.example.newsapp.features

import com.squareup.moshi.Json

data class Article(
    val author: String?,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) {

    companion object {
        fun empty() = Article(
            "",
            "",
            "",
            "",
            "",
            "",
            ""
        )
    }
}