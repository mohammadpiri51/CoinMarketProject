package com.example.data.repository

import com.example.data.datasource.ICurrencyInfoLocalDataSource
import com.example.data.datasource.ICurrencyInfoRemoteDataSource
import com.example.data.model.CurrencyInfo
import io.reactivex.Single
import javax.inject.Inject

class CurrencyInfoRepository @Inject constructor(
    private val currencyInfoLocalDataSource: ICurrencyInfoLocalDataSource
) {
    fun getLatest(): Single<List<CurrencyInfo>> {
        return currencyInfoLocalDataSource.getLatest()
    }

}