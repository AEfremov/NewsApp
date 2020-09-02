package com.example.newsapp.features

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.core.exception.Failure
import com.example.newsapp.core.extension.observe
import com.example.newsapp.core.extension.failure
import com.example.newsapp.core.extension.viewModel
import com.example.newsapp.core.navigation.Navigator
import com.example.newsapp.core.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_news.*
import javax.inject.Inject

class NewsFragment : BaseFragment() {

    @Inject lateinit var navigator: Navigator
    @Inject lateinit var newsAdapter: NewsAdapter

    private lateinit var newsViewModel: NewsViewModel

    companion object {
        fun getInstance() : NewsFragment = NewsFragment()
    }

    override fun layoutId(): Int = R.layout.fragment_news

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        newsViewModel = viewModel(viewModelFactory) {
            observe(topHeadlines, ::renderNewsList)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
    }

    private fun initializeView() {
        newsList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        newsList.adapter = newsAdapter
//        newsAdapter.clickListener =
    }

    private fun loadHeadlines() {

    }

    private fun renderNewsList(topHeadlines: List<ArticleView>?) {
    }

    private fun handleFailure(failure: Failure?) {
    }
}