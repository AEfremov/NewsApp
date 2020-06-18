package com.example.newsapp.features

import android.os.Bundle
import com.example.newsapp.R
import com.example.newsapp.core.navigation.Navigator
import com.example.newsapp.core.platform.BaseFragment
import javax.inject.Inject

class NewsFragment : BaseFragment() {

    @Inject lateinit var navigator: Navigator

    override fun layoutId(): Int = R.layout.fragment_news

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)


    }
}