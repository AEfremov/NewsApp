package com.example.newsapp.features

import androidx.lifecycle.MutableLiveData
import com.example.newsapp.core.interactor.UseCase
import com.example.newsapp.core.platform.BaseViewModel
import javax.inject.Inject

class NewsViewModel
@Inject constructor(private val getNews: GetNews) : BaseViewModel() {

    var topHeadlines: MutableLiveData<List<ArticleView>> = MutableLiveData()
//    var topHeadlines: MutableLiveData<ResponseDataEntity> = MutableLiveData()

    fun loadTopHeadlines(country: String, apiKey: String) =
        getNews(GetNews.Params(country, apiKey)) { it.fold(::handleFailure, ::handleTopHeadlines2) }

//    private fun handleTopHeadlines(topHeadlines: List<Article>) {
//        this.topHeadlines.value = topHeadlines.map { ArticleView(it.id) }
//    }

    private fun handleTopHeadlines2(topHeadlines: ResponseData) {
        this.topHeadlines.value = topHeadlines.articles?.map {
            ArticleView(
                    it.author,
                    it.title,
                    it.description,
                    it.url,
                    it.urlToImage,
                    it.publishedAt,
                    it.content
            ) }
    }
}