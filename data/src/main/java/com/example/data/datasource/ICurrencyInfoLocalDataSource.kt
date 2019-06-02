package com.example.data.datasource

import com.example.data.model.CurrencyInfo
import io.reactivex.Single

interface ICurrencyInfoLocalDataSource {
    fun getLatest(): Single<List<CurrencyInfo>>
    fun addCurrencyInfoList(currencyInfoList: List<CurrencyInfo>)
}