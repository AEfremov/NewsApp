package com.example.newsapp.core.navigation

import android.content.Context
import android.view.View
import com.example.newsapp.features.NewsActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject constructor() {

    fun showMain(context: Context) {
        showNews(context)
    }

    private fun showNews(context: Context) = context.startActivity(NewsActivity.callingIntent(context))

    fun openArticle(context: Context) {
    }

    class Extras(val transitionSharedElement: View)

    // TODO добавить класс для news extra
}