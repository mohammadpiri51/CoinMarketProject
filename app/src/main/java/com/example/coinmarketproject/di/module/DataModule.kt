package com.example.coinmarketproject.di.module

import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.remote.datasource.CurrencyInfoRemoteService
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {
    @Binds
    abstract fun provideCurrencyInfoRemoteService(currencyInfoServiceFactory: CurrencyInfoRemoteService): ICurrencyInfoRemoteDataSource
}