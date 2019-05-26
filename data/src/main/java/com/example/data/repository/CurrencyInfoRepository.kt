package com.example.data.repository

import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.data.entity.CurrencyInfoEntity
import io.reactivex.Single

class CurrencyInfoRepository(private val currencyInfoRemoteDataSource: ICurrencyInfoRemoteDataSource) {
    fun getLatest(): Single<List<CurrencyInfoEntity>> {
        return currencyInfoRemoteDataSource.getLatest()
    }
}