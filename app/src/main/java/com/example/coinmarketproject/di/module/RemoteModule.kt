package com.example.coinmarketproject.di.module

import com.example.remote.api.CurrencyInfoService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RemoteModule {

    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    fun provideCurrencyInfoService(retrofit: Retrofit.Builder): CurrencyInfoService {
        return retrofit
            .baseUrl(COINMARKET_BASE_URL)
            .build()
            .create(CurrencyInfoService::class.java)
    }

    companion object {
        const val COINMARKET_BASE_URL = "https://pro-api.coinmarketcap.com"
    }

}