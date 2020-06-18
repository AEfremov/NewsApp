package com.example.newsapp.core.di

import com.example.newsapp.AndroidApplication
import com.example.newsapp.core.di.viewmodel.ViewModelModule
import com.example.newsapp.core.navigation.RouteActivity
import com.example.newsapp.features.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(application: AndroidApplication)
    fun inject(routeActivity: RouteActivity)

    fun inject(fragment: NewsFragment)
}