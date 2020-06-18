package com.example.newsapp.core.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.core.di.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}