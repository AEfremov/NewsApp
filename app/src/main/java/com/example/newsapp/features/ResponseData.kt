package com.example.newsapp.features

import com.example.newsapp.core.extension.empty

data class ResponseData(
        val status: String,
        val totalResults: Int?,
        val articles: List<ArticleEntity>?,
        val code: String?,
        val message: String?
) {

    companion object {
        fun empty() = ResponseData(
                String.empty(),
                0,
                emptyList(),
                String.empty(),
                String.empty()
        )
    }
}