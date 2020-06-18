package com.example.newsapp.features

import com.example.newsapp.core.exception.Failure
import com.example.newsapp.core.functional.Either
import com.example.newsapp.core.platform.NetworkHandler
import retrofit2.Call
import javax.inject.Inject

interface NewsRepository {

    fun news(country: String, apiKey: String) : Either<Failure, List<Article>>
    fun news2(country: String, apiKey: String) : Either<Failure, ResponseData>

    class Network
    @Inject constructor(private val networkHandler: NetworkHandler,
                        private val service: NewsService) : NewsRepository {

        override fun news(country: String, apiKey: String): Either<Failure, List<Article>> {
            return when (networkHandler.isConnected) {
                true ->
                    request(service.topHeadlines(country, apiKey),
                        { it.map { articleEntity -> articleEntity.toArticle() } },
                        emptyList())
                false, null -> Either.Left(Failure.NetworkConnection)
            }
        }

        override fun news2(country: String, apiKey: String): Either<Failure, ResponseData> {
            return when (networkHandler.isConnected) {
                true -> request(service.topHeadlines2(country, apiKey),
                        { it.toResponseData() },
                        ResponseDataEntity.empty()
//                true -> request(service.topHeadlines2(country, apiKey),
//                        { it.articles?.map { articleEntity -> articleEntity.toArticle() } ?: emptyList<Article>() },
//                        ResponseDataEntity.empty()
                )
                false, null -> Either.Left(Failure.NetworkConnection)
            }
        }

        private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
            return try {
                val response = call.execute()
                when (response.isSuccessful) {
                    true -> Either.Right(transform((response.body() ?: default)))
                    false -> Either.Left(Failure.ServerError)
                }
            } catch (exception: Throwable) {
                Either.Left(Failure.ServerError)
            }
        }
    }
}