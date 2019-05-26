package com.example.remote.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


fun main() {
    var retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(CurrencyInfoService.COINMARKET_BASE_URL)
        .build()
    retrofit.create(CurrencyInfoService::class.java).getLatest()
        .subscribe { data->
            println(data)
        }
}


