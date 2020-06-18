package com.example.newsapp.features

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface NewsApi {

    companion object {
        const val API_VERSION = "v2"
    }

    @GET("$API_VERSION/top-headlines")
    fun topHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ) : Call<List<ArticleEntity>>

    @GET("$API_VERSION/top-headlines")
    fun topHeadlines2(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ) : Call<ResponseDataEntity>
}