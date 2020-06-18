package com.example.newsapp.features

import com.example.newsapp.core.exception.Failure
import com.example.newsapp.core.functional.Either
import com.example.newsapp.core.interactor.UseCase
import javax.inject.Inject

class GetNews
@Inject constructor(private val newsRepository: NewsRepository) : UseCase<ResponseData/*List<Article>*/, GetNews.Params>() {

//    override suspend fun run(params: Params) = newsRepository.news(params.country, params.apiKey)
    override suspend fun run(params: Params) = newsRepository.news2(params.country, params.apiKey)

    data class Params(val country: String, val apiKey: String)
}