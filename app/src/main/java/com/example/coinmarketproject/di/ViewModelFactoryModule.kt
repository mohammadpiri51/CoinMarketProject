package com.example.coinmarketproject.di

import androidx.lifecycle.ViewModelProvider
import com.example.coinmarketproject.utils.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}