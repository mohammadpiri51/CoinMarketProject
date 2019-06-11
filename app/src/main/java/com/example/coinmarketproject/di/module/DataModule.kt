package com.example.coinmarketproject.di.module

import android.content.Context
import dagger.Binds
import android.content.SharedPreferences
import com.example.data.datasource.ICurrencyInfoLocalDataSource
import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.local.database.CoinMarketDataBase
import com.example.local.datasource.CurrencyInfoLocalDataSource
import com.example.remote.api.CurrencyInfoService
import com.example.remote.datasource.CurrencyInfoRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideCurrencyInfoRemoteDataSource(
        currencyInfoService: CurrencyInfoService
    ): ICurrencyInfoRemoteDataSource {
        return CurrencyInfoRemoteDataSource(currencyInfoService)
    }

    @Provides
    fun provideCurrencyInfoLocalDataSource(
        coinMarketDataBase: CoinMarketDataBase,
        currencyInfoRemoteDataSource: ICurrencyInfoRemoteDataSource,
        sharedPreferences: SharedPreferences
    ): ICurrencyInfoLocalDataSource {
        return CurrencyInfoLocalDataSource(coinMarketDataBase, currencyInfoRemoteDataSource, sharedPreferences)
    }
}

//@Module
//class DataModule {
//    @Provides
//    fun provideCurrencyInfoRemoteDataSource(
//        currencyInfoRemoteDataSource: CurrencyInfoRemoteDataSource
//    ): ICurrencyInfoRemoteDataSource {
//        return currencyInfoRemoteDataSource
//    }
//
//    @Provides
//    fun provideCurrencyInfoLocalDataSource(
//        currencyInfoLocalDataSource: CurrencyInfoLocalDataSource
//    ): ICurrencyInfoLocalDataSource {
//        return currencyInfoLocalDataSource
//    }
//}

//@Module
//abstract class DataModule {
//    @Binds
//    abstract fun provideCurrencyInfoRemoteDataSource(
//        currencyInfoRemoteDataSource: CurrencyInfoRemoteDataSource
//    ): ICurrencyInfoRemoteDataSource
//
//    @Binds
//    abstract fun provideCurrencyInfoLocalDataSource(
//        currencyInfoLocalDataSource: CurrencyInfoLocalDataSource
//    ): ICurrencyInfoLocalDataSource
//}