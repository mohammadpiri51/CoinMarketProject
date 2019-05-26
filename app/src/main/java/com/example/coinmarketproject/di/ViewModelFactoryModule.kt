package com.example.coinmarketproject.di

import androidx.lifecycle.ViewModelProvider
import com.example.coinmarketproject.utils.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}