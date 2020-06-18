package com.example.newsapp.features

import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsService
@Inject constructor(retrofit: Retrofit) : NewsApi {

    private val newsApi by lazy { retrofit.create(NewsApi::class.java) }

    override fun topHeadlines(country: String, apiKey: String): Call<List<ArticleEntity>> =
            newsApi.topHeadlines(country, apiKey)

    override fun topHeadlines2(country: String, apiKey: String): Call<ResponseDataEntity> =
            newsApi.topHeadlines2(country, apiKey)
}