package com.example.data.datasource

import com.example.data.model.CurrencyInfo
import io.reactivex.Single

interface ICurrencyInfoRemoteDataSource {
    fun getLatest(): Single<List<CurrencyInfo>>
}